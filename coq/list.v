Require Setoid.
Require Import PeanoNat Le Gt Minus Bool Lt.

Set Implicit Arguments.

Open Scope list_scope.

Module ListNotations.
Notation "[ ]" := nil (format "[ ]") : list_scope.
Notation "[ x ]" := (cons x nil) : list_scope.
Notation "[ x ; y ; .. ; z ]" :=  (cons x (cons y .. (cons z nil) ..)) : list_scope.
End ListNotations.

Import ListNotations.

Section Lists.

  Variable A : Type.

  Definition hd (default:A) (l:list A) :=
    match l with
      | [] => default
      | x :: _ => x
    end.

  Definition hd_error (l:list A) :=
    match l with
      | [] => None
      | x :: _ => Some x
    end.

  Definition tl (l:list A) :=
    match l with
      | [] => nil
      | a :: m => m
    end.

  Fixpoint In (a:A) (l:list A) : Prop :=
    match l with
      | [] => False
      | b :: m => b = a \/ In a m
    end.

End Lists.

Section Facts.

  Variable A : Type.

  Theorem nil_cons : forall (x:A) (l:list A), [] <> x :: l.
  Proof.
    intros x l.
    unfold not.
    intro heq.
    inversion heq.
  Qed.

  Theorem destruct_list : forall l : list A, {x:A & {tl:list A | l = x::tl}}+{l = []}.
  Proof.
    intro l.
    induction l as [|a tail _].
    {
      apply inright.
      reflexivity.
    }
    {
      apply inleft.
      apply existT with a.
      apply exist with tail.
      reflexivity.
    }
  Qed.

  Lemma hd_error_tl_repr : forall l (a:A) r,
    hd_error l = Some a /\ tl l = r <-> l = a :: r.
  Proof.
    intro l.
    destruct l as [|x xs].
    {
      intros a r.
      simpl.
      unfold iff.
      apply conj.
      {
        intros [impossible _].
        inversion impossible.
      }
      {
        intro impossible.
        inversion impossible.
      }
    }
    {
      intros a r.
      simpl.
      split.
      {
        intros [heq_some heq].
        subst xs.
        inversion heq_some as [heq];clear heq_some.
        reflexivity.
      }
      {
        intro heq.
        inversion heq.
        subst x. subst xs.
        split;reflexivity.
    }
  }
  Qed.

  Lemma hd_error_some_nil : forall l (a:A), hd_error l = Some a -> l <> nil.
  Proof.
    intros l a.
    unfold hd_error.
    destruct l as [|u v].
    {
      intro imp;inversion imp.
    }
    {
      intro h;inversion h;clear h.
      subst u.
      unfold not. intro imp. inversion imp.
    }
  Qed.

  Theorem length_zero_iff_nil (l : list A):
    length l = 0 <-> l=[].
  Proof.
    split.
    {
      destruct l.
      {
        simpl.
        intros _.
        reflexivity.
      }
      {
        simpl.
        intro imp.
        inversion imp.
      }
    }
    {
      intro heq. subst l. simpl. reflexivity.
    }
  Qed.

  Theorem hd_error_nil : hd_error (@nil A) = None.
  Proof.
    simpl. reflexivity.
  Qed.

  Theorem hd_error_cons : forall (l : list A) (x : A), hd_error (x::l) = Some x.
  Proof.
    intros l x.
    simpl. reflexivity.
  Qed.

  Theorem in_eq : forall (a:A) (l:list A), In a (a :: l).
  Proof.
    intros a l.
    simpl. left. reflexivity.
  Qed.

  Theorem in_cons : forall (a b:A) (l:list A), In b l -> In b (a :: l).
  Proof.
    intros a b l.
    intro h.
    simpl. right. exact h.
  Qed.

  Theorem not_in_cons (x a : A) (l : list A):
    ~ In x (a::l) <-> x<>a /\ ~ In x l.
  Proof.
    split.
    {
      unfold not.
      intro h.
      split.
      {
        intro heq. subst x. apply h. apply in_eq.
      }
      {
        intro hin.
        apply h.
        simpl.
        right.
        exact hin.
      }
    }
    {
      unfold not.
      intros [hl hr].
      intro h.
      simpl in h.
      destruct h as [heq|hin].
      {
        subst x.
        apply hl.
        reflexivity.
      }
      {
        apply hr. exact hin.
      }
    }
  Qed.

  Theorem in_nil : forall a:A, ~ In a [].
  Proof.
    intro a.
    unfold not.
    simpl.
    intro h;assumption.
  Qed.

  Theorem in_split : forall x (l:list A), In x l -> exists l1 l2, l = l1++x::l2.
  Proof.
    intros x l.
    induction l as [|a tl].
    {
      simpl. intro f. inversion f.
    }
    {
      intro hin.
      simpl in hin.
      destruct hin as [hl|hr].
      {
        subst x.
        exists [].
        exists tl.
        simpl.
        reflexivity.
      }
      {
        specialize (IHtl hr).
        destruct IHtl as [u [ v h] ].
        subst tl.
        exists (a::u).
        exists v.
        reflexivity.
      }
    }
  Qed.

  Lemma in_inv : forall (a b:A) (l:list A), In b (a :: l) -> a = b \/ In b l.
  Proof.
    intros a b l.
    intro h.
    simpl in h.
    exact h.
  Qed.

  Theorem in_dec :
    (forall x y:A, {x = y} + {x <> y}) ->
    forall (a:A) (l:list A), {In a l} + {~ In a l}.
  Proof.
    intro h.
    intros a l.
    generalize dependent a.
    induction l.
    {
      simpl.
      intros _.
      right. intro f. exact f.
    }
    {
      intros b.
      specialize (IHl b).
      destruct IHl.
      {
        simpl.
        left. right. exact i.
      }
      {
        simpl.
        destruct (h a b).
        {
          subst b. left. left. reflexivity.
        }
        {
          right. intros [heq|hin].
          {
            subst b. apply n0. reflexivity.
          }
          {
            apply n. exact hin.
          }
        }
      }
    }
  Defined.


  Theorem app_cons_not_nil : forall (x y:list A) (a:A), [] <> x ++ a :: y.
  Proof.
    intros x y a.
    intro imp.
    destruct x.
    {
      simpl in imp. inversion imp.
    }
    {
      simpl in imp.
      inversion imp.
    }
  Qed.


  Theorem app_nil_l : forall l:list A, [] ++ l = l.
  Proof.
    intro l. simpl. reflexivity.
  Qed.

  Theorem app_nil_r : forall l:list A, l ++ [] = l.
  Proof.
    intro l.
    induction l.
    { simpl. reflexivity. }
    { simpl. rewrite IHl. reflexivity. }
  Qed.

  Theorem app_nil_end : forall (l:list A), l = l ++ [].
  Proof.
    intro l. symmetry. apply app_nil_r.
  Qed.

  Theorem app_assoc : forall l m n:list A, l ++ m ++ n = (l ++ m) ++ n.
  Proof.
    intros l m n.
    induction l.
    { simpl. reflexivity. }
    { simpl. rewrite IHl. reflexivity. }
  Qed.

  Theorem app_assoc_reverse : forall l m n:list A, (l ++ m) ++ n = l ++ m ++ n.
  Proof.
    intros l m n. symmetry. apply app_assoc.
  Qed.
  Hint Resolve app_assoc_reverse : core.

  Theorem app_comm_cons : forall (x y:list A) (a:A), a :: (x ++ y) = (a :: x) ++ y.
  Proof.
    intros x y a.
    simpl. reflexivity.
  Qed.

  Theorem app_eq_nil : forall l l':list A, l ++ l' = [] -> l = [] /\ l' = [].
  Proof.
    intros la lb.
    intro heq.
    destruct la.
    {
      simpl in heq.
      split. reflexivity. exact heq.
    }
    {
      simpl in heq. inversion heq.
    }
  Qed.

  Theorem app_eq_unit :
    forall (x y:list A) (a:A),
      x ++ y = [a] -> x = [] /\ y = [a] \/ x = [a] /\ y = [].
  Proof.
    intros x y a.
    intro h.
    destruct y as [|yhead ytail].
    {
      rewrite <- app_nil_end in h.
      right. split. exact h. reflexivity.
    }
    {
      destruct x as [|xhead xtail].
      {
        simpl in h. left. split. reflexivity. exact h.
      }
      {
        inversion h. subst xhead.
        apply app_eq_nil in H1.
        destruct H1.
        subst xtail.
        inversion H0.
      }
    }
  Qed.

  Lemma app_inj_tail :
    forall (x y:list A) (a b:A), x ++ [a] = y ++ [b] -> x = y /\ a = b.
  Proof.
    intros x.
    induction x as [|xhead xtail].
    { (* case x is nil *)
      intro y.
      simpl.
      intros a b heq.
      destruct y as [|yhead htail].
      { (* case y is nil *)
        simpl in heq.
        (* extract a=b from heq *)
        inversion_clear heq.
        split;reflexivity.
      }
      { (* x nil and y as at least one element => y has to many elements, and inversion will detect it *)
        simpl in heq.
        inversion heq.
        symmetry in H1.
        apply app_eq_nil in H1.
        destruct H1.
        inversion H1.
      }
    }
    { (* x not nil with induction hypothesis *)
      intros y a b.
      intro heq.
      destruct y as [|yhead ytail].
      { (* y nil => x has too many elements *)
        simpl in heq.
        inversion heq.
        apply app_eq_nil in H1.
        destruct H1.
        inversion H1.
      }
      { (* y not nil *)
        (* give the tail of y to the induction hypothesis to match the tail of x *)
        specialize (IHxtail ytail a b).
        simpl in heq.
        (* match head and tail in heq *)
        inversion heq;clear heq.
        subst yhead.
        (* use the result of that matching in the induction hypothesis *)
        specialize (IHxtail H1).
        (* and we're done *)
        destruct IHxtail.
        subst b. subst ytail.
        split;reflexivity.
      }
    }
  Qed.

  Lemma app_length : forall l l' : list A, length (l++l') = length l + length l'.
  Proof.
    intro x.
    induction x as [|xhead xtail].
    {
      intro y.
      simpl. reflexivity.
    }
    {
      intro y.
      simpl.
      specialize (IHxtail y).
      rewrite IHxtail.
      reflexivity.
    }
  Qed.

  Lemma in_app_or : forall (l m:list A) (a:A), In a (l ++ m) -> In a l \/ In a m.
  Proof.
    intros x.
    induction x as [|xhead xtail].
    {
      intros y a.
      simpl.
      intro h. right. exact h.
    }
    {
      intros y a h.
      simpl in h.
      simpl.
      specialize (IHxtail y a).
      destruct h as [heq|hin].
      {
        subst xhead. left. left. reflexivity.
      }
      {
        specialize (IHxtail hin).
        destruct IHxtail as [hl|hr].
        { left. right. exact hl. }
        { right. exact hr. }
      }
    }
  Qed.

  Lemma in_or_app : forall (l m:list A) (a:A), In a l \/ In a m -> In a (l ++ m).
  Proof.
    intro x.
    induction x as [|xhead xtail].
    {
      simpl.
      intros y a h.
      destruct h as [i|h].
      { inversion i. }
      { exact h. }
    }
    {
      intros y a.
      simpl.
      intro h.
      destruct h as [hl|hr].
      {
        destruct hl as [heq|hin].
        {
          subst xhead. left. reflexivity.
        }
        {
          specialize (IHxtail y a).
          right.
          apply IHxtail.
          left.
          exact hin.
        }
      }
      {
        specialize (IHxtail y a).
        right.
        apply IHxtail.
        right.
        exact hr.
      }
    }
  Qed.

  Lemma in_app_iff : forall l l' (a:A), In a (l++l') <-> In a l \/ In a l'.
  Proof.
    intros x y a.
    split.
    {
      intro hin.
      apply in_app_or. exact hin.
    }
    {
      intro h.
      apply in_or_app.
      exact h.
    }
  Qed.

  Lemma app_inv_head:
   forall l l1 l2 : list A, l ++ l1 = l ++ l2 -> l1 = l2.
  Proof.
    intro x.
    induction x as [|xhead xtail].
    {
      simpl. intros y z heq. exact heq.
    }
    {
      intros y z heq.
      apply IHxtail.
      simpl in heq.
      inversion heq.
      reflexivity.
    }
  Qed.

  Lemma app_inv_tail:
    forall l l1 l2 : list A, l1 ++ l = l2 ++ l -> l1 = l2.
  Proof.
    intro l. induction l as [|head tail].
    {
      intros x y.
      repeat rewrite app_nil_r.
      intro;assumption.
    }
    {
      intros x y h.
      specialize (IHtail (x++[head])).
      specialize (IHtail (y++[head])).
      repeat rewrite <- app_assoc in IHtail.
      simpl in IHtail.
      specialize (IHtail h).
      apply app_inj_tail in IHtail.
      destruct IHtail as [heq _].
      exact heq.
    }
  Qed.

End Facts.

Hint Resolve app_assoc app_assoc_reverse: datatypes.
Hint Resolve app_comm_cons app_cons_not_nil: datatypes.
Hint Immediate app_eq_nil: datatypes.
Hint Resolve app_eq_unit app_inj_tail: datatypes.
Hint Resolve in_eq in_cons in_inv in_nil in_app_or in_or_app: datatypes.


Section Elts.

  Variable A : Type.

  Fixpoint nth (n:nat) (l:list A) (default:A) {struct l} : A :=
    match n, l with
      | O, x :: l' => x
      | O, other => default
      | S m, [] => default
      | S m, x :: t => nth m t default
    end.

  Fixpoint nth_ok (n:nat) (l:list A) (default:A) {struct l} : bool :=
    match n, l with
      | O, x :: l' => true
      | O, other => false
      | S m, [] => false
      | S m, x :: t => nth_ok m t default
    end.

  Lemma nth_in_or_default :
    forall (n:nat) (l:list A) (d:A), {In (nth n l d) l} + {nth n l d = d}.
  Proof.
    intros n l d.
    generalize dependent d.
    generalize dependent n.
    induction l as [|head tail].
    {
      simpl.
      intro n.
      destruct n as [|Pn].
      {
        intro d. right. reflexivity.
      }
      {
        intro d. right. reflexivity.
      }
    }
    {
      simpl.
      intro n.
      destruct n as [|Pn].
      {
        intro d.
        specialize (IHtail O d).
        left. left. reflexivity.
      }
      {
        intro d.
        specialize (IHtail Pn d).
        destruct IHtail.
        {
          left. right. exact i.
        }
        {
          rewrite e. right. reflexivity.
        }
      }
    }
  Qed.

  Lemma nth_S_cons :
    forall (n:nat) (l:list A) (d a:A),
      In (nth n l d) l -> In (nth (S n) (a :: l) d) (a :: l).
  Proof.
    intros n l d.
    simpl.
    intros a h.
    right. assumption.
  Qed.

  Fixpoint nth_error (l:list A) (n:nat) {struct n} : option A :=
    match n, l with
      | O, x :: _ => Some x
      | S n, _ :: l => nth_error l n
      | _, _ => None
    end.

  Definition nth_default (default:A) (l:list A) (n:nat) : A :=
    match nth_error l n with
      | Some x => x
      | None => default
    end.

  Lemma nth_default_eq :
    forall n l (d:A), nth_default d l n = nth n l d.
  Proof.
    induction n as [|n hin].
    {
      intros l d.
      destruct l as [|head tail].
      {
        simpl. unfold nth_default. simpl. reflexivity.
      }
      {
        simpl. unfold nth_default. simpl. reflexivity.
      }
    }
    {
      intros l d.
      destruct l as [|head tail].
      {
        simpl. unfold nth_default. simpl. reflexivity.
      }
      {
        simpl.
        specialize (hin tail d).
        unfold nth_default. simpl.
        unfold nth_default in hin.
        exact hin. 
      }
    }
  Qed.

  Lemma nth_In :
    forall (n:nat) (l:list A) (d:A), n < length l -> In (nth n l d) l.
  Proof.
    intro n.
    induction n as [|n hin].
    {
      destruct l as [|head tail].
      {
        simpl.
        intros _ hi.
        unfold lt in hi.
        inversion hi.
      }
      {
        simpl.
        intros _ _.
        left.
        reflexivity.
      }
    }
    {
      destruct l as [|head tail].
      {
        simpl.
        unfold lt.
        intros _ hi.
        inversion hi.
      }
      {
        simpl.
        intros d hlt.
        unfold lt in hlt.
        apply le_S_n in hlt.
        unfold lt in hin.
        specialize (hin tail d).
        specialize (hin hlt).
        right. exact hin.
      }
    }
  Qed.

  Lemma In_nth l x d : In x l ->
    exists n, n < length l /\ nth n l d = x.
  Proof.
    induction l as [|head tail hin].
    {
      simpl. intro f. inversion f.
    }
    {
      intro h.
      destruct h as [hl|hr].
      {
        subst head.
        exists O.
        simpl.
        split.
        apply Nat.lt_0_succ.
        reflexivity.
      }
      {
        specialize (hin hr).
        inversion hin as [n h].
        destruct h as [hlt heq].
        exists (S n).
        simpl.
        split.
        {
          apply lt_n_S.
          exact hlt.
        }
        {
          exact heq.
        }
      }
    }
  Qed.

  Lemma nth_overflow : forall l n d, length l <= n -> nth n l d = d.
  Proof.
    intro l.
    induction l as [|head tail hin].
    {
      intro n.
      destruct n as [|n].
      {
        intro d.
        simpl.
        intros _.
        reflexivity.
      }
      {
        intro d.
        simpl.
        intros _.
        reflexivity.
      }
    }
    {
      intro n.
      destruct n as [|n].
      {
        simpl.
        intro d.
        intro h.
        inversion h.
      }
      {
        simpl.
        intros d h.
        apply hin.
        apply le_S_n.
        exact h.
      }
    }
  Qed.

  Lemma nth_indep :
    forall l n d d', n < length l -> nth n l d = nth n l d'.
  Proof.
intros l.
induction l as [|head tail hin].
{
simpl.
intro n.
destruct n as [|n].
{
intros d d' hi.
unfold lt in hi.
inversion hi.
}
{
intros d d' hi.
inversion hi.
}
}
{
simpl.
destruct n as [|n].
{
intros _ _ _.
reflexivity.
}
{
intros d d' h.
apply hin.
apply lt_S_n.
exact h.
}
}
  Qed.

  Lemma app_nth1 :
    forall l l' d n, n < length l -> nth n (l++l') d = nth n l d.
  Proof.
    intro l.
    induction l as [|head tail hin].

    simpl.
    destruct n as [|n].

    intro hi. inversion hi.

    intro hi. inversion hi.

    simpl.
    destruct n as [|n].

    intros _. reflexivity.

    intro h.
    apply hin.
    apply lt_S_n.
    exact h.
  Qed.

  Lemma app_nth2 :
    forall l l' d n, n >= length l -> nth n (l++l') d = nth (n-length l) l' d.
  Proof.

intro l.
induction l as [|head tail hin].
{
simpl.
intros l d n _.
rewrite Nat.sub_0_r.
reflexivity.
}
{
simpl.
destruct n as [|n].
{
simpl.
unfold ge.
intro hi.
inversion hi.
}
{
unfold ge.
intro h.
simpl.
apply hin.
unfold ge.
apply le_S_n.
exact h.
}
}
  Qed.

  Lemma nth_split n l d : n < length l ->
    exists l1, exists l2, l = l1 ++ nth n l d :: l2 /\ length l1 = n.
  Proof.

generalize dependent l.
induction n as [|n hin].
{
destruct l as [|head tail].
{
simpl.
intro hi. inversion hi.
}
{
simpl.
intro hlt. unfold lt in hlt.
exists [].
simpl.
exists tail.
split;reflexivity.
}
}
{
destruct l as [|head tail].
{
simpl.
intro hi. inversion hi.
}
{
simpl.
intro h.
unfold lt in h.
apply le_S_n in h.
unfold lt in hin.
specialize (hin tail).
specialize (hin h).
inversion hin as [x [ y [hl hr]]].
exists (head::x).
simpl.
rewrite hr.
exists y.
rewrite <- hl.
split;reflexivity.
}
}
  Qed.



  Lemma nth_error_In l n x : nth_error l n = Some x -> In x l.
  Proof.
generalize dependent n.
induction l as [|head tail hin].
{
simpl.
destruct n as [|n].
{
simpl.
intro hi. inversion hi.
}
{
simpl.
intro hi.
inversion hi.
}
}
{
simpl.
destruct n as [|n].
{
simpl.
intro hs.
inversion_clear hs.
left. reflexivity.
}
{
simpl.
intro h.
right.
apply (hin n).
exact h.
}
}
  Qed.



  Lemma In_nth_error l x : In x l -> exists n, nth_error l n = Some x.
  Proof.
induction l as [|head tail hin].
{
simpl.
intro hi.
inversion hi.
}
{
intro h.
simpl in h.
destruct h as [hl|hr].
{
subst x.
exists 0.
simpl.
reflexivity.
}
{
specialize (hin hr).
destruct hin as [n he].
exists (S n).
simpl.
exact he.
}
}
  Qed.

  Lemma nth_error_None l n : nth_error l n = None <-> length l <= n.
  Proof.
split.
{
generalize dependent n.
induction l as [|head tail].
{
intro n.
simpl.
intros _.
apply Nat.le_0_l.
}
{
intro n.
simpl.
intro h.
destruct n as [|n].
{
simpl in h.
inversion h.
}
{
simpl in h.
specialize (IHtail n).
apply le_n_S.
apply IHtail.
exact h.
}
}
}
{
generalize dependent n.
induction l as [|head tail hin].
{
simpl.
intros n h.
destruct n as [|n].
{
simpl.
reflexivity.
}
{
simpl.
reflexivity.
}
}
{
intros n h.
destruct n as [|n].
{
simpl.
simpl in h.
inversion h.
}
{
simpl.
simpl in h.
apply hin.
apply le_S_n.
exact h.
}
}
}
  Qed.


  Lemma nth_error_Some l n : nth_error l n <> None <-> n < length l.
  Proof.


generalize dependent n.
induction l as [|head tail hin].
{
simpl.
destruct n as [|n].
{
simpl.
split.
{
intro hi. unfold not in hi.
exfalso. apply hi. reflexivity.
}
{
intro hi.
inversion hi.
}
}
{
simpl.
split.
{
intro hi. unfold not in hi. exfalso. apply hi. reflexivity.
}
{
intro hi. inversion hi.
}
}
}
{
simpl.
intro n.
destruct n as [|n].
{
simpl.
split.
{
intros _.
apply Nat.lt_0_succ.
}
{
intro h.
unfold not.
intro hi.
inversion hi.
}
}
{
simpl.
split.
{
intro hn.
unfold not in hn.
apply lt_n_S.
apply hin.
unfold not.
intro h.
apply hn.
exact h.
}
{
intro h.
intro heq.
specialize (hin n).
destruct hin as [hl hr].
unfold not in hr.
apply hr.
{
apply lt_S_n. exact h.
}
{
exact heq.
}
}
}
}
  Qed.



  Lemma nth_error_split l n a : nth_error l n = Some a ->
    exists l1, exists l2, l = l1 ++ a :: l2 /\ length l1 = n.
  Proof.

generalize dependent n.
induction l as [|head tail hin].
{
intro n.
destruct n as [|n].
{
simpl.
intro hi. inversion hi.
}
{
simpl.
intro hi. inversion hi.
}
}
{
intro n.
destruct n as [|n].
{
simpl.
intro h. inversion h. subst a.
exists [].
simpl.
exists tail.
split;reflexivity.
}
{
simpl.
intro h.
specialize (hin n).
specialize (hin h).
destruct hin as [x [y he]].
destruct he as [he hl].
exists (head::x).
simpl.
exists y.
split.
rewrite <- he.
reflexivity.
apply eq_S.
exact hl.
}
}
  Qed.



  Lemma nth_error_app1 l l' n : n < length l ->
    nth_error (l++l') n = nth_error l n.
  Proof.
generalize dependent n.
induction l as [|head tail hin].
{
simpl.
intros n hi.
inversion hi.
}
{
simpl.
intros n h.
destruct n as [|n].
{
simpl. reflexivity.
}
{
simpl.
apply hin.
apply lt_S_n.
exact h.
}
}
  Qed.



  Lemma nth_error_app2 l l' n : length l <= n ->
    nth_error (l++l') n = nth_error l' (n-length l).
  Proof.
generalize dependent n.
induction l as [|head tail];intro n;destruct n as [|n].
{
simpl.
destruct l' as [|head tail];simpl.
{ intros;reflexivity. }
{ intros;reflexivity. }
}
{
simpl.
destruct l' as [|head tail];simpl.
{ intros;reflexivity. }
{ intros;reflexivity. }
}
{
simpl.
destruct l' as [|head' tail'];simpl.
{
intro h. inversion h.
}
{
intro h.
inversion h.
}
}
{
simpl.
intro h.
apply IHtail.
apply le_S_n.
exact h.
}
  Qed.



  (** Results directly relating [nth] and [nth_error] *)

  Lemma nth_error_nth : forall (l : list A) (n : nat) (x d : A),
    nth_error l n = Some x -> nth n l d = x.
  Proof.
intro l.
induction l as [|head tail hin].
simpl.
destruct n as [|n].
simpl.
intros x d hi.
inversion hi.
simpl.
intros x d hi.
inversion hi.
simpl.
destruct n as [|n].
simpl.
intros x _ h.
inversion h.
subst x. reflexivity.
simpl.
intros x d h.
apply hin.
exact h.
  Qed.



  Lemma nth_error_nth' : forall (l : list A) (n : nat) (d : A),
    n < length l -> nth_error l n = Some (nth n l d).
  Proof.
intros l.
induction l as [|head tail hin].
simpl.
destruct n as [|n].
simpl.
intros d hi.
inversion hi.
simpl.
intros d hi.
inversion hi.
simpl.
destruct n as [|n].
simpl.
intros _ _.
reflexivity.
simpl.
intros d h.
apply hin.
apply lt_S_n.
exact h.
  Qed.



  Hypothesis eq_dec : forall x y : A, {x = y}+{x <> y}.

  Fixpoint remove (x : A) (l : list A) : list A :=
    match l with
      | [] => []
      | y::tl => if (eq_dec x y) then remove x tl else y::(remove x tl)
    end.

  Theorem remove_In : forall (l : list A) (x : A), ~ In x (remove x l).
  Proof.
intro l.
induction l as [|head tail hin].
simpl.
intros _. unfold not. intro f. inversion f.
simpl.
intro x.
destruct (eq_dec x head).
subst x. apply hin.
simpl.
unfold not. unfold not in n.
intro h.
destruct h as [hl|hr].
{
subst x.
apply n.
reflexivity.
}
{
unfold not in hin.
specialize (hin x).
apply hin.
exact hr.
}
  Qed.

  Fixpoint last (l:list A) (d:A) : A :=
  match l with
    | [] => d
    | [a] => a
    | a :: l => last l d
  end.


  Fixpoint removelast (l:list A) : list A :=
    match l with
      | [] =>  []
      | [a] => []
      | a :: l => a :: removelast l
    end.

(* That one was a bit harder *)
  Lemma app_removelast_last :
    forall l d, l <> [] -> l = removelast l ++ [last l d].
  Proof.
intros l d.
generalize dependent l.
induction l as [|head tail hin].
simpl. intro h;exfalso;apply h;reflexivity.
simpl.
simpl in hin.
destruct tail as [|th tt] eqn:heq in |-.
subst tail. simpl. reflexivity.
set (x:=last tail d).
set (y:=removelast tail).
fold y in hin.
fold x in hin.
rewrite heq in hin.
rewrite heq.
simpl.
intro h.
rewrite <- hin.
reflexivity.
unfold not.
intro heq'.
inversion heq'.
  Qed.


  Lemma exists_last :
    forall l, l <> [] -> { l' : (list A) & { a : A | l = l' ++ [a]}}.
  Proof.

induction l as [|head tail hin].
intro hi. exfalso. apply hi. reflexivity.

intro h.
destruct tail as [|th tt].
exists []. exists head. simpl. reflexivity.

destruct hin as [x [a he]].
unfold not. intro hi. inversion hi.

exists (head::x).
exists a.
simpl.
rewrite he.
reflexivity.
  Qed.

  Lemma removelast_app :
    forall l l', l' <> [] -> removelast (l++l') = l ++ removelast l'.
  Proof.
intro l.
induction l as [|head tail hin].
simpl. intros l' _. reflexivity.
intro l'.
destruct l' as [|h t] eqn:heq.
intro hi. exfalso. apply hi. reflexivity.
intro hneq.
rewrite <- heq in hneq.
specialize (hin l' hneq).
rewrite <- heq.
simpl.
rewrite <- hin.
destruct (tail++l') eqn:hi.
apply app_eq_nil in hi.
destruct hi.
exfalso. apply hneq. assumption.
reflexivity.
  Qed.


  Fixpoint count_occ (l : list A) (x : A) : nat :=
    match l with
      | [] => 0
      | y :: tl =>
        let n := count_occ tl x in
        if eq_dec y x then S n else n
    end.

  Theorem count_occ_In l x : In x l <-> count_occ l x > 0.
  Proof.
induction l as [|head tail hin].
{
simpl. split. intro f;inversion f. intro hi;inversion hi.
}
{
destruct hin as [hl hr].
split.
{
intro h.
simpl in h.
destruct h as [heq|hin].
{
subst x.
simpl.
destruct (eq_dec head head).
{ apply gt_Sn_O. }
{ exfalso. apply n. reflexivity. }
}
{
simpl.
destruct (eq_dec head x).
{
subst x.
apply gt_Sn_O.
}
{
apply hl. exact hin.
}
}
}
{
intro h.
simpl.
simpl in h.
destruct (eq_dec head x).
{
subst x.
left. reflexivity.
}
{
right. apply hr. exact h.
}
}
}
  Qed.

  Theorem count_occ_not_In l x : ~ In x l <-> count_occ l x = 0.
  Proof.
    assert (oc:=count_occ_In).
    specialize (oc l x).
    apply not_iff_compat in oc.
    destruct oc as [hl hr].
    split.
    {
      intro h.
      specialize (hl h).
      unfold gt in hl.
      unfold lt in hl.
      destruct (count_occ l x).
      { reflexivity. }
      { exfalso. apply hl. apply le_n_S. apply le_0_n. }
    }
    {
      intro heq.
      rewrite heq in hl.
      rewrite heq in hr.
      apply hr.
      intro hi.
      inversion hi.
    }
  Qed.



  Lemma count_occ_nil x : count_occ [] x = 0.
  Proof.
    simpl. reflexivity.
  Qed.



  Theorem count_occ_inv_nil l :
    (forall x:A, count_occ l x = 0) <-> l = [].
  Proof.
    split.
    {
      induction l as [|head tail hin].
      { intro h. reflexivity. }
      {
        intro h.
        simpl in h.
        specialize (h head).
        destruct (eq_dec head head).
        { inversion h. }
        { exfalso. apply n. reflexivity. }
      }
    }
    {
      intro h.
      intro x.
      subst l.
      simpl.
      reflexivity.
    }
  Qed.


  Lemma count_occ_cons_eq l x y :
    x = y -> count_occ (x::l) y = S (count_occ l y).
  Proof.
    intro heq.
    subst y.
    simpl.
    destruct (eq_dec x x).
    reflexivity.
    exfalso. apply n. reflexivity.
  Qed.


  Lemma count_occ_cons_neq l x y :
    x <> y -> count_occ (x::l) y = count_occ l y.
  Proof.
    intros hn.
    simpl.
    destruct (eq_dec x y).
    subst y. exfalso. apply hn. reflexivity.
    reflexivity.
  Qed.

End Elts.

Section ListOps.

  Variable A : Type.

  Fixpoint rev (l:list A) : list A :=
    match l with
      | [] => []
      | x :: l' => rev l' ++ [x]
    end.

  Lemma rev_app_distr : forall x y:list A, rev (x ++ y) = rev y ++ rev x.
  Proof.
    intro x.
    induction x as [|head tail hin].
    {
      intro y.
      simpl.
      rewrite <- app_nil_end.
      reflexivity.
    }
    {
      intro y.
      simpl.
      rewrite hin.
      rewrite app_assoc.
      reflexivity.
    }
  Qed.

  Remark rev_unit : forall (l:list A) (a:A), rev (l ++ [a]) = a :: rev l.
  Proof.
    intro l.
    intro a.
    rewrite rev_app_distr.
    simpl.
    reflexivity.
  Qed.

  Lemma rev_involutive : forall l:list A, rev (rev l) = l.
  Proof.
    intro l.
    induction l as [|head tail hin].
    { simpl. reflexivity. }
    { simpl. rewrite rev_app_distr. rewrite hin. simpl. reflexivity. }
  Qed.

  Lemma in_rev : forall l x, In x l <-> In x (rev l).
  Proof.
    intro l.
    induction l as [|head tail hin].
    {
      simpl. intros _. split;intro;assumption.
    }
    {
      intro x.
      split.
      {
        simpl.
        intro h.
        destruct h as [hl | hr].
        {
          subst x.
          apply in_app_iff.
          right.
          simpl.
          left.
          reflexivity.
        }
        {
          apply in_app_iff.
          left.
          apply hin.
          exact hr.
        }
      }
      {
        intro h.
        simpl.
        simpl in h.
        apply in_app_iff in h.
        destruct h as [hl|hr].
        right. apply hin. exact hl.
        simpl in hr. destruct hr as [hl|hr].
        subst x. left. reflexivity.
        inversion hr.
      }
    }
  Qed.

  Lemma rev_length : forall l, length (rev l) = length l.
  Proof.
    intro l.
    induction l as [|head tail ih].
    {
      simpl.
      reflexivity.
    }
    {
      simpl.
      rewrite app_length.
      simpl.
      rewrite Nat.add_comm.
      simpl.
      rewrite ih.
      reflexivity.
    }
  Qed.


  Lemma rev_nth : forall l d n,  n < length l ->
    nth n (rev l) d = nth (length l - S n) l d.
  Proof.
    intros l d.
    induction l as [|head tail hinl].
    {
      (* empty list *)
      simpl. intros n.
      (* handle 0 and S _ separately *)
      destruct n as [|n].
      {
        (* 0 *)
        intros _ . reflexivity.
      }
      {
        (* S _ *)
        intros _.
        reflexivity.
      }
    }
    {
      (* non empty list *)
      destruct n as [|n].
      {
        (* n = 0 *)
        simpl.
        rewrite <- minus_n_O.
        intro h.
        unfold lt in h.
        apply le_S_n in h.
        destruct (length tail) as [|ltail] eqn:eqtail.
        {
          (* length tail = 0 *)
          (* the tail is empty *)
          apply length_zero_iff_nil in eqtail.
          subst tail.
          simpl.
          (* so there's only the head *)
          reflexivity.
        }
        {
          (* length tail > 0 *)
          unfold lt in hinl.
          rewrite <- eqtail in h.
          rewrite <- eqtail in hinl.
          (* since the tail is not empty, it must have a head (th) and a tail (tt) *)
          (* we use destruct to extract them it *)
          destruct tail as [|th tt] eqn:taileq.
          { (* empty tail => not possible, because we already know it is not empty *)
            simpl in eqtail.
            (* here is our contradiction for that case *)
            inversion eqtail.
          }
          {
            (* here we are with a non empty tail *)
            (* let's fold the tail for now *)
            rewrite <- taileq in *.
            (* since the tail is not empty and we are looking at the first element, we can discard (++ [head]) *)
            rewrite app_nth1.
            (* but we will have to prove that (rev tail) is not empty to do that, let's do it now *)
            2:{
              rewrite rev_length.
              rewrite taileq.
              simpl.
              unfold lt.
              apply le_n_S.
              apply le_0_n.
            }
            {
              (* we're going to use the induction hypothesis on 0 *)
              specialize (hinl 0).
              (* for the induction hypothesis *)
              assert (eqlen:1<=length tail).
              {
                rewrite taileq.
                simpl.
                apply le_n_S.
                apply le_0_n.
              }
              specialize (hinl eqlen).
              (* now we can use the induction hypothesis to rewrite the left hand side *)
              rewrite hinl.
              clear hinl.
              (* here we doing another assert because arithmetic on naturals can be tricky *)
              assert(eqltail:length tail - 1 = ltail).
              {
                rewrite taileq.
                simpl.
                rewrite <- minus_n_O.
                rewrite taileq in eqtail.
                simpl in eqtail.
                apply eq_add_S in eqtail.
                exact eqtail.
              }
              (* now we're good *)
              rewrite eqltail.
              reflexivity.
            }
          }
        }
      }
      {
        (* n = S n *)
        (* since we destructed n on the left, we reused 'n' for the one on the right *)
        intro h.
        simpl.
        (* again, we explore both possibility for the match *)
        destruct(length tail - S n) as [|otherside] eqn:heqlen.
        {
          (* 0 => head *)
          simpl in h.
          apply lt_S_n in h.
          apply Nat.sub_0_le in heqlen.
          unfold lt in h.
          (* we can deduce that length tail = S n in this case *)
          assert (heq:=Nat.le_antisymm).
          specialize (heq (S n) (length tail)).
          specialize (heq h).
          specialize (heq heqlen).
          (* for the induction hypothesis *)
          assert (h':n<length tail).
          {
            rewrite <- heq.
            apply lt_n_Sn.
          }
          specialize (hinl n).
          specialize (hinl h').
          (* again, we will split the tail *)
          destruct tail as [|th tt] eqn:heqtail.
          {
            (* the tail cannot be empty, because it's length is positive *)
            simpl in h'.
            inversion h'.
          }
          {
            (* so it has at least one element *)
            rewrite <- heqtail in *.
            (* since we're looking past the tail, we can discard (rev tail) *)
            rewrite app_nth2.
            2:{
              rewrite rev_length.
              rewrite heq.
              unfold ge.
              apply le_n.
            }
            {
              (* and we end up on the first element of what's remaining *)
              rewrite rev_length.
              rewrite <- heq.
              rewrite Nat.sub_diag.
              simpl.
              reflexivity.
            }
          }
        }
        {
          (* other possibility *)
          (* let's destruct the tail again *)
          destruct tail as [|th tt] eqn:heqtail.
          {
            (* empty tail => not possible here *)
            simpl in h.
            unfold lt in h.
            apply le_S_n in h.
            inversion h.
          }
          {
            (* so the tail is not empty *)
            rewrite <- heqtail in *.
            rename otherside into m.
            unfold lt in hinl.
            simpl in h.
            assert (m=(length tail - S n - 1)).
            {
              apply eq_add_S.
              rewrite heqlen.
              simpl.
              rewrite <- minus_n_O.
              reflexivity.
            }
            unfold lt in h.
            apply le_S_n in h.
            (* we will handle S n = length tail separately *)
            apply le_lt_or_eq in h.
            destruct h as [h|h].
            {
              (* inequality *)
              rewrite app_nth1.
              2:{ rewrite rev_length. exact h. }
              rewrite hinl.
              2:{ unfold lt in h. exact h. }
              subst m.
              repeat rewrite Nat.sub_succ_r.
              rewrite <- minus_n_O.
              reflexivity.
          }
          {
            (* equality is actually not possible *)
            subst tail.
            simpl in h.
            apply eq_add_S in h.
            subst n.
            rewrite minus_diag in heqlen.
            inversion heqlen.
          }
        }
      }
    }
  }
  Qed.




  (**  An alternative tail-recursive definition for reverse *)

  Fixpoint rev_append (l l': list A) : list A :=
    match l with
      | [] => l'
      | a::l => rev_append l (a::l')
    end.

  Definition rev' l : list A := rev_append l [].

  Lemma rev_append_rev : forall l l', rev_append l l' = rev l ++ l'.
  Proof.
    intro l.
    induction l as [|head tail ih].
    {
      intro l'.
      simpl.
      reflexivity.
    }
    {
      intro l'.
      simpl.
      rewrite <- app_assoc.
      simpl.
      specialize (ih (head::l')).
      rewrite ih.
      reflexivity.
    }
  Qed.

  Lemma rev_alt : forall l, rev l = rev_append l [].
  Proof.
    intro l.
    rewrite rev_append_rev.
    rewrite app_nil_r.
    reflexivity.
  Qed.

  Section Reverse_Induction.

    Lemma rev_list_ind :
      forall P:list A-> Prop,
	P [] ->
	(forall (a:A) (l:list A), P (rev l) -> P (rev (a :: l))) ->
	forall l:list A, P (rev l).
    Proof.
      intro P.
      intro pnil.
      intro pih.
      intro l.
      induction l as [|head tail ih].
      {
        simpl.
        exact pnil.
      }
      {
        apply pih.
        exact ih.
      }
    Qed.

(*
  Instead of using that complicated "reverse induction" principle,
  I simply change l into rev l, and then I can use the usual induction ;)
*)
    Theorem rev_ind :
      forall P:list A -> Prop,
	P [] ->
	(forall (x:A) (l:list A), P l -> P (l ++ [x])) -> forall l:list A, P l.
    Proof.
      intro P.
      intro pnil.
      intro pih.
      intro l.
      assert (exists l', l = rev l').
      {
        exists (rev l).
        rewrite rev_involutive.
        reflexivity.
      }
      destruct H as[l' heq].
      subst l.
      rename l' into l.
      induction l as [|head tail ih].
      {
        simpl.
        exact pnil.
      }
      {
        simpl.
        apply pih.
        exact ih.
      }
    Qed.

  End Reverse_Induction.

  (*************************)
  (** ** Concatenation     *)
  (*************************)

  Fixpoint concat (l : list (list A)) : list A :=
  match l with
  | nil => nil
  | cons x l => x ++ concat l
  end.

  Lemma concat_nil : concat nil = nil.
  Proof.
    simpl.
    reflexivity.
  Qed.

  Lemma concat_cons : forall x l, concat (cons x l) = x ++ concat l.
  Proof.
    intros x l.
    simpl.
    reflexivity.
  Qed.

  Lemma concat_app : forall l1 l2, concat (l1 ++ l2) = concat l1 ++ concat l2.
  Proof.
    intros x.
    induction x as [|head tail ih].
    { intro y. simpl. reflexivity. }
    { intro y. simpl. specialize (ih y). rewrite ih. rewrite app_assoc. reflexivity. }
  Qed.

  (***********************************)
  (** ** Decidable equality on lists *)
  (***********************************)

  Hypothesis eq_dec : forall (x y : A), {x = y}+{x <> y}.

  Lemma list_eq_dec : forall l l':list A, {l = l'} + {l <> l'}.
  Proof.
    intros xl.
    induction xl as [|head tail ih].
    {
      intro yl.
      destruct yl as [|yhead ytail].
      { left. reflexivity. }
      { right. intro i. inversion i. }
    }
    {
      intro yl.
      destruct yl as [|yhead ytail].
      { right. intro i. inversion i. }
      {
        destruct (eq_dec head yhead) as [hl|hr].
        {
          specialize (ih ytail).
          {
            destruct ih as [ihl|ihr].
            { subst yhead. subst ytail. left. reflexivity. }
            {
              subst yhead. right. intro i. apply ihr.
              apply (app_inv_head [head]).
              simpl.
              exact i.
}
}
}
{
specialize (ih ytail).
destruct (eq_dec head yhead) as [uu|vv].
{
subst yhead.
exfalso.
apply hr.
reflexivity.
}
{
destruct ih as [xx|yy].
{
subst ytail.
right.
intro eq.
apply hr.

assert([head]=[yhead]->head=yhead).
{
intro h.
inversion h.
subst yhead.
reflexivity.
}
apply H.
apply (app_inv_tail tail).
simpl.
exact eq.
}
{
right.
intro heq.
inversion heq.
subst ytail. subst yhead.
apply vv.
reflexivity.
}
}
}
}
}
Defined.

End ListOps.

(***************************************************)
(** * Applying functions to the elements of a list *)
(***************************************************)

(************)
(** ** Map  *)
(************)

Section Map.
  Variables (A : Type) (B : Type).
  Variable f : A -> B.

  Fixpoint map (l:list A) : list B :=
    match l with
      | [] => []
      | a :: t => (f a) :: (map t)
    end.

  Lemma map_cons (x:A)(l:list A) : map (x::l) = (f x) :: (map l).
  Proof.
    simpl.
    reflexivity.
  Qed.

  Lemma in_map :
    forall (l:list A) (x:A), In x l -> In (f x) (map l).
  Proof.
    intro l.
    induction l as [|head tail ih].
    { intros x h. simpl. simpl in h. exact h. }
    {
      intros x h.
      simpl in h.
      destruct h as [hl|hr].
      { subst x. simpl. left. reflexivity. }
      { simpl. right. apply ih. exact hr. }
  }
  Qed.

  Lemma in_map_iff : forall l y, In y (map l) <-> exists x, f x = y /\ In x l.
  Proof.
    intros l y.
    split.
    {
      generalize dependent y.
      generalize dependent l.
      induction l as [|head tail ih].
{
intros y h.
simpl in h.
inversion h.
}
{
intros y h.
simpl in h.
inversion_clear h as [hl|hr].
{
subst y.
exists head.
split.
{ reflexivity. }
{ simpl. left. reflexivity. }
}
{
specialize (ih y).
specialize (ih hr).
destruct ih as [x he].
destruct he as [heq hin].
subst y.
exists x.
split.
{ reflexivity. }
{ simpl. right. exact hin. }
}
}
}
{
generalize dependent y.
induction l as [|head tail ih].
{ intro y. intro he. simpl. destruct he as [x he]. destruct he as [heq hin]. simpl in hin. exact hin. }
{ intro y. intro h. destruct h as [x he]. destruct he as [heq hin]. subst y. simpl. simpl in hin. destruct hin as [hl|hr].
{ subst x. left. reflexivity. }
{ specialize (ih (f x)). right. apply ih. exists x. split. reflexivity. exact hr. }
}}
  Qed.

  Lemma map_length : forall l, length (map l) = length l.
  Proof.
    intro l.
    induction l as [|head tail ih].
    { simpl. reflexivity. }
    { simpl. apply eq_S. exact ih. }
  Qed.




  Lemma map_nth : forall l d n,
    nth n (map l) (f d) = f (nth n l d).
  Proof.
intro l.
induction l as [|head tail ih].
{
intros d n.
destruct n as [|n].
{ simpl. reflexivity. }
{ simpl. reflexivity. }
}
{
intros d n.
destruct n as [|n].
{ simpl. reflexivity. }
{ simpl. specialize (ih d). rewrite ih. reflexivity. }
}
  Qed.




  Lemma map_nth_error : forall n l d,
    nth_error l n = Some d -> nth_error (map l) n = Some (f d).
  Proof.
intros n l d.
generalize dependent n.
induction l as [|head tail ih].
{
intro n.
destruct n as [|n].
{ simpl. intro i. inversion i. }
{ simpl. intro i. inversion i. }
}
{
intro n.
destruct n as [|n].
{ simpl. intro h. inversion h. subst d. reflexivity. }
{ simpl. intro h. specialize (ih n). specialize (ih h). rewrite ih. reflexivity. }
}
  Qed.

  Lemma map_app : forall l l',
    map (l++l') = (map l)++(map l').
  Proof.
intro l.
induction l as [|head tail ih].
{ intro l'. simpl. reflexivity. }
{ intro l'. simpl. rewrite ih. reflexivity. }
  Qed.

  Lemma map_rev : forall l, map (rev l) = rev (map l).
  Proof.
    intro l.
    induction l as [|head tail ih].
    { simpl. reflexivity. }
    { simpl. rewrite map_app. simpl. rewrite ih. reflexivity. }
  Qed.

  Definition involutive {A:Type} (f:A->A) := forall x, f (f x) = x.
  Definition idempotent {A:Type} (f:A->A) := forall x, f (f x) = f x.
  Definition identity {A:Type} (f:A->A) := forall x, f x = x.

Theorem involutive_idempotent_identity:
  forall (A:Type) (f:A->A),
  (involutive f /\ idempotent f) -> identity f.
Proof.
  clear A B f.
  intros A f h.
  destruct h as [hin hid].
  unfold involutive in hin.
  unfold idempotent in hid.
  unfold identity.
  intro x.
  specialize (hin x).
  specialize (hid x).
  rewrite <- hid.
  rewrite hin.
  reflexivity.
Qed.

  
  Lemma map_eq_nil : forall l, map l = [] -> l = [].
  Proof.
intro l.
destruct l as [|head tail].
{ simpl. intros _. reflexivity. }
{ simpl. intro h. inversion h. }
  Qed.

  Hypothesis decA: forall x1 x2 : A, {x1 = x2} + {x1 <> x2}.
  Hypothesis decB: forall y1 y2 : B, {y1 = y2} + {y1 <> y2}.
  Hypothesis Hfinjective: forall x1 x2: A, (f x1) = (f x2) -> x1 = x2.

  Theorem count_occ_map x l:
    count_occ decA l x = count_occ decB (map l) (f x).
  Proof.
induction l as [|head tail ih].
{ simpl. reflexivity. }
{
simpl.
destruct (decA head x) as [hla|hra] eqn:eqna.
{
  subst x.
  rewrite ih. clear ih.
  destruct (decB (f head) (f head)) as [hlb|hrb].
  { reflexivity. }
  { exfalso. apply hrb. reflexivity. }
}
{
destruct (decB (f head) (f x)) as [hlb|hrb] eqn:heqb.
{
specialize (Hfinjective hlb).
subst x.
exfalso.
apply hra.
reflexivity.
}
{
rewrite ih.
reflexivity.
}
}
}
  Qed.

  Definition flat_map (f:A -> list B) :=
    fix flat_map (l:list A) : list B :=
    match l with
      | nil => nil
      | cons x t => (f x)++(flat_map t)
    end.

  Lemma in_flat_map : forall (f:A->list B)(l:list A)(y:B),
    In y (flat_map f l) <-> exists x, In x l /\ In y (f x).
  Proof.
    clear Hfinjective.
intro f'.
intro l.
intro y.
split.
{
induction l as [|head tail ih].
{
simpl.
intro i.
inversion i.
}
{
simpl.
intro h.
apply in_app_or in h.
destruct h as [hl|hr].
{
exists head.
split.
{ left. reflexivity. }
{ exact hl. }
}
{
specialize (ih hr).
destruct ih as [x [hel her]].
exists x.
split.
{ right. exact hel. }
{ exact her. }
}
}
}
{
intro h.
destruct h as [x [hl hr]].
induction l as [|head tail ih].
{ simpl. simpl in hl. exact hl. }
{
simpl.
apply in_or_app.
simpl in hl.
destruct hl as [hl'|hr'].
{ subst x. left. exact hr. }
{ right. apply ih. exact hr'. }
}
}
  Qed.

End Map.

Lemma flat_map_concat_map : forall A B (f : A -> list B) l,
  flat_map f l = concat (map f l).
Proof.
intros A B f.
intro l.
induction l as [|head tail ih].
{ simpl. reflexivity. }
{ simpl. rewrite ih. reflexivity. }
Qed.

Lemma concat_map : forall A B (f : A -> B) l, map f (concat l) = concat (map (map f) l).
Proof.
intros A B f l.
induction l as [|head tail ih].
{ simpl. reflexivity. }
{
simpl.
rewrite map_app.
rewrite ih.
reflexivity.
}
Qed.

Lemma map_id : forall (A :Type) (l : list A),
  map (fun x => x) l = l.
Proof.
intros A l.
induction l as [|head tail ih].
{ simpl. reflexivity. }
{ simpl. rewrite ih. reflexivity. }
Qed.

Lemma map_map : forall (A B C:Type)(f:A->B)(g:B->C) l,
  map g (map f l) = map (fun x => g (f x)) l.
Proof.
  intros A B C f g l.
  induction l as [|head tail ih].
 { simpl. reflexivity. }
{ simpl. rewrite ih. reflexivity. }
Qed.



Lemma map_ext_in :
  forall (A B : Type)(f g:A->B) l, (forall a, In a l -> f a = g a) -> map f l = map g l.
Proof.
intros A B f g l.
induction l as [|head tail ih].
{ simpl. intros _. reflexivity. }
{
simpl.
intro h.
rewrite ih. rewrite h. reflexivity.
{ left. reflexivity. }
{ intro a. intro hin. apply h. right. exact hin. }
}
Qed.

Lemma ext_in_map :
  forall (A B : Type)(f g:A->B) l, map f l = map g l -> forall a, In a l -> f a = g a.
Proof.
intros A B f g l.
induction l as [|head tail ih].
{ simpl. intros _. intro a. intro i. contradiction i. }
{
simpl.
intro h.
intro a.
intros [hl|hr].
{ subst a. inversion h. reflexivity. }
{
apply ih.
{ inversion h. reflexivity. }
{ exact hr. }
}
}
Qed.

Arguments ext_in_map [A B f g l].

Lemma map_ext_in_iff :
   forall (A B : Type)(f g:A->B) l, map f l = map g l <-> forall a, In a l -> f a = g a.
Proof.
intros A B f g l.
split.
{ apply ext_in_map. }
{ apply map_ext_in. }
Qed.

Arguments map_ext_in_iff {A B f g l}.

Lemma map_ext :
  forall (A B : Type)(f g:A->B), (forall a, f a = g a) -> forall l, map f l = map g l.
Proof.
intros A B f g.
intro h.
intro l.
apply map_ext_in.
intro a.
intro hin.
apply h.
Qed.

Section Fold_Left_Recursor.
  Variables (A : Type) (B : Type).
  Variable f : A -> B -> A.

  Fixpoint fold_left (l:list B) (a0:A) : A :=
    match l with
      | nil => a0
      | cons b t => fold_left t (f a0 b)
    end.

  Lemma fold_left_app : forall (l l':list B)(i:A),
    fold_left (l++l') i = fold_left l' (fold_left l i).
  Proof.

intro l.
induction l as [|head tail ih].
{
simpl.
intros.
reflexivity.
}
{
simpl.
intros l' i.
rewrite ih.
reflexivity.
}
  Qed.

End Fold_Left_Recursor.

Lemma fold_left_length :
  forall (A:Type)(l:list A), fold_left (fun x _ => S x) l 0 = length l.
Proof.
intros A l.
assert (hl':exists l', l = rev l').
{ exists (rev l). rewrite rev_involutive. reflexivity. }
destruct hl' as [l' heq].
subst l.
rename l' into l.
induction l as [|head tail ih].
{ simpl. reflexivity. }
{
simpl.
rewrite app_length.
simpl.
rewrite <- ih.
rewrite Nat.add_1_r.
rewrite fold_left_app.
simpl.
reflexivity.
}
Qed.

(************************************)
(** Right-to-left iterator on lists *)
(************************************)

Section Fold_Right_Recursor.
  Variables (A : Type) (B : Type).
  Variable f : B -> A -> A.
  Variable a0 : A.

  Fixpoint fold_right (l:list B) : A :=
    match l with
      | nil => a0
      | cons b t => f b (fold_right t)
    end.

End Fold_Right_Recursor.

  Lemma fold_right_app : forall (A B:Type)(f:A->B->B) l l' i,
    fold_right f i (l++l') = fold_right f (fold_right f i l') l.
  Proof.
intros A B f l l' i.
induction l as [|head tail ih].
{ simpl. reflexivity. }
{
simpl.
rewrite ih.
reflexivity.
}
  Qed.

  Lemma fold_left_rev_right : forall (A B:Type)(f:A->B->B) l i,
    fold_right f i (rev l) = fold_left (fun x y => f y x) l i.
  Proof.
intros A B f l.
induction l as [|head tail ih].
{ simpl. reflexivity. }
{
intro i.
simpl.
rewrite fold_right_app.
simpl.
specialize (ih (f head i)).
rewrite ih.
reflexivity.
}
  Qed.

  Definition associative {A:Type} (f : A -> A -> A) :=  forall x y z : A, f x (f y z) = f (f x y) z.
  Definition commutative {A B:Type} (f : A -> A -> B) :=  forall x y : A, f x y = f y x.

  Theorem fold_symmetric :
    forall (A : Type) (f : A -> A -> A),
    associative f ->commutative f ->
forall (a : A),
    forall (l : list A), fold_left f l a = fold_right f a l.
  Proof.
intros A f hassoc hcomm.
unfold associative in hassoc.
unfold commutative in hcomm.
intros a l.
generalize dependent a.
induction l as [|head tail ih].
{ intro a. simpl. reflexivity. }
{
intro a.
simpl.
rewrite ih.
clear ih.
generalize dependent a.
induction tail as [|th tt ih].
{ intro a. simpl. rewrite hcomm. reflexivity. }
{
intro a.
simpl.
rewrite ih.
set (fr:=fold_right f a tt).
rewrite (hassoc th head fr).
rewrite (hcomm th head).
rewrite <- (hassoc head th fr).
reflexivity.
}
}
Qed.

  Fixpoint list_power (A B:Type)(l:list A) (l':list B) :
    list (list (A * B)) :=
    match l with
      | nil => cons nil nil
      | cons x t =>
	flat_map (fun f:list (A * B) => map (fun y:B => cons (x, y) f) l')
        (list_power t l')
    end.


  Section Bool.
    Variable A : Type.
    Variable f : A -> bool.

    Fixpoint existsb (l:list A) : bool :=
      match l with
	| nil => false
	| a::l => f a || existsb l
      end.

    Lemma existsb_exists :
      forall l, existsb l = true <-> exists x, In x l /\ f x = true.
    Proof.
intro l.
split.
{
induction l as [|head tail ih].
{ simpl. intro i. inversion i. }
{ simpl. intro h.
destruct (f head) eqn:heqhead.
{ simpl in h. clear h. exists head. split. left. reflexivity. exact heqhead. }
{ simpl in h. specialize (ih h). clear h. destruct ih as [x h]. destruct h as [hin hfx]. exists x. split. right. exact hin. exact hfx. }
}
}
{
intro he.
destruct he as [x [hin hfx]].
generalize dependent x.
induction l as [|head tail ih].
{ simpl. intros x i. inversion i. }
{ simpl. intros x h. destruct h as [hl|hr].
{ subst x. intro heq. rewrite heq. simpl. reflexivity. }
{ intro heq. specialize (ih x). specialize (ih hr). specialize (ih heq). rewrite ih. rewrite orb_comm. simpl. reflexivity. }
}
}
    Qed.



    Lemma existsb_nth : forall l n d, n < length l ->
      existsb l = false -> f (nth n l d) = false.
    Proof.
intro l.
induction l as [|head tail ih].
{ intros n d i. simpl in i. unfold lt in i. inversion i. }
{ intros n d h. simpl in h. unfold lt in h. apply le_S_n in h.
intro he. simpl in he.
apply orb_false_elim in he.
destruct he as [hel her].
simpl.
destruct n as [|n].
{ exact hel. }
{
apply ih.
unfold lt. exact h. exact her.
}
}
    Qed.

    Lemma existsb_app : forall l1 l2,
      existsb (l1++l2) = existsb l1 || existsb l2.
    Proof.
intro l.
induction l as [|head tail ih].
{ intro l'. simpl. reflexivity. }
{ intro l'. simpl.
rewrite <- orb_assoc.
rewrite ih.
reflexivity.
}
    Qed.

    Fixpoint forallb (l:list A) : bool :=
      match l with
	| nil => true
	| a::l => f a && forallb l
      end.

    Lemma forallb_forall :
      forall l, forallb l = true <-> (forall x, In x l -> f x = true).
    Proof.
intro l.
induction l as [|head tail ih].
{
 simpl. split. intros _. intros x i. inversion i.
intros _. reflexivity.
}
{
simpl.
destruct ih as [ihl ihr].
split.
{ intro h.
apply andb_prop in h.
destruct h as [hl hr].
intros x [h|h].
{ subst x. exact hl. }
{ apply ihl. exact hr. exact h. }
}
{
intro h.
apply andb_true_intro.
split.
{
apply ihl.

(* xxx *)

      induction l; simpl; intuition.
      destruct (andb_prop _ _ H1).
      congruence.
      destruct (andb_prop _ _ H1); auto.
      assert (forallb l = true).
      apply H0; intuition.
      rewrite H1; auto.
    Qed.

    Lemma forallb_app :
      forall l1 l2, forallb (l1++l2) = forallb l1 && forallb l2.
    Proof.
      induction l1; simpl.
        solve[auto].
      case (f a); simpl; solve[auto].
    Qed.
  (** [filter] *)

    Fixpoint filter (l:list A) : list A :=
      match l with
	| nil => nil
	| x :: l => if f x then x::(filter l) else filter l
      end.

    Lemma filter_In : forall x l, In x (filter l) <-> In x l /\ f x = true.
    Proof.
      induction l; simpl.
      intuition.
      intros.
      case_eq (f a); intros; simpl; intuition congruence.
    Qed.

    Lemma filter_app (l l':list A) :
      filter (l ++ l') = filter l ++ filter l'.
    Proof.
      induction l as [|x l IH]; simpl; trivial.
      destruct (f x); simpl; now rewrite IH.
    Qed.

    Lemma concat_filter_map : forall (l : list (list A)),
      concat (map filter l) = filter (concat l).
    Proof.
      induction l as [| v l IHl]; [auto|].
      simpl. rewrite IHl. rewrite filter_app. reflexivity.
    Qed.

  (** [find] *)

    Fixpoint find (l:list A) : option A :=
      match l with
	| nil => None
	| x :: tl => if f x then Some x else find tl
      end.

    Lemma find_some l x : find l = Some x -> In x l /\ f x = true.
    Proof.
     induction l as [|a l IH]; simpl; [easy| ].
     case_eq (f a); intros Ha Eq.
     * injection Eq as [= ->]; auto.
     * destruct (IH Eq); auto.
    Qed.

    Lemma find_none l : find l = None -> forall x, In x l -> f x = false.
    Proof.
     induction l as [|a l IH]; simpl; [easy|].
     case_eq (f a); intros Ha Eq x IN; [easy|].
     destruct IN as [<-|IN]; auto.
    Qed.

  (** [partition] *)

    Fixpoint partition (l:list A) : list A * list A :=
      match l with
	| nil => (nil, nil)
	| x :: tl => let (g,d) := partition tl in
	  if f x then (x::g,d) else (g,x::d)
      end.

  Theorem partition_cons1 a l l1 l2:
    partition l = (l1, l2) ->
    f a = true ->
    partition (a::l) = (a::l1, l2).
  Proof.
    simpl. now intros -> ->.
  Qed.

  Theorem partition_cons2 a l l1 l2:
    partition l = (l1, l2) ->
    f a=false ->
    partition (a::l) = (l1, a::l2).
  Proof.
    simpl. now intros -> ->.
  Qed.

  Theorem partition_length l l1 l2:
    partition l = (l1, l2) ->
    length l = length l1 + length l2.
  Proof.
    revert l1 l2. induction l as [ | a l' Hrec]; intros l1 l2.
    - now intros [= <- <- ].
    - simpl. destruct (f a), (partition l') as (left, right);
      intros [= <- <- ]; simpl; rewrite (Hrec left right); auto.
  Qed.

  Theorem partition_inv_nil (l : list A):
    partition l = ([], []) <-> l = [].
  Proof.
    split.
    - destruct l as [|a l'].
      * intuition.
      * simpl. destruct (f a), (partition l'); now intros [= -> ->].
    - now intros ->.
  Qed.

  Theorem elements_in_partition l l1 l2:
    partition l = (l1, l2) ->
    forall x:A, In x l <-> In x l1 \/ In x l2.
  Proof.
    revert l1 l2. induction l as [| a l' Hrec]; simpl; intros l1 l2 Eq x.
    - injection Eq as [= <- <-]. tauto.
    - destruct (partition l') as (left, right).
      specialize (Hrec left right eq_refl x).
      destruct (f a); injection Eq as [= <- <-]; simpl; tauto.
  Qed.

  End Bool.


  (*******************************)
  (** ** Further filtering facts *)
  (*******************************)

  Section Filtering.
    Variables (A : Type).

    Lemma filter_map : forall (f g : A -> bool) (l : list A),
      filter f l = filter g l <-> map f l = map g l.
    Proof.
      induction l as [| a l IHl]; [firstorder|].
      simpl. destruct (f a) eqn:Hfa; destruct (g a) eqn:Hga; split; intros H.
      - inversion H. apply IHl in H1. rewrite H1. reflexivity.
      - inversion H. apply IHl in H1. rewrite H1. reflexivity.
      - assert (Ha : In a (filter g l)). { rewrite <- H. apply in_eq. }
        apply filter_In in Ha. destruct Ha as [_ Hga']. rewrite Hga in Hga'. inversion Hga'.
      - inversion H.
      - assert (Ha : In a (filter f l)). { rewrite H. apply in_eq. }
        apply filter_In in Ha. destruct Ha as [_ Hfa']. rewrite Hfa in Hfa'. inversion Hfa'.
      - inversion H.
      - rewrite IHl in H. rewrite H. reflexivity.
      - inversion H. apply IHl. assumption.
    Qed.

    Lemma filter_ext_in : forall (f g : A -> bool) (l : list A),
      (forall a, In a l -> f a = g a) -> filter f l = filter g l.
    Proof.
      intros f g l H. rewrite filter_map. apply map_ext_in. auto.
    Qed.

    Lemma ext_in_filter : forall (f g : A -> bool) (l : list A),
      filter f l = filter g l -> (forall a, In a l -> f a = g a).
    Proof.
      intros f g l H. rewrite filter_map in H. apply ext_in_map. assumption.
    Qed.

    Lemma filter_ext_in_iff : forall (f g : A -> bool) (l : list A),
      filter f l = filter g l <-> (forall a, In a l -> f a = g a).
    Proof.
      split; [apply ext_in_filter | apply filter_ext_in].
    Qed.

    Lemma filter_ext : forall (f g : A -> bool),
      (forall a, f a = g a) -> forall l, filter f l = filter g l.
    Proof.
      intros f g H l. rewrite filter_map. apply map_ext. assumption.
    Qed.

  End Filtering.


  (******************************************************)
  (** ** Operations on lists of pairs or lists of lists *)
  (******************************************************)

  Section ListPairs.
    Variables (A : Type) (B : Type).

  (** [split] derives two lists from a list of pairs *)

    Fixpoint split (l:list (A*B)) : list A * list B :=
      match l with
	| [] => ([], [])
	| (x,y) :: tl => let (left,right) := split tl in (x::left, y::right)
      end.

    Lemma in_split_l : forall (l:list (A*B))(p:A*B),
      In p l -> In (fst p) (fst (split l)).
    Proof.
      induction l; simpl; intros; auto.
      destruct p; destruct a; destruct (split l); simpl in *.
      destruct H.
      injection H; auto.
      right; apply (IHl (a0,b) H).
    Qed.

    Lemma in_split_r : forall (l:list (A*B))(p:A*B),
      In p l -> In (snd p) (snd (split l)).
    Proof.
      induction l; simpl; intros; auto.
      destruct p; destruct a; destruct (split l); simpl in *.
      destruct H.
      injection H; auto.
      right; apply (IHl (a0,b) H).
    Qed.

    Lemma split_nth : forall (l:list (A*B))(n:nat)(d:A*B),
      nth n l d = (nth n (fst (split l)) (fst d), nth n (snd (split l)) (snd d)).
    Proof.
      induction l.
      destruct n; destruct d; simpl; auto.
      destruct n; destruct d; simpl; auto.
      destruct a; destruct (split l); simpl; auto.
      destruct a; destruct (split l); simpl in *; auto.
      apply IHl.
    Qed.

    Lemma split_length_l : forall (l:list (A*B)),
      length (fst (split l)) = length l.
    Proof.
      induction l; simpl; auto.
      destruct a; destruct (split l); simpl; auto.
    Qed.

    Lemma split_length_r : forall (l:list (A*B)),
      length (snd (split l)) = length l.
    Proof.
      induction l; simpl; auto.
      destruct a; destruct (split l); simpl; auto.
    Qed.

  (** [combine] is the opposite of [split].
      Lists given to [combine] are meant to be of same length.
      If not, [combine] stops on the shorter list *)

    Fixpoint combine (l : list A) (l' : list B) : list (A*B) :=
      match l,l' with
	| x::tl, y::tl' => (x,y)::(combine tl tl')
	| _, _ => nil
      end.

    Lemma split_combine : forall (l: list (A*B)),
      let (l1,l2) := split l in combine l1 l2 = l.
    Proof.
      induction l.
      simpl; auto.
      destruct a; simpl.
      destruct (split l); simpl in *.
      f_equal; auto.
    Qed.

    Lemma combine_split : forall (l:list A)(l':list B), length l = length l' ->
      split (combine l l') = (l,l').
    Proof.
      induction l, l'; simpl; trivial; try discriminate.
      now intros [= ->%IHl].
    Qed.

    Lemma in_combine_l : forall (l:list A)(l':list B)(x:A)(y:B),
      In (x,y) (combine l l') -> In x l.
    Proof.
      induction l.
      simpl; auto.
      destruct l'; simpl; auto; intros.
      contradiction.
      destruct H.
      injection H; auto.
      right; apply IHl with l' y; auto.
    Qed.

    Lemma in_combine_r : forall (l:list A)(l':list B)(x:A)(y:B),
      In (x,y) (combine l l') -> In y l'.
    Proof.
      induction l.
      simpl; intros; contradiction.
      destruct l'; simpl; auto; intros.
      destruct H.
      injection H; auto.
      right; apply IHl with x; auto.
    Qed.

    Lemma combine_length : forall (l:list A)(l':list B),
      length (combine l l') = min (length l) (length l').
    Proof.
      induction l.
      simpl; auto.
      destruct l'; simpl; auto.
    Qed.

    Lemma combine_nth : forall (l:list A)(l':list B)(n:nat)(x:A)(y:B),
      length l = length l' ->
      nth n (combine l l') (x,y) = (nth n l x, nth n l' y).
    Proof.
      induction l; destruct l'; intros; try discriminate.
      destruct n; simpl; auto.
      destruct n; simpl in *; auto.
    Qed.

  (** [list_prod] has the same signature as [combine], but unlike
     [combine], it adds every possible pairs, not only those at the
     same position. *)

    Fixpoint list_prod (l:list A) (l':list B) :
      list (A * B) :=
      match l with
	| nil => nil
	| cons x t => (map (fun y:B => (x, y)) l')++(list_prod t l')
      end.

    Lemma in_prod_aux :
      forall (x:A) (y:B) (l:list B),
	In y l -> In (x, y) (map (fun y0:B => (x, y0)) l).
    Proof.
      induction l;
	[ simpl; auto
	  | simpl; destruct 1 as [H1| ];
	    [ left; rewrite H1; trivial | right; auto ] ].
    Qed.

    Lemma in_prod :
      forall (l:list A) (l':list B) (x:A) (y:B),
	In x l -> In y l' -> In (x, y) (list_prod l l').
    Proof.
      induction l;
	[ simpl; tauto
	  | simpl; intros; apply in_or_app; destruct H;
	    [ left; rewrite H; apply in_prod_aux; assumption | right; auto ] ].
    Qed.

    Lemma in_prod_iff :
      forall (l:list A)(l':list B)(x:A)(y:B),
	In (x,y) (list_prod l l') <-> In x l /\ In y l'.
    Proof.
      split; [ | intros; apply in_prod; intuition ].
      induction l; simpl; intros.
      intuition.
      destruct (in_app_or _ _ _ H); clear H.
      destruct (in_map_iff (fun y : B => (a, y)) l' (x,y)) as (H1,_).
      destruct (H1 H0) as (z,(H2,H3)); clear H0 H1.
      injection H2 as [= -> ->]; intuition.
      intuition.
    Qed.

    Lemma prod_length : forall (l:list A)(l':list B),
      length (list_prod l l') = (length l) * (length l').
    Proof.
      induction l; simpl; auto.
      intros.
      rewrite app_length.
      rewrite map_length.
      auto.
    Qed.

  End ListPairs.




(*****************************************)
(** * Miscellaneous operations on lists  *)
(*****************************************)



(******************************)
(** ** Length order of lists  *)
(******************************)

Section length_order.
  Variable A : Type.

  Definition lel (l m:list A) := length l <= length m.

  Variables a b : A.
  Variables l m n : list A.

  Lemma lel_refl : lel l l.
  Proof.
    unfold lel; auto with arith.
  Qed.

  Lemma lel_trans : lel l m -> lel m n -> lel l n.
  Proof.
    unfold lel; intros.
    now_show (length l <= length n).
    apply le_trans with (length m); auto with arith.
  Qed.

  Lemma lel_cons_cons : lel l m -> lel (a :: l) (b :: m).
  Proof.
    unfold lel; simpl; auto with arith.
  Qed.

  Lemma lel_cons : lel l m -> lel l (b :: m).
  Proof.
    unfold lel; simpl; auto with arith.
  Qed.

  Lemma lel_tail : lel (a :: l) (b :: m) -> lel l m.
  Proof.
    unfold lel; simpl; auto with arith.
  Qed.

  Lemma lel_nil : forall l':list A, lel l' nil -> nil = l'.
  Proof.
    intro l'; elim l'; auto with arith.
    intros a' y H H0.
    now_show (nil = a' :: y).
    absurd (S (length y) <= 0); auto with arith.
  Qed.
End length_order.

Hint Resolve lel_refl lel_cons_cons lel_cons lel_nil lel_nil nil_cons:
  datatypes.


(******************************)
(** ** Set inclusion on list  *)
(******************************)

Section SetIncl.

  Variable A : Type.

  Definition incl (l m:list A) := forall a:A, In a l -> In a m.
  Hint Unfold incl : core.

  Lemma incl_refl : forall l:list A, incl l l.
  Proof.
    auto.
  Qed.
  Hint Resolve incl_refl : core.

  Lemma incl_tl : forall (a:A) (l m:list A), incl l m -> incl l (a :: m).
  Proof.
    auto with datatypes.
  Qed.
  Hint Immediate incl_tl : core.

  Lemma incl_tran : forall l m n:list A, incl l m -> incl m n -> incl l n.
  Proof.
    auto.
  Qed.

  Lemma incl_appl : forall l m n:list A, incl l n -> incl l (n ++ m).
  Proof.
    auto with datatypes.
  Qed.
  Hint Immediate incl_appl : core.

  Lemma incl_appr : forall l m n:list A, incl l n -> incl l (m ++ n).
  Proof.
    auto with datatypes.
  Qed.
  Hint Immediate incl_appr : core.

  Lemma incl_cons :
    forall (a:A) (l m:list A), In a m -> incl l m -> incl (a :: l) m.
  Proof.
    unfold incl; simpl; intros a l m H H0 a0 H1.
    now_show (In a0 m).
    elim H1.
    now_show (a = a0 -> In a0 m).
    elim H1; auto; intro H2.
    now_show (a = a0 -> In a0 m).
    elim H2; auto. (* solves subgoal *)
    now_show (In a0 l -> In a0 m).
    auto.
  Qed.
  Hint Resolve incl_cons : core.

  Lemma incl_app : forall l m n:list A, incl l n -> incl m n -> incl (l ++ m) n.
  Proof.
    unfold incl; simpl; intros l m n H H0 a H1.
    now_show (In a n).
    elim (in_app_or _ _ _ H1); auto.
  Qed.
  Hint Resolve incl_app : core.

End SetIncl.

Hint Resolve incl_refl incl_tl incl_tran incl_appl incl_appr incl_cons
  incl_app: datatypes.


(**************************************)
(** * Cutting a list at some position *)
(**************************************)

Section Cutting.

  Variable A : Type.

  Fixpoint firstn (n:nat)(l:list A) : list A :=
    match n with
      | 0 => nil
      | S n => match l with
		 | nil => nil
		 | a::l => a::(firstn n l)
	       end
    end.

  Lemma firstn_nil n: firstn n [] = [].
  Proof. induction n; now simpl. Qed.

  Lemma firstn_cons n a l: firstn (S n) (a::l) = a :: (firstn n l).
  Proof. now simpl. Qed.

  Lemma firstn_all l: firstn (length l) l = l.
  Proof. induction l as [| ? ? H]; simpl; [reflexivity | now rewrite H]. Qed.

  Lemma firstn_all2 n: forall (l:list A), (length l) <= n -> firstn n l = l.
  Proof. induction n as [|k iHk].
    - intro. inversion 1 as [H1|?].
      rewrite (length_zero_iff_nil l) in H1. subst. now simpl.
    - destruct l as [|x xs]; simpl.
      * now reflexivity.
      * simpl. intro H. apply Peano.le_S_n in H. f_equal. apply iHk, H.
  Qed.

  Lemma firstn_O l: firstn 0 l = [].
  Proof. now simpl. Qed.

  Lemma firstn_le_length n: forall l:list A, length (firstn n l) <= n.
  Proof.
    induction n as [|k iHk]; simpl; [auto | destruct l as [|x xs]; simpl].
    - auto with arith.
    - apply Peano.le_n_S, iHk.
  Qed.

  Lemma firstn_length_le: forall l:list A, forall n:nat,
    n <= length l -> length (firstn n l) = n.
  Proof. induction l as [|x xs Hrec].
    - simpl. intros n H. apply le_n_0_eq in H. rewrite <- H. now simpl.
    - destruct n.
      * now simpl.
      * simpl. intro H. apply le_S_n in H. now rewrite (Hrec n H).
  Qed.

  Lemma firstn_app n:
    forall l1 l2,
    firstn n (l1 ++ l2) = (firstn n l1) ++ (firstn (n - length l1) l2).
  Proof. induction n as [|k iHk]; intros l1 l2.
    - now simpl.
    - destruct l1 as [|x xs].
      * unfold firstn at 2, length. now rewrite 2!app_nil_l, <- minus_n_O.
      * rewrite <- app_comm_cons. simpl. f_equal. apply iHk.
  Qed.

  Lemma firstn_app_2 n:
    forall l1 l2,
    firstn ((length l1) + n) (l1 ++ l2) = l1 ++ firstn n l2.
  Proof. induction n as [| k iHk];intros l1 l2.
    - unfold firstn at 2. rewrite <- plus_n_O, app_nil_r.
      rewrite firstn_app. rewrite <- minus_diag_reverse.
      unfold firstn at 2. rewrite app_nil_r. apply firstn_all.
    - destruct l2 as [|x xs].
      * simpl. rewrite app_nil_r. apply firstn_all2. auto with arith.
      * rewrite firstn_app. assert (H0 : (length l1 + S k - length l1) = S k).
        auto with arith.
        rewrite H0, firstn_all2; [reflexivity | auto with arith].
  Qed.

  Lemma firstn_firstn:
    forall l:list A,
    forall i j : nat,
    firstn i (firstn j l) = firstn (min i j) l.
  Proof. induction l as [|x xs Hl].
    - intros. simpl. now rewrite ?firstn_nil.
    - destruct i.
      * intro. now simpl.
      * destruct j.
        + now simpl.
        + simpl. f_equal. apply Hl.
  Qed.

  Fixpoint skipn (n:nat)(l:list A) : list A :=
    match n with
      | 0 => l
      | S n => match l with
		 | nil => nil
		 | a::l => skipn n l
	       end
    end.

  Lemma firstn_skipn_comm : forall m n l,
  firstn m (skipn n l) = skipn n (firstn (n + m) l).
  Proof. now intros m; induction n; intros []; simpl; destruct m. Qed.

  Lemma skipn_firstn_comm : forall m n l,
  skipn m (firstn n l) = firstn (n - m) (skipn m l).
  Proof. now induction m; intros [] []; simpl; rewrite ?firstn_nil. Qed.

  Lemma skipn_O : forall l, skipn 0 l = l.
  Proof. reflexivity. Qed.

  Lemma skipn_nil : forall n, skipn n ([] : list A) = [].
  Proof. now intros []. Qed.

  Lemma skipn_cons n a l: skipn (S n) (a::l) = skipn n l.
  Proof. reflexivity. Qed.

  Lemma skipn_none : forall l, skipn (length l) l = [].
  Proof. now induction l. Qed.

  Lemma skipn_all2 n: forall l, length l <= n -> skipn n l = [].
  Proof.
    intros l L%Nat.sub_0_le; rewrite <-(firstn_all l) at 1.
    now rewrite skipn_firstn_comm, L.
  Qed.

  Lemma firstn_skipn : forall n l, firstn n l ++ skipn n l = l.
  Proof.
    induction n.
    simpl; auto.
    destruct l; simpl; auto.
    f_equal; auto.
  Qed.

  Lemma firstn_length : forall n l, length (firstn n l) = min n (length l).
  Proof.
    induction n; destruct l; simpl; auto.
  Qed.

  Lemma skipn_length n :
    forall l, length (skipn n l) = length l - n.
  Proof.
    induction n.
    - intros l; simpl; rewrite Nat.sub_0_r; reflexivity.
    - destruct l; simpl; auto.
  Qed.

  Lemma skipn_all l: skipn (length l) l = nil.
  Proof. now induction l. Qed.

  Lemma skipn_app n : forall l1 l2,
    skipn n (l1 ++ l2) = (skipn n l1) ++ (skipn (n - length l1) l2).
  Proof. induction n; auto; intros [|]; simpl; auto. Qed.

  Lemma firstn_skipn_rev: forall x l,
      firstn x l = rev (skipn (length l - x) (rev l)).
  Proof.
    intros x l; rewrite <-(firstn_skipn x l) at 3.
    rewrite rev_app_distr, skipn_app, rev_app_distr, rev_length,
            skipn_length, Nat.sub_diag; simpl; rewrite rev_involutive.
    rewrite <-app_nil_r at 1; f_equal; symmetry; apply length_zero_iff_nil.
    repeat rewrite rev_length, skipn_length; apply Nat.sub_diag.
  Qed.

  Lemma firstn_rev: forall x l,
    firstn x (rev l) = rev (skipn (length l - x) l).
  Proof.
    now intros x l; rewrite firstn_skipn_rev, rev_involutive, rev_length.
  Qed.

  Lemma skipn_rev: forall x l,
      skipn x (rev l) = rev (firstn (length l - x) l).
  Proof.
    intros x l; rewrite firstn_skipn_rev, rev_involutive, <-rev_length.
    destruct (Nat.le_ge_cases (length (rev l)) x) as [L | L].
    - rewrite skipn_all2; [apply Nat.sub_0_le in L | trivial].
      now rewrite L, Nat.sub_0_r, skipn_none.
    - replace (length (rev l) - (length (rev l) - x))
         with (length (rev l) + x - length (rev l)).
      rewrite minus_plus. reflexivity.
      rewrite <- (Nat.sub_add _ _ L) at 2.
      now rewrite <-!(Nat.add_comm x), <-minus_plus_simpl_l_reverse.
  Qed.

   Lemma removelast_firstn : forall n l, n < length l ->
     removelast (firstn (S n) l) = firstn n l.
   Proof.
     induction n; destruct l.
     simpl; auto.
     simpl; auto.
     simpl; auto.
     intros.
     simpl in H.
     change (firstn (S (S n)) (a::l)) with ((a::nil)++firstn (S n) l).
     change (firstn (S n) (a::l)) with (a::firstn n l).
     rewrite removelast_app.
     rewrite IHn; auto with arith.

     clear IHn; destruct l; simpl in *; try discriminate.
     inversion_clear H.
     inversion_clear H0.
   Qed.

   Lemma firstn_removelast : forall n l, n < length l ->
     firstn n (removelast l) = firstn n l.
   Proof.
     induction n; destruct l.
     simpl; auto.
     simpl; auto.
     simpl; auto.
     intros.
     simpl in H.
     change (removelast (a :: l)) with (removelast ((a::nil)++l)).
     rewrite removelast_app.
     simpl; f_equal; auto with arith.
     intro H0; rewrite H0 in H; inversion_clear H; inversion_clear H1.
   Qed.

End Cutting.

(**************************************************************)
(** ** Combining pairs of lists of possibly-different lengths *)
(**************************************************************)

Section Combining.
    Variables (A B : Type).

    Lemma combine_nil : forall (l : list A),
      combine l (@nil B) = @nil (A*B).
    Proof.
      intros l.
      apply length_zero_iff_nil.
      rewrite combine_length. simpl. rewrite Nat.min_0_r.
      reflexivity.
    Qed.

    Lemma combine_firstn_l : forall (l : list A) (l' : list B),
      combine l l' = combine l (firstn (length l) l').
    Proof.
      induction l as [| x l IHl]; intros l'; [reflexivity|].
      destruct l' as [| x' l']; [reflexivity|].
      simpl. specialize IHl with (l':=l'). rewrite <- IHl.
      reflexivity.
    Qed.

    Lemma combine_firstn_r : forall (l : list A) (l' : list B),
      combine l l' = combine (firstn (length l') l) l'.
    Proof.
      intros l l'. generalize dependent l.
      induction l' as [| x' l' IHl']; intros l.
      - simpl. apply combine_nil.
      - destruct l as [| x l]; [reflexivity|].
        simpl. specialize IHl' with (l:=l). rewrite <- IHl'.
        reflexivity.
    Qed.

    Lemma combine_firstn : forall (l : list A) (l' : list B) (n : nat),
      firstn n (combine l l') = combine (firstn n l) (firstn n l').
    Proof.
      induction l as [| x l IHl]; intros l' n.
      - simpl. repeat (rewrite firstn_nil). reflexivity.
      - destruct l' as [| x' l'].
        + simpl. repeat (rewrite firstn_nil). rewrite combine_nil. reflexivity.
        + simpl. destruct n as [| n]; [reflexivity|].
          repeat (rewrite firstn_cons). simpl.
          rewrite IHl. reflexivity.
    Qed.

End Combining.

(**********************************************************************)
(** ** Predicate for List addition/removal (no need for decidability) *)
(**********************************************************************)

Section Add.

  Variable A : Type.

  (* [Add a l l'] means that [l'] is exactly [l], with [a] added
     once somewhere *)
  Inductive Add (a:A) : list A -> list A -> Prop :=
    | Add_head l : Add a l (a::l)
    | Add_cons x l l' : Add a l l' -> Add a (x::l) (x::l').

  Lemma Add_app a l1 l2 : Add a (l1++l2) (l1++a::l2).
  Proof.
   induction l1; simpl; now constructor.
  Qed.

  Lemma Add_split a l l' :
    Add a l l' -> exists l1 l2, l = l1++l2 /\ l' = l1++a::l2.
  Proof.
   induction 1.
   - exists nil; exists l; split; trivial.
   - destruct IHAdd as (l1 & l2 & Hl & Hl').
     exists (x::l1); exists l2; split; simpl; f_equal; trivial.
  Qed.

  Lemma Add_in a l l' : Add a l l' ->
   forall x, In x l' <-> In x (a::l).
  Proof.
   induction 1; intros; simpl in *; rewrite ?IHAdd; tauto.
  Qed.

  Lemma Add_length a l l' : Add a l l' -> length l' = S (length l).
  Proof.
   induction 1; simpl; auto with arith.
  Qed.

  Lemma Add_inv a l : In a l -> exists l', Add a l' l.
  Proof.
   intro Ha. destruct (in_split _ _ Ha) as (l1 & l2 & ->).
   exists (l1 ++ l2). apply Add_app.
  Qed.

  Lemma incl_Add_inv a l u v :
    ~In a l -> incl (a::l) v -> Add a u v -> incl l u.
  Proof.
   intros Ha H AD y Hy.
   assert (Hy' : In y (a::u)).
   { rewrite <- (Add_in AD). apply H; simpl; auto. }
   destruct Hy'; [ subst; now elim Ha | trivial ].
  Qed.

End Add.

(********************************)
(** ** Lists without redundancy *)
(********************************)

Section ReDun.

  Variable A : Type.

  Inductive NoDup : list A -> Prop :=
    | NoDup_nil : NoDup nil
    | NoDup_cons : forall x l, ~ In x l -> NoDup l -> NoDup (x::l).

  Lemma NoDup_Add a l l' : Add a l l' -> (NoDup l' <-> NoDup l /\ ~In a l).
  Proof.
   induction 1 as [l|x l l' AD IH].
   - split; [ inversion_clear 1; now split | now constructor ].
   - split.
     + inversion_clear 1. rewrite IH in *. rewrite (Add_in AD) in *.
       simpl in *; split; try constructor; intuition.
     + intros (N,IN). inversion_clear N. constructor.
       * rewrite (Add_in AD); simpl in *; intuition.
       * apply IH. split; trivial. simpl in *; intuition.
  Qed.

  Lemma NoDup_remove l l' a :
    NoDup (l++a::l') -> NoDup (l++l') /\ ~In a (l++l').
  Proof.
  apply NoDup_Add. apply Add_app.
  Qed.

  Lemma NoDup_remove_1 l l' a : NoDup (l++a::l') -> NoDup (l++l').
  Proof.
  intros. now apply NoDup_remove with a.
  Qed.

  Lemma NoDup_remove_2 l l' a : NoDup (l++a::l') -> ~In a (l++l').
  Proof.
  intros. now apply NoDup_remove.
  Qed.

  Theorem NoDup_cons_iff a l:
    NoDup (a::l) <-> ~ In a l /\ NoDup l.
  Proof.
    split.
    + inversion_clear 1. now split.
    + now constructor.
  Qed.

  (** Effective computation of a list without duplicates *)

  Hypothesis decA: forall x y : A, {x = y} + {x <> y}.

  Fixpoint nodup (l : list A) : list A :=
    match l with
      | [] => []
      | x::xs => if in_dec decA x xs then nodup xs else x::(nodup xs)
    end.

  Lemma nodup_fixed_point : forall (l : list A),
    NoDup l -> nodup l = l.
  Proof.
    induction l as [| x l IHl]; [auto|]. intros H.
    simpl. destruct (in_dec decA x l) as [Hx | Hx]; rewrite NoDup_cons_iff in H.
    - destruct H as [H' _]. contradiction.
    - destruct H as [_ H']. apply IHl in H'. rewrite -> H'. reflexivity.
  Qed.

  Lemma nodup_In l x : In x (nodup l) <-> In x l.
  Proof.
    induction l as [|a l' Hrec]; simpl.
    - reflexivity.
    - destruct (in_dec decA a l'); simpl; rewrite Hrec.
      * intuition; now subst.
      * reflexivity.
  Qed.

  Lemma NoDup_nodup l: NoDup (nodup l).
  Proof.
    induction l as [|a l' Hrec]; simpl.
    - constructor.
    - destruct (in_dec decA a l'); simpl.
      * assumption.
      * constructor; [ now rewrite nodup_In | assumption].
  Qed.

  Lemma nodup_inv k l a : nodup k = a :: l -> ~ In a l.
  Proof.
    intros H.
    assert (H' : NoDup (a::l)).
    { rewrite <- H. apply NoDup_nodup. }
    now inversion_clear H'.
  Qed.

  Theorem NoDup_count_occ l:
    NoDup l <-> (forall x:A, count_occ decA l x <= 1).
  Proof.
    induction l as [| a l' Hrec].
    - simpl; split; auto. constructor.
    - rewrite NoDup_cons_iff, Hrec, (count_occ_not_In decA). clear Hrec. split.
      + intros (Ha, H) x. simpl. destruct (decA a x); auto.
        subst; now rewrite Ha.
      + split.
        * specialize (H a). rewrite count_occ_cons_eq in H; trivial.
          now inversion H.
        * intros x. specialize (H x). simpl in *. destruct (decA a x); auto.
          now apply Nat.lt_le_incl.
  Qed.

  Theorem NoDup_count_occ' l:
    NoDup l <-> (forall x:A, In x l -> count_occ decA l x = 1).
  Proof.
    rewrite NoDup_count_occ.
    setoid_rewrite (count_occ_In decA). unfold gt, lt in *.
    split; intros H x; specialize (H x);
    set (n := count_occ decA l x) in *; clearbody n.
    (* the rest would be solved by omega if we had it here... *)
    - now apply Nat.le_antisymm.
    - destruct (Nat.le_gt_cases 1 n); trivial.
      + rewrite H; trivial.
      + now apply Nat.lt_le_incl.
  Qed.

  (** Alternative characterisations of being without duplicates,
      thanks to [nth_error] and [nth] *)

  Lemma NoDup_nth_error l :
    NoDup l <->
    (forall i j, i<length l -> nth_error l i = nth_error l j -> i = j).
  Proof.
    split.
    { intros H; induction H as [|a l Hal Hl IH]; intros i j Hi E.
      - inversion Hi.
      - destruct i, j; simpl in *; auto.
        * elim Hal. eapply nth_error_In; eauto.
        * elim Hal. eapply nth_error_In; eauto.
        * f_equal. apply IH; auto with arith. }
    { induction l as [|a l]; intros H; constructor.
      * intro Ha. apply In_nth_error in Ha. destruct Ha as (n,Hn).
        assert (n < length l) by (now rewrite <- nth_error_Some, Hn).
        specialize (H 0 (S n)). simpl in H. discriminate H; auto with arith.
      * apply IHl.
        intros i j Hi E. apply eq_add_S, H; simpl; auto with arith. }
  Qed.

  Lemma NoDup_nth l d :
    NoDup l <->
    (forall i j, i<length l -> j<length l ->
       nth i l d = nth j l d -> i = j).
  Proof.
    split.
    { intros H; induction H as [|a l Hal Hl IH]; intros i j Hi Hj E.
      - inversion Hi.
      - destruct i, j; simpl in *; auto.
        * elim Hal. subst a. apply nth_In; auto with arith.
        * elim Hal. subst a. apply nth_In; auto with arith.
        * f_equal. apply IH; auto with arith. }
    { induction l as [|a l]; intros H; constructor.
      * intro Ha. eapply In_nth in Ha. destruct Ha as (n & Hn & Hn').
        specialize (H 0 (S n)). simpl in H. discriminate H; eauto with arith.
      * apply IHl.
        intros i j Hi Hj E. apply eq_add_S, H; simpl; auto with arith. }
  Qed.

  (** Having [NoDup] hypotheses bring more precise facts about [incl]. *)

  Lemma NoDup_incl_length l l' :
    NoDup l -> incl l l' -> length l <= length l'.
  Proof.
   intros N. revert l'. induction N as [|a l Hal N IH]; simpl.
   - auto with arith.
   - intros l' H.
     destruct (Add_inv a l') as (l'', AD). { apply H; simpl; auto. }
     rewrite (Add_length AD). apply le_n_S. apply IH.
     now apply incl_Add_inv with a l'.
  Qed.

  Lemma NoDup_length_incl l l' :
    NoDup l -> length l' <= length l -> incl l l' -> incl l' l.
  Proof.
   intros N. revert l'. induction N as [|a l Hal N IH].
   - destruct l'; easy.
   - intros l' E H x Hx.
     destruct (Add_inv a l') as (l'', AD). { apply H; simpl; auto. }
     rewrite (Add_in AD) in Hx. simpl in Hx.
     destruct Hx as [Hx|Hx]; [left; trivial|right].
     revert x Hx. apply (IH l''); trivial.
     * apply le_S_n. now rewrite <- (Add_length AD).
     * now apply incl_Add_inv with a l'.
  Qed.

End ReDun.

(** NoDup and map *)

(** NB: the reciprocal result holds only for injective functions,
    see FinFun.v *)

Lemma NoDup_map_inv A B (f:A->B) l : NoDup (map f l) -> NoDup l.
Proof.
 induction l; simpl; inversion_clear 1; subst; constructor; auto.
 intro H. now apply (in_map f) in H.
Qed.

(***********************************)
(** ** Sequence of natural numbers *)
(***********************************)

Section NatSeq.

  (** [seq] computes the sequence of [len] contiguous integers
      that starts at [start]. For instance, [seq 2 3] is [2::3::4::nil]. *)

  Fixpoint seq (start len:nat) : list nat :=
    match len with
      | 0 => nil
      | S len => start :: seq (S start) len
    end.

  Lemma seq_length : forall len start, length (seq start len) = len.
  Proof.
    induction len; simpl; auto.
  Qed.

  Lemma seq_nth : forall len start n d,
    n < len -> nth n (seq start len) d = start+n.
  Proof.
    induction len; intros.
    inversion H.
    simpl seq.
    destruct n; simpl.
    auto with arith.
    rewrite IHlen;simpl; auto with arith.
  Qed.

  Lemma seq_shift : forall len start,
    map S (seq start len) = seq (S start) len.
  Proof.
    induction len; simpl; auto.
    intros.
    rewrite IHlen.
    auto with arith.
  Qed.

  Lemma in_seq len start n :
    In n (seq start len) <-> start <= n < start+len.
  Proof.
   revert start. induction len; simpl; intros.
   - rewrite <- plus_n_O. split;[easy|].
     intros (H,H'). apply (Lt.lt_irrefl _ (Lt.le_lt_trans _ _ _ H H')).
   - rewrite IHlen, <- plus_n_Sm; simpl; split.
     * intros [H|H]; subst; intuition auto with arith.
     * intros (H,H'). destruct (Lt.le_lt_or_eq _ _ H); intuition.
  Qed.

  Lemma seq_NoDup len start : NoDup (seq start len).
  Proof.
   revert start; induction len; simpl; constructor; trivial.
   rewrite in_seq. intros (H,_). apply (Lt.lt_irrefl _ H).
  Qed.

  Lemma seq_app : forall len1 len2 start,
    seq start (len1 + len2) = seq start len1 ++ seq (start + len1) len2.
  Proof.
    induction len1 as [|len1' IHlen]; intros; simpl in *.
    - now rewrite Nat.add_0_r.
    - now rewrite Nat.add_succ_r, IHlen.
  Qed.

End NatSeq.

Section Exists_Forall.

  (** * Existential and universal predicates over lists *)

  Variable A:Type.

  Section One_predicate.

    Variable P:A->Prop.

    Inductive Exists : list A -> Prop :=
      | Exists_cons_hd : forall x l, P x -> Exists (x::l)
      | Exists_cons_tl : forall x l, Exists l -> Exists (x::l).

    Hint Constructors Exists : core.

    Lemma Exists_exists (l:list A) :
      Exists l <-> (exists x, In x l /\ P x).
    Proof.
      split.
      - induction 1; firstorder.
      - induction l; firstorder; subst; auto.
    Qed.

    Lemma Exists_nil : Exists nil <-> False.
    Proof. split; inversion 1. Qed.

    Lemma Exists_cons x l:
      Exists (x::l) <-> P x \/ Exists l.
    Proof. split; inversion 1; auto. Qed.

    Lemma Exists_dec l:
      (forall x:A, {P x} + { ~ P x }) ->
      {Exists l} + {~ Exists l}.
    Proof.
      intro Pdec. induction l as [|a l' Hrec].
      - right. abstract now rewrite Exists_nil.
      - destruct Hrec as [Hl'|Hl'].
        * left. now apply Exists_cons_tl.
        * destruct (Pdec a) as [Ha|Ha].
          + left. now apply Exists_cons_hd.
          + right. abstract now inversion 1.
    Defined.

    Inductive Forall : list A -> Prop :=
      | Forall_nil : Forall nil
      | Forall_cons : forall x l, P x -> Forall l -> Forall (x::l).

    Hint Constructors Forall : core.

    Lemma Forall_forall (l:list A):
      Forall l <-> (forall x, In x l -> P x).
    Proof.
      split.
      - induction 1; firstorder; subst; auto.
      - induction l; firstorder.
    Qed.

    Lemma Forall_inv : forall (a:A) l, Forall (a :: l) -> P a.
    Proof.
      intros; inversion H; trivial.
    Qed.

    Lemma Forall_rect : forall (Q : list A -> Type),
      Q [] -> (forall b l, P b -> Q (b :: l)) -> forall l, Forall l -> Q l.
    Proof.
      intros Q H H'; induction l; intro; [|eapply H', Forall_inv]; eassumption.
    Qed.

    Lemma Forall_dec :
      (forall x:A, {P x} + { ~ P x }) ->
      forall l:list A, {Forall l} + {~ Forall l}.
    Proof.
      intro Pdec. induction l as [|a l' Hrec].
      - left. apply Forall_nil.
      - destruct Hrec as [Hl'|Hl'].
        + destruct (Pdec a) as [Ha|Ha].
          * left. now apply Forall_cons.
          * right. abstract now inversion 1.
        + right. abstract now inversion 1.
    Defined.

  End One_predicate.

  Theorem Forall_inv_tail
    :  forall (P : A -> Prop) (x0 : A) (xs : list A), Forall P (x0 :: xs) -> Forall P xs.
  Proof.
    intros P x0 xs H.
    apply Forall_forall with (l := xs).
    assert (H0 : forall x : A, In x (x0 :: xs) -> P x).
    apply Forall_forall with (P := P) (l := x0 :: xs).
    exact H.
    assert (H1 : forall (x : A) (H2 : In x xs), P x).
    intros x H2.
    apply (H0 x).
    right.
    exact H2.
    intros x H2.
    apply (H1 x H2).
  Qed.

  Theorem Exists_impl
    :  forall (P Q : A -> Prop), (forall x : A, P x -> Q x) -> forall xs : list A, Exists P xs -> Exists Q xs.
  Proof.
    intros P Q H xs H0.
    induction H0.
    apply (Exists_cons_hd Q x l (H x H0)).
    apply (Exists_cons_tl x IHExists).
  Qed.

  Lemma Forall_Exists_neg (P:A->Prop)(l:list A) :
   Forall (fun x => ~ P x) l <-> ~(Exists P l).
  Proof.
   rewrite Forall_forall, Exists_exists. firstorder.
  Qed.

  Lemma Exists_Forall_neg (P:A->Prop)(l:list A) :
    (forall x, P x \/ ~P x) ->
    Exists (fun x => ~ P x) l <-> ~(Forall P l).
  Proof.
   intro Dec.
   split.
   - rewrite Forall_forall, Exists_exists; firstorder.
   - intros NF.
     induction l as [|a l IH].
     + destruct NF. constructor.
     + destruct (Dec a) as [Ha|Ha].
       * apply Exists_cons_tl, IH. contradict NF. now constructor.
       * now apply Exists_cons_hd.
  Qed.

  Lemma neg_Forall_Exists_neg (P:A->Prop) (l:list A) :
    (forall x:A, {P x} + { ~ P x }) ->
    ~ Forall P l ->
    Exists (fun x => ~ P x) l.
  Proof.
    intro Dec.
    apply Exists_Forall_neg; intros.
    destruct (Dec x); auto.
  Qed.

  Lemma Forall_Exists_dec (P:A->Prop) :
    (forall x:A, {P x} + { ~ P x }) ->
    forall l:list A,
    {Forall P l} + {Exists (fun x => ~ P x) l}.
  Proof.
    intros Pdec l.
    destruct (Forall_dec P Pdec l); [left|right]; trivial.
    now apply neg_Forall_Exists_neg.
  Defined.

  Lemma Forall_impl : forall (P Q : A -> Prop), (forall a, P a -> Q a) ->
    forall l, Forall P l -> Forall Q l.
  Proof.
    intros P Q H l. rewrite !Forall_forall. firstorder.
  Qed.

End Exists_Forall.

Hint Constructors Exists : core.
Hint Constructors Forall : core.

Section Forall2.

  (** [Forall2]: stating that elements of two lists are pairwise related. *)

  Variables A B : Type.
  Variable R : A -> B -> Prop.

  Inductive Forall2 : list A -> list B -> Prop :=
    | Forall2_nil : Forall2 [] []
    | Forall2_cons : forall x y l l',
      R x y -> Forall2 l l' -> Forall2 (x::l) (y::l').

  Hint Constructors Forall2 : core.

  Theorem Forall2_refl : Forall2 [] [].
  Proof. intros; apply Forall2_nil. Qed.

  Theorem Forall2_app_inv_l : forall l1 l2 l',
    Forall2 (l1 ++ l2) l' ->
    exists l1' l2', Forall2 l1 l1' /\ Forall2 l2 l2' /\ l' = l1' ++ l2'.
  Proof.
    induction l1; intros.
      exists [], l'; auto.
      simpl in H; inversion H; subst; clear H.
      apply IHl1 in H4 as (l1' & l2' & Hl1 & Hl2 & ->).
      exists (y::l1'), l2'; simpl; auto.
  Qed.

  Theorem Forall2_app_inv_r : forall l1' l2' l,
    Forall2 l (l1' ++ l2') ->
    exists l1 l2, Forall2 l1 l1' /\ Forall2 l2 l2' /\ l = l1 ++ l2.
  Proof.
    induction l1'; intros.
      exists [], l; auto.
      simpl in H; inversion H; subst; clear H.
      apply IHl1' in H4 as (l1 & l2 & Hl1 & Hl2 & ->).
      exists (x::l1), l2; simpl; auto.
  Qed.

  Theorem Forall2_app : forall l1 l2 l1' l2',
    Forall2 l1 l1' -> Forall2 l2 l2' -> Forall2 (l1 ++ l2) (l1' ++ l2').
  Proof.
    intros. induction l1 in l1', H, H0 |- *; inversion H; subst; simpl; auto.
  Qed.
End Forall2.

Hint Constructors Forall2 : core.

Section ForallPairs.

  (** [ForallPairs] : specifies that a certain relation should
    always hold when inspecting all possible pairs of elements of a list. *)

  Variable A : Type.
  Variable R : A -> A -> Prop.

  Definition ForallPairs l :=
    forall a b, In a l -> In b l -> R a b.

  (** [ForallOrdPairs] : we still check a relation over all pairs
     of elements of a list, but now the order of elements matters. *)

  Inductive ForallOrdPairs : list A -> Prop :=
    | FOP_nil : ForallOrdPairs nil
    | FOP_cons : forall a l,
      Forall (R a) l -> ForallOrdPairs l -> ForallOrdPairs (a::l).

  Hint Constructors ForallOrdPairs : core.

  Lemma ForallOrdPairs_In : forall l,
    ForallOrdPairs l ->
    forall x y, In x l -> In y l -> x=y \/ R x y \/ R y x.
  Proof.
    induction 1.
    inversion 1.
    simpl; destruct 1; destruct 1; subst; auto.
    right; left. apply -> Forall_forall; eauto.
    right; right. apply -> Forall_forall; eauto.
  Qed.

  (** [ForallPairs] implies [ForallOrdPairs]. The reverse implication is true
    only when [R] is symmetric and reflexive. *)

  Lemma ForallPairs_ForallOrdPairs l: ForallPairs l -> ForallOrdPairs l.
  Proof.
    induction l; auto. intros H.
    constructor.
    apply <- Forall_forall. intros; apply H; simpl; auto.
    apply IHl. red; intros; apply H; simpl; auto.
  Qed.

  Lemma ForallOrdPairs_ForallPairs :
    (forall x, R x x) ->
    (forall x y, R x y -> R y x) ->
    forall l, ForallOrdPairs l -> ForallPairs l.
  Proof.
    intros Refl Sym l Hl x y Hx Hy.
    destruct (ForallOrdPairs_In Hl _ _ Hx Hy); subst; intuition.
  Qed.
End ForallPairs.

(** * Inversion of predicates over lists based on head symbol *)

Ltac is_list_constr c :=
 match c with
  | nil => idtac
  | (_::_) => idtac
  | _ => fail
 end.

Ltac invlist f :=
 match goal with
  | H:f ?l |- _ => is_list_constr l; inversion_clear H; invlist f
  | H:f _ ?l |- _ => is_list_constr l; inversion_clear H; invlist f
  | H:f _ _ ?l |- _ => is_list_constr l; inversion_clear H; invlist f
  | H:f _ _ _ ?l |- _ => is_list_constr l; inversion_clear H; invlist f
  | H:f _ _ _ _ ?l |- _ => is_list_constr l; inversion_clear H; invlist f
  | _ => idtac
 end.



(** * Exporting hints and tactics *)


Hint Rewrite
  rev_involutive (* rev (rev l) = l *)
  rev_unit (* rev (l ++ a :: nil) = a :: rev l *)
  map_nth (* nth n (map f l) (f d) = f (nth n l d) *)
  map_length (* length (map f l) = length l *)
  seq_length (* length (seq start len) = len *)
  app_length (* length (l ++ l') = length l + length l' *)
  rev_length (* length (rev l) = length l *)
  app_nil_r (* l ++ nil = l *)
  : list.

Ltac simpl_list := autorewrite with list.
Ltac ssimpl_list := autorewrite with list using simpl.

(* begin hide *)
(* Compatibility notations after the migration of [list] to [Datatypes] *)
Notation list := list (only parsing).
Notation list_rect := list_rect (only parsing).
Notation list_rec := list_rec (only parsing).
Notation list_ind := list_ind (only parsing).
Notation nil := nil (only parsing).
Notation cons := cons (only parsing).
Notation length := length (only parsing).
Notation app := app (only parsing).
(* Compatibility Names *)
Notation tail := tl (only parsing).
Notation head := hd_error (only parsing).
Notation head_nil := hd_error_nil (only parsing).
Notation head_cons := hd_error_cons (only parsing).
Notation ass_app := app_assoc (only parsing).
Notation app_ass := app_assoc_reverse (only parsing).
Notation In_split := in_split (only parsing).
Notation In_rev := in_rev (only parsing).
Notation In_dec := in_dec (only parsing).
Notation distr_rev := rev_app_distr (only parsing).
Notation rev_acc := rev_append (only parsing).
Notation rev_acc_rev := rev_append_rev (only parsing).
Notation AllS := Forall (only parsing). (* was formerly in TheoryList *)

Hint Resolve app_nil_end : datatypes.
(* end hide *)

Section Repeat.

  Variable A : Type.
  Fixpoint repeat (x : A) (n: nat ) :=
    match n with
      | O => []
      | S k => x::(repeat x k)
    end.

  Theorem repeat_length x n:
    length (repeat x n) = n.
  Proof.
    induction n as [| k Hrec]; simpl; rewrite ?Hrec; reflexivity.
  Qed.

  Theorem repeat_spec n x y:
    In y (repeat x n) -> y=x.
  Proof.
    induction n as [|k Hrec]; simpl; destruct 1; auto.
  Qed.

End Repeat.

(* Unset Universe Polymorphism. *)
