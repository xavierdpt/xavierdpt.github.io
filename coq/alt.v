  (* In this Coq file, we will construct lists, natural numbers from lists, and prove a few things about naturals *)

  (* We declare the scope "maths" to host our custom notations *)
  Declare Scope maths.
  Open Scope maths.

  (* First a few general definitions *)

  (* Definition of commutativity for a binary operation over some type T *)
  Definition commutative {T:Type} (f:T->T->T) := forall x y, f x y = f y x.

  (* Definition of associativity for a binary operation over some type T *)
  Definition associative {T:Type} (f:T->T->T) := forall x y z, f (f x y) z = f x (f y z).

  (* Definition of a commutative monoid for a binary operation over some type T *)
  Definition commutative_monoid (T:Type) (op:T->T->T) :=
    associative op /\ commutative op /\
    (exists e, forall a, op e a = a /\ op a e = a).

  (* Technical lemma two introduce equality *)
  Lemma eq_imp : forall {T:Type} (a b:T) (P:T->Prop), P a -> a = b -> P b.
  Proof.
    intros A a b P h heq.
    subst b. exact h.
  Qed.


  (* Here's the classic inductive definition of a list *)
  Inductive List {A:Type} : Type :=
  | nil : List
  | cons : A -> List -> List
  .

  (* We show the empty list as "_" *)
  Notation "'_'" := nil (only printing) : maths.
  Notation "[ x ]" := (cons x nil) (only printing) : maths.
  Notation "[ x ; y ; .. ; z ]" :=  (cons x (cons y .. (cons z nil) ..)) (only printing) : maths.
  (* And we show the cons constructor as "∘l". *)
  Notation "x ∘l y" := (cons x y) (only printing, at level 60) : maths.

  (* The syntax for expliciting implicit types is quickly verbose, these make it easier *)
  (* LO is a list of A, LOLO is a list of lists of A *)
  Definition LO (A:Type) := List (A:=A).
  Definition LOLO (A:Type) := List (A:=(LO A)).

  Fixpoint inlist {A:Type} (l:LO A) (a:A) := match l with
  | nil => False
  | cons head tail => a=head \/ inlist tail a
  end. 

  (* Fixpoint definition of l being longer or equal than m *)
  Fixpoint longerOrEqualThan {A:Type} (l m:LO A) := match l, m with
  | nil , nil => True
  | nil , cons _ _ => False
  | cons _ _ , nil  => True
  | cons _ ltail, cons _ mtail => longerOrEqualThan ltail mtail
  end.

  (* Classic fixpoint definition of append *)
  Fixpoint append {A:Type} (l l' : LO A) : (LO A) := match l, l' with
  | nil, _ => l'
  | cons head tail, _ => cons head (append tail l')
  end.
  (* With a notation *)
  Notation "x ⋄l y" := (append x y) (only printing, at level 60) : maths. 

  (* To convert cons to append in proofs *)
  Lemma cons_append {A:Type} : forall (head:A) (tail:LO A), cons head tail = append (cons head nil) tail.
  Proof.
    intros head tail.
    simpl.
    reflexivity.
  Qed.


  (* Simplification lemma to remove empty lists on the right *)
  Lemma append_nil {A:Type} : forall l : LO A, append l nil = l.
  Proof.
    (* We will work on that list *)
    intro l.
    (* We proceed by induction over the list *)
    induction l as [| head tail ih].
    (* Base case *)
    {
      (* Simple evaluation of the fixpoint *)
      simpl.
      (* We have equality *)
      reflexivity.
    }
    (* Induction case *)
    {
      (* Evaluation *)
      simpl.
      (* By induction, appending nil to the tail gives back the tail *)
      rewrite ih.
      (* So we have equality *)
      reflexivity.
    }
  Qed.

  (* Associativity of append *)
  Lemma append_assoc {A:Type} : associative (append (A:=A)) .
  Proof.
    (* We unfold the definition of associativity *)
    red.
    (* We introduce our three lists *)
    intros x y z.
    (* And we proceed by induction over x *)
    induction x as [|head tail ih].
    (* Base case *)
    {
      (* Simple evaluation on both sides *)
      simpl.
      (* And we have equality *)
      reflexivity.
    }
    (* Induction case *)
    {
      (* Simple evaluation on both sides *)
      simpl.
      (* We can use our induction hypothesis *)
      rewrite ih.
      (* And we have equality *)
      reflexivity.
    }
  Qed.

  (* Simple lemmas to eliminate the left part on append when it is the same *)
  Lemma append_intro_l {A:Type} : forall (l m n: LO A), m = n -> append l m = append l n.
  Proof.
    (* Introduce the three lists *)
    intros l m n.
    (* Introduce the equality hypothesis *)
    intro heq.
    (* Replace m with n *)
    subst m.
    (* And we have equality *)
    reflexivity.
  Qed.

  (* Same for the right part on append *)
  Lemma append_intro_r (A:Type) : forall (l m n: LO A), m = n -> append m l = append n l.
  Proof.
    intros l m n heq. subst m. reflexivity.
  Qed.

  (* A predicate that asserts whether a list is empty *)
  Definition isnil {A:Type} (l:LO A) := l = nil.

  (* The empty list is empty *)
  Lemma isnil_nil {A:Type} : isnil (nil (A:=A)).
  Proof.
    red.
    reflexivity.
  Qed.

  (* Predicate that asserts that all elements in a list satisfy a given property *)
  Fixpoint allmatch {A:Type} (l:List) (P:A->Prop) := match l with
  | nil => True
  | cons x l' => P x /\ allmatch l' P
  end.

  (* If allmatch is true for two lists, then it is true for their concatenation *)
  Theorem allmatch_append {A:Type} : forall (l m:LO A) (P:A->Prop),
    allmatch l P -> allmatch m P -> allmatch (append l m) P.
  Proof.
    (* We introduce both lists and the predicate *)
    intros l m P.
    (* And we will proceed by induction *)
    induction l as [|head tail ih].
    (* Base case *)
    {
      (* We don't need that *)
      intros _.
      (* This is the allmatch hypothesis for m *)
      intro hm.
      (* Simple evaluation *)
      simpl.
      (* And that's exactly our hypothesis *)
      exact hm.
    }
    (* Induction case *)
    {
      (* Hypotheses on n and m *)
      intros hn hm.
      (* Simple evaluation in goal and hypotheses *)
      simpl in *.
      (* The predicate applies to the head and to the tail *)
      destruct hn as [hhead htail].
      (* And we have to prove that the predicate applies to th ehead, the tail and m. *)
      split.
      (* We already know this *)
      { exact hhead. }
      (* Here we have to use the induction hypothesis *)
      {
        clear hhead.
        (* The predicate applies to the tail because htail *)
        specialize (ih htail). clear htail.
        (* And it applies to m because hm *)
        specialize (ih hm). clear hm.
        (* And therefore, we have our goal *)
        exact ih.
      }
    }
  Qed.

  (* Predicate that asserts tha all elements in a list of lists are empty *)
  Definition allnil {A:Type} (l:LOLO A) := allmatch l isnil.

  (* In an empty list of lists, all elements are empty *)
  Lemma allnil_nil {A:Type} : allnil (nil (A:=LOLO A)).
  Proof.
    red.
    simpl.
    trivial.
  Qed.

  (* In a list of lists, if all elements are the empty list, then append commutes for these two lists *)
  Lemma allnil_append_comm {A:Type} : forall (l m : LOLO A), allnil l -> allnil m -> append l m = append m l.
  Proof.
    (* Induction on l *)
    intros l m.
    induction l as [|head tail ih].
    (* Base case *)
    {
      (* We don't care about the hypotheses for that case *)
      intros _ _.
      (* Left is simplified by definition of the fixpoint for append *)
      simpl.
      (* For the right side, we need our previous theorem *)
      rewrite append_nil.
      (* And we have equality *)
      reflexivity.
    }
    (* Induction case *)
    {
      (* First, we introduce and massage the hypotheses *)
      simpl in *.
      intros hx hy.
      red in hx, hy.
      simpl in *.
      destruct hx as [hnil hmatch].
      red in hnil.
      subst head.
      (* Then we prepare to use the induction hypothese *)
      unfold allnil in ih.
      specialize (ih hmatch). clear hmatch.
      specialize (ih hy).
      (* And we use it for rewrite *)
      rewrite ih. clear ih.
      (* Now we proceed by induction over m *)
      induction m as [|mhead mtail ih].
      (* Base case for m *)
      { simpl. reflexivity. }
      (* Induction case for m *)
      {
        (* Again we massage the hypotheses *)
        simpl.
        simpl in hy.
        destruct hy as [hnil hmatch'].
        red in hnil.
        subst mhead.
        (* Prepare the induction hypothese *)
        specialize (ih hmatch').
        (* Use it for rewrite *)
        rewrite ih. clear ih.
        (* And we have equality *)
        reflexivity.
      }
    }
  Qed.

  (* Here we construct the naturals as the lists of empty lists over some type *)
  Module Natural.

  (* The actual type does not matter *)
  Parameter TypeForNat : Type.

  (* And we define two levels of lists *)
  Definition Level1 := LO TypeForNat.
  Definition Level2 := LO Level1.

  (* A list of lists is "natural" if all its elements are empty lists *)
  Definition isnatural (l:Level2) := allnil l.

  (* We define Zero as the empty list of empty lists *)
  Definition zero_l := nil (A:=Level1).

  (* The "successor" function adds an empty list to any lists of list *)
  Definition next_l (n:Level2) : Level2 := cons nil n.

  (* zero-l is a "natural" list *)
  Theorem  zero_l_natural : isnatural zero_l.
  Proof.
    (* Unfold the definitions *)
    unfold isnatural.
    unfold allnil.
    unfold zero_l.
    (* allmatch on empty lists is always true anyway *)
    simpl.
    trivial.
  Qed.

  (* Using next_l on a "natural" list yields another "natural" list *)
  Lemma next_l_natural : forall (l:Level2), (isnatural l) -> isnatural (next_l l).
  Proof.
    (* We first unfold terms to a more convenient level *)
    unfold isnatural. unfold allnil.
    (* The proof proceeds by induction *)
    intro l.
    destruct l as [|head tail].
    (* Base case *)
    {
      (* We don't need the hypothesis in this case *)
      intros _.
      (* Simplification applies to both next_l and allmatch *)
      simpl.
      (* That gives a part for the head which is nil,
         and a part for the tail, which is the empty list and for which allmatch evaluates to True *)
      split.
      { red. reflexivity. }
      { trivial. }
    }
    (* Other case *)
    {
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
  (*
    We use "T" as the type with the expectation that we will later introduce a "Natural" module so that we can write
    Natural.T for the type
  *)
  Definition T := { l | isnatural l }.

  (* This notation discard everything that is not really relevant when printing it on screen *)
  Notation "§E x" := (exist _ x _) (only printing, at level 60).

  (* There are two projection functions which retrive the content and the hypothese *)
  Definition number (t:T) := proj1_sig t.
  Definition hyp (t:T) := proj2_sig t.

  (* The axiom of proof irrelevance is necessary to assume that two proofs of the same thing are "equal" *)
  (* Coq does not make this assumption *)
  Axiom proof_irrelevance : forall {A:Type} {P:A->Prop} (x y :sig P), proj1_sig x = proj1_sig y -> x = y.

  (* Axiom proof_irrelevance : forall (x y:T), number x = number y -> x = y. *)

  (* Here we define the strong zero *)
  (* This uses the "exist" constructor from "sig" with zero and a proof that zero is natural. *)
  Definition zero := exist _ zero_l zero_l_natural.
  Notation "0n" := zero (only printing) : maths. 

  (*
    Same idea for the strong next function, although it is maybe a bit more difficult to follow,
    since it use the proof that n is natural to construct the proof that the next number is natural
  *)
  Definition next (n:T) := exist _
    (next_l (number n))
    (next_l_natural (number n) (hyp n)).
  Notation "]n x" := (next x) (only printing, at level 60) : maths. 

  (* Here are one and two *)
  Definition one := next zero.
  Notation "1n" := one (only printing) : maths.

  Definition two := next one.
  Notation "2n" := two (only printing) : maths.

  (* next is injective *)
  Lemma next_injective : forall n m, next n = next m -> n = m.
  Proof.
    intros nT mT.
    intro hnext.
    inversion hnext as [heq].
    apply proof_irrelevance in heq. 
    exact heq.
  Qed.

  (* If the "number" of a natural is zero_l, then that number is zero *)
  Lemma number_nil_zero : forall (n:T), number n = zero_l -> n = zero.
  Proof.
    (* intro n as "nT" *)
    intro nT.
    (* intro the equality hypothese *)
    intro heq.
    (* Explode the things of type T into their corresponding lists and hypotheses *)
    destruct nT as [n hn];
    destruct zero as [z hz] eqn:heqz.
    (* Simplify in heq *)
    simpl in heq.
    (* Apply proof irrelevance to get to n=z *)
    apply proof_irrelevance;simpl.
    (* Substitute n with it's value *)
    subst n.
    (* Uses inversion on the equality to find a value for z *)
    inversion heqz as [heq]. clear heqz. subst z.
    (* And we have equality *)
    reflexivity.
  Qed.

  (* This lemma proves that the predecessor exists when the "number" of a natural is a non-empty list *)
  Lemma predecessor_exists : forall (nT:T) head tail, number nT = cons head tail -> exists mT:T, number mT = tail.
  Proof.
    intros nT head tail heq.
    destruct nT as [n hn].
    simpl in heq.
    subst n.
    (* Massage the hypothese *)
    red in hn.
    unfold allnil in hn.
    simpl in hn.
    destruct hn as [hnil hmatch].
    red in hnil.
    subst head.
    (* Create the proof that m is natural *)
    assert (hm:isnatural tail).
    {
      red.
      unfold allnil.
      exact hmatch.
    }
    (* Create mT *)
    rename tail into m.
    exists (exist _ m hm).
    (* And voila. *)
    simpl.
    reflexivity.
  Qed.

  (* Now we are ready to prove the induction principle on T *)
  Theorem I : forall (P: T -> Prop),
    (P zero) ->  
    (forall n, P n -> P (next n)) -> 
    (forall n, P n).
  Proof.
    intros P hzero hnext.
    intro n.
    (* We define nT to keep it around after the destruction *)
    set (nT:=n).
    (* And we destruct it *)
    destruct n as [n hn].
    (* We now can proceed by induction over the list *)
    induction n as [|head tail ih].
    (* Base case *)
    {
      (* For this case, we only need hzero *)
      clear hnext.
      (* We prove that nT = zeroT using number_nil_zero*)
      assert(hnz:=number_nil_zero).
      specialize (hnz nT).
      (* number nT is nil by definition of nT *)
      simpl in hnz.
      (* and zero_l is nil too *)
      unfold zero_l in hnz.
      (* reflexexivity is actually an application of eq_refl *)
      specialize (hnz (eq_refl _)).
      (* Now we have our equality *)
      rewrite hnz.
      clear hnz nT hn.
      exact hzero.
    }
    (* Induction case *)
    {
      (* We won't need hzero here *)
      clear hzero.
      (* Massage hn first *)
      unfold isnatural in hn.
      unfold allnil in hn.
      simpl in hn.
      destruct hn as [hnil hmatch].
      unfold isnil in hnil.
      subst head.
      (* Here we want to construct the predecessor of nT *)
      assert (hm:=predecessor_exists).
      specialize (hm nT).
      (* Simplification will use what it know about nT *)
      simpl in hm.
      (* We use the head and tail that we already have *)
      specialize (hm nil).
      specialize (hm tail).
      (* And that makes equality *)
      specialize (hm (eq_refl _)).
      (* Now we have our predecessor *)
      destruct hm as [mT hm].
      (* We plug that predecessor in the induction hypothese of our induction principle *)
      specialize (hnext mT).
      (* And now we want to prove that the successor of that predecessor is nT itself *)
      assert (hmn:nT = next mT).
      {
        apply proof_irrelevance.
        (* We know what's inside nT, and a little about what's inside (nextT mT) *)
        simpl.
        (* Here we are down the "next_l" function *)
        unfold next_l.
        (* We can use hm for the right part *)
        rewrite hm.
        (* And there we are *)
        reflexivity.
      }
      (* Now we can finally get read of nT *)
      rewrite hmn. clear hmn. clear nT.
      (* And apply and clear the induction hypotheses of our principle *)
      apply hnext.
      clear hnext.
      (* Preparation for the induction hypothesis of the list *)
      assert (hnat:isnatural tail).
      {
        red.
        unfold allnil.
        exact hmatch.
      }
      specialize (ih hnat).
      clear hmatch.
      (* This weird "let" in ih will go away with "simpl" *)
      simpl in ih.
      (* We force an equality *)
      eapply eq_imp.
      (* We join with ih *)
      apply ih.
      (* To prove the equality, we can use proof irrelevance *)
      apply proof_irrelevance;simpl.
      unfold number in hm.
      rewrite hm.
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
  Definition plus (nT mT : T) : T :=
    (* Extract the parts from n and m *)
    let (n, hn) := nT in
    let (m, hm) := mT in
    (* Construct the result *)
    let result := append n m in
    (* And binds the proof using the proof above *)
    exist _ result (append_natural n m hn hm).
  Notation "x +n y" := (plus x y) (only printing, at level 60) : maths. 
 
  (* Proof that plus is commutative *)
  Theorem plus_comm : commutative plus.
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
  Theorem plus_zero_l : forall n, plus zero n = n.
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
  Theorem plus_zero_r : forall n, plus n zero = n.
  Proof.
    intro n.
    (* We can use commutativity of addition *)
    rewrite plus_comm.
    apply plus_zero_l.
  Qed.

  (* (next n) + m = next(n+m) *)
  Lemma plus_next_r : forall n m, plus (next n) m = next (plus n m).
  Proof.
    intros nT mT.
    destruct nT as [n hn];
    destruct mT as [m hm].
    simpl.
    apply proof_irrelevance.
    simpl.
    unfold next.
    reflexivity.
  Qed.

  (* n + (next m) = next(n+m) *)
  Lemma plus_next_l : forall n m, plus n (next m) = next (plus n m).
  Proof.
    intros n m.
    rewrite plus_comm.
    rewrite plus_next_r.
    rewrite (plus_comm m).
    reflexivity.
  Qed.

  (* Proof that plus is associative *)
  Theorem plus_assoc : associative plus.
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
  Lemma plus_elim_zero_l : forall n m, plus n m = n -> m = zero.
  Proof.
  intro n.
  pattern n;apply I.
  { intro m. intro h. rewrite plus_zero_l in h. exact h. }
  {
    clear n.
    intro n.
    intro ih.
    intro m.
    intro h.
    apply ih.
    clear ih.
    apply next_injective.
    rewrite plus_next_r in h.
    exact h.
  }
  Qed.

  (* n + m = m -> n = 0 *)
  Lemma plus_elim_zero_r : forall n m, plus n m = m -> n = zero.
  Proof.
    intros n m h.
    apply plus_elim_zero_l with m.
    rewrite plus_comm.
    exact h.
  Qed.

  (* next n = n + 1 *)
  Lemma next_eq_plus_one : forall n, next n = plus n one.
  Proof.
    intro n.
    unfold one.
    rewrite plus_comm.
    rewrite plus_next_r.
    rewrite plus_zero_l.
    reflexivity.
  Qed.

  (* "multiplication" of two list repeatitivly applies append on the second list *)
  (* What happens in this function does not really matter as long as
     length (x*y)=length(x)*length(y) *)
  Fixpoint mult_l (x y:Level2) : Level2 := match x with
  | nil => nil
  | cons head tail => append y (mult_l tail y)
  end.
  Notation "x *l y" := (mult_l x y) (only printing, at level 60) : maths. 

  (* Helper lemma that show that "multiplying" by nil on the right yields nil *)
  Lemma mult_l_nil : forall x, mult_l x nil  = nil.
  Proof.
    intro x.
    induction x as [|head tail ih].
    { simpl. reflexivity. }
    { simpl. rewrite ih. reflexivity. }
  Qed.

  (* "Multiplying" two "natural" lists yields a "natural" list *)
  Lemma mult_l_natural : forall (n m:Level2), isnatural n -> isnatural m -> isnatural (mult_l n m).
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
  Definition mult (nT mT : T) : T :=
    let (n, hn) := nT in
    let (m, hm) := mT in
    let result := mult_l n m in
    exist _ result (mult_l_natural n m hn hm).
  Notation "x *n y" := (mult x y) (only printing, at level 60) : maths. 

  (* Multiplication is commutative *)
  Theorem mult_comm : commutative mult.
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
  Theorem mult_one_l : forall n, mult one n = n.
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
  Theorem mult_one_r : forall n, mult n one = n.
  Proof.
    intro n.
    rewrite mult_comm.
    apply mult_one_l.
  Qed.

  (* Here we prove commutativity of multl_l using the commutativity of mult *)
  Theorem multl_comm : forall x y, isnatural x -> isnatural y -> mult_l x y = mult_l y x.
  Proof.
    intros x y hx hy.
    assert (hcomm := mult_comm).
    unfold commutative in hcomm.
    specialize (hcomm (exist _ x hx)).
    specialize (hcomm (exist _ y hy)).
    simpl in hcomm.
    inversion hcomm as [h].
    clear hcomm.
    reflexivity.
  Qed.

  (* x*(y+z) = x*y + x*z *)
  Theorem plus_mult_distribute_left : forall x y z, mult x (plus y z) = plus (mult x y) (mult x z).
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
        apply mult_l_natural.
        { apply hmatchx. }
        { red. unfold allnil. exact hy. }
      }
    }
  Qed.

  Theorem plus_mult_distribute_leftl : forall x y z,
    isnatural x -> isnatural y -> isnatural z
    -> mult_l x (append y z) = append (mult_l x y) (mult_l x z).
  Proof.
    intros x y z hx hy hz.
    assert (h := plus_mult_distribute_left).
    specialize (h (exist _ x hx)).
    specialize (h (exist _ y hy)).
    specialize (h (exist _ z hz)).
    simpl in h.
    inversion h as [h']. clear h. rename h' into h.
    reflexivity.
  Qed.

  (* (x+y)*z = x*z + y*z *)
  Theorem plus_mult_distribute_right : forall x y z, mult (plus x y) z  = plus (mult x z) (mult y z).
  Proof.
    intros x y z.
    repeat rewrite (mult_comm _ z).
    rewrite plus_mult_distribute_left.
    reflexivity.
  Qed.

  Theorem plus_mult_distribute_rightl : forall x y z,
    isnatural x -> isnatural y -> isnatural z
    -> mult_l (append x y) z  = append (mult_l x z) (mult_l y z).
  Proof.
    intros x y z hx hy hz.
    assert (h := plus_mult_distribute_right).
    specialize (h (exist _ x hx)).
    specialize (h (exist _ y hy)).
    specialize (h (exist _ z hz)).
    simpl in h.
    inversion h as [h']. clear h. rename h' into h.
    reflexivity.
  Qed.

  (* Multiplication is associative *)
  Theorem mult_assoc : associative mult.
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
      rewrite plus_mult_distribute_rightl.
      { reflexivity. }
      { unfold isnatural. unfold allnil. exact hy. }
      { apply mult_l_natural.
        { unfold isnatural. unfold allnil. exact hmatchx. }
        { unfold isnatural. unfold allnil. exact hy. }
      }
      { unfold isnatural. unfold allnil. exact hz. }
    }
  Qed.

  (* The set of natural numbers is a commutative monoid for addition and multiplication *)
  Theorem Natural_commutative_monoid : commutative_monoid T plus /\ commutative_monoid T mult.
  Proof.
    split.
    {
      red.
      repeat split.
      { apply plus_assoc. }
      { apply plus_comm. }
      { exists zero.
        intro a.
        split.
        { rewrite plus_zero_l. reflexivity. }
        { rewrite plus_zero_r. reflexivity. }
      }
    }
      red.
      repeat split.
      { apply mult_assoc. }
      { apply mult_comm. }
      { exists one.
        intro a.
        split.
        { rewrite mult_one_l. reflexivity. }
        { rewrite mult_one_r. reflexivity. }
      }
  Qed.

  (* (next n) + m = n + (next m) *)
  (* TODO: This can be rewritten without destruction *)
  Lemma plus_next: forall (n m:T), plus (next n) m = plus n (next m).
  Proof.
    intros nT mT.
    destruct nT as [n hn];
    destruct mT as [m hm].
    simpl. apply proof_irrelevance. simpl.
    unfold next_l.
    rewrite cons_append.
    rewrite (cons_append _ m).
    repeat rewrite <- append_assoc.
    apply append_intro_r.
    Search append.
    rewrite (allnil_append_comm n _).
    { reflexivity. }
    { unfold isnatural in hn. exact hn. }
    { clear. red. simpl. split. apply isnil_nil. trivial. }
  Qed.


  (* If n + m = 0, then n = 0 and m = 0 *)
  Lemma plus_zero_zero_eq_zero : forall (n m:T), plus n m = zero -> n = zero /\ m = zero.
  Proof.
    intro n.
    (* We apply our custom induction principle *)
    pattern n;apply I.
    (* Base case *)
    {
      intros m heq.
      rewrite plus_zero_l in heq.
      subst m.
      split;reflexivity.
    }
    (* Induction case *)
    {
      clear n. intro n. intro ih.
      intros m heq.
      specialize (ih (next m)).
      rewrite plus_next in heq.
      specialize (ih heq).
      destruct ih as [ _ hr ].
      (* We can have next m = 0 *)
      inversion hr.
    }
  Qed.

  (* Definition of "less than or equal to" *)
  Definition le_n (n m:T) := longerOrEqualThan (number m) (number n).
  Notation "x <=n y" := (le_n x y) (only printing, at level 60) : maths. 

  (* Definition of "less than" *)
  Definition lt_n (n m:T) := le_n (next n) m.
  Notation "x <n y" := (lt_n x y) (only printing, at level 60) : maths. 

  (* If n <= m, then next n <= next m *)
  Lemma le_n_next : forall n m, le_n n m -> le_n (next n) (next m).
  Proof.
    (* Destruct n and m into their parts *)
    intros nT mT.
    unfold le_n.
    destruct nT as [n hn];
    destruct mT as [m hm].
    simpl.
    (* Induction on n *)
    generalize dependent m.
    induction n as [|head tail ih].
    (* Base case *)
    {
      intro m.
      destruct m as [|headm tailm].
      (* m is nil *)
      { simpl. intros _ _. trivial. }
      (* m is not nil *)
      { simpl. intros _ _. trivial. }
    }
    (* Induction case *)
    {
      red in hn. unfold allnil in hn. simpl in hn. destruct hn as [hnil hmatch].
      unfold isnatural in ih. unfold allnil in ih. specialize (ih hmatch).
      intros m hm.
      destruct m as [|headm tailm].
      (* m is nil *)
      {
        (* We get a contradiction *)
        simpl. intro f. exact f.
      }
      (* m is not nil *)
      {
        (* we can use the induction hypothesis on both tails *)
        simpl. intro h.
        unfold isnatural in hm. unfold allnil in hm. simpl in hm. destruct hm as [hnilm hmatchm].
        specialize (ih _ hmatchm).
        specialize (ih h).
        exact ih.
      }
    }
  Qed.

  (* n <= n + m *)
  Lemma le_n_n : forall n m, le_n n (plus n m).
  Proof.
    (* Destruct n and m into their parts *)
    intros nT mT.
    unfold le_n.
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

  (* "<=" is transitive *)
  Lemma le_trans : forall n m k, le_n n m -> le_n m k -> le_n n k.
  Proof.
    (* Destruct n, m and k into their parts *)
    intros nT mT kT.
    unfold le_n.
    destruct nT as [n hn];
    destruct mT as [m hm];
    destruct kT as [k hk].
    simpl.
    clear hn hm hk.
    generalize dependent m.
    generalize dependent n.
    (* Induction on k *)
    induction k as [|headk tailk ih].
    (* Base case *)
    {
      simpl.
      (* Simpl is a bit too offensive here, but whenever a match is unfolded like this, it's a hint to use "destruct" *)
      intros n m h.
      destruct m as [|headm tailm].
      (* m is nil *)
      {
        destruct n as [|headn tailn].
        (* n is nil *)
        { intros _. trivial. }
        (* n is not nil *)
        {
          simpl in h.
          (* that's a contradiction, because destruct covers all possibilities, including the irrealistic ones *)
          (* and irrealistic possibilities must be filtered out while proving *)
          inversion h.
        }
      }
      (* m is not nil *)
      {
        (* another contradiction *)
        intro f. inversion f.
      }
    }
    (* Induction case *)
    {
      intros n m ha hb.
      simpl.
      destruct n as [|headn tailn].
      (* n is nil *)
      { trivial. }
      (* n is nil *)
      { simpl in *.
        destruct m as [|headm tailm].
        (* m is nil *)
        { simpl in *. inversion ha. }
        (* this is the only case where n, m and k are all not nil, and we have to use the induction hypothesis *)
        {
          simpl in *.
          (* We want to show that (n-1) <= (k-1) (reading tailn as being equivalent to n-1) *)
          eapply ih.
          (* Here we can use ha, which states that (n-1) <= (m-1) *)
          { apply ha. }
          (* and hb states that (m-1) <= (k-1) *)
          { apply hb. }
        }
      }
    }
  Qed.

  (* a <= next a *)
  Lemma le_next_self : forall a, le_n a (next a).
  Proof.
    intro aT.
    destruct aT as [a ha].
    unfold le_n.
    simpl.
    clear ha.
    induction a as [|head tail ih].
    { trivial. }
    { simpl. apply ih. }
  Qed.

  (* next n <= next m => n <= m *)
  Lemma le_n_next_intro : forall n m, le_n (next n) (next m) -> le_n n m.
  Proof.
    intros nT mT.
    unfold le_n.
    destruct nT as [n hn];
    destruct mT as [m hm].
    simpl.
    clear hn hm.
    intro h.
    (* the hypothese was reduced to the goal during simplification *)
    exact h.
  Qed.

  (* "<" is irreflexive *)
  Lemma lt_irrefl : forall n, lt_n n n -> False.
  Proof.
    intro nT.
    unfold lt_n.
    unfold le_n.
    destruct nT as [n hn].
    simpl.
    induction n as [|head tail ih].
    (* Base case *)
    {
      (* 0 < 0 evaluates to False, which is our contradiction *)
      simpl. intro f. exact f.
    }
    {
      simpl.
      unfold isnatural in *.
      unfold allnil in *.
      simpl in *.
      destruct hn as [hnil hmatch].
      specialize (ih hmatch).
      clear hmatch.
      red in hnil.
      subst head.
      unfold next_l in ih.
      exact ih.
    }
  Qed.

  (* To converts "<" back to "<=" in proofs *)
  Lemma lt_le: forall n m, le_n (next n) m -> lt_n n m.
  Proof.
    intros n m h.
    unfold lt_n.
    exact h.
  Qed.


  (* Length of a list *)
  Fixpoint length {A:Type} (l : LO A) : T := match l with
  | nil => zero
  | cons _ tail => next (length tail)
  end.

  (* A type is infinite if for any (finite) list of elements of that type,
     it's possible to find another element that is not in the list *)
  Definition is_infinite (A:Type) := forall (l:LO A), exists (a:A), not (inlist l a).


  (* Sum of a list *)
  Fixpoint sum (l:LO T) := match l with
  | nil => zero
  | cons head tail => plus head (sum tail)
  end.

  (* If the sum of a list is zero, then all its elements are zero *)
  Lemma sum_zero : forall (l:LO T), sum l = zero -> forall a, inlist l a -> a = zero.
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
      apply plus_zero_zero_eq_zero in heq.
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
  Lemma sum_lt : forall (l:LO T), forall a, inlist l a -> le_n a (sum l).
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
      apply le_n_n.
    }
    (* a is in the tail *)
    {
      specialize (ih _ hr).
      apply le_trans with (sum tail).
      { exact ih. }
      {
        simpl.
        rewrite plus_comm.
        apply le_n_n.
      }
    }
  }
  Qed.


  (* If an element is bigger than any element of the list, then it is not in the list *)
  Lemma lt_notin_list : forall (l:LO T) (a:T), (forall x, inlist l x -> lt_n a x) -> not (inlist l a).
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
      apply lt_irrefl in h.
      inversion h.
    }
  Qed.

  (* The sum of the elements of a list + 1 is not in the list *)
  Lemma sum1_not_in_list : forall (l:LO T), not (inlist l (plus (sum l) one)).
  Proof.

    (* The sum + 1 of a list is bigger than any elements of the list *)
    assert(thm:=sum_lt).

    (* We will work on that list *)
    intro l.
    specialize (thm l).

    (* Let's call the sum 'S' *)
    set (S:=plus (sum l) one). 

    (* Negation means proving False *)
    unfold not in *.

    (* We assume that S in in the list, then derive a contradiction *)
    intro h.

    (* We can apply thm on S *)
    specialize (thm S).

    (* Is S in the least ? Yes by assumption *)
    specialize (thm h).
    clear h.
    
  Qed.

  (* The set of naturals is infinite *)
  Theorem Natural_infinite : is_infinite T.
  Proof.
    (* Being infinite means that for any finite list l of elements of type T,
       we can find an element of type T that is not in the list *)
    red.
    (* We will work on that list *)
    intro l.
    (* And in particular, the sum of the list + 1 is not in the list *)
    exists (plus (sum l) oneT).
    (* This it what we proved just above *)
    apply sum1_not_in_list.
  Qed.


  Lemma mult_zero_l : forall n:T, mult zeroT n = zeroT.
    Proof.
    intro nT.
    destruct zeroT as [z hz] eqn:heqz;
    destruct nT as [n hn].
    simpl. apply proof_irrelevance. simpl.
    inversion heqz as [heq]. clear heqz.
    unfold zero in *. subst z.
    simpl.
    reflexivity.
  Qed.

  Lemma mult_zero_r : forall n:T, mult n zeroT = zeroT.
    Proof.
    intro nT.
    rewrite mult_comm.
    rewrite mult_zero_l.
    reflexivity.
  Qed.

  Definition divides d n := exists d', mult d d' = n.

  Lemma divides_zero_n : forall n:T, divides n zeroT.
  Proof.
    intro n.
    red.
    exists zeroT.
    rewrite mult_zero_r.
    reflexivity.
  Qed.

  Lemma divides_n_zero : forall n:T, divides zeroT n -> n = zeroT.
  Proof.
    intro n.
    pattern n;apply I.
    { intros _. reflexivity. }
    {
      clear n. intro n.
      intro ih.
      intro h.
      red in h.
      destruct h as [d h].
      rewrite mult_zero_l in h.
      inversion h.
    }
  Qed.

  Definition isprime n := n <> zeroT /\ (forall d, divides d n -> d = oneT).

  Lemma next_zeroT : nextT zeroT = oneT.
  Proof. unfold oneT. reflexivity. Qed.

  Lemma isprime_one : isprime oneT.
  Proof.
  red.
split.
{ red. intro heq. inversion heq. }
{ intro d.
pattern d;apply I.
{
intro h. red in h. destruct h as [d' heq]. rewrite mult_zero_l in heq. inversion heq. }
{ intros n ih. intro hn.
red in hn.
destruct hn as [d' hn].
Search nextT.
rewrite next_oneT in hn.
rewrite plus_mult_distribute_right in hn.
rewrite mult_one_l in hn.





  Lemma xxx : forall n:T, n = zeroT \/ isprime n \/ exists d, lt_n oneT d /\ divides d n.
  Proof.
  intro n.
  pattern n;apply I.
  {
    left.
    reflexivity.
  }
  {
    clear n. intro n.
    intro ih.
    destruct ih as [heqz | [hprime | hmult]].
    {
      subst n.
      rewrite next_zeroT.
      right. left.
      red.
      split.
      { unfold not. intro heq. inversion heq. }
      {
        


  Lemma zero_neq_two : zeroT = twoT -> False.
  Proof.
    intro i. inversion i.
  Qed.

  Lemma one_neq_two : oneT = twoT -> False.
  Proof.
    intro h.
    inversion h.
  Qed.



  Definition Pair {A:Type} := { l : LO A | length(l) = twoT }.
  Definition PairOf (A:Type) := Pair (A:=A).

  Definition first {A:Type} (p : PairOf A) : A.
  Proof.
  destruct p as [l h].
  destruct l as [|first rest].
  { simpl in h. exfalso. apply zero_neq_two. exact h. }
  { exact first. }
  Defined.

  Definition second {A:Type} (p:PairOf A) : A.
  Proof.
  destruct p as [l h].
  destruct l as [|first rest].
  { simpl in h. exfalso. apply zero_neq_two. exact h. }
  {
    destruct rest as [|second rest].
    { simpl in h. rewrite next_zeroT in h. exfalso. apply one_neq_two. exact h. }
    { exact second. }
  }
  Qed.

  Theorem pair_eq {A:Type} : forall (p q: PairOf A), first p = first q -> second p = second q -> p = q.
  Proof.
    intros pP qP hf hs.
    destruct pP as [p hp].
    destruct qP as [q hq].
    simpl in *.
    
      

  
 