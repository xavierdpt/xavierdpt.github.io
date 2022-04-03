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

  Lemma mult_zero_l : forall n:T, mult zero n = zero.
    Proof.
    intro nT.
    destruct zero as [z hz] eqn:heqz;
    destruct nT as [n hn].
    simpl. apply proof_irrelevance. simpl.
    inversion heqz as [heq]. clear heqz.
    unfold zero in *. subst z.
    simpl.
    reflexivity.
  Qed.

  Lemma mult_zero_r : forall n:T, mult n zero = zero.
    Proof.
    intro nT.
    rewrite mult_comm.
    rewrite mult_zero_l.
    reflexivity.
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
    specialize (thm h).
    clear h.

    (* Now we can use irreflexivity of "<" to derive a contradiction *)
    eapply lt_irrefl with S.
    subst S.
    unfold lt_n.
    rewrite <- next_eq_plus_one.
    apply le_n_next.
    rewrite <- next_eq_plus_one in thm.
    exact thm.
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
    exists (plus (sum l) one).
    (* This it what we proved just above *)
    apply sum1_not_in_list.
  Qed.



  Definition divides d n := exists d', mult d d' = n.

  Lemma divides_zero_n : forall n:T, divides n zero.
  Proof.
    intro n.
    red.
    exists zero.
    rewrite mult_zero_r.
    reflexivity.
  Qed.

  Lemma divides_n_zero : forall n:T, divides zero n -> n = zero.
  Proof.
    intro n.
    pattern n;apply I.
    (* n = 0 *)
    { intros _. reflexivity. }
    (* n > 0 => impossible *)
    {
      clear n. intro n.
      intro ih. clear ih.
      intro h.
      unfold divides in *.
      destruct h as [d h].
      rewrite mult_zero_l in h.
      (* inversion is kind of magic here, but it will try to match nil against cons head tail and find it can't *)
      inversion h.
    }
  Qed.

  Lemma divides_one_n : forall n:T, divides one n.
  Proof.
    intro n.
    unfold divides.
    exists n.
    rewrite mult_one_l.
    reflexivity.
  Qed.

  (* n + m = 1 -> (n = 1 and m = 0) or (n = 0 and m = 1) *)
  Lemma plus_eq_one : forall (n m:T), plus n m = one -> n = one /\ m = zero \/ n = zero /\ m = one.
  Proof.
    (* Induction on n *)
    intro n.
    pattern n;apply I.
    (* Base case *)
    {
      (* n = 0 -> m = 1 *)
      intros m h.
      rewrite plus_zero_l in h.
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
      rewrite plus_next_r in h.
      unfold one in h.
      apply next_injective in h.
      apply plus_zero_zero_eq_zero in h.
      destruct h as [ hl hr ].
      (* Substitute n and m with zero *)
      subst n. subst m.
      (* Prepare the induction hypothesis *)
      specialize (ih one).
      rewrite plus_zero_l in ih.
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
        { unfold one. reflexivity. }
        { reflexivity. }
      }
    }
  Qed.

  (* n * m = 1 -> n = 1 and m = 1 *)
  Theorem mult_one_one_eq_one : forall n m : T, mult n m = one -> n = one /\ m = one.
  Proof.
    (* Induction over n *)
    intro n.
    pattern n;apply I.
    (* Base case *)
    {
      (* n = 0 -> impossible *)
      intros m h.
      rewrite mult_zero_l in h.
      inversion h.
    }
    (* Induction case *)
    {
      (* We don't need the induction hypothesis *)
      clear n. intro n'. intro ih. clear ih.
      intro m. intro  h.
      (* We can deduce that m = 0 or m = 1 *)
      rewrite next_eq_plus_one in h.
      rewrite plus_mult_distribute_right in h.
      rewrite mult_one_l in h.
      apply plus_eq_one in h.
      destruct h as [hl | hr ].
      (* m = 0 -> impossible *)
      {
        destruct hl as [hl hr].
        subst m.
        rewrite mult_zero_r in hl.
        inversion hl.
      }
      (* m = 1 *)
      {
        (* so n' must be zero *)
        destruct hr as [hl hr].
        subst m.
        rewrite mult_one_r in hl.
        subst n'.
        (* And now it's obvious *)
        split.
        { unfold one. reflexivity . }
        { reflexivity. }
      }
    }
  Qed.

  Lemma divides_n_one : forall n:T, divides n one -> n = one.
  Proof.
  intros n h.
  unfold divides in h.
  destruct h as [d h].
  generalize dependent d.
  (* Induction over n *)
  pattern n;apply I.
  (* Base case *)
  {
    intros d h.
    rewrite mult_zero_l in h.
    inversion h.
  }
  (* Induction case *)
  {
    (* We don't need the induction hypothesis *)
    clear n. intro n'. intro ih. clear ih.
    intro d. intro h.
    (* From h, we can deduce that n' = zero, and therefore n = 1 *)
    apply mult_one_one_eq_one in h.
    destruct h as [hl hr].
    subst d.
    unfold one in hl.
    apply next_injective in hl.
    subst n'.
    unfold one.
    reflexivity.
  }
  Qed.

  Lemma divides_n_n : forall n, divides n n.
  Proof.
    intro n.
    unfold divides.
    exists one.
    rewrite mult_one_r.
    reflexivity.
  Qed.

  Definition isprime n := forall d, divides d n -> d<>n -> d = one.

  Lemma zero_not_eq_one : zero = one -> False.
  Proof.
    intro h.
    inversion h.
  Qed.

  Lemma two_not_eq_one : two = one -> False.
  Proof.
    intro h.
    inversion h.
  Qed.

  Lemma next_zero : next zero = one.
  Proof. unfold one. reflexivity. Qed.

  Lemma zero_not_prime : not (isprime zero).
  Proof.
    unfold not. intro h.
    unfold isprime in h.
    (* For d = zero, we would prove 0 = 1, which is impossible *)
    specialize (h two).
    apply two_not_eq_one.
    apply h.
    (* Two divides zero indeed *)
    clear h.
    apply divides_zero_n.
    unfold not. intro heq. inversion heq.
  Qed.

  Lemma isprime_one : isprime one.
  Proof.
    unfold isprime.
    intro d.
    intro h.
    unfold divides in h.
    destruct h as [d' heq].
    apply mult_one_one_eq_one in heq.
    destruct heq as [hl _].
    subst d.
    intros _.
    reflexivity.
  Qed.

  Lemma plus_elim_l : forall n m p, plus n m = plus n p -> m = p.
  Proof.
    intro n.
    pattern n;apply I.
    {
    intro m. intro p.
    intro heq.
    repeat rewrite plus_zero_l in heq.
    exact heq.
    }
    { 
    clear n. intro n'. intro ih.
    intro m. intro p. intro heq.
    rewrite plus_next_r in heq.
    rewrite plus_next_r in heq.
    apply next_injective in heq.
    apply ih.
    exact heq.
    }
  Qed.

  Lemma plus_elim_r : forall n m p, plus m n = plus p n -> m = p.
  Proof.
    intros n m p heq.
    apply plus_elim_l with n.
    rewrite (plus_comm n).
    rewrite (plus_comm n).
    exact heq.
  Qed.

  Lemma plus_eq_two : forall (n m:T), plus n m = two -> (n = zero /\ m = two) \/ (n = one /\ m = one) \/ (n = two /\ m = zero).
  Proof.
  intro n.
  pattern n;apply I.
  {
    intros m h.
    rewrite plus_zero_l in h.
    subst m.
    left. split.
    { reflexivity. }
    { reflexivity. }
  }
  {
    intros n' ih. clear ih.
    intros m heq.
    rewrite next_eq_plus_one in heq.
    unfold two in heq.
    rewrite next_eq_plus_one in heq.
    rewrite (plus_comm n') in heq.
    repeat rewrite plus_assoc in heq.
    apply plus_elim_l in heq.
    apply plus_eq_one in heq.
    destruct heq as [heql | heqr].
    {
      destruct heql as [hn hm].
      subst m.
      subst n'.
      right. right.
      split.
      { unfold two. reflexivity. }
      { reflexivity. }
    }
    {
      destruct heqr as [hn hm].
      subst n'. subst m.
      right. left. split.
      { unfold one. reflexivity. }
      { reflexivity. }
    }
  }
  Qed.

  Lemma mult_eq_zero : forall n m, mult n m = zero -> n = zero \/ m = zero.
  Proof.
  intro n.
  pattern n;apply I.
  {
    intro m. intro heq. clear heq.
    left. reflexivity.
  }
  {
    clear n. intro n'. intro ih. clear ih.
    intro m. intro heq.
    rewrite next_eq_plus_one in heq.
    rewrite plus_mult_distribute_right in heq.
    rewrite mult_one_l in heq.
    apply plus_zero_zero_eq_zero in heq.
    destruct heq as [hl hr].
    subst m.
    right.
    reflexivity.
  }
  Qed.

  Lemma isprime_two : isprime two.
  Proof.
    unfold isprime.
    intro d.
    intro h.
    intro hneq.
    unfold divides in h.
    destruct h as [d' heq].
    generalize dependent d'.
    generalize dependent hneq.
    pattern d;apply I.
    {
      intros hneq d' heq.
      rewrite mult_zero_l in heq.
      inversion heq.
    }
    {
      clear d. intro d. intro ih.
      intro hneq. intro d'. intro heq.
      rewrite next_eq_plus_one in heq.
      rewrite plus_mult_distribute_right in heq.
      rewrite mult_one_l in heq.
      apply plus_eq_two in heq.
      destruct heq as [h02 | [h11 | h20]].
      {
        destruct h02 as [hl hr].
        subst d'.
        apply mult_eq_zero in hl.
        destruct hl as [hl | hr].
        {
          subst d.
          unfold one.
          reflexivity.
        }
        { inversion hr. }
      }
      {
        destruct h11 as [hl hr].
        subst d'.
        rewrite mult_one_r in hl.
        subst d.
        clear ih.
        exfalso.
        apply hneq.
        unfold two.
        reflexivity.
      }
      {
        destruct h20 as [hl hr].
        subst d'.
        rewrite mult_zero_r in hl.
        inversion hl.
      }
    }
  Qed.

  Lemma zero_neq_two : zero = two -> False.
  Proof.
    intro i. inversion i.
  Qed.

  Lemma one_neq_two : one = two -> False.
  Proof.
    intro h.
    inversion h.
  Qed.

  Lemma plus_eq_plus_1 : forall n m p:T, plus n m = plus p one ->
    (exists n', plus n' m=p) \/
    (exists m', plus n m' = p).
  Proof.
    intro n.
    pattern n;apply I.
    {
      intro m.
      intro p.
      intro heq.
      rewrite plus_zero_l in heq.
      subst m.
      right.
      exists p.
      rewrite plus_zero_l.
      reflexivity.
    }
    {
      clear n. intro n'. intro ih.
      intro m. intro p. intro heq.
      specialize (ih (next m)).
      specialize (ih p).
      rewrite plus_next_r in heq.
      rewrite <- plus_next_l in heq.
      specialize (ih heq).
      destruct ih as [hl | hr].
      {
        destruct hl as [z hz].
        left.
        exists (next z).
        rewrite plus_next_r.
        rewrite <- plus_next_l.
        exact hz.
      }
      {
        destruct hr as [z hz].
        rewrite plus_next_l in heq.
        rewrite <- next_eq_plus_one in heq.
        apply next_injective in heq.
        rewrite <- heq in hz.
        apply plus_elim_l in hz.
        subst z.
        left.
        exists n'.
        exact heq.
      }
    }
  Qed.

  Definition three := next two.

  Lemma isprime_three : isprime three.
  Proof.
    unfold isprime.
    intro d.
    pattern d;apply I.
    (* d = 0 *)
    {
      intro h.
      intro hneq.
      unfold divides in h.
      destruct h as [d' heq].
      rewrite mult_zero_l in heq.
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
      rewrite next_eq_plus_one in heq.
      rewrite plus_mult_distribute_right in heq.
      rewrite mult_one_l in heq.
      unfold three in heq.
      rewrite next_eq_plus_one in heq.
      assert(kept:=heq).
      apply plus_eq_plus_1 in heq.
      destruct heq as [hl | hr ].
      {
        destruct hl as [d'' heq].
        apply plus_eq_two in heq.
        destruct heq as [heq | [ heq | heq ] ].
        {
          destruct heq as [h'' h].
          subst d''.
          subst q.
          rewrite (plus_comm two) in kept.
          apply plus_elim_r in kept.
          apply mult_one_one_eq_one in kept.
          destruct kept as [_ i].
          inversion i.
        }
        {
          destruct heq as [hl hr].
          subst q. subst d''.
          rewrite mult_one_r in kept.
          apply plus_elim_r in kept.
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
          rewrite mult_zero_r in kept.
          rewrite plus_zero_l in kept.
          rewrite <- next_eq_plus_one in kept.
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
          apply mult_eq_zero in hl.
          destruct hl as [h | h].
          {
            subst d'.
            unfold one.
            reflexivity.
          }
          {
            subst q.
            rewrite mult_zero_r in kept.
            rewrite plus_zero_l in kept.
            rewrite <- next_eq_plus_one in kept.
            inversion kept.
          }
        }
        {
          destruct h as [hl hr].
          subst u.
          apply mult_one_one_eq_one in hl.
          destruct hl as [hl hr].
          subst d'.
          subst q.
          rewrite mult_one_r in kept.
          repeat rewrite <- next_eq_plus_one in kept.
          inversion kept.
        }
        {
          destruct h as [hl hr].
          subst u.
          assert(heq:=kept).
          rewrite hl in heq.
          apply plus_elim_l in heq.
          subst q.
          rewrite mult_one_r in hl.
          subst d'.
          exfalso.
          apply hneq.
          unfold three.
          reflexivity.
        }
      }
    }
  Qed.

  Definition even (n:T) := divides two n.
  Definition odd (n:T) := not (even n).

  Lemma f_eq {A B:Type} : forall (f:A->B) (x y:A), x = y ->f x  = f y.
  Proof. intros f x y heq. subst y. reflexivity. Qed.

  Lemma mult_two_r : forall n, mult n two = plus n n.
  Proof.
    intro n.
    unfold two.
    rewrite next_eq_plus_one.
    rewrite plus_mult_distribute_left.
    repeat rewrite mult_one_r.
    reflexivity.
  Qed.

  Lemma mult_two_l : forall n, mult two n = plus n n.
  Proof.
    intro n.
    rewrite mult_comm.
    apply mult_two_r.
  Qed.

  Lemma not_even_odd : forall (n:T), not (even n /\ odd n).
  Proof.
    intro n.
    unfold not.
    intros [heven hodd].
    unfold odd in hodd.
    apply hodd.
    exact heven.
  Qed.

  Lemma even_2k : forall (k:T), even (mult two k).
  Proof.
  intro k.
  pattern k;apply I.
  { unfold even. rewrite mult_zero_r. apply divides_zero_n. }
  {
    clear k. intro k'. intro ih. clear ih.
    unfold even.
    unfold divides.
    exists (next k').
    reflexivity.
  }
  Qed.
  
  Lemma destruct_n : forall n:T, n = zero \/ exists n', n = next n'.
  Proof.
    intro n.
    pattern n;apply I.
    { left. reflexivity. }
    {
      clear n. intro n'. intro ih.
      destruct ih as [hl | hr].
      {
        subst n'.
        right.
        exists zero.
        reflexivity.
      }
      {
        destruct hr as [n'' heq].
        subst n'.
        right.
        exists (next n'').
        reflexivity.
      }
    }
  Qed.
    

  Lemma odd_2k1 : forall (k:T), odd (next (mult two k)).
  Proof.
  intro k.
  pattern k;apply I.
  {
    rewrite mult_zero_r.
    unfold odd.
    unfold not.
    intro heven.
    unfold even in heven.
    unfold divides in heven.
    destruct heven as [e he].
    clear k.
    generalize dependent he.
    pattern e;apply I.
    {
      intro h.
      rewrite mult_zero_r in h.
      inversion h.
    }
    {
      clear e. intro e'. intro hi. clear hi. intro h.
      rewrite mult_two_l in h.
      fold one in h.
      apply plus_eq_one in h.
      destruct h as [h | h].
      { destruct h as [hl hr]. rewrite hr in hl. inversion hl. }
      { destruct h as [hl hr]. rewrite hr in hl. inversion hl. }
    }
  }
  {
    clear k. intro k'. intro ih.
    unfold odd.
    unfold not.
    intro heq.
    unfold even in heq.
    unfold divides in heq.
    destruct heq as [d heq].
    unfold odd in ih.
    unfold not in ih.
    apply ih.
    clear ih.
    unfold even.
    unfold divides.
    rewrite mult_two_l in heq.
    rewrite mult_two_l in heq.    
    rewrite plus_next_l in heq.
    rewrite plus_next_r in heq.
    rewrite mult_two_l.
    assert (hd:=destruct_n d).
    {
      destruct hd as [hz | he].
      { subst d. rewrite plus_zero_l in heq. inversion heq. }
      {
        destruct he as [d' heq']. subst d.
        rewrite plus_next_l in heq.
        rewrite plus_next_r in heq.
        apply next_injective in heq.
        apply next_injective in heq.
        exists d'.
        rewrite mult_two_l.
        exact heq.
      }
    }
  }
  Qed.

  Lemma n_destruct_odd_even : forall n:T, (exists k, n = mult two k) \/ (exists k, n = next (mult two k)).
  Proof.
  intro n.
  pattern n;apply I.
  {
    left.
    exists zero.
    rewrite mult_zero_r.
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
      exists (next k).
      rewrite mult_two_l.
      rewrite mult_two_l.
      rewrite plus_next_l.
      rewrite plus_next_r.
      reflexivity.
    }
  }
  Qed.

  Lemma next_not_eq : forall n:T, n = next n -> False.
  Proof.
    intro n.
    pattern n;apply I.
    { intro heq. inversion heq. }
    {
      clear n. intro n'. intro ih.
      intro hneq.
      apply next_injective in hneq.
      apply ih.
      exact hneq.
    }
  Qed.

  Lemma even_or_odd : forall (n:T), even n \/ odd n.
  Proof.
    intro n.
    assert (h:=n_destruct_odd_even n).
    destruct h as [h | h].
    {
      destruct h as [k h].
      left.
      unfold even.
      unfold divides.
      exists k.
      subst n.
      reflexivity.
    }
    {
      destruct h as [k h].
      right.
      unfold odd.
      unfold not.
      intro heven.
      unfold even in heven.
      unfold divides in heven.
      destruct heven as [k' h'].
      rewrite <- h' in h.
      clear h'. clear n.
      rename k into m.
      rename k' into n.
      repeat rewrite mult_two_l in h.
      generalize dependent m.
      pattern n;apply I.
      {
        intro m.
        rewrite plus_zero_l.
        intro h.
        inversion h.
      }
      {
        clear n. intros n' ih. intros m heq.
        rewrite plus_next_l in heq.
        rewrite plus_next_r in heq.
        apply next_injective in heq.
        assert (dm:=destruct_n m).
        destruct dm as [hl | hr].
        { subst m. rewrite plus_zero_l in heq. inversion heq. }
        {
          destruct hr as [m' heq'].
          subst m.
          specialize (ih m').
          apply ih.
          rewrite plus_next_l in heq.
          rewrite plus_next_r in heq.
          apply next_injective in heq.
          exact heq.
        }
      }
    }
  Qed.

  Theorem le_refl : forall n:T, le_n n n.
  Proof.
    intro nT.
    destruct nT as [n hn].
    unfold le_n.
    simpl.
    clear hn.
    induction n as [|head tail ih].
    { simpl. trivial. }
    { simpl. exact ih. }
  Qed.

  Inductive Pair {A B:Type} :=
  | pair : A -> B -> Pair
  .

  Definition PairOf (A:Type) := Pair (A:=A) (B:=A).

  Definition first {A:Type} (p : PairOf A) : A := match p with
  | pair l _ => l
  end.

  Definition second {A:Type} (p : PairOf A) : A := match p with
  | pair _ r => r
  end.

  Definition ZRel (x y:PairOf T) := plus (first x) (second y) = plus (second x) (first y).

  Definition reflexive {A:Type} (R:A->A->Prop) := forall x, R x x.
  Definition transitive {A:Type} (R:A->A->Prop) := forall x y z, R x y -> R y z -> R x z.
  Definition symmetric {A:Type} (R:A->A->Prop) := forall x y, R x y -> R y x.
  Definition equivalence {A:Type} (R:A->A->Prop) := reflexive R /\ symmetric R /\ transitive R.

  Theorem ZRel_equivalence : equivalence ZRel.
  Proof.
    red.
    split.
    (* reflexivity *)
    {
      red.
      intro x.
      red.
      rewrite plus_comm.
      reflexivity.
    }
    split.
    (* symmetry *)
    {
      red.
      intros x y h.
      red.
      red in h.
      rewrite (plus_comm (second y)).
      rewrite h.
      rewrite (plus_comm (second x)).
      reflexivity.
    }
    (* transitivity *)
    {
      red.
      intros x y z.
      unfold ZRel.
      set (fx:=first x).
      set (fy:=first y).
      set (fz:=first z).
      set (sx:=second x).
      set (sy:=second y).
      set (sz:=second z).
      intros hxy hyz.
      apply plus_elim_l with sy.
      repeat rewrite <- plus_assoc.
      rewrite (plus_comm sy).
      rewrite hxy.
      clear hxy.
      rewrite plus_assoc.
      rewrite hyz.
      clear hyz.
      rewrite <- plus_assoc.
      rewrite (plus_comm sx).
      reflexivity.
    }
  Qed.

  Lemma feq_l {A B C:Type} : forall (f:A->B->C) n m k, n = m -> f k n = f k m.
  Proof.
    intro f.
    intros n m k.
    intro heq. subst m.
    reflexivity.
  Qed.

  (* Membership condition for a class equivalence representative *)
  Definition ZCond p := first p = zero \/ second p = zero.
  (* Set of representatives *)
  Definition Z := { p | ZCond p }.

  (* We prove that all pairs of naturals are represented by at least one representative *)
  Lemma Z_representation : forall (p:PairOf T), exists (z:Z), ZRel p (proj1_sig z).
  Proof.
    (* We work on that pair *)
    intro p.
    (* It's made of two parts *)
    destruct p as [pf ps].
    (* Let's recall what ZRel is *)
    unfold ZRel.
    simpl.
    (* We'll proceed by induction over pf *)
    pattern pf;apply I;clear pf.
    (* Base case: pf = 0 *)
    {
      (* The representative is (0,ps) *)
      set(zp:=pair zero ps).
      (* Proving that it satisfies the representative condition is simple *)
      assert(zh:ZCond zp).
      { red. left. simpl. reflexivity. }
      (* So here it comes *)
      exists (exist _ zp zh).
      (* We just need some cleanup, then use proof irrelevance to prove equality *)
      subst zp.
      simpl.
      rewrite plus_zero_r.
      destruct ps as [psn psh].
      apply proof_irrelevance.
      simpl.
      reflexivity.
    }
    (* Induction case *)
    {
      intro pf'. intro ih.
      (* We have a z that satisfies the condition for (pf', ps), and pf' is not zero *)
      destruct ih as [z ih].
      (* So we extract its parts *)
      destruct z as [z hz].
      red in hz.
      destruct z as [zf zs].

      (* This is convoluted way to fold "T" to simplify notations, just ignore it *)
      (* Begin technical *)
      assert (tech:exists zf':T, zf'=zf).
      { exists zf. reflexivity. }
      destruct tech as [zf' heq].
      subst zf.

      assert (tech:exists zs':T, zs'=zs).
      { exists zs. reflexivity. }
      destruct tech as [zs' heq].
      subst zs.

      rename zf' into zf.
      rename zs' into zs.
      (* End technical *)

      (* Simplification *)
      simpl in hz.
      simpl in ih.
      destruct hz as [h|h].
      (* zf = 0 *)
      {
        assert(hzs:=destruct_n zs).
        destruct hzs as [ hzs | hzs ].
        (* zs = 0 *)
        {
          subst zs.
          rewrite plus_zero_r in ih.
          subst pf'.
          subst zf.
          (* Answer is (1,0) *)
          set(zp:=pair one zero).
          assert (zh:ZCond zp).
          { red. simpl. right. reflexivity. }
          exists (exist _ zp zh).        
          rewrite plus_zero_r.
          rewrite plus_zero_r.
          subst zp.
          unfold proj1_sig.
          unfold first, second.
          rewrite next_eq_plus_one.
          reflexivity.
        }
        (* zs is not 0 *)
        {
          destruct hzs as [zs' heq].
          subst zs.
          subst zf.
          rewrite plus_zero_r in ih.
          subst ps.
          (* answer is (0, pred(zs)) *)
          set(zp:=pair zero zs').
          assert (zh:ZCond zp).
          { red. simpl. left. reflexivity. }
          exists (exist _ zp zh).
          unfold proj1_sig.
          subst zp.
          unfold second.
          unfold first.
          rewrite plus_zero_r.
          repeat rewrite next_eq_plus_one.
          repeat rewrite plus_assoc.
          apply feq_l.
          rewrite plus_comm.
          reflexivity.
        }
      }
      (* zs = 0 *)
      {
        subst zs.
        rewrite plus_zero_r in ih.
        subst pf'.
        (* answer is (zf+1,0) *)
        set(zp:=pair (next zf) zero).
        assert (zh:ZCond zp).
        { red. simpl. right. reflexivity. }
        exists (exist _ zp zh).
        subst zp.
        unfold proj1_sig, first, second.
        rewrite plus_zero_r.
        repeat rewrite next_eq_plus_one.
        repeat rewrite plus_assoc.
        reflexivity.
      }
    }
  Qed.

  Definition le_n_dec n m : sumbool (le_n n m) (le_n m n).
  Proof.
    destruct n as [n hn];
    destruct m as [m hm].
    unfold le_n.
    simpl.
    clear hn.
    generalize dependent m.
    induction n as [|headn tailn ihn].
    {
      intros m _.
      destruct m as [|headm tailm].
      { simpl. left. trivial. }
      { simpl. left. trivial. }
    }
    {
      intros m hm.
      destruct m as [|headm tailm].
      { simpl. right. trivial. }
      { simpl. unfold isnatural in hm. unfold allnil in hm. simpl in hm.
        destruct hm as [hheadm htailm]. unfold isnil in hheadm. subst headm.
        specialize (ihn tailm). specialize (ihn htailm).
        destruct ihn as [ihn|ihn].
        { left. exact ihn. }
        { right. exact ihn. }
      }
    }
  Defined.

  Definition eq_dec (n m:T) : sumbool (n = m) (n <> m).
  Proof.
    destruct n as [n hn];
    destruct m as [m hm].
    generalize dependent m.
    induction n as [|headn tailn ihn].
    {
      intros m hm.
      destruct m as [|headm tailm].
      { left. apply proof_irrelevance. simpl. reflexivity. }
      { right. unfold not. intro heq. inversion heq. }
    }
    {
      intros m hm.
      destruct m as [|headm tailm].
      { right. unfold not. intro heq. inversion heq. }
      {
        unfold isnatural in hn, hm.
        unfold allnil in hn, hm.
        simpl in hn, hm.
        destruct hn as [hniln htailn];
        destruct hm as [hnilm htailm].
        red in hniln, hnilm.
        subst headn. subst headm.
        specialize (ihn htailn).
        specialize (ihn tailm htailm).
        destruct ihn as [ihn|ihn].
        {
          inversion ihn.
          subst tailm.
          left.
          apply proof_irrelevance.
          simpl.
          reflexivity.
        }
        {
          unfold not in ihn.
          right.
          unfold not.
          intro heq.
          inversion heq.
          subst tailm.
          apply ihn.
          apply proof_irrelevance.
          simpl.
          reflexivity.
        }
      }
    }
  Defined.


  Definition min n m := match le_n_dec n m with
  | left _ => n
  | right _ => m
  end.

  Definition max n m := match le_n_dec n m with
  | left _ => m
  | right _ => n
  end.

  Lemma min_nm : forall n m, le_n (min n m) n /\ le_n (min n m) m.
  Proof.
    intros n m.
    split.
    {
      unfold min.
      destruct (le_n_dec n m).
      { apply le_refl. }
      { exact l. }
    }
    {
      unfold min.
      destruct (le_n_dec n m).
      { exact l. }
      { apply le_refl. }
    }
  Qed.


  Fixpoint list_minus {A:Type} (l m: LO A) : (LO A) := match l, m with
  | nil, nil => nil
  | nil, cons _ _ =>  m
  | cons _ _, nil =>  l
  | cons _ tailn, cons _ tailm =>  list_minus tailn tailm
  end.

  Lemma list_minus_natural : forall l m, isnatural l -> isnatural m -> isnatural (list_minus l m).
  Proof.
    intro l.
    induction l as [|headl taill ih].
    {
      destruct m as [|headm tailm].
      simpl. intros h _. exact h.
      simpl. intros _ h. exact h.
  }
  {
    destruct m as [|headm tailm].
    { simpl. intros h _. exact h. }
    {
      intros hl hm.
      simpl.
      apply ih.
      apply hl.
      apply hm.
    }
  }
  Qed.

  Definition minus (nT mT:T) := 
    let (n, hn) := nT in
    let (m, hm) := mT in
    let r := list_minus n m in
    exist _ r (list_minus_natural n m hn hm).


  Lemma minus_n : forall n, minus n n = zero.
  Proof.
    intros (n, hn).
    simpl.
    generalize dependent hn.
    induction n as [|head tail ih].
    { simpl. intro hn. unfold zero. apply proof_irrelevance. simpl. unfold zero_l. reflexivity. }
    {
      intro hn.
      simpl in *.
      unfold isnatural in *.
      unfold allnil in *.
      simpl in *.
      unfold zero. unfold zero_l.
      apply proof_irrelevance.
      simpl.
      destruct hn as [hhead htail].
      unfold isnil in hhead.
      subst head.
      specialize (ih htail).
      unfold zero in ih.
      inversion ih.
      rewrite H0.
      unfold zero_l.
      reflexivity.
    }
  Qed.

  Lemma minus_zero_r : forall n, minus n zero = n.
  Proof.
    intros (n, hn).
    induction n as [|head tail ih].
    simpl. apply proof_irrelevance. simpl. reflexivity.
    simpl. apply proof_irrelevance. simpl. reflexivity.
  Qed.

  Lemma minus_comm : forall n m, minus n m = minus m n.
  Proof.
  intros (n,hn) (m,hm).
  generalize dependent m.
  unfold isnatural in *. unfold allnil in *.
  induction n as [|headn tailn ih].
  {
    intros m hm.
    destruct m as [|headm tailm].
    { simpl. apply proof_irrelevance. simpl. reflexivity. }
    {
      simpl in hm. destruct hm as [hheadm htailm]. unfold isnil in hheadm. subst headm.
      simpl. apply proof_irrelevance. simpl. reflexivity.
    }
  }
  {
    intros m hm.
    destruct m as [|headm tailm].
    { simpl. apply proof_irrelevance. simpl. reflexivity. }
    {
      simpl. apply proof_irrelevance. simpl.
      simpl in hn, hm.
      destruct hn as [hheadn htailn].
      destruct hm as [hheadm htailm].
      unfold isnil in hheadn, hheadm.
      subst headn. subst headm.
      specialize (ih htailn _ htailm).
      inversion ih. clear ih. rename H0 into ih. clear htailn htailm.
      rewrite ih. clear ih.
      reflexivity.
    }
  }
  Qed.

  Lemma minus_zero_l : forall n, minus zero n = n.
  Proof.
    intro n. rewrite minus_comm. apply minus_zero_r.
  Qed.

  Lemma min_zero_l : forall n, min zero n = zero.
  Proof.
    intros (n, hn).
    induction n as [|head tail ih].
    { unfold min. simpl. reflexivity. }
    { unfold min. simpl. reflexivity. }
  Qed.

  Lemma le_n_zero : forall n, le_n n zero -> n = zero.
  Proof.
    intros (n,hn).
    unfold le_n.
    induction n as [|head tail ih].
    { simpl. intros _. apply proof_irrelevance. simpl. reflexivity. }
    { simpl. intro f. inversion f. }
  Qed.

  Lemma le_n_antisym : forall n m, le_n n m -> le_n m n -> n = m.
  Proof.
    intros (n,hn) (m,hm).
    unfold le_n.
    simpl.
    generalize dependent m.
    induction n as [|headn tailn ih].
    {
      intros m hm.
      destruct m as [|headm tailm].
      { simpl. intros _ _. apply proof_irrelevance. simpl. reflexivity. }
      { simpl. intros _ f. inversion f. }
    }
    {
      intros m hm.
      destruct m as [|headm tailm].
      { simpl. intro f. inversion f. }
      {
        simpl.
        unfold isnatural in *.
        unfold allnil in *.
        simpl in *.
        destruct hn as [hheadn htailn].
        destruct hm as [hheadm htailm].
        unfold isnil in hheadn, hheadm.
        subst headn. subst headm.
        intros hmn hnm.
        specialize (ih htailn _ htailm).
        apply proof_irrelevance. simpl.
        specialize (ih hmn hnm). clear hmn. clear hnm.
        inversion ih. clear ih. rename H0 into ih.
        clear htailn htailm. clear ih.
        reflexivity.
      }
    }
  Qed.


  Lemma min_comm : forall n m, min n m = min m n.
  Proof.
    intro n.
    pattern n;apply I;clear n.
    {
      intro m. rewrite min_zero_l.
      pattern m;apply I;clear m.
      { unfold min. simpl. reflexivity. }
      {
        intros m ih.
        unfold min.
        destruct (le_n_dec (next m) zero).
        { apply le_n_zero in l. inversion l. }
        { reflexivity. }
      }
    }
    {
      intros n ih.
      intro m.
      assert (hd:=destruct_n m).
      destruct hd as [heq|hnext].
      {
        subst m. rewrite min_zero_l. unfold min.
        destruct (le_n_dec (next n) zero).
        { apply le_n_zero in l. inversion l. }
        { reflexivity. }
      }
      {
        destruct hnext as [n' hn'].
        subst m.
        rename n' into m.
        specialize (ih m).
        unfold min.
        destruct (le_n_dec (next n) (next m)).
        {
          destruct (le_n_dec (next m) (next n)).
          { apply le_n_antisym.
          { exact l. }
          { exact l0. }
        }
        { reflexivity. }
      }
      {
        destruct (le_n_dec (next m) (next n)).
        { reflexivity. }
        {
          apply le_n_antisym.
          { exact l. }
          { exact l0. }
        }
      }
    }
  }
  Qed.

  Lemma min_zero_r : forall n, min n zero = zero.
  Proof.
    intro n.
    rewrite min_comm.
    apply min_zero_l.
  Qed.

  Lemma max_zero_l : forall n, max zero n = n.
  Proof.
    intro n.
    pattern n;apply I;clear n.
    { unfold max. simpl. reflexivity. }
    {
      intros n' ih.
      unfold max. simpl. reflexivity.
    }
  Qed.

  Lemma max_zero_r : forall n, max n zero = n.
    Proof.
    intro n.
    pattern n;apply I;clear n.
    { unfold max. simpl. reflexivity. }
    {
      intros n ih.
      unfold max.
      simpl.
      reflexivity.
    }
  Qed.

  Lemma max_comm : forall n m, max n m = max m n.
  Proof.
    intro n.
    pattern n;apply I;clear n.
    { intro m. rewrite max_zero_l. rewrite max_zero_r. reflexivity. }
    {
      intros n' ih.
      intros m.
      unfold max.
      destruct (le_n_dec (next n') m);destruct (le_n_dec m (next n')).
      { apply le_n_antisym. exact l0. exact l. }
      { reflexivity. }
      { reflexivity. }
      { apply le_n_antisym. exact l0. exact l. }
    }
  Qed.

  Lemma min_next : forall n m, min (next n) (next m) = next (min n m).
  Proof.
    intro n.
    pattern n;apply I;clear n.
    {
      intro m. rewrite min_zero_l.
      unfold min. destruct (le_n_dec (next zero) (next m)).
      { reflexivity. }
      { apply le_n_zero in l. subst m. reflexivity. }
    }
    {
      intros n ih.
      intro m.
      set (nnn:=next (next n)).
      set (nm:=next m).
      set (nn:=next n).
      unfold min.
      destruct (le_n_dec nnn nm);destruct (le_n_dec nn m).
      { subst nnn. subst nn. reflexivity. }
      { subst nnn. subst nn. subst nm.
        apply le_n_antisym.
        { exact l. }
        { apply le_n_next. exact l0. }
      }
      { subst nnn. subst nn. subst nm.
        apply le_n_antisym.
        { exact l. }
        { apply le_n_next. exact l0. }
      }
      { subst nm. reflexivity. }
    }
  Qed.

  Lemma minus_next : forall n m, minus (next n) (next m) = minus n m.
  Proof.
    intros (n, hn) (m, hm).
    generalize dependent m.
    induction n as [|headn tailn ih].
    {
      destruct m as [|headm tailm].
      { intros hm. simpl. apply proof_irrelevance. simpl. reflexivity. }
      { intros hm. simpl. apply proof_irrelevance. simpl. reflexivity. }
    }
    {
      destruct m as [|headm tailm].
      { intro hm. simpl. apply proof_irrelevance. simpl. reflexivity. }
      {intro hm. simpl. apply proof_irrelevance. simpl. reflexivity. }
    }
  Qed.

  Lemma max_next : forall n m, max (next n) (next m) = next (max n m).
  Proof.
    intros n. pattern n;apply I;clear n.
    {
      intro m.
      rewrite max_zero_l.
      unfold max.
      destruct (le_n_dec (next zero) (next m)).
      { reflexivity. }
      { apply le_n_zero in l. subst m. reflexivity. }
    }
    {
      intros n' ih.
      intro m.
      unfold max.
      destruct (le_n_dec (next (next n')) (next m));
      destruct (le_n_dec (next n') m).
      { reflexivity. }
      { apply le_n_antisym. apply le_n_next. exact l0. exact l. }
      { apply le_n_antisym. apply le_n_next. exact l0. exact l. }
      { reflexivity. }
    }
  Qed.

  Lemma plus_min_minus_max : forall n m, plus (min n m) (minus n m) = max n m.
  
  Proof.
    intro n.
    pattern n;apply I;clear n.
    {
      intro m.
      rewrite min_zero_l.
      rewrite minus_zero_l.
      rewrite plus_zero_l.
      rewrite max_zero_l.
      reflexivity.
    }
    {
      intros n' ih.
      intro m.
      destruct (destruct_n m).
      {
        subst m.
        rewrite min_zero_r.
        rewrite minus_zero_r.
        rewrite max_zero_r.
        rewrite plus_zero_l.
        reflexivity.
      }
      {
        destruct H. subst m. rename x into m.
        rewrite min_next.
        rewrite minus_next.
        rewrite max_next.
        rewrite plus_next_r.
        apply f_eq.
        apply ih.
      }
    }
  Qed.

  Definition Z_representative (p:PairOf T) :=
    match p with
    | pair pf ps => let m := min pf ps in
      match (eq_dec m pf) with
      | left _ => pair zero (minus ps pf)
      | right _ => pair (minus pf ps) zero
      end
    end.

  Lemma Z_representative_ok : forall (p:PairOf T), ZCond (Z_representative p).
  Proof.
    intro p.
    destruct p as [pf ps].
    unfold ZCond.
    unfold Z_representative.
    pattern pf;apply I;clear pf.
    { rewrite min_zero_l. rewrite minus_zero_r. rewrite minus_zero_l. simpl. left. reflexivity. }
    {
      intros pf' ih.
      destruct (destruct_n ps).
      { subst ps. rewrite min_zero_r. rewrite minus_zero_l. rewrite minus_zero_r. simpl. right. reflexivity. }
      { destruct H. subst ps. rename x into ps'.
        rewrite min_next. rewrite minus_next. rewrite minus_next.
        destruct (eq_dec (next (min pf' ps')) (next pf')).
        left. simpl. reflexivity.
        right. simpl. reflexivity.
      }
    }
  Qed.

  Lemma Z_uniqueness : forall (zx zy:Z),
    let zxp := proj1_sig zx in
    let zyp := proj1_sig zy in
    ZRel zxp zyp -> zxp = zyp.
  Proof.
    intros zx zy.
    simpl.
    intro heqv.
    destruct zx as [x hx];
    destruct zy as [y hy].
    destruct x as [xf xs];
    destruct y as [yf ys].

    (* Begin technical *)
    (* There must be a better way of folding type definitions *)
    assert(tech:exists techtmp:T,techtmp=xf). exists xf. reflexivity.
    destruct tech as [techtmp techeq]. subst xf. rename techtmp into xf.

    assert(tech:exists techtmp:T,techtmp=xs). exists xs. reflexivity.
    destruct tech as [techtmp techeq]. subst xs. rename techtmp into xs.

    assert(tech:exists techtmp:T,techtmp=yf). exists yf. reflexivity.
    destruct tech as [techtmp techeq]. subst yf. rename techtmp into yf.

    assert(tech:exists techtmp:T,techtmp=ys). exists ys. reflexivity.
    destruct tech as [techtmp techeq]. subst ys. rename techtmp into ys.
    (* End technical *)

    unfold ZRel in heqv.
    unfold proj1_sig, first, second in heqv.
    simpl.
    unfold ZCond in hx, hy.
    unfold first, second in hx, hy.
    destruct hx as [ hx | hx ];
    destruct hy as [ hy | hy ].
    { subst xf. subst yf. rewrite plus_zero_l in heqv. rewrite plus_zero_r in heqv. subst ys. reflexivity. }
    { subst xf. subst ys. rewrite plus_zero_l in heqv. symmetry in heqv.
      apply plus_zero_zero_eq_zero in heqv. destruct heqv as [hx hy]. subst xs. subst yf. reflexivity.
    }
    { subst xs. subst yf. rewrite plus_zero_r in heqv.
      apply plus_zero_zero_eq_zero in heqv. destruct heqv as [hx hy]. subst xf. subst ys. reflexivity.
    }
    { subst xs. subst ys. rewrite plus_zero_l in heqv. rewrite plus_zero_r in heqv. subst yf. reflexivity. }
  Qed.

  (* TODO : Bind ZRel_equivalence, Z_representation and Z_uniqueness in a single lemma that states
     that Z defines a partitions on equivalences classes *)



  Definition Z_plus (x y : Z) : Z :=
    let (xp, hx) := x in
    let (yp, hy) := y in
    let result := pair (plus (first xp) (first yp)) (plus (second xp) (second yp))
    in exist _ (Z_representative result) (Z_representative_ok result).

  Lemma zero_Zh : ZCond (pair zero zero).
  Proof.
    unfold ZCond. left. simpl. reflexivity.
  Qed.

  Definition zero_Z := exist _ (pair zero zero) zero_Zh.

  Lemma Z_plus_zero_l : forall x:Z, Z_plus x zero_Z = x.
  Proof.
    intro x.
    destruct x as [x hx].
    apply proof_irrelevance.
    simpl.
    red in hx.
    destruct x as [xf xs].
    simpl in hx.
    simpl.
    rewrite plus_zero_r.
    rewrite plus_zero_r.
    destruct hx as [ hx | hx ].
    { subst xf. rewrite min_zero_l. rewrite minus_zero_r. rewrite minus_zero_l. simpl. reflexivity. }
    { subst xs. rewrite min_zero_r. rewrite minus_zero_l. rewrite minus_zero_r.
      destruct (eq_dec zero xf).
      { subst xf. reflexivity. }
      { reflexivity. }
    }
  Qed.

  Lemma Z_plus_zero_r : forall x:Z, Z_plus zero_Z x = x.
  Proof.
    intros (x,hx).
    apply proof_irrelevance.
    simpl.
    red in hx.
    destruct x as [xf xs].
    simpl in hx.
    simpl.
    destruct hx as [ hx | hx ].
    {
      subst xf. simpl.
      destruct xs as [xs hxs].
      destruct xs as [|xshead xstail].
      { simpl. apply f_eq. apply proof_irrelevance. simpl. reflexivity. }
      { simpl. apply f_eq. apply proof_irrelevance. simpl. reflexivity. }
    }
    {
      subst xs. simpl.
      destruct xf as [xf hxf]. simpl.
      destruct xf as [|xfhead xftail].
      { simpl. apply f_equal2.
        { apply proof_irrelevance. simpl. unfold zero_l. reflexivity. }
        { apply proof_irrelevance. simpl. unfold zero_l. reflexivity. }
      }
      { simpl. apply f_equal2.
        { apply proof_irrelevance. simpl. reflexivity. }
        { reflexivity. }
      }
    }
  Qed.

  Lemma Z_plus_comm : forall x y, Z_plus x y = Z_plus y x.
  Proof.
    intros (x,hx) (y,hy).
    apply proof_irrelevance.
    simpl.
    destruct x as [xf xs].
    destruct y as [yf ys].
    unfold ZCond in hx, hy.
    simpl in *.
    destruct hx as [hx|hx];
    destruct hy as [hy|hy].
    {
      subst xf. subst yf.
      rewrite plus_zero_l.
      rewrite min_zero_l.
      rewrite min_zero_l.
      rewrite minus_zero_l.
      rewrite minus_zero_l.
      rewrite minus_zero_r.
      rewrite minus_zero_r.
      repeat rewrite (plus_comm ys).
      reflexivity.
    }
    {
      subst xf. subst ys.
      rewrite plus_zero_l.
      rewrite plus_zero_r.
      rewrite plus_zero_r.
      rewrite plus_zero_l.
      reflexivity.
    }
    {
      subst xs.
      subst yf.
      rewrite plus_zero_r.
      rewrite plus_zero_l.
      rewrite plus_zero_l.
      rewrite plus_zero_r.
      reflexivity.
    }
    {
      subst xs.
      subst ys.
      rewrite plus_zero_l.
      rewrite min_zero_r.
      rewrite min_zero_r.
      rewrite minus_zero_l.
      rewrite minus_zero_l.
      repeat rewrite (plus_comm yf).
      reflexivity.
    }
  Qed.

  Lemma zero_eq : forall (h:isnatural zero_l), exist _ zero_l h = zero.
  Proof.
    intro h.
    apply proof_irrelevance.
    simpl. reflexivity.
  Qed.

  Lemma Z_plus_assoc : forall x y z:Z, Z_plus (Z_plus x y) z = Z_plus x (Z_plus y z).
  Proof.
  intros x y z.
  destruct x as [x hx];
  destruct y as [y hy];
  destruct z as [z hz].
  destruct x as [xf xs].
  destruct y as [yf ys].
  destruct z as [zf zs].
  apply proof_irrelevance.
  unfold ZCond in hx, hy, hz.
  simpl in hx, hy, hz.
  simpl.
  remember (plus xf yf) as e00 eqn:heq00.
  remember (plus xs ys) as e01 eqn:heq01.
  remember (minus e01 e00) as e02 eqn:heq02.
  remember (minus e00 e01) as e03 eqn:heq03.
  remember (min e00 e01) as e04 eqn:heq04.
  remember (eq_dec e04 e00) as e05 eqn:heq05.
  remember (pair zero e02) as e06 eqn:heq06.
  remember (pair e03 zero) as e07 eqn:heq07.
  remember (if e05 then e06 else e07) as e08 eqn:heq08.
  remember (first e08) as e09 eqn:heq09.
  remember (plus e09 zf) as e10 eqn:heq10.
  remember (second e08) as e11 eqn:heq11.
  remember ( plus e11 zs) as e12 eqn:heq12.
  remember (min e10 e12) as e13 eqn:heq13.
  remember (eq_dec e13 e10) as e14 eqn:heq14.
  remember (minus e12 e10) as e15 eqn:heq15.
  remember (pair zero e15) as e16 eqn:heq16.
  remember (minus e10 e12) as e17 eqn:heq17.
  remember (pair e17 zero) as e18 eqn:heq18.
  remember ( if e14 then e16 else e18) as e19 eqn:heq19.
  remember (plus yf zf) as e20 eqn:heq20.
  remember (plus ys zs) as e21 eqn:heq21.
  remember (min e20 e21) as e22 eqn:heq22.
  remember (eq_dec e22 e20) as e23 eqn:heq23.
  remember (minus e21 e20) as e24 eqn:heq24.
  remember (pair zero e24) as e25 eqn:heq25.
  remember (minus e20 e21) as e26 eqn:heq26.
  remember (pair e26 zero) as e27 eqn:heq27.
  remember (if e23 then e25 else e27) as e28 eqn:heq28.
  remember (first e28) as e29 eqn:heq29.
  remember (plus xf e29) as e30 eqn:heq30.
  remember (second e28) as e31 eqn:heq31.
  remember (plus xs e31) as e32 eqn:heq32.
  remember (min e30 e32) as e33 eqn:heq33.
  remember (minus e32 e30) as e34 eqn:heq34.
  remember (eq_dec e33 e30) as e35 eqn:heq35.
  remember (pair zero e34) as e36 eqn:heq36.
  remember (minus e30 e32) as e37 eqn:heq37.
  remember (pair e37 zero) as e38 eqn:heq38.
  remember (if e35 then e36 else e38) as e39 eqn:heq39.
  destruct hx as [hx|hx];
  destruct hy as [hy|hy];
  destruct hz as [hz|hz].
  { subst xf. subst yf. subst zf.
    rewrite plus_zero_l in *.
    subst e00. subst e20.
    rewrite min_zero_l in *.
    subst e22.
    subst e23.
    simpl in heq28.
    subst e28.
    subst e25.
    simpl in heq29, heq31.
    subst e29 e31.
    subst e30.
    rewrite min_zero_l in *.
    subst e33.
    simpl in heq35. subst e35.
    subst e39.
    rewrite plus_zero_r in *.
    subst e10.
    subst e04. simpl in heq05. subst e05. subst e08.
    rewrite minus_zero_r in *.
    subst e02.
    subst e01.
    rewrite minus_zero_l in *.
    subst e03.
    subst e06.
    simpl in heq09, heq11.
    subst e09.
    rewrite min_zero_l in *.
    subst e13.
    simpl in heq14.
    subst e14.
    subst e19.
    subst e16.
    subst e15.
    rewrite minus_zero_r.
    subst e12.
    subst e11.
    subst.
    rewrite plus_assoc.
    reflexivity.
  }
  {
    subst xf yf zs.
    rewrite plus_zero_l in * ; rewrite plus_zero_r in *.
    subst e00 e12 e20 e21 e30.
    rewrite minus_zero_r in * ; rewrite minus_zero_l in * ; rewrite min_zero_l in *.
    subst e02 e03 e04.
    simpl in heq05. subst e05.
    subst e08.
    subst e06. simpl in heq09, heq11.
    subst e09 e11.
    rewrite plus_zero_l in heq10.
    subst e10.
    destruct e14 as [h14|h14];
    destruct e23 as [h23|h23];
    destruct e35 as [h35|h35].
    {
      subst e13 e22 e33.    
      clear heq14 heq23.
      subst e19.
      subst e39.
      subst e28.
      subst e25.
      simpl in heq29, heq31.
      subst e29.
      rewrite minus_zero_r in * ; rewrite minus_zero_l in *.
      subst e34 e37.
      clear heq35 h35.
      subst.
      rewrite heq22 in heq13. clear heq22.
      apply f_eq.
      rename xs into a.
      rename ys into b.
      rename zf into c.

      assert (le_n_zero_n:forall n, le_n zero n).
      {
        clear. intros (n, hn). unfold le_n. simpl.
        clear hn. destruct n. simpl. trivial. simpl. trivial.
      }
      assert (min_le_n:forall x y, x = min x y -> le_n x y).
      {
        clear -le_n_zero_n.
        intro x.
        pattern x;apply I;clear x.
        {
          intros y h.
          apply le_n_zero_n.
        }
        {
          intros n ih.
          intros y h.
          destruct (destruct_n y).
          { subst y. rewrite min_zero_r in h. inversion h. }
          { destruct H. subst y. rewrite min_next in h. apply next_injective in h.
            apply le_n_next. apply ih. exact h.
          }
        }
      }
      apply min_le_n in heq13.
Search le_n.

          apply le_n_zero.
      generalize dependent c.
      generalize dependent b.
      pattern a;apply I;clear a.
      {
        intros b c _.
        rewrite plus_zero_l.
        rewrite plus_zero_l.
        reflexivity.
      }
      {
        intros a ih.
        intros b c h.
        rewrite plus_next_r.
        rewrite <- plus_next_l.
        specialize (ih (next b)).
        specialize (ih c).

        rewrite ih.
        clear ih.
        rewrite plus_next_r.
        rewrite <- plus_next_l.
        apply f_eq.
        pattern b;apply I;clear b.
        {
          rewrite minus_zero_l.
          destruct (destruct_n c).
          { subst c. rewrite minus_zero_r. reflexivity. }
          { destruct H. subst c. rename x into c. rewrite minus_next. rewrite minus_zero_l.