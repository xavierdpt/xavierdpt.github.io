  (* Technical lemma two introduce equality *)
  Lemma eq_imp : forall {T:Type} (a b:T) (P:T->Prop), P a -> a = b -> P b.
  Proof.
    intros A a b P h heq.
    subst b. exact h.
  Qed.

  Declare Scope maths.
  Open Scope maths.

  (* This notation discard everything that is not really relevant when printing it on screen *)
  Notation "§E x" := (exist _ x _) (only printing, at level 60) : maths.

  (* The axiom of proof irrelevance is necessary to assume that two proofs of the same thing are "equal" *)
  (* Coq does not make this assumption *)
  Axiom proof_irrelevance : forall {A:Type} {P:A->Prop} (x y :sig P), proj1_sig x = proj1_sig y -> x = y.

  Lemma f_eq {A B:Type} : forall (f:A->B) (x y:A), x = y ->f x  = f y.
  Proof. intros f x y heq. subst y. reflexivity. Qed.

  Lemma feq_l {A B C:Type} : forall (f:A->B->C) n m k, n = m -> f k n = f k m.
  Proof.
    intro f.
    intros n m k.
    intro heq. subst m.
    reflexivity.
  Qed.

