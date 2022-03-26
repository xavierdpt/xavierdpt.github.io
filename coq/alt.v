



Inductive List {A:Type} : Type :=
| nil : List
| cons : A -> List -> List
.

Definition LO (A:Type) := List (A:=A).
Definition LOLO (A:Type) := List (A:=LO A).

Definition isnil {A:Type} (l:LO A) := l = nil.

Fixpoint allmatch {A:Type} (l:List) (P:A->Prop) := match l with
| nil => True
| cons x l' => P x /\ allmatch l' P
end.

Definition allnil {A:Type} (l:LOLO A) := allmatch l isnil.
Definition zero {A:Type} := nil (A:=LO A).
Definition next {A:Type} (l:LOLO A) := cons nil l.

Theorem unique_pred : forall {A:Type}, forall (l l' : LOLO A), next l = next l' -> l = l'.
Proof.
intros A l l'.
intro heq.
unfold next in heq.
inversion heq.
subst l'.
reflexivity.
Qed.

Definition natural {A:Type} (l:LOLO A) := allnil l.

Definition TypeForNat : Type.
Proof.
apply False.
Defined.
Opaque TypeForNat.

Module Natural.
Record Natural : Type := mkNatural {
  n : LOLO TypeForNat ;
  h : natural n ;
}.
Definition T := Natural.
Definition C := mkNatural.
End Natural.

Definition zero_Natural : Natural.T.
Proof.
  set (t:=zero (A:=TypeForNat)).
  assert (isnatural: natural t).
  { unfold natural. unfold t. unfold zero. unfold allnil. simpl. trivial. }
  apply (Natural.C t).
  exact isnatural.
Defined.

Lemma natural_next : forall (n:Natural.T),  natural(next (Natural.n n)).
Proof.
  intros [n hn].
  induction n as [|head tail ih].
  {
    simpl.
    unfold natural.
    unfold allnil.
    simpl.
    split.
    { unfold isnil. reflexivity. }
    { trivial. }
  }
  {
    simpl. simpl in ih.
    unfold natural.
    unfold next.
    unfold allnil.
    simpl.
    unfold natural in ih.
    unfold allnil in ih.
    unfold next in ih.
    simpl in ih.
    unfold natural in hn.
    unfold allnil in hn.
    simpl in hn.
    destruct hn as [hhead htail].
    specialize (ih htail).
    destruct ih as [hnil _].
    split.
    { exact hnil. }
    {
      split.
      { exact hhead. }
      { exact htail. }
    }
  }
Qed.

Definition next_Natural (n:Natural.T) := Natural.C
  (next (Natural.n n))
  (natural_next n).

Fixpoint plus (n m: LOLO TypeForNat) := match n, m with
| nil, m => m
| cons nhead ntail, m => plus ntail (next m)
end.

Lemma plus_natural : forall n m, natural n -> natural m -> natural (plus n m).
Proof.
intro n.
induction n as [|head tail ih].
{
  intro m.
  intro h.
  unfold natural in h.
  unfold allnil in h.
  simpl in h.
  clear h.
  intro hm.
  simpl.
  exact hm.
}
{
  simpl.
  intro m.
  intro h.
  intro hm.
  unfold natural in h.
  unfold allnil in h.
  simpl in h.
  destruct h as [hhead htail].
  apply ih.
  unfold natural. unfold allnil. exact htail.
  unfold natural.
  unfold allnil.
  simpl.
  split.
  { unfold isnil. reflexivity. }
  { unfold natural in hm. unfold allnil in hm. exact hm. }
}
Qed.

Definition Plus (N M:Natural.T) : Natural.T := match N, M with
| Natural.mkNatural n hn, Natural.mkNatural m hm => Natural.C (plus n m) (plus_natural n m hn hm)
end.

Definition commutative {A:Type} (f:A->A->A) := forall x y, f x y = f y x.

Axiom proof_irrelevance : forall {P : Prop} (p1 p2 : P), p1 = p2.

Theorem Plus_comm : commutative Plus.
Proof.
unfold commutative.
intro x.
destruct x as [x hx].
simpl.
destruct y as [y hy].
simpl.
induction x as [|xhead xtail xih].
{
  simpl.
  induction y as [|yhead ytail yih].
  {
    simpl.
    assert (pi:=proof_irrelevance hx hy).
    subst hy.
    reflexivity.
  }
  {
    simpl.
    simpl in yih.



