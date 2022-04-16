
  (* This is an attempt to construct natural integers
     from lists of empty lists over some arbitrary type in Coq *)

  (* We import a small set of custom rather basic definitions
     that we will explain as we go *)
  Require Export XD.Technical.
  Require Export XD.List.

  (* The actual type does not matter *)
  (* Note: We prefix "private" definitions and lemmas with "_",
     and "public" ones are unprefixed. *)
  Parameter _NType : Type.

  (* We define two levels of lists *)
  Definition _NLevel1 := List _NType.
  Definition _NLevel2 := List _NLevel1.

  (* A list of lists is "natural" if all its elements are empty lists *)
  Definition isnatural (l:_NLevel2) := allnil l.

  (* Note: allnil is defined in the List file, and relies on isnil and allmatch *)
  Print allnil.
  Print isnil.
  Print allmatch.

  (* We define Zero as the empty list of empty lists *)
  Definition _Nzero := nil (A:=_NLevel1).

  (* The "successor" function adds an empty list to any list of lists *)
  Definition _Nnext (n:_NLevel2) : _NLevel2 := cons nil n.

  (* _Nzero is a "natural" list *)
  Theorem  _Nzero_natural : isnatural _Nzero.
  Proof.
    (* Unfold the definitions *)
    unfold isnatural.
    unfold allnil.
    unfold _Nzero.
    (* allmatch on empty lists is always true *)
    simpl.
    trivial.
  Qed.

  (* Applying _Nnext on a "natural" list yields another "natural" list *)
  Lemma _Nnext_natural : forall (l:_NLevel2), (isnatural l) -> isnatural (_Nnext l).
  Proof.
    (* We first unfold terms to a more convenient level *)
    unfold isnatural. unfold allnil.
    (* The proof proceeds by induction over the list *)
    intro l.
    destruct l as [|head tail].
    (* Base case *)
    {
      (* We don't need the hypothesis in this case *)
      intros _.
      (* Simplification applies to both _Nnext and allmatch *)
      simpl.
      (* We get two parts *)
      split.
      (* First part is for the head which is nil *)
      { red. reflexivity. }
      (* Second part is for the tail, which is the empty list and for which allmatch evaluates to True *)
      { trivial. }
    }
    (* Induction case *)
    {
      (* If all elements are nil, then adding one nil element
         makes a list where all eleemnts are nil *)
      simpl in *.
      intros [hhead htail].
      unfold isnil in hhead. subst head.
      split. apply isnil_nil. split. apply isnil_nil. exact htail.
    }
  Qed.

  (*
     We define the type for natural integers as the set of lists which are "natural",
     i.e. lists which are made of empty lists
  *)
  (*
    This uses the "sig" inductive type, which defines an "exist" constructor
    that takes elements, and proofs that the elements satisfy the declared property *)
  Definition NN := { l | isnatural l }.

  (* sig comes with two projection functions which do not have very natural names *)
  (* First projection function retrieves the list *)
  Definition Nlist (t:NN) := proj1_sig t.
  (* Second project function retrieves the hypothesis *)
  Definition Nhyp (t:NN) := proj2_sig t.

  (* Here we define zero with a notation *)
  (* This uses the "exist" constructor from "sig" with zero and a proof that zero is natural. *)
  Definition Nzero := exist _ _Nzero _Nzero_natural.
  Notation "0n" := Nzero (only printing) : maths. 

  (* For Nnext, we have to construct a new natural using the proof _Nnext_natural *)
  Definition Nnext (n:NN) := exist _
    (_Nnext (Nlist n))
    (_Nnext_natural (Nlist n) (Nhyp n)).
  (* And this is a rather unconventional notation for "next", you may think of better *)
  Notation "\n x" := (Nnext x) (only printing, at level 60) : maths. 

  (* Here are one and two *)
  Definition None := Nnext Nzero.
  Notation "1n" := None (only printing) : maths.

  Definition Ntwo := Nnext None.
  Notation "2n" := Ntwo (only printing) : maths.

  (* next is injective *)
  Lemma Nnext_elim : forall n m, Nnext n = Nnext m -> n = m.
  Proof.
    (* Since we don't know anything about the properties of Nnext yet, we have
       to destroy n m into their parts (the lists and the hypotheses) *)
    intros [nl nh] [ml mh].
    (* Note: the weird §E notations means an instance of sig which carries
       a payload (shown) and an hypotheses (not shown) *)
    (* We can unfold Nnext and _Nnext *)
    unfold Nnext.
    unfold _Nnext.
    (* Simplifying will retrieve nl using Nlist and discard the hypotheses *)
    simpl.
    (* Now we have an equality hypotehse *)
    intro heq.
    (* Using inversion matches nl and ml because sig and List are inductive types. *)
    inversion heq.
    (* Now we can replace ml *)
    subst ml.
    (* These terms are not the same, because of the hidden proofs that are not equal for Coq *)
    Fail reflexivity.
    (* We need to apply a proof irrelevance axiom to ignore the proofs terms.
       Which we defined this in Technical.v .
       The mere fact that they exist means that what they prove is true *)
    Print proof_irrelevance.
    apply proof_irrelevance.
    simpl.
    (* Now we have equality *)
    reflexivity.
  Qed.

  (* One of the most useful thing is to prove an induction principle over NN *)
  (* For inductive types such as nat, the induction principle is created automatically by Coq *)
  Print nat.
  (* That's the induction principle over types *)
  Check nat_rect.
  (* That's the same thing over propositions *)
  Check nat_ind.
  (* And here's the same thing over sets *)
  Check nat_rec.
  

  (* But since NN is not an inductive type, we have to prove it ourselve *)
  (* Here it is for types *)
  Theorem NinductionT : forall (P: NN -> Type),
    (P Nzero) ->  
    (forall n, P n -> P (Nnext n)) -> 
    (forall n, P n).
  Proof.
    (* That's the proposition, that must be proven for all naturals *)
    intro P.
    (* We know it is true for zero *)
    intro hzero.
    (* And we now that whenever it holds for one number, it holds for its successor *)
    intro hnext.
    (* So we have to prove that it holds for that arbitrary number n *)
    intro n.
    (* We know that n is made of a list, and a assertion over that list *)
    (* To access those, we use destruct *)
    (* ln is the list, hn is the assertion on that list, and eqn: introduce an equation to
       bind these things with n *)
    destruct n as [ln hn] eqn:heqn.
    (* We will proceed by induction over the list, but first, we need to put back n in the goal
       Otherwise, we will get stuck with that particular n in the induction step *)
    generalize dependent n.
    (* Now we start the induction *)
    induction ln as [|head tail ih].
    (* This is the base case, ln is the empty list *)
    {
      (* For this case, we only need hzero *)
      clear hnext.
      (* We introduce back n into our context *)
      intro n.
      (* And we have an equation over n that asserts that n is made of the empty list *)
      intro heqn.
      (* We need to resort to proof irrelevance to show that n is actually zero *)
      assert (heqz : n = Nzero).
      {
        (* Substitute n with its value *)
        subst n.
        (* Use proof irrelevance to keep only the payload on both sides *)
        apply proof_irrelevance.
        (* This will retrive the payload *)
        simpl.
        (* _Nzero is defined to be the empty list *)
        unfold _Nzero.
        (* And we're done *)
        reflexivity.
      }
      (* Now we can use rewriting *)
      rewrite <- heqn.
      rewrite heqz.
      (* And we have hzero *)
      exact hzero.
    }
    (* For the induction case, we need to link the induction hypothesis ih with
       our induction hypothesis hnext *)
    {
      (* We won't need hzero here *)
      clear hzero.
      (* Here's n *)
      intro n.
      (* n is made of a head and a tail *)
      intro heqn.
      (* Here we massage hn, to extract as much information as we can from it *)
      unfold isnatural in hn.
      unfold allnil in hn.
      simpl in hn.
      destruct hn as [hnil hmatch].
      unfold isnil in hnil.
      subst head.
      (* We can use hmatch in ih *)
      unfold isnatural in ih.
      unfold allnil in ih.
      specialize (ih hmatch).
      (* We can construct the predecessor of n using hmatch. *)
      (* The type of hmatch is equivalent to that of isnatural, and Coq can see this *)
      eset (pred:=exist _ tail hmatch:NN).
      (* We can feed pred to hnext and ih *)
      specialize (hnext pred).
      specialize (ih pred).
      (* Here we get a difficulty, we want to match hnext with the goal, but we need
         to use proof irrelevance.
         To that end, I defined a technical lemma in Technical.v that can help in this situation *)
      assert(e:=@eq_impT).
      (* The lemma is trivial to prove by substution when equality is assumed in the context
         But to use it, we need to prove that we indeed have equality using proof irrelevance *)
      specialize (e NN).
      (* We want to convert to (Nnext pred) *)
      specialize (e (Nnext pred)).
      (* We use apply to let Coq find be for us *)
      apply e;clear e.
      (* This will work if we can prove the equality, so let's do it first *)
      2:{
        subst pred.
        apply proof_irrelevance.
        simpl.
        unfold _Nnext.
        reflexivity.
      }
      (* We can now use hnext *)
      apply hnext.
      (* And we don't need it anymore. Since most hypotheses are use only once, it's good hygiene
         to remove them as soon as they are used *)
      clear hnext.
      (* To use ih, we use our technical lemma again, but in a different way *)
      assert(e:=@eq_impT).
      specialize (e NN).
      (* This time, we know 'b', and we can bind it directly with apply.
         But 'a' is hidden in ih, and we will let Coq find it for us *)
      eapply e.
      {
        (* Applying ih will bind 'a' *)
        apply ih.
        (* To prove the equality, we need proof irrelevance again *)
        subst pred.
        apply proof_irrelevance.
        simpl.
        reflexivity.
      }
      (* All that is left is to prove the same equality, using proof irrelevance again *)
      {
        subst pred.
        apply proof_irrelevance.
        simpl.
        reflexivity.
      }
    }
  Defined.

  (* To prove Ninduction, we reuse NinductionT *)
  (* That's a big weird, because 'Prop' is of type 'Type',
     but what is true for all types is true for all props *)
  Check Prop.
  Goal forall (P:Type->Prop), (forall (T:Type), P T) -> (forall (P':Prop), P P').
    (* P maps a Type to a Prop *)
    intro P.
    (* h says that P holds for all types *)
    intro h.
    (* P' is of type 'Prop' *)
    intro P'.
    (* And here, we can mysteriously apply h, which takes a thing of type 'Type',
       to P', which is of type 'Prop', which is of type 'Type' *)
    specialize (h P').
    (* And that works! *)
    exact h.
  Abort.

  (* So the proof if quite straightforward once you accept that fact *)
  Theorem Ninduction : forall (P: NN -> Prop),
    (P Nzero) ->  
    (forall n, P n -> P (Nnext n)) -> 
    (forall n, P n).
  Proof.
    intros P hzero hnext.
    intro n.
    apply NinductionT.
    { exact hzero. }
    { intros n' h. apply hnext. exact h. }
  Defined.

  (* The same is true for Set *)
  Check Set.
  Goal forall (P:Type->Prop), (forall (T:Type), P T) -> (forall (S:Set), P S).
    intro P.
    intro h.
    intro S.
    (* Mysterious apply *)
    specialize (h S).
    (* And that works! *)
    exact h.
  Abort.

  (* Again, the proof of induction over sets is straightforward *)
  Theorem NinductionS : forall (P: NN -> Set),
    (P Nzero) ->  
    (forall n, P n -> P (Nnext n)) -> 
    (forall n, P n).
  Proof.
    intros P hzero hnext.
    intro n.
    apply NinductionT.
    { exact hzero. }
    { intros n' h. apply hnext. exact h. }
  Defined.

  (* To write functions over NN, it is sometimes necessary to know that equality is decidable *)
  (* This means that given two naturals n and m, we have an actual program that can inspect those
     numbers and decide equality. *)
  (* This is done using sumbool, which with an inductive type other Set *)
  Print sumbool.

  (* So for any naturals n and m, with can find a proof that n is equal to m,
     or we can find a prooof that n is not equal to m *)
  Definition Neq_dec (n m:NN) : sumbool (n = m) (n <> m).
  Proof.
    (* We need to look at what n and m are made of .*)
    destruct n as [n hn];
    destruct m as [m hm].
    (* We put back m in the goal to have a more flexible induction hypothesis over any 'm' *)
    generalize dependent m.
    (* Let's start the induction *)
    induction n as [|headn tailn ihn].
    (* Here n is the empty list *)
    {
      intros m hm.
      (* if m is the empty list, then we have equality
         otherwise, we have inequality *)
      destruct m as [|headm tailm].
      (* For equality, we use proof irrelevane *)
      {
        left.
        apply proof_irrelevance. simpl. reflexivity.
      }
      (* For inequality, we use inversion *)
      { right.
        unfold not.
        intro heq.
        (* Inversion will deconstruct the 'exist' into its parts,
           then match the 'nil' constructor on left to the 'cons' constructor on the right.
           And that's not possible, so that branch must be discarded *)
        inversion heq.
      }
    }
    (* Here we have the inductino step *)
    {
      intros m hm.
      (* Again, we destruct m *)
      destruct m as [|headm tailm].
      (* if m is nil, then we can use inversion again because n is not nil *)
      { right. unfold not. intro heq. inversion heq. }
      (* Here m is not nil *)
      {
        (* Massage the hypotheses *)
        unfold isnatural in hn, hm.
        unfold allnil in hn, hm.
        simpl in hn, hm.
        destruct hn as [hniln htailn];
        destruct hm as [hnilm htailm].
        red in hniln, hnilm.
        subst headn headm.
        (* Prepare the induction hypothesis with the tails *)
        specialize (ihn htailn).
        specialize (ihn tailm).
        specialize (ihn htailm).
        (* Examine each case in the induction hypothesis *)
        destruct ihn as [ihn|ihn].
        (* Equality case *)
        {
          (* We use inversion to match tailn with tailm, then we can use proof irrelevance
             to show equality *)
          inversion ihn.
          subst tailm.
          left.
          apply proof_irrelevance.
          simpl.
          reflexivity.
        }
        (* Inequality case *)
        {
          (* If the right is not equal, that means that equality implies a contradiction *)
          right.
          unfold not.
          intro heq.
          (* We can use inversion to show equality of tailn and tailm *)
          inversion heq.
          subst tailm.
          (* But the induction said that they were not equal, so that's our contradiction *)
          unfold not in ihn.
          apply ihn.
          apply proof_irrelevance.
          simpl.
          (* I'm always a bit uncomfortable with that kind for reasoning ;) *)
          reflexivity.
        }
      }
    }
  Defined.

  (* We define ordering by inspecting the length of the associated list *)
  (* We defined a 'longerOrEqualThan' function in List.v for that purpose *)
  Print longerOrEqualThan.

  (* Definition of 'less than or equal to' *)
  Definition Nle (n m:NN) := longerOrEqualThan (Nlist m) (Nlist n).
  Notation "x <=n y" := (Nle x y) (only printing, at level 60) : maths. 

  (* Definition of 'less than but not equal to, using Nle and Nnext' *)
  Definition Nlt (n m:NN) := Nle (Nnext n) m.
  Notation "x <n y" := (Nlt x y) (only printing, at level 60) : maths. 

  (* Nle is decidable *)
  Definition Nle_dec n m : sumbool (Nle n m) (Nle m n).
  Proof.
    (* The proof is a bit similar to Nle_dec, first we go down to lists *)
    destruct n as [n hn];
    destruct m as [m hm].
    unfold Nle.
    simpl.
    (* What's nice is that we don't have to deal with proof irrelevance here, it immediately
       goes away *)
    clear hn.
    (* We keep hm around because will use it to replace the head of m with nil, which simplifies
       the proof. But the proof would be doable without since we only look at the lengths of
       the lists *)
    generalize dependent m.
    induction n as [|headn tailn ihn].
    (* n is nil *)
    {
      (* All lists are longer or equal than the nil list *)
      intros m _.
      destruct m as [|headm tailm].
      { simpl. left. trivial. }
      { simpl. left. trivial. }
    }
    (* n is not nil *)
    {
      intros m hm.
      destruct m as [|headm tailm].
      (* m is nil, so n is longer or equal than m, so it's the right branch *)
      { simpl. right. trivial. }
      (* m is not nil, so we'll use the induction hypothesis *)
      {
        (* Massage the hypotheses *)
        simpl. unfold isnatural in hm. unfold allnil in hm. simpl in hm.
        destruct hm as [hheadm htailm]. unfold isnil in hheadm. subst headm.
        (* Prepare the induction hypothese *)
        specialize (ihn tailm). specialize (ihn htailm).
        (* Look at each cases *)
        destruct ihn as [ihn|ihn].
        (* Note: the fixpoint in longerOrEqual discarded the head of m and the head of n
           so we're left only with the tails and it's quite easy to match the goal
           to each case *)
        { left. exact ihn. }
        { right. exact ihn. }
      }
    }
  Defined.

  (* Nle is reflexive : forall n, n <= n *)
  Theorem Nle_refl : forall n:NN, Nle n n.
  Proof.
    (* We go down to list, and the proof is quite straightforward using induction on lists *)
    intro n.
    destruct n as [nl hn].
    unfold Nle.
    simpl.
    clear hn.
    induction nl as [|head tail ih].
    { simpl. trivial. }
    { simpl. exact ih. }
  Qed.


  (* Nle is transitive :  forall n m k, n <= m -> m <= k -> n <= k *)
  Lemma Nle_trans : forall n m k, Nle n m -> Nle m k -> Nle n k.
  Proof.
    (* We go down to lists, and proceed by induction *)
    (* This proof is more involved because there are many subcases *)
    intros n m k.
    unfold Nle.
    destruct n as [nl hn];
    destruct m as [ml hm];
    destruct k as [kl hk].
    simpl.
    clear hn hm hk.
    generalize dependent ml.
    generalize dependent nl.
    (* Induction on kl *)
    induction kl as [|headk tailk ih].
    (* kl is nil *)
    {
      simpl.
      (* Simpl is a bit too offensive here, but whenever a match is unfolded like this,
         it's a hint to use "destruct" *)
      intros nl ml h.
      destruct ml as [|headm tailm].
      (* ml is nil *)
      {
        destruct nl as [|headn tailn].
        (* nl is nil *)
        { intros _. trivial. }
        (* nl is not nil *)
        {
          simpl in h.
          (* that's a contradiction, because destruct covers all possibilities,
             including the irrealistic ones *)
          (* so this branch of the proof can be discarded *)
          inversion h.
        }
      }
      (* ml is not nil *)
      {
        (* another contradiction *)
        intro f. inversion f.
      }
    }
    (* Induction case for kl *)
    {
      intros nl ml hmn hkm.
      simpl. simpl in hkm.
      destruct nl as [|headn tailn].
      (* nl is nil *)
      { trivial. }
      (* nl is not nil *)
      {
        destruct ml as [|headm tailm].
        (* ml is nil *)
        { simpl in *. inversion hmn. }
        (* nl, ml and kl are not nil *)
        {
          simpl in *.
          (* We want to show that (n-1) <= (k-1) (reading tailn as being equivalent to n-1) *)
          eapply ih.
          (* Here we can use hmn, which states that (n-1) <= (m-1) *)
          { apply hmn. }
          (* and hkm states that (m-1) <= (k-1) *)
          { apply hkm. }
        }
      }
    }
  Qed.

  (* Nle is antisymmetric: forall n m, n <= m -> m <= n -> n = m. *)
  Lemma Nle_antisym : forall n m, Nle n m -> Nle m n -> n = m.
  Proof.
    (* Again, we go down to lists,
       and here's another syntax to destruct n and m directly in the intro *)
    intros (nl,hn) (ml,hm).
    unfold Nle.
    simpl.
    generalize dependent ml.
    induction nl as [|headn tailn ih].
    (* n is nil *)
    {
      intros ml hm.
      destruct ml as [|headm tailm].
      (* ml is nil *)
      { simpl. intros _ _. apply proof_irrelevance. simpl. reflexivity. }
      (* ml is not nil, so we have a contradiction *)
      { simpl. intros _ f. inversion f. }
    }
    (* Induction case for nl *)
    {
      intros ml hm.
      destruct ml as [|headm tailm].
      (* ml is nil, so we have a contradiction *)
      { simpl. intro f. inversion f. }
      (* ml is not nil, so we use the induction hypothesis *)
      {
        simpl.
        (* Massage the hypotheses *)
        unfold isnatural in *.
        unfold allnil in *.
        simpl in *.
        destruct hn as [hheadn htailn].
        destruct hm as [hheadm htailm].
        unfold isnil in hheadn, hheadm.
        subst headn headm.
        intros hmn hnm.
        (* Prepare the induction *)
        specialize (ih htailn).
        specialize (ih tailm).
        specialize (ih htailm).
        specialize (ih hmn).
        specialize (ih hnm).
        (* Use inversion to extract tailn = tailm equality *)
        inversion ih.
        subst tailm.
        (* Use proof irrelevance to prove the equality, discarding the proofs *)
        apply proof_irrelevance. simpl. reflexivity.
      }
    }
  Qed.

  (* "<" is irreflexive : if n < n, then that's a contradiction *)
  Lemma Nlt_irrefl : forall n, Nlt n n -> False.
  Proof.
    (* Again, we go down to lists *)
    intros (nl, hn).
    unfold Nlt. unfold Nle.
    simpl.
    induction nl as [|head tail ih].
    (* n is nil *)
    {
      (* longerOrEqualThan evaluates to false, which is our contradiction *)
      unfold _Nnext. simpl. intro f. exact f.
    }
    (* Induction case *)
    {
      (* Massage the hypotheses *)
      intro h.
      simpl in *.
      unfold isnatural in *.
      unfold allnil in *.
      simpl in *.
      destruct hn as [hnil hmatch].
      red in hnil.
      subst head.
      (* Prepare the induction hypothese *)
      specialize (ih hmatch).
      clear hmatch.
      unfold _Nnext in ih.
      (* Use the induction hypothese *)
      apply ih.
      exact h.
    }
  Qed.

  (* The next two lemmas relate Nnext and Nle *)

  (* next n <= next m => n <= m *)
  Lemma Nle_next_elim : forall n m, Nle (Nnext n) (Nnext m) -> Nle n m.
  Proof.
    (* Go down to lists *)
    intros (nl,hn) (ml,hm).
    unfold Nle.
    simpl.
    clear hn hm.
    intro h.
    (* the hypothese was reduced to the goal during simplification of the fixpoint *)
    exact h.
  Qed.

  (* If n <= m, then next n <= next m *)
  Lemma Nle_next_intro : forall n m, Nle n m -> Nle (Nnext n) (Nnext m).
  Proof.
    (* Go down to lists *)
    intros (nl,hn) (ml,hm).
    unfold Nle.
    simpl.
    clear hn hm.
    (* the goal was reduced to the hypothesis during simplification of the fixpoint *)
    intro h. exact h.
  Qed.

  (* To define recursive function in Coq, we can use Fixpoint and recursion on syntactic
     subterms of inductive types.
     But NN is not an inductive type. One solution is to prove a well founded property of a
     relation, then use that well foundedness to define general recursion using Fix and Fix_eq.
     Unfortunately, this is quite messy.
   *)

  (* The "<" relation is well_founded *)
  Lemma Nlt_wf: well_founded Nlt.
  Proof.
    (* I don't understand this proof very well *)
    red.
    intro a.
    (* We have to prove this *)
    apply Acc_intro.
    (* So we know 'a', and we have to prove that for any 'y' that is strictly less than 'a',
       y is something that I fail to enunciate *)
    induction a as [|a ih] using Ninduction.
    (* a is zero *)
    {
      (* That vacuously true... ok *)
      intros y h.
      unfold Nlt in h.
      contradiction h.
    }
    {
      intros b hb.
      (* So we have a 'b', let's find a 'c' too, why not ? *)
      apply Acc_intro.
      intro c. intro hc.
      (* And we can apply ih by transitivity *)
      apply ih. clear ih.
      unfold Nlt in *.
      apply Nle_next_elim in hb.
      apply Nle_trans with b.
      exact hc.
      exact hb.
      (* So it's true... whatever it is, and Nlt is well founded, whatever that means *)
    }
  Defined.

  (* To use recursion, we will have to go down by one, but that's harder to do that it looks,
     because of the zero *)
  (* So we define a 'rest' function, which given two numbers n and m, gives the number k such that
     n + k = m or n = k + m *)
  (* That's a bit unconventional, but better than defining pred 0 = 0 as they do in the standard
     library. *)
  Print Nat.pred.

  (* We define it other lists
    (we cheat again, it would be probably nicer to define it using what we already have) *)
  Fixpoint _Nrest {A:Type} (l m: LO A) : (LO A) := match l, m with
  | nil, nil => nil
  | nil, cons _ _ =>  m
  | cons _ _, nil =>  l
  | cons _ tailn, cons _ tailm =>  _Nrest tailn tailm
  end.

  (* We prove that the natural property is conserved by Nrest *)
  (* Proofs on fixpoint functions are a bit difficult to follow because Coq does a lot of work
     while evaluating the fixpoint and unfolding all the particular cases *)
  (* You have to look closely at what changes on the 'simpl' steps *)
  Lemma _Nrest_natural : forall l m, isnatural l -> isnatural m -> isnatural (_Nrest l m).
  Proof.
    intro l.
    induction l as [|headl taill ih].
    (* l is nil *)
    {
      destruct m as [|headm tailm].
      (* m is nil *)
      { simpl. intros h _. exact h. }
      (* m is not nil *)
      { simpl. intros _ h. exact h. }
    }
    (* induction case *)
    {
      destruct m as [|headm tailm].
      (* m is nil *)
      { simpl. intros h _. exact h. }
      (* m is not nil, so we use the induction hypothesis *)
      {
        intros hl hm.
        simpl.
        apply ih.
        { apply hl. }
        { apply hm. }
      }
    }
  Qed.

  (* We can now define Nrest over NN *)
  Definition Nrest (n m:NN) := 
    let (nl, hn) := n in
    let (ml, hm) := m in
    exist _ (_Nrest nl ml) (_Nrest_natural nl ml hn hm).

  (* Fun fact: the 'rest' function is commutative *)
  Lemma Nrest_comm : forall n m, Nrest n m = Nrest m n.
  Proof.
    (* We go down to lists again, and it's another induction/destruct proof *)
    intros (nl,hn) (ml,hm).
    generalize dependent ml.
    unfold isnatural in *. unfold allnil in *.
    induction nl as [|headn tailn ih].
    (* nl is nil *)
    {
      intros ml hm.
      destruct ml as [|headm tailm].
      (* ml is nil *)
      { simpl. apply proof_irrelevance. simpl. reflexivity. }
      (* ml is not nil *)
      {
        simpl in hm. destruct hm as [hheadm htailm].
        unfold isnil in hheadm. subst headm.
        simpl. apply proof_irrelevance. simpl. reflexivity.
      }
    }
    (* Induction step *)
    {
      intros ml hm.
      destruct ml as [|headm tailm].
      (* ml is nil *)
      { simpl. apply proof_irrelevance. simpl. reflexivity. }
      (* ml is not nil, and we use the induction hypothesis *)
      {
        simpl. apply proof_irrelevance. simpl.
        simpl in hn, hm.
        destruct hn as [hheadn htailn].
        destruct hm as [hheadm htailm].
        unfold isnil in hheadn, hheadm.
        subst headn headm.
        specialize (ih htailn _ htailm).
        inversion ih as [heq]. clear ih.
        rewrite heq.
        reflexivity.
      }
    }
  Qed.

  (* Next two lemmas relate 'rest' and zero *)

  (* rest 0 n = n *)
  Lemma Nrest_zero_l : forall n, Nrest Nzero n = n.
  Proof.
    (* Go down to lists *)
    intros (nl, hn).
    simpl.
    (* no induction needed, destruct is enough here *)
    destruct nl as [|head tail].
    { apply proof_irrelevance. simpl. reflexivity. }
    { apply proof_irrelevance. simpl. reflexivity. }
  Qed.

  (* rest n 0 = n *)
  Lemma Nrest_zero_r : forall n, Nrest n Nzero  = n.
  Proof.
    intro n. rewrite Nrest_comm. apply Nrest_zero_l.
  Qed.

  (* rest n n = 0 *)
  (* I'm not sure if that kind of property has a name *)
  Lemma Nrest_cancel : forall n, Nrest n n = Nzero.
  Proof.
    (* Go down to list again *)
    intros (nl, hn).
    simpl.
    generalize dependent hn.
    induction nl as [|head tail ih].
    (* nl is nil *)
    {
      simpl. intro hn. apply proof_irrelevance. simpl. unfold _Nzero. reflexivity.
    }
    (* Induction step *)
    {
      intro hn.
      (* Massage the hypotheses *)
      simpl in *.
      unfold isnatural in *.
      unfold allnil in *.
      simpl in *.
      destruct hn as [hhead htail].
      unfold isnil in hhead.
      subst head.
      (* Prepare the induction hypothesis *)
      specialize (ih htail).

      (* Use the technical lemma to bind the two equality together *)
      eapply eq_imp.
      2:{ apply ih. }
      {
        apply proof_irrelevance.
        simpl.
        reflexivity.
      }
    }
  Qed.

  (* This lemma relates 'rest' and 'next' *)
  (* rest (next n) (next m) = rest n m *)
  Lemma Nrest_next : forall n m, Nrest (Nnext n) (Nnext m) = Nrest n m.
  Proof.
    intros (nl, hn) (ml, hm).
    (* Coq will eliminate calls to 'next' while evaluation the fixpoints *)
    destruct nl as [|headn tailn].
    (* nl is nil *)
    {
      destruct ml as [|headm tailm].
      (* ml is nil *)
      { simpl. apply proof_irrelevance. simpl. reflexivity. }
      (* ml is not nil *)
      { simpl. apply proof_irrelevance. simpl. reflexivity. }
    }
    (* nl is not nil *)
    {
      destruct ml as [|headm tailm].
      (* ml is nil *)
      { simpl. apply proof_irrelevance. simpl. reflexivity. }
      (* ml is not nil *)
      { simpl. apply proof_irrelevance. simpl. reflexivity. }
    }
  Qed.

  (* TODO: describe *)
  Lemma Nrest_one_lt : forall n:NN, Nzero <> n -> Nlt (Nrest n None) n.
  Proof.
    intro n.
    induction n as [|n _] using Ninduction.
    { intro f. contradiction f. reflexivity. }
    {
      intros _.
      unfold None.
      rewrite Nrest_next.
      rewrite Nrest_zero_r.
      unfold Nlt.
      apply Nle_refl.
    }
  Qed.

  Definition mytype (a : NN) := forall b : NN, NN.

  Definition _Nplus_rec : (forall x : NN, (forall y : NN,(Nlt y x) -> mytype y) -> mytype x).
    intro x.
    intro rec.
    unfold mytype.
    intro y.
    destruct (Neq_dec Nzero x) as [d|d].
    { apply y. }
    {
      specialize (rec (Nrest x None)).
      apply Nrest_one_lt in d.
      specialize (rec d). clear d.
      unfold mytype in rec.
      specialize (rec y).
      apply (Nnext rec).
    }
  Defined.

  Definition Nplus := Fix Nlt_wf _ _Nplus_rec.

  Goal Nplus Nzero Nzero = Nzero.
    unfold Nplus.
    unfold Fix.
    simpl.
    unfold _Nplus_rec.
    simpl.
    reflexivity.
  Qed.

  Goal Nplus Nzero None = None.
    unfold Nplus.
    unfold Fix.
    unfold _Nplus_rec.
    simpl.
    reflexivity.
  Qed.

  Goal Nplus None Nzero  = None.
    unfold Nplus.
    rewrite Fix_eq.
    {
unfold _Nplus_rec.
rewrite Nrest_cancel.
destruct (Neq_dec _). inversion e.
rewrite Fix_eq. simpl.
unfold None. reflexivity.

intros.
destruct (Neq_dec _).
reflexivity.
rewrite H. reflexivity.
}
intros.
unfold _Nplus_rec.
destruct (Neq_dec _).
reflexivity.
rewrite H.
reflexivity.
Qed.


Lemma Nplus_next_l : forall n m, Nplus (Nnext n) m = Nnext (Nplus n m).
Proof.
intro n.
induction n as [|n ih] using Ninduction.
{
intro m.
induction m as [|m _] using Ninduction.
{
remember (Nplus _ _) as left eqn:heql in |-*.
remember (Nplus _ _) as right eqn:heqr in |-*.
unfold Nplus in heqr.
unfold Fix in heqr.
simpl in heqr.
unfold _Nplus_rec in heqr.
simpl in heqr.
subst right.
unfold Nplus in heql.
rewrite Fix_eq in heql.
{
unfold _Nplus_rec in heql.
destruct (Neq_dec _) as [d|d] in heql.
{ inversion d. }
{ unfold None in heql. rewrite Nrest_cancel in heql.
unfold Fix in heql. simpl in heql.
subst left.
reflexivity.
}
}
{ clear. intros. unfold _Nplus_rec. destruct (Neq_dec _) as [d|d].
reflexivity. rewrite H. reflexivity. }
}
{
remember (Nplus _ _) as left eqn:heql in |-*.
remember (Nplus _ _) as right eqn:heqr in |-*.
unfold Nplus in heqr. unfold Fix in heqr. unfold _Nplus_rec in heqr.
simpl in heqr.
subst right.
unfold Nplus in heql.
rewrite Fix_eq in heql.
{
unfold _Nplus_rec in heql.
destruct (Neq_dec _) in heql.
inversion e. clear n.
unfold None in heql. rewrite Nrest_cancel in heql.
unfold Fix in heql. simpl in heql.
subst left.
reflexivity.
}
{
clear. intros. unfold _Nplus_rec.
destruct (Neq_dec _). reflexivity. rewrite H. reflexivity.
}
}
}
{
intro m.
rewrite ih.
clear ih.
remember (Nplus _ _) as left eqn:heql in |-*.
remember (Nplus _ _) as right eqn:heqr in |-*.
unfold Nplus in heql.
rewrite Fix_eq in heql.
unfold _Nplus_rec in heql.
destruct (Neq_dec _) in heql.
inversion e. clear n0.
unfold None in heql.
rewrite Nrest_next in heql.
rewrite Nrest_zero_r in heql.
rewrite Fix_eq in heql.
destruct (Neq_dec _) in heql.
inversion e. clear n0.
rewrite Nrest_next in heql.
rewrite Nrest_zero_r in heql.
subst left.
{

apply f_eq. apply f_eq.
unfold Nplus in heqr.
unfold _Nplus_rec in heqr.
subst right.
reflexivity.
}

{
clear. intros.
destruct (Neq_dec _). reflexivity. rewrite H. reflexivity.
}
{
clear. intros.
unfold _Nplus_rec. destruct (Neq_dec _ _).
reflexivity.
rewrite H. reflexivity.
}
}
Qed.




Lemma Nplus_comm : commutative Nplus.
red.
intro n.
induction n as [|n ih] using Ninduction.
{
intro m.
remember (Nplus _ _) as left eqn:heql in |-*.
unfold Nplus in heql. unfold Fix in heql.
unfold _Nplus_rec in heql. simpl in heql.
subst left.
induction m as [|m ih] using Ninduction. 
{
unfold Nplus. unfold Fix. unfold _Nplus_rec. simpl. reflexivity.
}
{
rewrite Nplus_next_l. rewrite <- ih. reflexivity.
}
}
{
intro m.
rewrite Nplus_next_l.
rewrite ih.
clear ih.
induction m as [|m ih] using Ninduction.
{
remember (Nplus _ _) as left eqn:heql in |-*.
remember (Nplus _ _) as right eqn:heqr in |-*.
unfold Nplus in heql. unfold Fix in heql. unfold _Nplus_rec in heql. simpl in heql. subst left.
unfold Nplus in heqr. unfold Fix in heqr. unfold _Nplus_rec in heqr. simpl in heqr. subst right.
reflexivity.
}
{
repeat rewrite Nplus_next_l.
rewrite <- ih.
reflexivity.
}
}
Qed.



Lemma Nplus_next_r : forall n m, Nplus n (Nnext m) = Nnext (Nplus n m).
intros.
rewrite Nplus_comm. rewrite Nplus_next_l. rewrite Nplus_comm. reflexivity.
Qed.

Lemma Nplus_zero_l : forall n, Nplus Nzero n = n.
intro.
unfold Nplus. unfold Fix. unfold _Nplus_rec. simpl. reflexivity.
Qed.

Lemma Nplus_zero_r : forall n, Nplus n Nzero = n.
intro.
rewrite Nplus_comm. rewrite Nplus_zero_l. reflexivity.
Qed.

Lemma Nplus_assoc : associative Nplus.
red.
intro n.
induction n as [|n ih] using Ninduction.
{ intros. repeat rewrite Nplus_zero_l. reflexivity. }
{
intros m k.
rewrite Nplus_next_l.
rewrite Nplus_next_l.
rewrite Nplus_next_l.
apply f_eq.
rewrite ih.
reflexivity.
}
Qed.








  (* This lemma shows that isnatural is conserved by append *)
  Lemma append_natural : forall l m, isnatural l -> isnatural m -> isnatural (append l m).
  Proof.
    intros l m.
    unfold isnatural.
    unfold allnil.
    (* The induction is actually quite simple, so no comments *)
    induction l as [|head tail ih].
    { simpl. intros _ h. exact h. }
    {
      simpl.
      intros [hnil hmatch].
      intro hm.
      split.
      { exact hnil. }
      { apply ih.
        { exact hmatch. }
        { exact hm. }
      }
    }
  Qed.

  (* We define addition as concatenation of empty lists *)
  Definition Nplus (nT mT : NN) : NN :=
    (* Extract the parts from n and m *)
    let (n, hn) := nT in
    let (m, hm) := mT in
    (* Construct the result *)
    let result := append n m in
    (* And binds the proof using the proof above *)
    exist _ result (append_natural n m hn hm).
  Notation "x +n y" := (Nplus x y) (only printing, at level 50) : maths. 
 
  (* Proof that plus is commutative *)
  Theorem Nplus_comm : commutative Nplus.
  Proof.
    (* Expand the definition *)
    red.
      intros xT yT.
    (* Explode xT and yT *)
    destruct xT as [x hx];
    destruct yT as [y hy].
    (* Simplify *)
    simpl.
    (* Use proof_irrevance *)
    apply proof_irrelevance;simpl.
    unfold isnatural in hx, hy.
    (* We already proved that append commutes when all elements are nil *)
    apply allnil_append_comm.
    { exact hx. }
    { exact hy. }
  Qed.

  (* 0 + n = n *)
  Theorem Nplus_zero_l : forall n, Nplus Nzero n = n.
  Proof.
    intro nT.
    destruct nT as [n hn].
    (* Simple evaluation will produce the equality *)
    simpl.
    (* We still need proof irrelevance to ignore the hidden proofs *)
    apply proof_irrelevance;simpl.
    reflexivity.
  Qed.

  (* n + 0 = n *)
  Theorem Nplus_zero_r : forall n, Nplus n Nzero = n.
  Proof.
    intro n.
    (* We can use commutativity of addition *)
    rewrite Nplus_comm.
    apply Nplus_zero_l.
  Qed.

  (* (next n) + m = next(n+m) *)
  Lemma Nplus_next_l : forall n m, Nplus (Nnext n) m = Nnext (Nplus n m).
  Proof.
    intros nT mT.
    destruct nT as [n hn];
    destruct mT as [m hm].
    simpl.
    apply proof_irrelevance.
    simpl.
    unfold Nnext.
    reflexivity.
  Qed.

  (* n + (next m) = next(n+m) *)
  Lemma Nplus_next_r : forall n m, Nplus n (Nnext m) = Nnext (Nplus n m).
  Proof.
    intros n m.
    rewrite Nplus_comm.
    rewrite Nplus_next_l.
    rewrite (Nplus_comm m).
    reflexivity.
  Qed.

  (* Proof that plus is associative *)
  Theorem Nplus_assoc : associative Nplus.
  Proof.
    (* Expand the definition *)
    red.
    (* Intro the variables *)
    intros xT yT zT.
    (* Explode everything *)
    destruct xT as [x hx];
    destruct yT as [y hy];
    destruct zT as [z hz].
    (* Cleanup the mess *)
    simpl.
    (* Apply proof irrevance to focus on the content *)
    apply proof_irrelevance;simpl.
    (* Use the fact that append is associative *)
    rewrite append_assoc.
    (* And there we are *)
    reflexivity.
  Qed.

  (* n + m = n -> m = 0 *)
  Lemma Nplus_elim_zero_l : forall n m, Nplus n m = n -> m = Nzero.
  Proof.
  intro n.
  pattern n;apply Ninduction.
  { intro m. intro h. rewrite Nplus_zero_l in h. exact h. }
  {
    clear n.
    intro n.
    intro ih.
    intro m.
    intro h.
    apply ih.
    clear ih.
    apply Nnext_elim.
    rewrite Nplus_next_l in h.
    exact h.
  }
  Qed.

  (* n + m = m -> n = 0 *)
  Lemma Nplus_elim_zero_r : forall n m, Nplus n m = m -> n = Nzero.
  Proof.
    intros n m h.
    apply Nplus_elim_zero_l with m.
    rewrite Nplus_comm.
    exact h.
  Qed.

  (* next n = n + 1 *)
  Lemma Nnext_eq : forall n, Nnext n = Nplus n None.
  Proof.
    intro n.
    unfold None.
    rewrite Nplus_comm.
    rewrite Nplus_next_l.
    rewrite Nplus_zero_l.
    reflexivity.
  Qed.

  (* "multiplication" of two list repeatitivly applies append on the second list *)
  (* What happens in this function does not really matter as long as
     length (x*y)=length(x)*length(y) *)
  Fixpoint _Nmult (x y:_NLevel2) : _NLevel2 := match x with
  | nil => nil
  | cons head tail => append y (_Nmult tail y)
  end.
  Notation "x _*n y" := (_Nmult x y) (only printing, at level 60) : maths. 

  (* "Multiplying" two "natural" lists yields a "natural" list *)
  Lemma _Nmult_natural : forall (n m:_NLevel2), isnatural n -> isnatural m -> isnatural (_Nmult n m).
  Proof.
    unfold isnatural.
    unfold allnil.
    intros n m hn hm.
    generalize dependent m.
    induction n as [|headn tailn ihn].
    (* Base case *)
    {
      intros m hm.
      simpl.
      trivial.
    }
    (* Induction case *)
    {
      simpl in hn.
      destruct hn as [hniln hmatchn].
      red in hniln.
      subst headn.
      intros m hm.
      simpl.
      apply allmatch_append.
      { exact hm. }
      apply ihn.
      { exact hmatchn. }
      { exact hm. }
    }
  Qed.

  (* Now we can define multiplication on T *)
  Definition Nmult (nT mT : NN) : NN :=
    let (n, hn) := nT in
    let (m, hm) := mT in
    let result := _Nmult n m in
    exist _ result (_Nmult_natural n m hn hm).
    Notation "x *n y" := (Nmult x y) (only printing, at level 60) : maths. 

  (* Multiplication is commutative *)
  Theorem Nmult_comm : commutative Nmult.
  Proof.
    red.
    (* Explode x and y into their list parts and use proof irrelevance *)
    intros xT yT.
    destruct xT as [x hx];
    destruct yT as [y hy];
    simpl;
    apply proof_irrelevance;
    simpl.
    (* Unfold to a more convenient level *)
    unfold isnatural in *.
    unfold allnil in *.
    (* We will use double induction on x, then y *)
    generalize dependent y.
    induction x as [|headx tailx ihx].
    (* Base case for x *)
    {
      intros.
      simpl.
      induction y as [|heady taily ihy].
      (* Base case for y *)
      { simpl. reflexivity. }
      (* Induction case for y *)
      {
        simpl.
        simpl in hy.
        destruct hy as [hnily hmatchy].
        specialize (ihy hmatchy).
        exact ihy.
      }
    }
    (* Induction case for x *)
    {
      intros y hy.
      simpl.
      simpl in hx.
      destruct hx as [hnilx hmatchx].
      specialize (ihx hmatchx).
      red in hnilx.
      subst headx.
      specialize (ihx y).
      specialize (ihx hy).
      (* Use the induction hypothesis *)
      rewrite ihx.
      clear ihx.
      induction y as [|heady taily ihy].
      (* Base case for y *)
      { simpl. reflexivity. }
      (* Induction case for y *)
      {
        simpl.
        simpl in hy.
        destruct hy as [hnily hmatchy].
        red in hnily.
        subst heady.
        specialize (ihy hmatchy).
        (* Use the induction hypothesis *)
        rewrite <- ihy.
        (* Next trick is to use commutivity of append for list of nils *)
        repeat rewrite <- append_assoc.
        assert (heq:=allnil_append_comm taily tailx).
        unfold allnil in heq.
        specialize (heq hmatchy).
        specialize (heq hmatchx).
        (* For some reason, it's necessary to help Coq a little here for the rewrite *)
        pattern (append taily tailx).
        rewrite heq.
        (* And we have equality *)
        reflexivity.
      }
    }
  Qed.

  (* 1 * n = n *)
  Theorem Nmult_one_l : forall n, Nmult None n = n.
  Proof.
    intro nT.
    destruct nT as [n hn].
    simpl.
    apply proof_irrelevance.
    simpl.
    rewrite append_nil.
    reflexivity.
  Qed.

  (* n * 1 = n *)
  Theorem Nmult_one_r : forall n, Nmult n None = n.
  Proof.
    intro n.
    rewrite Nmult_comm.
    apply Nmult_one_l.
  Qed.

  (* x*(y+z) = x*y + x*z *)
  Theorem Nplus_mult_distr_l : forall x y z, Nmult x (Nplus y z) = Nplus (Nmult x y) (Nmult x z).
  Proof.
    intros xT yT zT.
    (* We explode all three numbers into their parts *)
    destruct xT as [x hx];
    destruct yT as [y hy];
    destruct zT as [z hz].
    simpl.
    apply proof_irrelevance;simpl.
    unfold isnatural in *.
    unfold allnil in *.
    induction x as [|headx tailx ihx].
    (* Base case *)
    { simpl. reflexivity. }
    {
      simpl in *.
      destruct hx as [hnilx hmatchx].
      red in hnilx.
      subst headx.
      specialize (ihx hmatchx).
      rewrite ihx.
      clear ihx.
      (* Remove common parts *)
      repeat rewrite append_assoc.
      apply append_intro_l.
      repeat rewrite <- append_assoc.
      apply append_intro_r.
      (* Commutativity of append for list of nils *)
      rewrite (allnil_append_comm z).
      (* And we have equality *)
      { reflexivity. }
      (* But we still have to prove that the lists are made of nils *)
      { red. exact hz. }
      {
        red.
        apply _Nmult_natural.
        { apply hmatchx. }
        { red. unfold allnil. exact hy. }
      }
    }
  Qed.

  (* (x+y)*z = x*z + y*z *)
  Theorem Nplus_mult_distr_r : forall x y z, Nmult (Nplus x y) z  = Nplus (Nmult x z) (Nmult y z).
  Proof.
    intros x y z.
    repeat rewrite (Nmult_comm _ z).
    rewrite Nplus_mult_distr_l.
    reflexivity.
  Qed.


  Theorem _Nplus_mult_dist_r : forall x y z,
    isnatural x -> isnatural y -> isnatural z
    -> _Nmult (append x y) z  = append (_Nmult x z) (_Nmult y z).
  Proof.
    intros x y z hx hy hz.
    assert (h := Nplus_mult_distr_r).
    specialize (h (exist _ x hx)).
    specialize (h (exist _ y hy)).
    specialize (h (exist _ z hz)).
    simpl in h.
    inversion h as [h']. clear h. rename h' into h.
    reflexivity.
  Qed.

  (* Multiplication is associative *)
  Theorem Nmult_assoc : associative Nmult.
  Proof.
    red.
    (* Destruct x, y and z into their parts *)
    intros xT yT zT.
    destruct xT as [x hx];
    destruct yT as [y hy];
    destruct zT as [z hz].
    simpl.
    apply proof_irrelevance;simpl.
    unfold isnatural in *.
    unfold allnil in *.
    generalize dependent z.
    generalize dependent y.
    (* Induction on x *)
    induction x as [|headx tailx ihx].
    (* Base case *)
    { intros y hy z hz. simpl. reflexivity. }
    (* Induction case *)
    {
      simpl.
      intros y hy z hz.
      simpl in hx.
      destruct hx as [hnilx hmatchx].
      red in hnilx.
      subst headx.
      specialize (ihx hmatchx).
      specialize (ihx y hy).
      specialize (ihx z hz).
      (* Use induction hypothesis *)
      rewrite <- ihx.
      clear ihx.
      rename tailx into x.
      rewrite _Nplus_mult_dist_r.
      { reflexivity. }
      { unfold isnatural. unfold allnil. exact hy. }
      { apply _Nmult_natural.
        { unfold isnatural. unfold allnil. exact hmatchx. }
        { unfold isnatural. unfold allnil. exact hy. }
      }
      { unfold isnatural. unfold allnil. exact hz. }
    }
  Qed.

  Lemma Nmult_zero_l : forall n:NN, Nmult Nzero n = Nzero.
    Proof.
    intro nT.
    destruct Nzero as [z hz] eqn:heqz;
    destruct nT as [n hn].
    simpl. apply proof_irrelevance. simpl.
    inversion heqz as [heq]. clear heqz.
    unfold Nzero in *. subst z.
    simpl.
    reflexivity.
  Qed.

  Lemma Nmult_zero_r : forall n:NN, Nmult n Nzero = Nzero.
    Proof.
    intro nT.
    rewrite Nmult_comm.
    rewrite Nmult_zero_l.
    reflexivity.
  Qed.

  (* The set of natural numbers is a commutative monoid for addition and multiplication *)
  Theorem N_commutative_monoid : commutative_monoid NN Nplus /\ commutative_monoid NN Nmult.
  Proof.
    split.
    {
      red.
      repeat split.
      { apply Nplus_assoc. }
      { apply Nplus_comm. }
      { exists Nzero.
        intro a.
        split.
        { rewrite Nplus_zero_l. reflexivity. }
        { rewrite Nplus_zero_r. reflexivity. }
      }
    }
      red.
      repeat split.
      { apply Nmult_assoc. }
      { apply Nmult_comm. }
      { exists None.
        intro a.
        split.
        { rewrite Nmult_one_l. reflexivity. }
        { rewrite Nmult_one_r. reflexivity. }
      }
  Qed.

  (* (next n) + m = n + (next m) *)
  Lemma Nplus_next: forall (n m:NN), Nplus (Nnext n) m = Nplus n (Nnext m).
  Proof.
    intros n m.
    rewrite Nplus_next_l.
    rewrite Nplus_next_r.
    reflexivity.
  Qed.


  (* If n + m = 0, then n = 0 and m = 0 *)
  Lemma Nplus_zero : forall (n m:NN), Nplus n m = Nzero -> n = Nzero /\ m = Nzero.
  Proof.
    intro n.
    (* We apply our custom induction principle *)
    pattern n;apply Ninduction.
    (* Base case *)
    {
      intros m heq.
      rewrite Nplus_zero_l in heq.
      subst m.
      split;reflexivity.
    }
    (* Induction case *)
    {
      clear n. intro n. intro ih.
      intros m heq.
      specialize (ih (Nnext m)).
      rewrite Nplus_next in heq.
      specialize (ih heq).
      destruct ih as [ _ hr ].
      (* We can have next m = 0 *)
      inversion hr.
    }
  Qed.





  (* n <= n + m *)
  Lemma Nle_plus_l : forall n m, Nle n (Nplus n m).
  Proof.
    (* Destruct n and m into their parts *)
    intros nT mT.
    unfold Nle.
    destruct nT as [n hn];
    destruct mT as [m hm].
    simpl. clear hn hm.
    induction n as [|headn tailn ih].
    (* Base case *)
    {
      simpl.
      destruct m as [|headm tailm].
      (* m is nil *)
      { simpl. trivial. }
      (* m is not nil *)
      { simpl. trivial. }
    }
    (* Induction case *)
    { simpl. exact ih. }
  Qed.



  (* a <= next a *)
  Lemma Nle_next : forall a, Nle a (Nnext a).
  Proof.
    intro aT.
    destruct aT as [a ha].
    unfold Nle.
    simpl.
    clear ha.
    induction a as [|head tail ih].
    { trivial. }
    { simpl. apply ih. }
  Qed.





  (* To converts "<" back to "<=" in proofs *)
  Lemma Nlt_le: forall n m, Nle (Nnext n) m -> Nlt n m.
  Proof.
    intros n m h.
    unfold Nlt.
    exact h.
  Qed.


  (* Length of a list *)
  Fixpoint length {A:Type} (l : LO A) : NN := match l with
  | nil => Nzero
  | cons _ tail => Nnext (length tail)
  end.

  (* A type is infinite if for any (finite) list of elements of that type,
     it's possible to find another element that is not in the list *)
  Definition is_infinite (A:Type) := forall (l:LO A), exists (a:A), not (inlist l a).


  (* Sum of a list *)
  Fixpoint Nsum (l:LO NN) := match l with
  | nil => Nzero
  | cons head tail => Nplus head (Nsum tail)
  end.

  (* If the sum of a list is zero, then all its elements are zero *)
  Lemma sum_zero : forall (l:LO NN), Nsum l = Nzero -> forall a, inlist l a -> a = Nzero.
  Proof.
    intro l.
    induction l as [|head tail ih].
    (* Base case *)
    {
      (* We can't find anything in an empty list *)
      simpl.
      intros _.
      intros a f.
      inversion f.
    }
    {
      simpl.
      intro heq.
      (* head = 0 and sum tail = 0 *)
      apply Nplus_zero in heq.
      destruct heq as [hl hr].
      subst head.
      specialize (ih hr).
      clear hr.
      intro a.
      specialize (ih a).
      intro h.
      (* a = 0 or a is in the tail *)
      destruct h as [hr | hl].
      (* a=0 *)
      {
        (* therefore a=0 *)
        exact hr.
      }
      (* a is in the tail *)
      {
        (* then the induction hypothesis says that a=0 *)
        specialize (ih hl).
        exact ih.
      }
    }
  Qed.

  (* Any element in a list is less than their sum *)
  Lemma sum_lt : forall (l:LO NN), forall a, inlist l a -> Nle a (Nsum l).
  Proof.
  intro l.
  induction l as [|head tail ih].
  (* Base case *)
  { (* There are no elements in an empty list *)
    intros a h. simpl in h. inversion h.
  }
  {
    (* Assuming it's true for the tail, we just need to get rid of the head of the list *)
    intros a h.
    simpl in *.
    destruct h as [hl|hr].
    (* a is the head *)
    {
      subst a. simpl.
      apply Nle_plus_l.
    }
    (* a is in the tail *)
    {
      specialize (ih _ hr).
      apply Nle_trans with (Nsum tail).
      { exact ih. }
      {
        simpl.
        rewrite Nplus_comm.
        apply Nle_plus_l.
      }
    }
  }
  Qed.


  (* If an element is bigger than any element of the list, then it is not in the list *)
  Lemma lt_notin_list : forall (l:LO NN) (a:NN), (forall x, inlist l x -> Nlt a x) -> not (inlist l a).
  Proof.
    intro l.
    induction l as [|head tail ih].
    {
      (* There are no elements in an empty list *)
      simpl.
      intros _ _.
      unfold not.
      intro f. exact f.
    }
    {
      (* if a is in the list, then we can show that a<a *)
      intros a h.
      unfold not.
      intro hin.
      unfold not in ih.
      specialize (h _ hin).
      apply Nlt_irrefl in h.
      inversion h.
    }
  Qed.

  (* The sum of the elements of a list + 1 is not in the list *)
  Lemma sum1_not_in_list : forall (l:LO NN), not (inlist l (Nplus (Nsum l) None)).
  Proof.

    (* The sum + 1 of a list is bigger than any elements of the list *)
    assert(thm:=sum_lt).

    (* We will work on that list *)
    intro l.
    specialize (thm l).

    (* Let's call the sum 'S' *)
    set (S:=Nplus (Nsum l) None). 

    (* Negation means proving False *)
    unfold not in *.

    (* We assume that S in in the list, then derive a contradiction *)
    intro h.

    (* We can apply thm on S *)
    specialize (thm S).
    specialize (thm h).
    clear h.

    (* Now we can use irreflexivity of "<" to derive a contradiction *)
    eapply Nlt_irrefl with S.
    subst S.
    unfold Nlt.
    rewrite <- Nnext_eq.
    apply Nle_next_intro.
    rewrite <- Nnext_eq in thm.
    exact thm.
  Qed.

  (* The set of naturals is infinite *)
  Theorem Ninfinite : is_infinite NN.
  Proof.
    (* Being infinite means that for any finite list l of elements of type T,
       we can find an element of type T that is not in the list *)
    red.
    (* We will work on that list *)
    intro l.
    (* And in particular, the sum of the list + 1 is not in the list *)
    exists (Nplus (Nsum l) None).
    (* This it what we proved just above *)
    apply sum1_not_in_list.
  Qed.


  Definition divides d n := exists d', Nmult d d' = n.

  Lemma divides_zero_n : forall n:NN, divides n Nzero.
  Proof.
    intro n.
    red.
    exists Nzero.
    rewrite Nmult_zero_r.
    reflexivity.
  Qed.

  Lemma divides_n_zero : forall n:NN, divides Nzero n -> n = Nzero.
  Proof.
    intro n.
    pattern n;apply Ninduction.
    (* n = 0 *)
    { intros _. reflexivity. }
    (* n > 0 => impossible *)
    {
      clear n. intro n.
      intro ih. clear ih.
      intro h.
      unfold divides in *.
      destruct h as [d h].
      rewrite Nmult_zero_l in h.
      (* inversion is kind of magic here, but it will try to match nil against cons head tail and find it can't *)
      inversion h.
    }
  Qed.

  Lemma divides_one_n : forall n:NN, divides None n.
  Proof.
    intro n.
    unfold divides.
    exists n.
    rewrite Nmult_one_l.
    reflexivity.
  Qed.

  (* n + m = 1 -> (n = 1 and m = 0) or (n = 0 and m = 1) *)
  Lemma plus_eq_one : forall (n m:NN), Nplus n m = None -> n = None /\ m = Nzero \/ n = Nzero /\ m = None.
  Proof.
    (* Induction on n *)
    intro n.
    pattern n;apply Ninduction.
    (* Base case *)
    {
      (* n = 0 -> m = 1 *)
      intros m h.
      rewrite Nplus_zero_l in h.
      subst m.
      (* The right part of the disjunction applies *)
      right.
      split.
      { reflexivity. }
      { reflexivity. }
    }
    (* Induction case *)
    {
      (* n and induction hypothesis *)
      clear n. intro n. intro ih.
      (* m and equality hypothesis *)
      intro m. intro h.
      (* We can deduce n = 0 and m = 0 *)
      rewrite Nplus_next_l in h.
      unfold None in h.
      apply Nnext_elim in h.
      apply Nplus_zero in h.
      destruct h as [ hl hr ].
      (* Substitute n and m with zero *)
      subst n. subst m.
      (* Prepare the induction hypothesis *)
      specialize (ih None).
      rewrite Nplus_zero_l in ih.
      specialize (ih (eq_refl _)).
      (* Examine each "possibility" *)
      destruct ih as [hl | hr].
      (* The left case is impossible *)
      {
        destruct hl as [hl hr].
        inversion hl.
      }
      (* The right case is obvious *)
      {
        clear hr.
        left.
        split.
        { unfold None. reflexivity. }
        { reflexivity. }
      }
    }
  Qed.

  (* n * m = 1 -> n = 1 and m = 1 *)
  Theorem Nmult_one : forall n m : NN, Nmult n m = None -> n = None /\ m = None.
  Proof.
    (* Induction over n *)
    intro n.
    pattern n;apply Ninduction.
    (* Base case *)
    {
      (* n = 0 -> impossible *)
      intros m h.
      rewrite Nmult_zero_l in h.
      inversion h.
    }
    (* Induction case *)
    {
      (* We don't need the induction hypothesis *)
      clear n. intro n'. intro ih. clear ih.
      intro m. intro  h.
      (* We can deduce that m = 0 or m = 1 *)
      rewrite Nnext_eq in h.
      rewrite Nplus_mult_distr_r in h.
      rewrite Nmult_one_l in h.
      apply plus_eq_one in h.
      destruct h as [hl | hr ].
      (* m = 0 -> impossible *)
      {
        destruct hl as [hl hr].
        subst m.
        rewrite Nmult_zero_r in hl.
        inversion hl.
      }
      (* m = 1 *)
      {
        (* so n' must be zero *)
        destruct hr as [hl hr].
        subst m.
        rewrite Nmult_one_r in hl.
        subst n'.
        (* And now it's obvious *)
        split.
        { unfold None. reflexivity . }
        { reflexivity. }
      }
    }
  Qed.

  Lemma divides_n_one : forall n:NN, divides n None -> n = None.
  Proof.
  intros n h.
  unfold divides in h.
  destruct h as [d h].
  generalize dependent d.
  (* Induction over n *)
  pattern n;apply Ninduction.
  (* Base case *)
  {
    intros d h.
    rewrite Nmult_zero_l in h.
    inversion h.
  }
  (* Induction case *)
  {
    (* We don't need the induction hypothesis *)
    clear n. intro n'. intro ih. clear ih.
    intro d. intro h.
    (* From h, we can deduce that n' = zero, and therefore n = 1 *)
    apply Nmult_one in h.
    destruct h as [hl hr].
    subst d.
    unfold None in hl.
    apply Nnext_elim in hl.
    subst n'.
    unfold None.
    reflexivity.
  }
  Qed.

  Lemma divides_n_n : forall n, divides n n.
  Proof.
    intro n.
    unfold divides.
    exists None.
    rewrite Nmult_one_r.
    reflexivity.
  Qed.

  Definition isprime n := forall d, divides d n -> d<>n -> d = None.

  Lemma zero_not_eq_one : Nzero = None -> False.
  Proof.
    intro h.
    inversion h.
  Qed.

  Lemma two_not_eq_one : Ntwo = None -> False.
  Proof.
    intro h.
    inversion h.
  Qed.

  Lemma next_zero : Nnext Nzero = None.
  Proof. unfold None. reflexivity. Qed.

  Lemma zero_not_prime : not (isprime Nzero).
  Proof.
    unfold not. intro h.
    unfold isprime in h.
    (* For d = zero, we would prove 0 = 1, which is impossible *)
    specialize (h Ntwo).
    apply two_not_eq_one.
    apply h.
    (* Two divides zero indeed *)
    clear h.
    apply divides_zero_n.
    unfold not. intro heq. inversion heq.
  Qed.

  Lemma isprime_one : isprime None.
  Proof.
    unfold isprime.
    intro d.
    intro h.
    unfold divides in h.
    destruct h as [d' heq].
    apply Nmult_one in heq.
    destruct heq as [hl _].
    subst d.
    intros _.
    reflexivity.
  Qed.

  Lemma Nplus_elim_l : forall n m p, Nplus n m = Nplus n p -> m = p.
  Proof.
    intro n.
    pattern n;apply Ninduction.
    {
    intro m. intro p.
    intro heq.
    repeat rewrite Nplus_zero_l in heq.
    exact heq.
    }
    { 
    clear n. intro n'. intro ih.
    intro m. intro p. intro heq.
    rewrite Nplus_next_l in heq.
    rewrite Nplus_next_l in heq.
    apply Nnext_elim in heq.
    apply ih.
    exact heq.
    }
  Qed.

  Lemma Nplus_elim_r : forall n m p, Nplus m n = Nplus p n -> m = p.
  Proof.
    intros n m p heq.
    apply Nplus_elim_l with n.
    rewrite (Nplus_comm n).
    rewrite (Nplus_comm n).
    exact heq.
  Qed.

  Lemma plus_eq_two : forall (n m:NN), Nplus n m = Ntwo -> (n = Nzero /\ m = Ntwo) \/ (n = None /\ m = None) \/ (n = Ntwo /\ m = Nzero).
  Proof.
  intro n.
  pattern n;apply Ninduction.
  {
    intros m h.
    rewrite Nplus_zero_l in h.
    subst m.
    left. split.
    { reflexivity. }
    { reflexivity. }
  }
  {
    intros n' ih. clear ih.
    intros m heq.
    rewrite Nnext_eq in heq.
    unfold Ntwo in heq.
    rewrite Nnext_eq in heq.
    rewrite (Nplus_comm n') in heq.
    repeat rewrite Nplus_assoc in heq.
    apply Nplus_elim_l in heq.
    apply plus_eq_one in heq.
    destruct heq as [heql | heqr].
    {
      destruct heql as [hn hm].
      subst m.
      subst n'.
      right. right.
      split.
      { unfold Ntwo. reflexivity. }
      { reflexivity. }
    }
    {
      destruct heqr as [hn hm].
      subst n'. subst m.
      right. left. split.
      { unfold None. reflexivity. }
      { reflexivity. }
    }
  }
  Qed.

  Lemma Nmult_zero : forall n m, Nmult n m = Nzero -> n = Nzero \/ m = Nzero.
  Proof.
  intro n.
  pattern n;apply Ninduction.
  {
    intro m. intro heq. clear heq.
    left. reflexivity.
  }
  {
    clear n. intro n'. intro ih. clear ih.
    intro m. intro heq.
    rewrite Nnext_eq in heq.
    rewrite Nplus_mult_distr_r in heq.
    rewrite Nmult_one_l in heq.
    apply Nplus_zero in heq.
    destruct heq as [hl hr].
    subst m.
    right.
    reflexivity.
  }
  Qed.

  Lemma isprime_two : isprime Ntwo.
  Proof.
    unfold isprime.
    intro d.
    intro h.
    intro hneq.
    unfold divides in h.
    destruct h as [d' heq].
    generalize dependent d'.
    generalize dependent hneq.
    pattern d;apply Ninduction.
    {
      intros hneq d' heq.
      rewrite Nmult_zero_l in heq.
      inversion heq.
    }
    {
      clear d. intro d. intro ih.
      intro hneq. intro d'. intro heq.
      rewrite Nnext_eq in heq.
      rewrite Nplus_mult_distr_r in heq.
      rewrite Nmult_one_l in heq.
      apply plus_eq_two in heq.
      destruct heq as [h02 | [h11 | h20]].
      {
        destruct h02 as [hl hr].
        subst d'.
        apply Nmult_zero in hl.
        destruct hl as [hl | hr].
        {
          subst d.
          unfold None.
          reflexivity.
        }
        { inversion hr. }
      }
      {
        destruct h11 as [hl hr].
        subst d'.
        rewrite Nmult_one_r in hl.
        subst d.
        clear ih.
        exfalso.
        apply hneq.
        unfold Ntwo.
        reflexivity.
      }
      {
        destruct h20 as [hl hr].
        subst d'.
        rewrite Nmult_zero_r in hl.
        inversion hl.
      }
    }
  Qed.

  Lemma zero_neq_two : Nzero = Ntwo -> False.
  Proof.
    intro i. inversion i.
  Qed.

  Lemma one_neq_two : None = Ntwo -> False.
  Proof.
    intro h.
    inversion h.
  Qed.

  Lemma Nplus_elim_one_r : forall n m p:NN, Nplus n m = Nplus p None ->
    (exists n', Nplus n' m  = p) \/
    (exists m', Nplus n  m' = p).
  Proof.
    intro n.
    pattern n;apply Ninduction.
    {
      intro m.
      intro p.
      intro heq.
      rewrite Nplus_zero_l in heq.
      subst m.
      right.
      exists p.
      rewrite Nplus_zero_l.
      reflexivity.
    }
    {
      clear n. intro n'. intro ih.
      intro m. intro p. intro heq.
      specialize (ih (Nnext m)).
      specialize (ih p).
      rewrite Nplus_next_l in heq.
      rewrite <- Nplus_next_r in heq.
      specialize (ih heq).
      destruct ih as [hl | hr].
      {
        destruct hl as [z hz].
        left.
        exists (Nnext z).
        rewrite Nplus_next_l.
        rewrite <- Nplus_next_r.
        exact hz.
      }
      {
        destruct hr as [z hz].
        rewrite Nplus_next_r in heq.
        rewrite <- Nnext_eq in heq.
        apply Nnext_elim in heq.
        rewrite <- heq in hz.
        apply Nplus_elim_l in hz.
        subst z.
        left.
        exists n'.
        exact heq.
      }
    }
  Qed.

  Definition three := Nnext Ntwo.

  Lemma isprime_three : isprime three.
  Proof.
    unfold isprime.
    intro d.
    pattern d;apply Ninduction.
    (* d = 0 *)
    {
      intro h.
      intro hneq.
      unfold divides in h.
      destruct h as [d' heq].
      rewrite Nmult_zero_l in heq.
      inversion heq.
    }
    {
    (* d = next d' *)
      clear d.
      intro d'.
      intro ih.
      intro h.
      intro hneq.
      unfold divides in h.
      destruct h as [q heq].
      rewrite Nnext_eq in heq.
      rewrite Nplus_mult_distr_r in heq.
      rewrite Nmult_one_l in heq.
      unfold three in heq.
      rewrite Nnext_eq in heq.
      assert(kept:=heq).
      apply Nplus_elim_one_r in heq.
      destruct heq as [hl | hr ].
      {
        destruct hl as [d'' heq].
        apply plus_eq_two in heq.
        destruct heq as [heq | [ heq | heq ] ].
        {
          destruct heq as [h'' h].
          subst d''.
          subst q.
          rewrite (Nplus_comm Ntwo) in kept.
          apply Nplus_elim_r in kept.
          apply Nmult_one in kept.
          destruct kept as [_ i].
          inversion i.
        }
        {
          destruct heq as [hl hr].
          subst q. subst d''.
          rewrite Nmult_one_r in kept.
          apply Nplus_elim_r in kept.
          subst d'.
          unfold three in hneq.
          exfalso.
          apply hneq.
          reflexivity.
        }
        {
          destruct heq as [hl hr].
          subst q.
          subst d''.
          rewrite Nmult_zero_r in kept.
          rewrite Nplus_zero_l in kept.
          rewrite <- Nnext_eq in kept.
          inversion kept.
        }
      }
      {
        destruct hr as [u h].
        apply plus_eq_two in h.
        destruct h as [ h | [ h | h ] ].
        {
          destruct h as [ hl hr ].
          subst u.
          apply Nmult_zero in hl.
          destruct hl as [h | h].
          {
            subst d'.
            unfold None.
            reflexivity.
          }
          {
            subst q.
            rewrite Nmult_zero_r in kept.
            rewrite Nplus_zero_l in kept.
            rewrite <- Nnext_eq in kept.
            inversion kept.
          }
        }
        {
          destruct h as [hl hr].
          subst u.
          apply Nmult_one in hl.
          destruct hl as [hl hr].
          subst d'.
          subst q.
          rewrite Nmult_one_r in kept.
          repeat rewrite <- next_eq_plus_one in kept.
          inversion kept.
        }
        {
          destruct h as [hl hr].
          subst u.
          assert(heq:=kept).
          rewrite hl in heq.
          apply Nplus_elim_l in heq.
          subst q.
          rewrite Nmult_one_r in hl.
          subst d'.
          exfalso.
          apply hneq.
          unfold three.
          reflexivity.
        }
      }
    }
  Qed.

  Definition Neven (n:NN) := divides Ntwo n.
  Definition Nodd (n:NN) := not (Neven n).

  Lemma mult_two_r : forall n, Nmult n Ntwo = Nplus n n.
  Proof.
    intro n.
    unfold Ntwo.
    rewrite Nnext_eq.
    rewrite Nplus_mult_distr_l.
    repeat rewrite Nmult_one_r.
    reflexivity.
  Qed.

  Lemma mult_two_l : forall n, Nmult Ntwo n = Nplus n n.
  Proof.
    intro n.
    rewrite Nmult_comm.
    apply mult_two_r.
  Qed.

  Lemma not_even_odd : forall (n:NN), not (Neven n /\ Nodd n).
  Proof.
    intro n.
    unfold not.
    intros [heven hodd].
    unfold Nodd in hodd.
    apply hodd.
    exact heven.
  Qed.

  Lemma Neven_2k : forall (k:NN), Neven (Nmult Ntwo k).
  Proof.
  intro k.
  pattern k;apply Ninduction.
  { unfold Neven. rewrite Nmult_zero_r. apply divides_zero_n. }
  {
    clear k. intro k'. intro ih. clear ih.
    unfold Neven.
    unfold divides.
    exists (Nnext k').
    reflexivity.
  }
  Qed.
  
  Lemma Ndestruct : forall n:NN, n = Nzero \/ exists n', n = Nnext n'.
  Proof.
    intro n.
    pattern n;apply Ninduction.
    { left. reflexivity. }
    {
      clear n. intro n'. intro ih.
      destruct ih as [hl | hr].
      {
        subst n'.
        right.
        exists Nzero.
        reflexivity.
      }
      {
        destruct hr as [n'' heq].
        subst n'.
        right.
        exists (Nnext n'').
        reflexivity.
      }
    }
  Qed.
    

  Lemma Nodd_2k1 : forall (k:NN), Nodd (Nnext (Nmult Ntwo k)).
  Proof.
  intro k.
  pattern k;apply Ninduction.
  {
    rewrite Nmult_zero_r.
    unfold Nodd.
    unfold not.
    intro heven.
    unfold Neven in heven.
    unfold divides in heven.
    destruct heven as [e he].
    clear k.
    generalize dependent he.
    pattern e;apply Ninduction.
    {
      intro h.
      rewrite Nmult_zero_r in h.
      inversion h.
    }
    {
      clear e. intro e'. intro hi. clear hi. intro h.
      rewrite mult_two_l in h.
      fold None in h.
      apply plus_eq_one in h.
      destruct h as [h | h].
      { destruct h as [hl hr]. rewrite hr in hl. inversion hl. }
      { destruct h as [hl hr]. rewrite hr in hl. inversion hl. }
    }
  }
  {
    clear k. intro k'. intro ih.
    unfold Nodd.
    unfold not.
    intro heq.
    unfold Neven in heq.
    unfold divides in heq.
    destruct heq as [d heq].
    unfold Nodd in ih.
    unfold not in ih.
    apply ih.
    clear ih.
    unfold Neven.
    unfold divides.
    rewrite mult_two_l in heq.
    rewrite mult_two_l in heq.
    rewrite Nplus_next_r in heq.
    rewrite Nplus_next_l in heq.
    rewrite mult_two_l.
    assert (hd:=Ndestruct d).
    {
      destruct hd as [hz | he].
      { subst d. rewrite Nplus_zero_l in heq. inversion heq. }
      {
        destruct he as [d' heq']. subst d.
        rewrite Nplus_next_r in heq.
        rewrite Nplus_next_l in heq.
        apply Nnext_elim in heq.
        apply Nnext_elim in heq.
        exists d'.
        rewrite mult_two_l.
        exact heq.
      }
    }
  }
  Qed.

  Lemma Ndestruct_odd_even : forall n:NN, (exists k, n = Nmult Ntwo k) \/ (exists k, n = Nnext (Nmult Ntwo k)).
  Proof.
  intro n.
  pattern n;apply Ninduction.
  {
    left.
    exists Nzero.
    rewrite Nmult_zero_r.
    reflexivity.
  }
  {
    clear n. intro n'. intro ih.
    destruct ih as [h|h].
    {
      destruct h as [k h].
      subst n'.
      right.
      exists k.
      reflexivity.
    }
    {
      destruct h as [k h].
      subst n'.
      left.
      exists (Nnext k).
      rewrite mult_two_l.
      rewrite mult_two_l.
      rewrite Nplus_next_r.
      rewrite Nplus_next_l.
      reflexivity.
    }
  }
  Qed.

  Lemma next_not_eq : forall n:NN, n = Nnext n -> False.
  Proof.
    intro n.
    pattern n;apply Ninduction.
    { intro heq. inversion heq. }
    {
      clear n. intro n'. intro ih.
      intro hneq.
      apply Nnext_elim in hneq.
      apply ih.
      exact hneq.
    }
  Qed.

  Lemma even_or_odd : forall (n:NN), Neven n \/ Nodd n.
  Proof.
    intro n.
    assert (h:=Ndestruct_odd_even n).
    destruct h as [h | h].
    {
      destruct h as [k h].
      left.
      unfold Neven.
      unfold divides.
      exists k.
      subst n.
      reflexivity.
    }
    {
      destruct h as [k h].
      right.
      unfold Nodd.
      unfold not.
      intro heven.
      unfold Neven in heven.
      unfold divides in heven.
      destruct heven as [k' h'].
      rewrite <- h' in h.
      clear h'. clear n.
      rename k into m.
      rename k' into n.
      repeat rewrite mult_two_l in h.
      generalize dependent m.
      pattern n;apply Ninduction.
      {
        intro m.
        rewrite Nplus_zero_l.
        intro h.
        inversion h.
      }
      {
        clear n. intros n' ih. intros m heq.
        rewrite Nplus_next_r in heq.
        rewrite Nplus_next_l in heq.
        apply Nnext_elim in heq.
        assert (dm:=Ndestruct m).
        destruct dm as [hl | hr].
        { subst m. rewrite Nplus_zero_l in heq. inversion heq. }
        {
          destruct hr as [m' heq'].
          subst m.
          specialize (ih m').
          apply ih.
          rewrite Nplus_next_r in heq.
          rewrite Nplus_next_l in heq.
          apply Nnext_elim in heq.
          exact heq.
        }
      }
    }
  Qed.






  Definition Nmin n m := match Nle_dec n m with
  | left _ => n
  | right _ => m
  end.

  Definition Nmax n m := match Nle_dec n m with
  | left _ => m
  | right _ => n
  end.

  Lemma min_nm : forall n m, Nle (Nmin n m) n /\ Nle (Nmin n m) m.
  Proof.
    intros n m.
    split.
    {
      unfold Nmin.
      destruct (Nle_dec n m).
      { apply Nle_refl. }
      { exact n0. }
    }
    {
      unfold Nmin.
      destruct (Nle_dec n m).
      { exact n0. }
      { apply Nle_refl. }
    }
  Qed.









  Lemma Nmin_zero_l : forall n, Nmin Nzero n = Nzero.
  Proof.
    intros (n, hn).
    induction n as [|head tail ih].
    { unfold min. simpl. reflexivity. }
    { unfold min. simpl. reflexivity. }
  Qed.

  Lemma Nle_zero_l : forall n, Nle n Nzero -> n = Nzero.
  Proof.
    intros (n,hn).
    unfold Nle.
    induction n as [|head tail ih].
    { simpl. intros _. apply proof_irrelevance. simpl. reflexivity. }
    { simpl. intro f. inversion f. }
  Qed.




  Lemma Nmin_comm : forall n m, Nmin n m = Nmin m n.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    {
      intro m. rewrite Nmin_zero_l.
      pattern m;apply Ninduction;clear m.
      { unfold min. simpl. reflexivity. }
      {
        intros m ih.
        unfold min.
        destruct (Nle_dec (Nnext m) Nzero).
        { apply Nle_zero_l in n. inversion n. }
        { reflexivity. }
      }
    }
    {
      intros n ih.
      intro m.
      assert (hd:=Ndestruct m).
      destruct hd as [heq|hnext].
      {
        subst m. rewrite Nmin_zero_l. unfold min.
        destruct (Nle_dec (Nnext n) Nzero).
        { apply Nle_zero_l in n0. inversion n0. }
        { reflexivity. }
      }
      {
        destruct hnext as [n' hn'].
        subst m.
        rename n' into m.
        specialize (ih m).
        unfold Nmin.
        destruct (Nle_dec (Nnext n) (Nnext m)).
        {
          destruct (Nle_dec (Nnext m) (Nnext n)).
          { apply Nle_antisym.
          { exact n0. }
          { exact n1. }
        }
        { reflexivity. }
      }
      {
        destruct (Nle_dec (Nnext m) (Nnext n)).
        { reflexivity. }
        {
          apply Nle_antisym.
          { exact n0. }
          { exact n1. }
        }
      }
    }
  }
  Qed.

  Lemma Nmin_zero_r : forall n, Nmin n Nzero = Nzero.
  Proof.
    intro n.
    rewrite Nmin_comm.
    apply Nmin_zero_l.
  Qed.

  Lemma Nmax_zero_l : forall n, Nmax Nzero n = n.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { unfold max. simpl. reflexivity. }
    {
      intros n' ih.
      unfold max. simpl. reflexivity.
    }
  Qed.

  Lemma Nmax_zero_r : forall n, Nmax n Nzero = n.
    Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { unfold max. simpl. reflexivity. }
    {
      intros n ih.
      unfold max.
      simpl.
      reflexivity.
    }
  Qed.

  Lemma Nmax_comm : forall n m, Nmax n m = Nmax m n.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { intro m. rewrite Nmax_zero_l. rewrite Nmax_zero_r. reflexivity. }
    {
      intros n' ih.
      intros m.
      unfold Nmax.
      destruct (Nle_dec (Nnext n') m);destruct (Nle_dec m (Nnext n')).
      { apply Nle_antisym. exact n0. exact n. }
      { reflexivity. }
      { reflexivity. }
      { apply Nle_antisym. exact n0. exact n. }
    }
  Qed.

  Lemma Nmin_next : forall n m, Nmin (Nnext n) (Nnext m) = Nnext (Nmin n m).
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    {
      intro m. rewrite Nmin_zero_l.
      unfold Nmin. destruct (Nle_dec (Nnext Nzero) (Nnext m)).
      { reflexivity. }
      { apply Nle_zero_l in n. subst m. reflexivity. }
    }
    {
      intros n ih.
      intro m.
      set (nnn:=Nnext (Nnext n)).
      set (nm:=Nnext m).
      set (nn:=Nnext n).
      unfold Nmin.
      destruct (Nle_dec nnn nm);destruct (Nle_dec nn m).
      { subst nnn. subst nn. reflexivity. }
      { subst nnn. subst nn. subst nm.
        apply Nle_antisym.
        { exact n0. }
        { apply Nle_next_intro. exact n1. }
      }
      { subst nnn. subst nn. subst nm.
        apply Nle_antisym.
        { exact n0. }
        { apply Nle_next_intro. exact n1. }
      }
      { subst nm. reflexivity. }
    }
  Qed.



  Lemma Nmax_next : forall n m, Nmax (Nnext n) (Nnext m) = Nnext (Nmax n m).
  Proof.
    intros n. pattern n;apply Ninduction;clear n.
    {
      intro m.
      rewrite Nmax_zero_l.
      unfold Nmax.
      destruct (Nle_dec (Nnext Nzero) (Nnext m)).
      { reflexivity. }
      { apply Nle_zero_l in n. subst m. reflexivity. }
    }
    {
      intros n' ih.
      intro m.
      unfold Nmax.
      destruct (Nle_dec (Nnext (Nnext n')) (Nnext m));
      destruct (Nle_dec (Nnext n') m).
      { reflexivity. }
      { apply Nle_antisym. apply Nle_next_intro. exact n0. exact n. }
      { apply Nle_antisym. apply Nle_next_intro. exact n0. exact n. }
      { reflexivity. }
    }
  Qed.

  Lemma plus_min_minus_max : forall n m, Nplus (Nmin n m) (Nrest n m) = Nmax n m.
  
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    {
      intro m.
      rewrite Nmin_zero_l.
      rewrite Nrest_zero_l.
      rewrite Nplus_zero_l.
      rewrite Nmax_zero_l.
      reflexivity.
    }
    {
      intros n' ih.
      intro m.
      destruct (Ndestruct m).
      {
        subst m.
        rewrite Nmin_zero_r.
        rewrite Nrest_zero_r.
        rewrite Nmax_zero_r.
        rewrite Nplus_zero_l.
        reflexivity.
      }
      {
        destruct H. subst m. rename x into m.
        rewrite Nmin_next.
        rewrite Nrest_next.
        rewrite Nmax_next.
        rewrite Nplus_next_l.
        apply f_eq.
        apply ih.
      }
    }
  Qed.

  Lemma zero_eq : forall (h:isnatural _Nzero), exist _ _Nzero h = Nzero.
  Proof.
    intro h.
    apply proof_irrelevance.
    simpl. reflexivity.
  Qed.


  Lemma Nle_zero_r : forall n, Nle Nzero n.
  Proof.
    intros (n, hn). unfold Nle. simpl.
    clear hn. destruct n.
    { simpl. trivial. }
    { simpl. trivial. }
  Qed.

  Lemma Nmin_le : forall x y, x = Nmin x y -> Nle x y.
  Proof.
    intro x.
    pattern x;apply Ninduction;clear x.
    { intros y h. apply Nle_zero_r. }
    {
      intros n ih.
      intros y h.
      destruct (Ndestruct y).
      { subst y. rewrite Nmin_zero_r in h. inversion h. }
      {
        destruct H. subst y. rewrite Nmin_next in h. apply Nnext_elim in h.
        apply Nle_next_intro. apply ih. exact h.
      }
    }
  Qed.

  Lemma destruct_min_le_n : forall n m, (Nle n m /\ Nmin n m = n) \/ (Nle m n /\ Nmin n m = m).
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    {
      intro m.
      rewrite Nmin_zero_l.
      left.
      split.
      { apply Nle_zero_r. }
      { reflexivity. }
    }
    {
      intros n' ih.
      intro m.
      destruct (Ndestruct m).
      {
        subst m. rewrite Nmin_zero_r. right. split.
        { apply Nle_zero_r. }
        { reflexivity. }
      }
      {
        destruct H. subst m. rename x into m'.
        rewrite Nmin_next.
        specialize (ih m').
        destruct ih as [ih|ih].
        {
          destruct ih as [hle heq]. left. split.
          { apply Nle_next_intro. exact hle. }
          { apply f_eq. exact heq. }
        }
        {
          destruct ih as [hle heq]. right. split.
          { apply Nle_next_intro. exact hle. }
          { apply f_eq. exact heq. }
        }
      }
    }
  Qed.

  Lemma Nle_nmk : forall n m, Nle n m -> exists k, Nplus n k = m.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { intros m h. exists m. rewrite Nplus_zero_l. reflexivity. }
    {
      intros n ih.
      intros m h.
      destruct (Ndestruct m).
      { subst m. inversion h. }
      {
        destruct H. subst m. rename x into m'.
        apply Nle_next_elim in h.
        specialize (ih m'). specialize (ih h). destruct ih. exists x.
        rewrite Nplus_next_l. rewrite H. reflexivity.
      }
    }
  Qed.

  Lemma Nrest_plus_nmm : forall n m, Nrest (Nplus n m) m = n.
  Proof.
    intros n m.
    generalize dependent n.
    pattern m;apply Ninduction;clear m.
    { intro n. rewrite Nplus_zero_r. rewrite Nrest_zero_r. reflexivity. }
    {
      intros m' ih. intro n.
      rewrite Nplus_next_r.
      rewrite Nrest_next.
      specialize (ih n).
      exact ih.
    }
  Qed.

  Lemma min_nm_neq_n : forall n m, Nmin n m <> n -> Nmin n m = m.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { intro m. rewrite Nmin_zero_l. intro h. exfalso. apply h. reflexivity. }
    {
    intros n' ih m h.
    destruct (Ndestruct m).
    { subst m. rewrite Nmin_zero_r. reflexivity. }
    {
    destruct H. subst m. rename x into m'.
    rewrite Nmin_next.
    apply f_eq.
    specialize (ih m').
    apply ih.
    intro heq.
    apply h.
    rewrite Nmin_next.
    apply f_eq.
    exact heq.
    }
    }
Qed.

  Lemma Nmin_neq_le : forall n m, Nmin n m <> n -> Nle m n.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { intros. rewrite Nmin_zero_l in *. exfalso. apply H. reflexivity. }
    { intros. destruct (Ndestruct m).
    subst m. rewrite Nmin_zero_r in *. apply Nle_zero_r.
    destruct H1. subst m. rewrite Nmin_next in H0. apply Nle_next_intro.
    apply H. intro heq. apply H0. apply f_eq. assumption.
    }
  Qed.

  Lemma Nle_plus_elim_l : forall n m k, Nle (Nplus n m) (Nplus n k) -> Nle m k.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { intros. repeat rewrite Nplus_zero_l in *. assumption. }
    {
      intros.
      repeat rewrite Nplus_next_l in H0.
      apply Nle_next_elim in H0.
      specialize (H _ _ H0). assumption.
    }
  Qed.

  Lemma Nle_plus_elim_r : forall n m k, Nle (Nplus m n) (Nplus k n) -> Nle m k.
  Proof.
    intros.
    repeat rewrite (Nplus_comm _ n) in H.
    apply Nle_plus_elim_l in H.
    assumption.
  Qed.

  Lemma Nle_plus_elim_zero_l : forall n m, Nle (Nplus m n) n -> m = Nzero.
  Proof.
    intros n m h.
    rewrite <- Nplus_zero_l in h.
    apply Nle_plus_elim_r in h.
    apply Nle_zero_l in h.
    assumption.
  Qed.

  Lemma Nle_plus_elim_zero_r : forall n m, Nle (Nplus n m) n -> m = Nzero.
  Proof.
    intros n m.
    rewrite Nplus_comm.
    apply Nle_plus_elim_zero_l.
  Qed.

  Lemma Nrest_one : forall n:NN, n <> Nzero -> Nnext (Nrest n None) = n.
  Proof.
    intros n.
    induction n using Ninduction.
    { intro i. contradiction i. reflexivity. }
    { intros _. unfold None. rewrite Nrest_next. rewrite Nrest_zero_r. reflexivity. }
  Qed.

  Definition Ndestruct_dec n : sumbool (n=Nzero) (exists n', n = Nnext n').
  Proof.
    destruct (Neq_dec n Nzero) as [d|d].
    { left. exact d. }
    { right. exists (Nrest n None). rewrite Nrest_one. reflexivity. exact d. }
  Qed.



  Lemma Nneq_zero_lt : forall x:NN, x <> Nzero -> Nlt Nzero x.
  Proof.
    intros x h.
    unfold Nlt.
    destruct (Ndestruct x).
    { subst x. contradiction h. reflexivity. }
    { destruct H. subst x. apply Nle_next_intro. apply Nle_zero_r. }
  Qed.

  Lemma xxx : forall x y ,x <> y -> Nle x y -> Nlt x y.
intro x.
induction x using Ninduction.
{ intros. unfold Nlt. destruct (Ndestruct y).
{ subst y. contradiction H. reflexivity. }
{ destruct H1. subst y. apply Nle_next_intro. apply Nle_zero_r. }
}
{ intros. unfold Nlt in *.
destruct (Ndestruct y).
{ subst y. inversion H0. }
{ destruct H1. subst y. apply Nle_next_intro.
apply IHx.
intro. subst x0. apply H. reflexivity.
apply Nle_next_elim. assumption.
}
}
Qed.

  Definition Nlt_dec x y : sumbool (Nle x y) (Nlt y x).
    destruct (Neq_dec x y).
    { subst y. left. apply Nle_refl. }
    { destruct (Nle_dec x y).
      { left. assumption. }
      { right. apply xxx. intro. subst y. apply n. reflexivity. assumption. }
    }
  Defined.

Definition computational_eq {m n} (opaque_eq:m=n) : m = n :=
match Neq_dec m n with
| left transparent_eq => transparent_eq
| _ => opaque_eq
end.


Definition Npred (n:NN) (h:Nlt Nzero n) := Nrest n None.

Lemma Nnext_pred : forall n h, Nnext (Npred n h) = n.
Proof.
  intro n.
  induction n using Ninduction.
  { intros. inversion h. }
  {
    intros. unfold Npred.
    unfold None. rewrite Nrest_next. rewrite Nrest_zero_r.
    reflexivity.
  }
Qed.

Definition uu : forall x : NN, (forall y : NN, Nlt y x -> NN -> NN) -> NN -> NN.
intros. apply Nzero.
Defined.
Print uu.

Lemma vv x (r:Nzero <> x) : Nlt (Nrest x None) x.
Proof.
unfold Nlt.
unfold None.
assert (u:=Nnext_pred).
specialize (u x).
assert (v:Nlt Nzero x).
apply Nneq_zero_lt. intro heq. subst x. apply r. reflexivity.
specialize (u v).
pattern x at 1;rewrite <- u. rewrite Nrest_next. rewrite Nrest_zero_r.
rewrite u. apply Nle_refl.
Defined.

Definition _Nfact_main (x:NN) (f : forall y : NN, Nlt y x -> NN) : NN.
destruct (Neq_dec Nzero x).
{ apply None. }
{
  specialize (f (Nrest x None)).
  assert (Nlt (Nrest x None) x).
  { apply vv. exact n. }
  specialize (f H).
  apply (Nmult x f).
}
Defined.

Definition Nfact := Fix Nlt_wf _ _Nfact_main.

Lemma Nfact_zero : Nfact Nzero = None.
unfold Nfact. unfold Fix. simpl.
unfold _Nfact_main. simpl. reflexivity.
Qed.

Lemma Nfact_one: Nfact None = None.
Proof.
unfold Nfact.
assert (h:=Fix_eq).
specialize (h NN Nlt Nlt_wf).
specialize (h _ _Nfact_main).
rewrite h.
{
unfold _Nfact_main. rewrite Nmult_one_l. rewrite Nrest_cancel.
rewrite h.
{
unfold _Nfact_main. simpl. reflexivity. }
{
clear h.
intros.
unfold _Nfact_main.
destruct (Neq_dec _).
{ reflexivity. }
{ rewrite H. reflexivity. }
}
}
clear h.
intros.
unfold _Nfact_main.
destruct (Neq_dec _).
{ reflexivity. }
{ rewrite H. reflexivity. }
Qed.

Lemma Nfact_r : forall n, Nfact (Nnext n) = Nmult (Nnext n) (Nfact n).
Proof.
intro n.
induction n using Ninduction.
{
rewrite Nfact_zero. rewrite Nmult_one_r.
fold None. rewrite Nfact_one. reflexivity.
}
{
rename IHn into ih.
remember (Nfact n) as fn.
remember (Nfact (Nnext n)) as fnn.
remember (Nfact (Nnext (Nnext n))) as fnnn.
unfold Nfact in Heqfnnn.
rewrite Fix_eq in Heqfnnn.
{
unfold _Nfact_main in Heqfnnn.
destruct (Neq_dec _) in Heqfnnn.
{ inversion e. }
{
unfold Nfact in Heqfnn.
unfold _Nfact_main in Heqfnn.
unfold None at 3 in Heqfnnn.
rewrite Nrest_next in Heqfnnn.
rewrite Nrest_zero_r in Heqfnnn.
rewrite <- Heqfnn in Heqfnnn.
rewrite Heqfnnn.
reflexivity.
}
}
{
clear. intros.
unfold _Nfact_main.
destruct (Neq_dec _).
{ reflexivity. }
{ rewrite H. reflexivity. }
}
}
Qed.

