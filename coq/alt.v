
  (* In this Coq file, we will construct lists, natural numbers from lists, and prove a few things about naturals *)

  Require Export XD.Definitions.
  Require Export XD.Technical.
  Require Export XD.List.
  Require Export XD.Naturals.

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


  Definition Z_plus_p (x y : PairOf T) : (PairOf T) := match x, y with
  | pair xf xs, pair yf ys => pair (plus xf yf) (plus xs ys)
  end.

  Lemma Z_plus_p_comm : commutative Z_plus_p.
  Proof.
    red. intros x y.
    destruct x as [xf xs];
    destruct y as [yf ys].
    simpl.
    rewrite (plus_comm yf).
    rewrite (plus_comm ys).
    reflexivity.
  Qed.

  Lemma Z_plus_p_assoc : associative Z_plus_p.
  Proof.
    red.
    intros x y z.
    destruct x as [xf xs].
    destruct y as [yf ys].
    destruct z as [zf zs].
    unfold Z_plus_p.
    repeat rewrite plus_assoc.
    reflexivity.
  Qed.


  Definition makeZ (x : PairOf T) := exist _ (Z_representative x) (Z_representative_ok x).

  Definition Z_plus (x y : Z) : Z :=
    let (xp, hx) := x in
    let (yp, hy) := y in
    makeZ (Z_plus_p xp yp).

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
    apply f_eq.
    rewrite Z_plus_p_comm.
    reflexivity.
  Qed.

  Lemma Z_plus_repr : forall x y, Z_representative (Z_plus_p x y) = Z_representative (Z_plus_p x (Z_representative y)).
  Proof.
    intros [xf xs] [ys yf].
    unfold Z_representative. unfold Z_plus_p.
    destruct (eq_dec (min (plus xf ys) (plus xs yf)) (plus xf ys)).
    {
      symmetry in e.
      apply min_le_n in e.
      destruct (eq_dec (min ys yf) ys).
      {
        symmetry in e0.
        apply min_le_n in e0.
        rewrite plus_zero_r.
        apply le_n_nmk in e0. destruct e0.
        subst yf.
        rewrite (plus_comm ys) in e.
        rewrite <- plus_assoc in e.
        apply le_n_plus_r in e.
        rewrite (plus_comm ys).
        rewrite minus_plus_nmm.
        apply le_n_nmk in e. destruct e.
        rewrite <- plus_assoc.
        rewrite <- H.
        rewrite (plus_comm xf).
        rewrite plus_assoc.
        rewrite minus_plus_nmm.
        rewrite minus_plus_nmm.
        rewrite (minus_comm xf).
        rewrite minus_plus_nmm.
        destruct (eq_dec (min xf (plus x0 xf)) xf).
        { reflexivity. }
        {
          apply min_neq_le in n.
          apply le_n_plus_l_zero in n.
          subst x0. reflexivity.
        }
      }
      {
        apply min_neq_le in n.
        rewrite plus_zero_r.
        apply le_n_nmk in n. destruct n. subst ys.
        rename xf into a.
        rename xs into b.
        rename yf into c.
        rename x into d.
        rewrite (plus_comm c) in e.
        rewrite <- plus_assoc in e.
        apply le_n_plus_r in e.
        rewrite (plus_comm c).
        rewrite minus_plus_nmm.
        destruct (eq_dec (min (plus a d) b) (plus a d)).
        {
          symmetry in e0. apply min_le_n in e0. clear e0.
          f_equal.
          apply le_n_nmk in e. destruct e. subst b.
          rewrite (plus_comm _ x).
          repeat rewrite plus_assoc.
          rewrite minus_plus_nmm.
          rewrite minus_plus_nmm.
          reflexivity.
        }
        {
          apply min_neq_le in n.
          assert(heq:=le_n_antisym).
          specialize (heq _ _ e n).
          clear e n. subst b.
          repeat rewrite plus_assoc.
          rewrite minus_n.
          rewrite minus_n.
          reflexivity.
        }
      }
    }
    {
      rename xf into a.
      rename xs into b.
      rename ys into c.
      rename yf into d.
      apply min_neq_le in n.
      destruct (eq_dec (min c d) c).
      {
        symmetry in e. apply min_le_n in e.
        apply le_n_nmk in e. destruct e. subst d.
        rewrite (plus_comm c) in n. rewrite <- plus_assoc in n.
        apply le_n_plus_r in n.
        rewrite plus_zero_r.
        rewrite (plus_comm c).
        rewrite minus_plus_nmm.
        destruct (eq_dec (min a (plus b x)) a).
        {
          symmetry in e. apply min_le_n in e.
          assert(heq:=le_n_antisym).
          specialize (heq _ _ n e).
          clear n e. subst a.
          repeat rewrite plus_assoc.
          rewrite minus_n.
          rewrite minus_n.
          reflexivity.
        }
        {
          apply min_neq_le in n0. clear n0.
          f_equal.
          apply le_n_nmk in n. destruct n. subst a.
          rewrite (plus_comm _ x0).
          repeat rewrite plus_assoc.
          rewrite minus_plus_nmm.
          rewrite minus_plus_nmm.
          reflexivity.
        }
      }
      {
        apply min_neq_le in n0.
        apply le_n_nmk in n0.
        destruct n0. subst c.
        rewrite plus_zero_r.
        rewrite (plus_comm d). rewrite minus_plus_nmm.
        destruct (eq_dec (min (plus a x) b) (plus a x)).
        {
          symmetry in e. apply min_le_n in e.
          apply le_n_nmk in e. destruct e. subst b.
          rewrite minus_comm.
          repeat rewrite plus_assoc.
          rewrite (plus_comm x0).
          repeat rewrite <- plus_assoc.
          rewrite (plus_comm _ x0).
          rewrite plus_assoc. rewrite minus_plus_nmm.
          rewrite (plus_comm _ x0).
          rewrite minus_plus_nmm.
          rewrite (plus_comm d) in n.
          repeat rewrite <- plus_assoc in n.
          apply le_n_plus_r in n.
          rewrite plus_assoc in n.
          apply le_n_plus_l in n.
          rewrite plus_comm in n.
          apply le_n_plus_l_zero in n.
          subst x0.
          reflexivity.
        }
        {
          apply min_neq_le in n0.
          clear n.
          apply le_n_nmk in n0. destruct n0.
          rewrite <- plus_assoc. rewrite <- H. rewrite (plus_comm _ x0). repeat rewrite plus_assoc.
          rewrite minus_plus_nmm.
          rewrite minus_plus_nmm.
          reflexivity.
        }
      }
    }
  Qed.


  Lemma Z_plus_assoc : forall x y z:Z, Z_plus (Z_plus x y) z = Z_plus x (Z_plus y z).
  Proof.
    intros x y z.
    destruct x as [x hx];
    destruct y as [y hy];
    destruct z as [z hz].
    unfold Z_plus.
    apply proof_irrelevance.
    simpl.
    rewrite <- Z_plus_repr.
    rewrite (Z_plus_p_comm (Z_representative _)).
    rewrite <- Z_plus_repr.
    rewrite (Z_plus_p_comm z).
    rewrite Z_plus_p_assoc.
    reflexivity.
  Qed.

































