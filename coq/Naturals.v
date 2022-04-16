
  (* In this file, we construct the natural numbers (0, 1, 2, ...)
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

  (* n <= next n *)
  Lemma Nle_next : forall n, Nle n (Nnext n).
  Proof.
    intro n.
    induction n as [|n ih] using Ninduction.
    { unfold Nle. simpl. trivial. }
    { apply Nle_next_intro. exact ih. }
  Qed.

  (* 0 <= n *)
  Lemma Nle_zero_l : forall n, Nle Nzero n.
  Proof.
    intro n.
    induction n as [|n ih] using Ninduction.
    { apply Nle_refl. }
    {
      apply Nle_trans with n.
      { exact ih. }
      { apply Nle_next. }
    }
  Qed.

  (* n <= 0 -> n = 0 *)
  Lemma Nle_zero_r : forall n, Nle n Nzero -> n = Nzero.
  Proof.
    intro n.
    induction n as [|n ih] using Ninduction.
    { intros _. reflexivity. }
    { intro h. inversion h. }
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
  Lemma _Nrest_natural : forall l m, isnatural l -> isnatural m ->
    isnatural (_Nrest l m).
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

  (* When n is not zero, (rest n 1) < n *)
  Lemma Nrest_one_lt : forall n:NN, Nzero <> n -> Nlt (Nrest n None) n.
  Proof.
    intro n.
    induction n as [|n _] using Ninduction.
    (* n is zero *)
    {
      (* then this contradict the hypothesis *)
      intro f. contradiction f. reflexivity.
    }
    {
      (* otherwise, it is straightforward *)
      intros _.
      unfold None.
      rewrite Nrest_next.
      rewrite Nrest_zero_r.
      unfold Nlt.
      apply Nle_refl.
    }
  Qed.

  (* We are about to define addition using Fix.
     That's still quite confusing to be, and I had to go through a lot of trial and error
     and copy/pasting from the Internet to arrive at this *)

  (* In particular, I have some trouble understanding this definition *)
  Definition _NRecType (a : NN) := forall b : NN, NN.

  (* But anyway, we will use it to define the recursive part of addition *)
  Definition _Nplus_rec : forall x : NN,
    (forall y : NN,(Nlt y x) -> _NRecType y) -> _NRecType x.
    (* We actually construct that function by 'proving' it *)
    (* We have a number *)
    intro x.
    (* And a recursive function *)
    intro rec.
    (* We can unfold that thing *)
    unfold _NRecType.
    (* ok, we have another number *)
    intro y.
    (* If x is zero, then we return y, otherwise, we proceed with the recursive case *)
    destruct (Neq_dec Nzero x) as [d|d].
    (* Case x = 0 *)
    { apply y. }
    (* Recursive case *)
    {
      (* We want to go down by one, and that's (rest x 1),
         which is ok because x is not zero *)
      specialize (rec (Nrest x None)).
      (* We need to prove that we are actually going down, and we can use the
         lemma we proved earlier just for that *)
      apply Nrest_one_lt in d. specialize (rec d). clear d.
      (* Now we unfold the thing again *)
      unfold _NRecType in rec.
      (* We give y to rec, why not ? *)
      specialize (rec y).
      (* And we set the next of rec as the result *)
      apply (Nnext rec).
    }
    (* Does that look like plus to you ? If so, bravo ! *)
  Defined.

  (* Now we simply give the proof that Nlt is well founded to fix, along with the recursive
     part, to Fix, and we have our general-recursion fixpoint definition of 'plus' *)
  Definition Nplus := Fix Nlt_wf _ _Nplus_rec.
  Notation "x +n y" := (Nplus x y) (only printing, at level 50) : maths. 

  (* It's a function from NN into _NRecType *)
  Check Nplus.
  (* But if we give it two numbers, it goes through the definition of _NRecType and we 
     get another number, so that's look like a binary operation on NN *)
  Check (Nplus Nzero Nzero).

  (* Let's see if our addition has the properties of an addition *)
  (* First, we'll start with zero *)

  (* 0 + n = n *)
  Lemma Nplus_zero_l : forall n, Nplus Nzero n = n.
  Proof.
    (* The strategy here is to unfold the fixpoint to go straight into the base case *)
    intro n.
    (* unfold these three things *)
    unfold Nplus.
    unfold _Nplus_rec.
    unfold Fix.
    (* It's ugly, but it somehow simplifies *)
    simpl.
    (* magic *)
    reflexivity.
  Qed.

  (* n + 0 = n *)
  Lemma Nplus_zero_r : forall n, Nplus n Nzero = n.
  Proof.
    (* For the other side, we don't know commutativity yet, so we have to
       proceed by induction *)
    intro n.
    induction n as [|n ih] using Ninduction.
    (* n = 0 *)
    { rewrite Nplus_zero_l. reflexivity. }
    (* Induction step *)
    {
      (* We can use Fix_eq to unfold one step *)
      unfold Nplus.
      rewrite Fix_eq.
      (* This generates a weird second goal that is a bit annoying but not difficult to
         prove, we'll look at it after *)
      {
        (* If you can read this, you're lucky, all I know is that I can unfold _Nplus_rec *)
        unfold _Nplus_rec.
        (* That's ugly, but we can destruct the if part *)
        destruct (Neq_dec _) as [d|d].
        {
          (* That's impossible, but oh! look, the hypothesis is the same as the goal *)
          exact d.
        }
        {
          (* Now the idea is to make the goal look a bit like the induction hypothesis *)
          clear d.
          (* First, we can simplify the Nrest part *)
          unfold None at 2.
          rewrite Nrest_next.
          rewrite Nrest_zero_r.
          (* Remove 'next' on both sides *)
          apply f_eq.
          (* I know it's hard to belive, but you're actually looking at n + 0 = n here *)
          unfold Nplus in ih.
          unfold _Nplus_rec in ih.
          (* And we're done! *)
          exact ih.
        }
      }
      {
        (* This weird part is to guarantee some good property of _Nplus_rec *)
        clear. intros x f g h.
        (* We can unfold _Nplus_rec *)
        unfold _Nplus_rec.
        (* And investigate both possibilities for Neq_dec *)
        destruct (Neq_dec _) as [d|d].
        (* In this branch, we have equality *)
        { reflexivity. }
        (* In this branch, we need to do some rewriting *)
        { rewrite h. reflexivity. }
      }
    }
  Qed.

  (* Now, it's nice to know how 'plus' and 'next' interact *)

  (* (next n) + m = next (n+m) *)
  Lemma Nplus_next_l : forall n m, Nplus (Nnext n) m = Nnext (Nplus n m).
  Proof.
    intro n.
    induction n as [|n ih] using Ninduction.
    (* n = 0 *)
    {
      intro m.
      rewrite Nplus_zero_l.
      (* We should get to our answer with only one unfolding of the fixpoint *)
      unfold Nplus.
      rewrite Fix_eq.
      {
        unfold _Nplus_rec.
        destruct (Neq_dec _) as [d|d].
        (* Contradiction *)
        { inversion d. }
        {
          unfold None at 2.
          rewrite Nrest_cancel.
          apply f_eq.
          unfold Fix.
          simpl.
          (* yeah ! *)
          reflexivity.
        }
      }
      (* And we have to deal with this weird thing again *)
      {
        clear.
        intros x f g h.
        unfold _Nplus_rec. destruct (Neq_dec _) as [d|d].
        reflexivity. rewrite h. reflexivity.
      }
    }
    (* Induction case *)
    {
      intro m.
      rewrite ih. clear ih.
      (* Usually, once the induction hypothesis is used, we're set *)
      (* We have to unfold the fixpoint to get further *)
      unfold Nplus at 1.
      rewrite Fix_eq.
      {
        unfold _Nplus_rec at 1.
        destruct (Neq_dec _) as [d|d].
        { inversion d. }
        {
          clear d.
          apply f_eq.
          unfold None.
          rewrite Nrest_next.
          rewrite Nrest_zero_r.
          unfold Nplus.
          (* Too bad, we need to unfold again *)
          rewrite Fix_eq.
          {
            unfold _Nplus_rec at 1.
            destruct (Neq_dec _) as [d|d].
            { inversion d. }
            {
              unfold None at 1.
              rewrite Nrest_next.
              rewrite Nrest_zero_r.
              (* yipee ! *)
              reflexivity.
            }
          }
          (* What's left is the usual noise *)
          {
            clear. intros x f g h. unfold _Nplus_rec.
            destruct (Neq_dec _) as [d|d].
            { reflexivity. }
            { rewrite h. reflexivity. }
          }
        }
      }
      {
        clear. intros x f g h. unfold _Nplus_rec.
        destruct (Neq_dec _) as [d|d].
        { reflexivity. }
        { rewrite h. reflexivity. }
      }
    }
  Qed.

  (* n + (next m) = next (n+m) *)
  Lemma Nplus_next_r : forall n m, Nplus n (Nnext m) = Nnext (Nplus n m).
  Proof.
    (* That's the same thing on the right *)
    intros n.
    induction n as [|n ih] using Ninduction.
    (* n = 0 *)
    {
      intro m.
      (* This time, we have zero in scope of 'plus' on both sides *)
      rewrite Nplus_zero_l. rewrite Nplus_zero_l.
      reflexivity.
    }
    (* Induction case *)
    {
      intro m.
      (* It's accidental, but I'm still doing the induction on n, when I moved
         'next' to m. *)
      (* But that allows me to reuse the previous lemma *)
      rewrite Nplus_next_l.
      rewrite Nplus_next_l.
      rewrite ih.
      (* And we have equality *)
      reflexivity.
    }
  Qed.

  (* Addition is commutative *)
  Lemma Nplus_comm : commutative Nplus.
  Proof.
    (* Using the previous lemmas, this is now easy *)
    red.
    intro n.
    induction n as [|n ih] using Ninduction.
    (* n = 0 *)
    {
      intro m.
      rewrite Nplus_zero_l.
      rewrite Nplus_zero_r.
      reflexivity.
    }
    (* Induction step *)
    {
      intro m.
      rewrite Nplus_next_l.
      rewrite Nplus_next_r.
      rewrite ih.
      reflexivity.
    }
  Qed.

  (* Addition is associative *)
  Lemma Nplus_assoc : associative Nplus.
  Proof.
    red.
    intro n.
    induction n as [|n ih] using Ninduction.
    (* n = 0 *)
    {
      intros m k.
      rewrite Nplus_zero_l.
      rewrite Nplus_zero_l.
      reflexivity.
    }
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

  (* Next, two trivial lemmas that are useful to have *)

  (* n = m -> n + k = m + k *)
  Lemma Nplus_intro_r : forall n m k, n = m -> Nplus n k = Nplus m k.
  Proof.
  intros n m k heq. subst m. reflexivity.
  Qed.

  (* n = m -> k + n = k + m *)
  Lemma Nplus_intro_l : forall n m k, n = m -> Nplus k n = Nplus k m.
  Proof.
  intros n m k heq. subst m. reflexivity.
  Qed.

  (* The converse lemmas quite straighforward *)

  (* n + k = m + k -> n = m *)
  Lemma Nplus_elim_r : forall n m k, Nplus n k = Nplus m k -> n = m.
  Proof.
    intros n m k.
    generalize dependent m.
    generalize dependent n.
    induction k as [|k ih] using Ninduction.
    (* k = 0 *)
    {
      intros n m heq.
      rewrite Nplus_zero_r in heq.
      rewrite Nplus_zero_r in heq.
      exact heq.
    }
    (* Induction step *)
    {
      intros n m heq.
      rewrite Nplus_next_r in heq.
      rewrite Nplus_next_r in heq.
      apply Nnext_elim in heq.
      apply ih.
      exact heq.
    }
  Qed.

  (* k + n = k + m -> n = m *)
  Lemma Nplus_elim_l : forall n m k, Nplus k n = Nplus k m -> n = m.
  Proof.
    intros n m k heq.
    apply Nplus_elim_r with k.
    rewrite (Nplus_comm n).
    rewrite (Nplus_comm m).
    exact heq.
  Qed.

  (* Two specializations for 0 *)

  (* n + m = n -> m = 0 *)
  Lemma Nplus_elim_zero_l : forall n m, Nplus n m = n -> m = Nzero.
  Proof.
    intros n m heq.
    apply Nplus_elim_l with n.
    rewrite Nplus_zero_r.
    exact heq.
  Qed.

  (* n + m = m -> n = 0 *)
  Lemma Nplus_elim_zero_r : forall n m, Nplus n m = m -> n = Nzero.
  Proof.
    intros n m heq.
    apply Nplus_elim_zero_l with m.
    rewrite Nplus_comm.
    exact heq.
  Qed.

  (* Link between next and plus *)
  (* next n = n + 1 *)
  Lemma Nnext_eq : forall n, Nnext n = Nplus n None.
  Proof.
    intro n.
    unfold None.
    rewrite Nplus_next_r.
    rewrite Nplus_zero_r.
    reflexivity.
  Qed.

  (* This is a handy lemma for when a sum is zero *)

  (* If n + m = 0, then n = 0 and m = 0 *)
  Lemma Nplus_zero : forall (n m:NN), Nplus n m = Nzero -> n = Nzero /\ m = Nzero.
  Proof.
    intro n.
    induction n as [|n ih] using Ninduction.
    (* n = 0 *)
    {
      (* If n is zero, then m is zero *)
      intros m heq.
      rewrite Nplus_zero_l in heq.
      subst m.
      split;reflexivity.
    }
    (* Induction case *)
    {
      (* Otherwise, we have a contradiction *)
      intros m heq.
      rewrite Nplus_next_l in heq.
      inversion heq.
    }
  Qed.

  (* If n + m = 1, then n = 1 or m = 1 *)
  Lemma Nplus_one : forall (n m:NN), Nplus n m = None -> n = None \/ m = None.
  Proof.
    intro n.
    induction n as [|n _] using Ninduction.
    (* n = 0 *)
    {
      (* then m = 1 *)
      intros m heq.
      rewrite Nplus_zero_l in heq.
      right. exact heq.
    }
    (* n is not zero *)
    {
      intros m heq.
      rewrite Nplus_next_l in heq.
      unfold None in heq.
      apply Nnext_elim in heq.
      (* Then n and m are zero *)
      apply Nplus_zero in heq.
      destruct heq as [heqn heqm].
      subst n m.
      (* which means the original n was one *)
      left.
      fold None.
      reflexivity.
    }
  Qed.

  (* In this part, we prove some properties of Nplus and Nle *)

  (* n <= m -> k + n <= k + m *)
  Lemma Nle_plus_intro_l: forall n m k : NN, Nle n m -> Nle (Nplus k n) (Nplus k m).
  Proof.
    intros n m k.
    generalize dependent m.
    generalize dependent n.
    (* k = 0 *)
    induction k as [|k ih] using Ninduction.
    {
      intros n m h.
      rewrite Nplus_zero_l.
      rewrite Nplus_zero_l.
      exact h.
    }
    (* Induction step *)
    {
      intros n m h.
      rewrite Nplus_next_l.
      rewrite Nplus_next_l.
      apply Nle_next_intro.
      apply ih.
      exact h.
    }
  Qed.

  (* n <= m -> n + k <= m + k *)
  Lemma Nle_plus_intro_r: forall n m k : NN, Nle n m -> Nle (Nplus n k) (Nplus m k).
  Proof.
    intros n m k h.
    rewrite (Nplus_comm n).
    rewrite (Nplus_comm m).
    apply Nle_plus_intro_l.
    exact h.
  Qed.

  (* k + n <= k + m -> n <= m *)
  Lemma Nle_plus_elim_l: forall n m k : NN, Nle (Nplus k n) (Nplus k m) -> Nle n m.
  Proof.
    intros n m k.
    generalize dependent m.
    generalize dependent n.
    induction k as [|k ih] using Ninduction.
    (* k = 0 *)
    {
      intros n m h.
      rewrite Nplus_zero_l in h.
      rewrite Nplus_zero_l in h.
      exact h.
    }
    (* Induction step *)
    {
      intros n m h.
      rewrite Nplus_next_l in h.
      rewrite Nplus_next_l in h.
      apply Nle_next_elim in h.
      apply ih.
      exact h.
    }
  Qed.

  (* n + k <= m + k -> n <= m *)
  Lemma Nle_plus_elim_r: forall n m k : NN, Nle (Nplus n k) (Nplus m k) -> Nle n m.
  Proof.
    intros n m k h.
    apply Nle_plus_elim_l with k.
    rewrite (Nplus_comm k).
    rewrite (Nplus_comm k).
    exact h.
  Qed.

  (* n + m <= n -> m = 0 *)
  Lemma Nle_plus_elim_zero_r: forall n m : NN, Nle (Nplus n m) n -> m = Nzero.
  Proof.
    intros n m h.
    rewrite <- Nplus_zero_r in h.
    apply Nle_plus_elim_l in h.
    apply Nle_zero_r in h.
    exact h.
  Qed.

  (* n + m <= m -> n = 0 *)
  Lemma Nle_plus_elim_zero_l: forall n m : NN, Nle (Nplus n m) m -> n = Nzero.
  Proof.
    intros n m h.
    apply Nle_plus_elim_zero_r with m.
    rewrite Nplus_comm.
    exact h.
  Qed.


  (* In this section, we define min and max and prove a number of properties *)

  Definition Nmin n m := match Nle_dec n m with
  | left _ => n
  | right _ => m
  end.

  (* min is commutative *)
  Lemma Nmin_comm : commutative Nmin.
  Proof.
    red.
    intros n m.
    unfold Nmin.
    (* We simply examine all possibilities and use antisymmetry of Nle *)
    destruct (Nle_dec n m) as [dnm|dnm];
    destruct (Nle_dec m n) as [dmn|dmn].
    { apply Nle_antisym. exact dnm. exact dmn. }
    { reflexivity. }
    { reflexivity. }
    { apply Nle_antisym. exact dnm. exact dmn. }
  Qed.

  (* min is associative *)
  Lemma Nmin_assoc : associative Nmin.
  Proof.
    red.
    intros n m k.
    remember (Nmin n m) as nm.
    remember (Nmin m k) as mk.
    unfold Nmin in *.
    (* We can try to be smart, and destruct things as needed,
       or brutally destruct and examine all 16 cases, which is what we go for here *)
    destruct (Nle_dec n m) as [d1|d1];
    destruct (Nle_dec m k) as [d2|d2];
    destruct (Nle_dec nm k) as [d3|d3];
    destruct (Nle_dec n mk) as [d4|d4].
    (* Strategy is to see reflexivity, otherwise try antisymmetry, and otherwise
       use transitivity with the remaining variable *)
    { subst. reflexivity. }
    { subst. apply Nle_antisym;try assumption. }
    {
      subst. apply Nle_antisym;try assumption.
      apply Nle_trans with m;assumption.
    }
    {
      subst. apply Nle_antisym;try assumption.
      apply Nle_trans with n;assumption.
    }
    { subst. reflexivity. }
    { subst. apply Nle_antisym;try assumption. }
    { subst. apply Nle_antisym;try assumption. }
    { subst. reflexivity. }
    { subst. apply Nle_antisym;try assumption. }
    { subst. reflexivity. }
    { subst. apply Nle_antisym;try assumption.
      apply Nle_trans with m;try assumption.
      apply Nle_trans with m;try assumption.
    }
    { subst. apply Nle_antisym;try assumption. }
    { subst. apply Nle_antisym;try assumption.
      apply Nle_trans with k;try assumption.
    }
    { subst. apply Nle_antisym;try assumption. }
    { subst. apply Nle_antisym;try assumption.
      apply Nle_trans with m;try assumption.
    }
    { subst. reflexivity. }
  Qed.



  (* min 0 n = 0 *)
  Lemma Nmin_zero_l : forall n, Nmin Nzero n = Nzero.
  Proof.
    intro n.
    unfold Nmin.
    destruct (Nle_dec _) as [d|d].
    { reflexivity. }
    { apply Nle_zero_r in d. subst n. reflexivity. }
  Qed. 

  (* max n 0 = 0 *)
  Lemma Nmin_zero_r : forall n, Nmin n Nzero = Nzero.
  Proof.
    intro n.
    rewrite Nmin_comm.
    rewrite Nmin_zero_l.
    reflexivity.
  Qed. 

  (* min n n = n *)
  Lemma Nmin_cancel : forall n, Nmin n n  = n.
  Proof.
    intro n.
    unfold Nmin.
    destruct (Nle_dec _) as [d|d].
    reflexivity.
    reflexivity.
  Qed. 

  (* min (next n) (next m) = min n m *)
  Lemma Nmin_next : forall n m, Nmin (Nnext n) (Nnext m)  = Nnext (Nmin n m).
  Proof.
    intros n m.
    unfold Nmin.
    destruct (Nle_dec _) as [d1|d1];
    destruct (Nle_dec _) as [d2|d2].
    { reflexivity. }
    { apply Nle_antisym. exact d1. apply Nle_next_intro. exact d2. }
    { apply Nle_antisym. exact d1. apply Nle_next_intro. exact d2. }
    { reflexivity. }
  Qed.

  (* min n m = n -> n <= m *)
  Lemma Nmin_le : forall n m, Nmin n m = n -> Nle n m.
  Proof.
    intros n m h.
    unfold Nmin in h.
    destruct (Nle_dec _) as [d|d].
    { exact d. }
    { subst m. exact d. }
  Qed.

  Definition Nmax n m := match Nle_dec n m with
  | left _ => m
  | right _ => n
  end.

  (* max is commutative *)
  Lemma Nmax_comm : commutative Nmax.
  Proof.
    red.
    intros n m.
    unfold Nmax.
    (* We simply examine all possibilities and use antisymmetry of Nle *)
    destruct (Nle_dec n m) as [dnm|dnm];
    destruct (Nle_dec m n) as [dmn|dmn].
    { apply Nle_antisym. exact dmn. exact dnm. }
    { reflexivity. }
    { reflexivity. }
    { apply Nle_antisym. exact dmn. exact dnm. }
  Qed.

  (* max is associative *)
  Lemma Nmax_assoc : associative Nmax.
  Proof.
    (* Same strategy as for min, but we use even more proof automation *)
    (* I am not a big fan of proof automation because the details of a proof
       are what make it interesting, but in this particular case, there's not
       much to enjoy from the details. *)
    red.
    intros n m k.
    remember (Nmax n m) as nm.
    remember (Nmax m k) as mk.
    unfold Nmax in *.
    destruct (Nle_dec n m) as [d1|d1];
    destruct (Nle_dec m k) as [d2|d2];
    destruct (Nle_dec nm k) as [d3|d3];
    destruct (Nle_dec n mk) as [d4|d4];
    subst;
    try reflexivity;
    try apply Nle_antisym;
    try assumption.
    { apply Nle_trans with m;assumption. }
    { apply Nle_trans with k;assumption. }
    { apply Nle_trans with m;assumption. }
    { apply Nle_trans with m;assumption. }
    { apply Nle_trans with n;assumption. }
    { apply Nle_trans with m;assumption. }
  Qed.

  (* max 0 n = n *)
  Lemma Nmax_zero_l : forall n, Nmax Nzero n = n.
  Proof.
    intro n.
    unfold Nmax.
    destruct (Nle_dec _) as [d|d].
    { reflexivity. }
    { apply Nle_zero_r in d. subst n. reflexivity. }
  Qed. 

  (* max n 0 = n *)
  Lemma Nmax_zero_r : forall n, Nmax n Nzero = n.
  Proof.
    intro n.
    rewrite Nmax_comm.
    rewrite Nmax_zero_l.
    reflexivity.
  Qed. 

  (* max n n = n *)
  Lemma Nmax_cancel : forall n, Nmax n n  = n.
  Proof.
    intro n.
    unfold Nmax.
    destruct (Nle_dec _) as [d|d].
    reflexivity.
    reflexivity.
  Qed. 

  (* max (next n) (next m) = max n m *)
  Lemma Nmax_next : forall n m, Nmax (Nnext n) (Nnext m)  = Nnext (Nmax n m).
  Proof.
    intros n m.
    unfold Nmax.
    destruct (Nle_dec _) as [d1|d1];
    destruct (Nle_dec _) as [d2|d2].
    { reflexivity. }
    { apply Nle_antisym. apply Nle_next_intro. exact d2. exact d1. }
    { apply Nle_antisym. exact d2. apply Nle_next_intro. exact d1. }
    { reflexivity. }
  Qed.

  (* max n m = n -> m <= n *)
  Lemma Nmax_le : forall n m, Nmax n m = n -> Nle m n.
  Proof.
    intros n m h.
    unfold Nmax in h.
    destruct (Nle_dec _) as [d|d].
    { subst m. exact d. }
    { exact d. }
  Qed.  













  (* That's all nice, we are now ready to define multiplication ! *)

  Parameter A : NN.
  Parameter B : NN.

  Definition _Nmult_rec : forall x : NN,
    (forall y : NN,(Nlt y x) -> _NRecType y) -> _NRecType x.
  Proof.
    intro x.
    intro rec.
    unfold _NRecType.
    intro y.
    destruct (Neq_dec Nzero x) as [d|d].
    { apply Nzero. }
    {
      specialize (rec (Nrest x None)).
      apply Nrest_one_lt in d. specialize (rec d). clear d.
      unfold _NRecType in rec.
      specialize (rec y).
      apply (Nplus y rec).
    }
  Defined.

  Definition Nmult := Fix Nlt_wf _ _Nmult_rec.
  Notation "x *n y" := (Nmult x y) (only printing, at level 50) : maths. 



  Lemma Nmult_zero_l : forall n, Nmult Nzero n = Nzero.
  Proof.
    intro n.
    unfold Nmult.
    unfold Fix.
    unfold _Nmult_rec.
    simpl.
    reflexivity.
  Qed.

  Lemma Nmult_zero_r : forall n, Nmult n Nzero = Nzero.
Proof.
intro n.
induction n as [|n ih] using Ninduction.
{ rewrite Nmult_zero_l. reflexivity. }
{
unfold Nmult. rewrite Fix_eq.
{
unfold _Nmult_rec.
destruct (Neq_dec _) as [d|d].
{ inversion d. }
{ 
unfold None at 2. rewrite Nrest_next. rewrite Nrest_zero_r.
rewrite Nplus_zero_l.
clear d.
fold _Nmult_rec.
fold Nmult.
exact ih.
}
}
{
clear.
intros x f g h.
unfold _Nmult_rec.
destruct (Neq_dec _).
reflexivity.
rewrite h.
reflexivity.
}
}
Qed.

  Lemma Nmult_one_l : forall n, Nmult None n = n.
Proof.
intro n.
unfold Nmult.
unfold _Nmult_rec.
rewrite Fix_eq.
{ destruct (Neq_dec _) as [d|d].
{ inversion d. }
{
clear d.
rewrite Nrest_cancel.
fold _Nmult_rec.
fold Nmult.
rewrite Nmult_zero_l.
rewrite Nplus_zero_r.
reflexivity.
}
}
{
clear. intros x f g h.
destruct (Neq_dec _). reflexivity.
rewrite h. reflexivity.
}
Qed.

  Lemma Nmult_one_r : forall n, Nmult n None = n.
Proof.
intro n.
induction n as [|n ih] using Ninduction.
{  rewrite Nmult_zero_l. reflexivity. }
{ 
unfold Nmult. unfold _Nmult_rec.
rewrite Fix_eq.
{
destruct (Neq_dec _) as [d|d].
{ inversion d. }
{
clear d.
unfold None at 3.
rewrite Nrest_next. rewrite Nrest_zero_r.
fold _Nmult_rec. fold Nmult.
rewrite ih.
rewrite Nplus_comm.
rewrite <- Nnext_eq.
reflexivity.
}
}
clear.
intros x f g h.
destruct (Neq_dec _).
reflexivity.
rewrite h. reflexivity.
}
Qed.

Lemma Nmult_next_l : forall n m, Nmult (Nnext n) m = Nplus m (Nmult n m).
Proof.


intros n m.
generalize dependent n.
induction m as [|m ih] using Ninduction.
{
intro n.
rewrite Nmult_zero_r. 
rewrite Nmult_zero_r. 
rewrite Nplus_zero_r.
reflexivity.
}
{
intro n.
unfold Nmult at 1.
unfold _Nmult_rec.
rewrite Fix_eq.
{
destruct (Neq_dec _) as [d|_].
{ inversion d. }
{
unfold None at 2. rewrite Nrest_next. rewrite Nrest_zero_r.
fold _Nmult_rec. fold Nmult.
reflexivity.
}
}
{
clear. intros x f g h.
destruct (Neq_dec _). reflexivity. rewrite h. reflexivity.
}
}
Qed.

Lemma Nmult_next_r : forall n m, Nmult n (Nnext m) = Nplus n (Nmult n m).
Proof.
intros n.
induction n as [|n ih] using Ninduction.
{ intro m. rewrite Nmult_zero_l. rewrite Nmult_zero_l.
rewrite Nplus_zero_l. reflexivity.
}
{
intro m.
rewrite Nmult_next_l.
rewrite Nmult_next_l.
rewrite Nplus_next_l.
rewrite Nplus_next_l.
apply f_eq.
rewrite ih.
rewrite (Nplus_comm m).
repeat rewrite Nplus_assoc.
apply Nplus_intro_l.
rewrite Nplus_comm.
reflexivity.
}
Qed.

Lemma Nmult_comm : commutative Nmult.
Proof.
red.
intros n m.
generalize dependent m.
induction n as [|n ih] using Ninduction.
{ intros. rewrite Nmult_zero_l. rewrite Nmult_zero_r.
 reflexivity.
}
{
intro m.
rewrite Nmult_next_l.
rewrite Nmult_next_r.
apply Nplus_intro_l.
rewrite ih.
reflexivity.
}
Qed.

Lemma Nplus_mult_distr_l : forall n m k, Nmult k (Nplus n m) = Nplus (Nmult k n) (Nmult k m).
Proof.
intros n m k.
generalize dependent m.
generalize dependent n.
induction k as [|k ih] using Ninduction.
{
intros n m.
rewrite Nmult_zero_l.
rewrite Nmult_zero_l.
rewrite Nmult_zero_l.
rewrite Nplus_zero_l.
reflexivity.
}
{
intros n m.
rewrite Nmult_next_l.
rewrite Nmult_next_l.
rewrite Nmult_next_l.
repeat rewrite Nplus_assoc.
apply Nplus_intro_l.
symmetry.
repeat rewrite <- Nplus_assoc.
rewrite (Nplus_comm _ m).
repeat rewrite Nplus_assoc.
apply Nplus_intro_l.
rewrite ih.
reflexivity.
}
Qed.

Lemma Nplus_mult_distr_r : forall n m k, Nmult  (Nplus n m) k = Nplus (Nmult n k ) (Nmult m k ).
Proof.
intros n m k.
rewrite (Nmult_comm _ k).
rewrite Nplus_mult_distr_l.
repeat rewrite (Nmult_comm k).
reflexivity.
Qed.

Lemma Nmult_assoc : associative Nmult.
Proof.
red.
intros n m k.
generalize dependent k.
generalize dependent m.
induction n as [|n ih] using Ninduction.
{
intros m k. rewrite Nmult_zero_l. rewrite Nmult_zero_l.
reflexivity.
}
{
intros m k.
rewrite Nmult_next_l.
rewrite Nmult_next_l.
rewrite Nplus_mult_distr_r.
apply Nplus_intro_l.
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







  (* n <= n + m *)
  Lemma Nle_plus_l : forall n m, Nle n (Nplus n m).
  Proof.

  Admitted.








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

  Admitted.

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



  Lemma destruct_min_le_n : forall n m, (Nle n m /\ Nmin n m = n) \/ (Nle m n /\ Nmin n m = m).
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    {
      intro m.
      rewrite Nmin_zero_l.
      left.
      split.
      { apply Nle_zero_l. }
      { reflexivity. }
    }
    {
      intros n' ih.
      intro m.
      destruct (Ndestruct m).
      {
        subst m. rewrite Nmin_zero_r. right. split.
        { apply Nle_zero_l. }
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
    subst m. rewrite Nmin_zero_r in *. apply Nle_zero_l.
    destruct H1. subst m. rewrite Nmin_next in H0. apply Nle_next_intro.
    apply H. intro heq. apply H0. apply f_eq. assumption.
    }
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
    { destruct H. subst x. apply Nle_next_intro. apply Nle_zero_l. }
  Qed.

  Lemma xxx : forall x y ,x <> y -> Nle x y -> Nlt x y.
intro x.
induction x using Ninduction.
{ intros. unfold Nlt. destruct (Ndestruct y).
{ subst y. contradiction H. reflexivity. }
{ destruct H1. subst y. apply Nle_next_intro. apply Nle_zero_l. }
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
