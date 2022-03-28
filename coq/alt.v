
Declare Scope alt.
Open Scope alt.

(* I like to name properties *)
Definition commutative {A:Type} (f:A->A->A) := forall x y, f x y = f y x.
Definition associative {A:Type} (f:A->A->A) := forall x y z, f (f x y) z = f x (f y z).

(* That's the classic definition of a list *)
Inductive List {A:Type} : Type :=
| nil : List
| cons : A -> List -> List
.

Notation "'_'" := nil (only printing) : alt.
Notation "[ x ]" := (cons x nil) (only printing) : alt.
Notation "[ x ; y ; .. ; z ]" :=  (cons x (cons y .. (cons z nil) ..)) (only printing) : alt.
Notation "x ∘ y" := (cons x y) (only printing, at level 60) : alt. 

Definition singleton (A:Type) (a:A) := cons a nil.

(* The syntax for expliciting implicit types is quickly verbose, these make it easier *)
(* LO is a list of A, LOLO is a list of lists of A *)
Definition LO (A:Type) := List (A:=A).
Definition LOLO (A:Type) := List (A:=(LO A)).

(* Classic fixpoint definition of append *)
Fixpoint append {A:Type} (l l' : LO A) : (LO A) := match l, l' with
| nil, _ => l'
| cons head tail, _ => cons head (append tail l')
end.
Notation "x ⋄ y" := (append x y) (only printing, at level 60) : alt. 

(* Simplification lemma to remove empty lists on the right *)
Lemma append_nil {A:Type} : forall l : LO A, append l nil = l.
Proof.
  intro l.
  induction l as [| head tail ih].
  { simpl. reflexivity. }
  { simpl. rewrite ih. reflexivity. }
Qed.

(* Associativity of append *)
Lemma append_assoc {A:Type} : associative (append (A:=A)) .
Proof.
  red.
  intro x.
  induction x as [|head tail ih].
  { intros y z. simpl. reflexivity. }
  { intros y z. simpl. rewrite ih. reflexivity. }
Qed.

Lemma append_intro_l {A:Type} : forall (l m n: LO A), m = n -> append l m = append l n.
Proof.
  intros l m n heq.
  subst m.
  reflexivity.
Qed.

Lemma append_intro_r (A:Type) : forall (l m n: LO A), m = n -> append m l = append n l.
Proof.
  intros l m n heq.
  subst m.
  reflexivity.
Qed.

(* A predicate that asserts whether a list is empty *)
Definition isnil {A:Type} (l:LO A) := l = nil.

(* The empty list is empty *)
(* It's trivial, but it comes up often in proofs *)
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

Theorem allmatch_append {A:Type} : forall (l m:LO A) (P:A->Prop),
  allmatch l P -> allmatch m P -> allmatch (append l m) P.
Proof.
intro l.
induction l as [|head tail ih].
{
intros m P hn hm.
simpl.
exact hm.
}
{
intros m P hn hm.
simpl.
simpl in hn.
destruct hn as [hhead htail].
split.
{
exact hhead.
}
{
apply ih.
exact htail.
exact hm.
}
}
Qed.

(* Map function over lists *)
Fixpoint map {A B:Type} (f:A->B) (x:LO A) := match x with
| nil => nil
| cons head tail => cons (f head) (map f tail)
end.

(* Flattens a list of lists *)
Fixpoint flatten {A:Type} (l:LOLO A) := match l with
| nil => nil
| cons head tail => append head (flatten tail)
end.

(* Predicate that asserts tha all elements in a list of lists are empty *)
Definition allnil {A:Type} (l:LOLO A) := allmatch l isnil.

(* In an empty list of lists, all elements are empty *)
(* Also trivial, but comes up often in proofs *)
Lemma allnil_nil {A:Type} : allnil (nil (A:=LOLO A)).
Proof.
  red.
  simpl.
  trivial.
Qed.

(* In a list of lists, if all elements are the empty list, then append commutes for these two lists *)
Lemma allnil_append_comm {A:Type} : forall (l m : LOLO A), allnil l -> allnil m -> append l m = append m l.
Proof.
  (* The proof uses induction and rewriting *)
  intro l.
  (* First, we do induction on the left *)
  induction l as [|head tail ih].
  {
    intro m.
    (* We don't care about the hypotheses for that case *)
    intros _ _.
    simpl.
    rewrite append_nil.
    reflexivity.
  }
  {
    (* First, we introduce and massage the hypotheses *)
    intro m.
    simpl.
    intros hx hy.
    red in hx, hy.
    simpl in hx.
    destruct hx as [hnil hmatch].
    red in hnil.
    subst head.
    (* Then we prepare to use the induction hypothese *)
    unfold allnil in ih.
    specialize (ih m).
    specialize (ih hmatch).
    specialize (ih hy).
    (* And we use it for rewrite *)
    rewrite ih. clear ih.
    (* Now we proceed by induction over m *)
    induction m as [|mhead mtail ih].
    { simpl. reflexivity. }
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

(* Now we attempt to construct the naturals as the lists of empty lists over some type *)
Module Natural.

  (* The actual type does not matter *)
  Parameter TypeForNat : Type.

  (* And we define two typing levels *)
  Definition Level1 := LO TypeForNat.
  Definition Level2 := LO Level1.

  (* A list of lists is natural if all its elements are empty lists *)
  Definition isnatural (l:Level2) := allnil l.

  (* Zero is the empty list of empty lists *)
  Definition zero := nil (A:=Level1).
  (* The successor function adds an empty list to any lists of list *)
  Definition next (n:Level2) : Level2 := cons nil n.

  (* We can show that zero is natural *)
  Theorem  zero_natural : isnatural zero.
  Proof.
    red.
    unfold allnil.
    simpl.
    trivial.
  Qed.

  (* And that using next on a natural generates a natural *)
  Lemma next_natural : forall (n:Level2), (isnatural n) -> isnatural (next n).
  Proof.
    (* We first unfold terms to a more convenient level *)
    unfold isnatural. unfold allnil.
    (* The proof proceeds by induction *)
    intro n.
    induction n as [|head tail ih].
    (* Base case *)
    {
      intros _.
      simpl.
      split.
      { red. reflexivity. }
      { trivial. }
    }
    (* Induction case *)
    {
      (* Massage the hypotheses *)
      intro h.
      unfold next in *.
      simpl in *.
      destruct h as [hnil hmatch].
      red in hnil.
      subst head.
      (* Massage the induction hypothese *)
      specialize (ih hmatch).
      destruct ih as [hnil _].
      (* Use the induction hypothese *)
      split.
      { exact hnil. }
      {
        split.
        { exact hnil. }
        { exact hmatch. }
      }
    }
  Qed.

  (* Here's where it get's quickly insance *)
  (* We would like to define the type T for naturals as the list of lists which are natural *)
  (* That's possible with that syntax *)
  (* This uses the "sig" inductive type, which has a single "exist" constructor *)
  Definition T := { l | isnatural l }.

  (* There are also two projection functions which retrive the content and the hypothese *)
  Definition number (t:T) := proj1_sig t.
  Definition hyp (t:T) := proj2_sig t.

  (* Here we need  to do a weird thing. Coq requires that two elements in T are equals if
     - their content are equal, that's ok
     - but also the proofs of their hypotheses are equal
     So we introduce an axiom of proof irrelevance to declare that when the content is equal, then the elements are equal
     The assertions on each element are true by the existence of the proofs of these assertions
  *)
  
  Axiom proof_irrelevance : forall (x y:T), number x = number y -> x = y.

  (* Here we define the strong zero *)
  (* This uses the "exist" constructor from "sig" with zero and a proof that zero is natural. *)
  Definition zeroT := exist _ zero zero_natural.
  Notation "0i" := zeroT (only printing) : alt. 

  (*
    Same idea for the strong next function, although it is maybe a bit more difficult to follow,
    since it use the proof that n is natural to construct the proof that the next number is natural
  *)
  Definition nextT (n:T) := exist _
    (next (number n))
    (next_natural (number n) (hyp n)).
  Notation "+i x" := (nextT x) (only printing, at level 60) : alt. 

  Definition oneT := nextT zeroT.
  Notation "1i" := oneT (only printing) : alt.

  Definition twoT := nextT oneT.
  Notation "2i" := twoT (only printing) : alt.

  (*
    Here's a first usage of proof irrelevance to prove that a number is the "strong" zero
    whenever it's content is the "weak" zero
  *)
  Lemma number_nil_zero : forall (n:T), number n = zero -> n = zeroT.
  Proof.
    (* First, we use some strange deconstructing intro syntax to extract the number and the hypothese *)
    intros (n, hn).
    (* Now, observe that n has been exploded into it's exist constructor, which is very verbose *)
    (* simpl will simplify the "number" part, but verbosity will remain in the goal *)
    simpl.
    (* The equality hypothese now looks more simple *)
    intro heq.
    (* And we can replace n by zero *)
    subst n.
    (*
      Now we still have to do something with zeroT
      Here we destruct it into its part, but also use eqn: to keep the equality.
    *)
    destruct zeroT as [z hz] eqn:heqz.
    (* Why do we need the equality ? Because the actual value of z was forgotten in the process! *)
    (* We can recover it by inversion of the constructor *)
    inversion heqz as [heqzl].
    (* Now we can unfold zero everywhere *)
    unfold zero in *.
    (* And substitute z with it's value *)
    subst z.
    (*
      Here we are another strange thing, the goal is verbose on the left hand side,
      but has "isnatural" in the right hand side.
      It would be nice if we also had "isnatural" on the left hand side
    *)
    fold isnatural.
    (* But it's seems "fold" does not work here *)
    (* Anyway, observe that it is actually impossible to prove that hn = hz,
      so we have to use our proof irrelevance axiom.
    *)
    apply proof_irrelevance.
    (* Now it's verbose, but simplification will make things very much simpler *)
    simpl.
    (* And we have our equality *)
    reflexivity.
  Qed.

  (* Here's is another helper lemma, that proves that constructs the predecessor number *)
  Lemma predecessor_exists : forall (nT:T) head tail, number nT = cons head tail -> exists mT:T, number mT = tail.
  Proof.
    intros nT head tail heq.
    (* We explode nT into it's content and it's hypothese, then get rid of the equality *)
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
    (P zeroT) ->  
    (forall n, P n -> P (nextT n)) -> 
    (forall n, P n).
  Proof.
    intros P hzero hnext.
    intro n.
    (* We define nT to keep it around after the destruction *)
    set (nT:=n).
    (* And we destruct it *)
    destruct n as [n hn].
    (* And we proceed by induction over the list *)
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
      (* and zero is nil too *)
      unfold zero in hnz.
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
      assert (hmn:nT = nextT mT).
      {
        (* This requires our proof irrelevance axiom. *)
        apply proof_irrelevance.
        (* We know what's inside nT, and a little about what's inside (nextT mT) *)
        simpl.
        (* Here we are down the "next" function *)
        unfold next.
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
      (* Preparation for ih *)
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
      (* But we need to use proof irrelevance again to do the binding *)
      assert (hirr:=proof_irrelevance).
      specialize (hirr mT).
      (* We will let Coq find y for us here *)
      rewrite <- hirr in ih.
      {
        (* That's ih *)
        exact ih.
      }
      {
        (* And Coq will simplify this mess *)
        simpl.
        exact hm.
      }
    }
  Qed.

  (* This little lemma show that isnatural is conserved by append *)
  Lemma append_natural : forall l m, isnatural l -> isnatural m -> isnatural (append l m).
  Proof.
    intros l.
    unfold isnatural.
    unfold allnil.
    (* The induction is actually quite simple, so no comments *)
    induction l as [|head tail ih].
    { simpl. intros m _ h. exact h. }
    {
      simpl.
      intros m [hnil hmatch].
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
  Notation "x +i y" := (plus x y) (only printing, at level 60) : alt. 
 
  (* Proof that plus is commutative *)
  Theorem plus_comm : commutative plus.
  Proof.
    red.
      intros xT yT.
    (* We explode both xT and yT *)
    destruct xT as [x hx].
    destruct yT as [y hy].
    (* Simplify a bit *)
    simpl.
    (* Use proof_irrevance *)
    apply proof_irrelevance.
    simpl.
    unfold isnatural in hx, hy.
    apply allnil_append_comm.
    { exact hx. }
    { exact hy. }
  Qed.

  Theorem plus_zero_l : forall n, plus zeroT n = n.
  Proof.
    intro nT.
    destruct nT as [n hn].
    simpl.
    apply proof_irrelevance.
    simpl.
    reflexivity.
  Qed.

  Theorem plus_zero_r : forall n, plus n zeroT = n.
  Proof.
    intro n.
    rewrite plus_comm.
    apply plus_zero_l.
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
    apply proof_irrelevance.
    (* Cleanup the mess *)
    simpl.
    (* Use the fact that append is associative *)
    rewrite append_assoc.
    (* And there we are *)
    reflexivity.
  Qed.

  Fixpoint multl (x y:Level2) : Level2 := match x with
  | nil => nil
  | cons head tail => append y (multl tail y)
  end.
  Notation "x *i_ y" := (multl x y) (only printing, at level 60) : alt. 

  Lemma multl_nil : forall x, multl x nil  = nil.
  Proof.
    intro x.
    induction x as [|head tail ih].
    { simpl. reflexivity. }
    { simpl. rewrite ih. reflexivity. }
  Qed.

  Lemma multl_natural : forall (n m:Level2), isnatural n -> isnatural m -> isnatural (multl n m).
  Proof.
    unfold isnatural.
    unfold allnil.
    intros n m hn hm.
    generalize dependent m.
    induction n as [|headn tailn ihn].
    {
      intros m hm.
      simpl.
      trivial.
    }
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

  Definition mult (nT mT : T) : T :=
    let (n, hn) := nT in
    let (m, hm) := mT in
    let result := multl n m in
    exist _ result (multl_natural n m hn hm).
  Notation "x *i y" := (mult x y) (only printing, at level 60) : alt. 

  Theorem mult_one_l : forall n, mult oneT n = n.
  Proof.
    intro nT.
    destruct nT as [n hn].
    simpl.
    apply proof_irrelevance.
    simpl.
    rewrite append_nil.
    reflexivity.
  Qed.

  Theorem mult_comm : commutative mult.
  Proof.
    red.
    intros xT yT.
    destruct xT as [x hx];
    destruct yT as [y hy];
    simpl;
    apply proof_irrelevance;
    simpl.
    unfold isnatural in *.
    unfold allnil in *.
    generalize dependent y.
    induction x as [|headx tailx ihx].
    {
      intros.
      simpl.
      induction y as [|heady taily ihy].
      { simpl. reflexivity. }
      {
        simpl.
        simpl in hy.
        destruct hy as [hnily hmatchy].
        specialize (ihy hmatchy).
        exact ihy.
      }
    }
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
      rewrite ihx.
      clear ihx.
      induction y as [|heady taily ihy].
      { simpl. reflexivity. }
      {
        simpl.
        simpl in hy.
        destruct hy as [hnily hmatchy].
        specialize (ihy hmatchy).
        rewrite <- ihy.
        red in hnily.
        subst heady.
        repeat rewrite <- append_assoc.
        assert (heq:=allnil_append_comm taily tailx).
        pattern (append taily tailx).
        rewrite heq.
        reflexivity.
        unfold allnil. exact hmatchy.
        unfold allnil. exact hmatchx.
      }
    }
  Qed.

  Theorem mult_one_r : forall n, mult n oneT = n.
  Proof.
    intro n.
    rewrite mult_comm.
    apply mult_one_l.
  Qed.

  Theorem multl_comm : forall x y, isnatural x -> isnatural y -> multl x y = multl y x.
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

  Theorem plus_mult_distribute_left : forall x y z, mult x (plus y z) = plus (mult x y) (mult x z).
  Proof.
    intros xT yT zT.
    destruct xT as [x hx];
    destruct yT as [y hy];
    destruct zT as [z hz].
    simpl.
    apply proof_irrelevance.
    simpl.
    unfold isnatural in *.
    unfold allnil in *.
    induction x as [|headx tailx ihx].
    { simpl. reflexivity. }
    {
      simpl in *.
      destruct hx as [hnilx hmatchx].
      red in hnilx.
      subst headx.
      specialize (ihx hmatchx).
      rewrite ihx.
      clear ihx.
      repeat rewrite append_assoc.
      apply append_intro_l.
      repeat rewrite <- append_assoc.
      apply append_intro_r.
      rewrite (allnil_append_comm z).
      { reflexivity. }
      { red. exact hz. }
      {
        red.
        apply multl_natural.
        { apply hmatchx. }
        { red. unfold allnil. exact hy. }
      }
    }
  Qed.

  Theorem plus_mult_distribute_leftl : forall x y z,
    isnatural x -> isnatural y -> isnatural z
    -> multl x (append y z) = append (multl x y) (multl x z).
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

  Theorem plus_mult_distribute_right : forall x y z, mult (plus x y) z  = plus (mult x z) (mult y z).
  Proof.
    intros x y z.
    repeat rewrite (mult_comm _ z).
    rewrite plus_mult_distribute_left.
    reflexivity.
  Qed.

  Theorem plus_mult_distribute_rightl : forall x y z,
    isnatural x -> isnatural y -> isnatural z
    -> multl (append x y) z  = append (multl x z) (multl y z).
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

  Theorem mult_assoc : associative mult.
  Proof.
    red.
    intros xT yT zT.
    destruct xT as [x hx];
    destruct yT as [y hy];
    destruct zT as [z hz].
    simpl.
    apply proof_irrelevance.
    simpl.
    unfold isnatural in *.
    unfold allnil in *.
    generalize dependent z.
    generalize dependent y.
    induction x as [|headx tailx ihx].
    { intros y hy z hz. simpl. reflexivity. }
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
      rewrite <- ihx.
      clear ihx.
      rename tailx into x.
      rewrite plus_mult_distribute_rightl.
      { reflexivity. }
      { unfold isnatural. unfold allnil. exact hy. }
      { apply multl_natural.
        { unfold isnatural. unfold allnil. exact hmatchx. }
        { unfold isnatural. unfold allnil. exact hy. }
      }
      { unfold isnatural. unfold allnil. exact hz. }
    }
  Qed.

  Definition commutative_monoid (T:Type) (op:T->T->T) :=
    associative op /\ commutative op /\ (exists e, forall a, op e a = a /\ op a e = a).

  Theorem Natural_plus_commutative_monoid : commutative_monoid T plus /\ commutative_monoid T mult.
  Proof.
    split.
    {
      red.
      repeat split.
      { apply plus_assoc. }
      { apply plus_comm. }
      { exists zeroT.
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
      { exists oneT.
        intro a.
        split.
        { rewrite mult_one_l. reflexivity. }
        { rewrite mult_one_r. reflexivity. }
      }
  Qed.

  Fixpoint length {A:Type} (l : LO A) : T := match l with
  | nil => zeroT
  | cons _ tail => nextT (length tail)
  end.

  Definition Pair {A:Type} := { l : LO A | length(l) = twoT }.
  Definition PairOf (A:Type) := Pair (A:=A).

  Definition first {A:Type} (p : PairOf A) : A.
  Proof.
  destruct p as [l h].
  destruct l as [|first rest].
  { simpl in h. inversion h. }
  { exact first. }
  Defined.

  Definition second {A:Type} (p:PairOf A) : A.
  Proof.
  destruct p as [l h].
  destruct l as [|first rest].
  { simpl in h. inversion h. }
  {
    destruct rest as [|second rest].
    { simpl in h. inversion h. }
    { exact second. }
  }
  Qed.

  Theorem pair_eq {A:Type} : forall (p q: PairOf A), first p = first q -> second p = second q -> p = q.
  Proof.
    intros pP qP hf hs.
    destruct pP as [p hp].
    destruct qP as [q hq].
    simpl in *.
    
      

  
 