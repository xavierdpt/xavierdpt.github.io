
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

  Definition ZRel (x y:PairOf NN) := Nplus (first x) (second y) = Nplus (second x) (first y).


  Theorem ZRel_equivalence : equivalence ZRel.
  Proof.
    red.
    split.
    (* reflexivity *)
    {
      red.
      intro x.
      red.
      rewrite Nplus_comm.
      reflexivity.
    }
    split.
    (* symmetry *)
    {
      red.
      intros x y h.
      red.
      red in h.
      rewrite (Nplus_comm (second y)).
      rewrite h.
      rewrite (Nplus_comm (second x)).
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
      apply Nplus_elim_l with sy.
      repeat rewrite <- Nplus_assoc.
      rewrite (Nplus_comm sy).
      rewrite hxy.
      clear hxy.
      rewrite Nplus_assoc.
      rewrite hyz.
      clear hyz.
      rewrite <- Nplus_assoc.
      rewrite (Nplus_comm sx).
      reflexivity.
    }
  Qed.



  (* Membership condition for a class equivalence representative *)
  Definition ZCond p := first p = Nzero \/ second p = Nzero.
  (* Set of representatives *)
  Definition Z := { p | ZCond p }.

  (* We prove that all pairs of naturals are represented by at least one representative *)
  Lemma Z_representation : forall (p:PairOf NN), exists (z:Z), ZRel p (proj1_sig z).
  Proof.
    (* We work on that pair *)
    intro p.
    (* It's made of two parts *)
    destruct p as [pf ps].
    (* Let's recall what ZRel is *)
    unfold ZRel.
    simpl.
    (* We'll proceed by induction over pf *)
    pattern pf;apply Ninduction;clear pf.
    (* Base case: pf = 0 *)
    {
      (* The representative is (0,ps) *)
      set(zp:=pair Nzero ps).
      (* Proving that it satisfies the representative condition is simple *)
      assert(zh:ZCond zp).
      { red. left. simpl. reflexivity. }
      (* So here it comes *)
      exists (exist _ zp zh).
      (* We just need some cleanup, then use proof irrelevance to prove equality *)
      subst zp.
      simpl.
      rewrite Nplus_zero_r.
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
      assert (tech:exists zf':NN, zf'=zf).
      { exists zf. reflexivity. }
      destruct tech as [zf' heq].
      subst zf.

      assert (tech:exists zs':NN, zs'=zs).
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
        assert(hzs:=Ndestruct zs).
        destruct hzs as [ hzs | hzs ].
        (* zs = 0 *)
        {
          subst zs.
          rewrite Nplus_zero_r in ih.
          subst pf'.
          subst zf.
          (* Answer is (1,0) *)
          set(zp:=pair None Nzero).
          assert (zh:ZCond zp).
          { red. simpl. right. reflexivity. }
          exists (exist _ zp zh).        
          rewrite Nplus_zero_r.
          rewrite Nplus_zero_r.
          subst zp.
          unfold proj1_sig.
          unfold first, second.
          rewrite Nnext_eq.
          reflexivity.
        }
        (* zs is not 0 *)
        {
          destruct hzs as [zs' heq].
          subst zs.
          subst zf.
          rewrite Nplus_zero_r in ih.
          subst ps.
          (* answer is (0, pred(zs)) *)
          set(zp:=pair Nzero zs').
          assert (zh:ZCond zp).
          { red. simpl. left. reflexivity. }
          exists (exist _ zp zh).
          unfold proj1_sig.
          subst zp.
          unfold second.
          unfold first.
          rewrite Nplus_zero_r.
          repeat rewrite Nnext_eq.
          repeat rewrite Nplus_assoc.
          apply feq_l.
          rewrite Nplus_comm.
          reflexivity.
        }
      }
      (* zs = 0 *)
      {
        subst zs.
        rewrite Nplus_zero_r in ih.
        subst pf'.
        (* answer is (zf+1,0) *)
        set(zp:=pair (Nnext zf) Nzero).
        assert (zh:ZCond zp).
        { red. simpl. right. reflexivity. }
        exists (exist _ zp zh).
        subst zp.
        unfold proj1_sig, first, second.
        rewrite Nplus_zero_r.
        repeat rewrite Nnext_eq.
        repeat rewrite Nplus_assoc.
        reflexivity.
      }
    }
  Qed.

  Definition Z_representative (p:PairOf NN) :=
    match p with
    | pair pf ps => let m := Nmin pf ps in
      match (Neq_dec m pf) with
      | left _ => pair Nzero (Nrest ps pf)
      | right _ => pair (Nrest pf ps) Nzero
      end
    end.

  Lemma Z_representative_ok : forall (p:PairOf NN), ZCond (Z_representative p).
  Proof.
    intro p.
    destruct p as [pf ps].
    unfold ZCond.
    unfold Z_representative.
    pattern pf;apply Ninduction;clear pf.
    { rewrite Nmin_zero_l. rewrite Nrest_zero_r. rewrite Nrest_zero_l. simpl. left. reflexivity. }
    {
      intros pf' ih.
      destruct (Ndestruct ps).
      { subst ps. rewrite Nmin_zero_r. rewrite Nrest_zero_l. rewrite Nrest_zero_r. simpl. right. reflexivity. }
      { destruct H. subst ps. rename x into ps'.
        rewrite Nmin_next. rewrite Nrest_next. rewrite Nrest_next.
        destruct (Neq_dec (Nnext (Nmin pf' ps')) (Nnext pf')).
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
    assert(tech:exists techtmp:NN,techtmp=xf). exists xf. reflexivity.
    destruct tech as [techtmp techeq]. subst xf. rename techtmp into xf.

    assert(tech:exists techtmp:NN,techtmp=xs). exists xs. reflexivity.
    destruct tech as [techtmp techeq]. subst xs. rename techtmp into xs.

    assert(tech:exists techtmp:NN,techtmp=yf). exists yf. reflexivity.
    destruct tech as [techtmp techeq]. subst yf. rename techtmp into yf.

    assert(tech:exists techtmp:NN,techtmp=ys). exists ys. reflexivity.
    destruct tech as [techtmp techeq]. subst ys. rename techtmp into ys.
    (* End technical *)

    unfold ZRel in heqv.
    unfold proj1_sig, first, second in heqv.
    simpl.
    unfold ZCond in hx, hy.
    unfold first, second in hx, hy.
    destruct hx as [ hx | hx ];
    destruct hy as [ hy | hy ].
    { subst xf. subst yf. rewrite Nplus_zero_l in heqv. rewrite Nplus_zero_r in heqv. subst ys. reflexivity. }
    { subst xf. subst ys. rewrite Nplus_zero_l in heqv. symmetry in heqv.
      apply Nplus_zero in heqv. destruct heqv as [hx hy]. subst xs. subst yf. reflexivity.
    }
    { subst xs. subst yf. rewrite Nplus_zero_r in heqv.
      apply Nplus_zero in heqv. destruct heqv as [hx hy]. subst xf. subst ys. reflexivity.
    }
    { subst xs. subst ys. rewrite Nplus_zero_l in heqv. rewrite Nplus_zero_r in heqv. subst yf. reflexivity. }
  Qed.

  (* TODO : Bind ZRel_equivalence, Z_representation and Z_uniqueness in a single lemma that states
     that Z defines a partitions on equivalences classes *)


  Definition Z_plus_p (x y : PairOf NN) : (PairOf NN) := match x, y with
  | pair xf xs, pair yf ys => pair (Nplus xf yf) (Nplus xs ys)
  end.

  Lemma Z_plus_p_comm : commutative Z_plus_p.
  Proof.
    red. intros x y.
    destruct x as [xf xs];
    destruct y as [yf ys].
    simpl.
    rewrite (Nplus_comm yf).
    rewrite (Nplus_comm ys).
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
    repeat rewrite Nplus_assoc.
    reflexivity.
  Qed.


  Definition makeZ (x : PairOf NN) := exist _ (Z_representative x) (Z_representative_ok x).

  Definition Z_plus (x y : Z) : Z :=
    let (xp, hx) := x in
    let (yp, hy) := y in
    makeZ (Z_plus_p xp yp).

  Lemma zero_Zh : ZCond (pair Nzero Nzero).
  Proof.
    unfold ZCond. left. simpl. reflexivity.
  Qed.

  Definition zero_Z := exist _ (pair Nzero Nzero) zero_Zh.

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
    rewrite Nplus_zero_r.
    rewrite Nplus_zero_r.
    destruct hx as [ hx | hx ].
    { subst xf. rewrite Nmin_zero_l. rewrite Nrest_zero_r. rewrite Nrest_zero_l. simpl. reflexivity. }
    { subst xs. rewrite Nmin_zero_r. rewrite Nrest_zero_l. rewrite Nrest_zero_r.
      destruct (Neq_dec Nzero xf).
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
        { apply proof_irrelevance. simpl. unfold _Nzero. reflexivity. }
        { apply proof_irrelevance. simpl. unfold _Nzero. reflexivity. }
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
    destruct (Neq_dec (Nmin (Nplus xf ys) (Nplus xs yf)) (Nplus xf ys)).
    {
      symmetry in e.
      apply Nmin_le in e.
      destruct (Neq_dec (Nmin ys yf) ys).
      {
        symmetry in e0.
        apply Nmin_le in e0.
        rewrite Nplus_zero_r.
        apply Nle_nmk in e0. destruct e0.
        subst yf.
        rewrite (Nplus_comm ys) in e.
        rewrite <- Nplus_assoc in e.
        apply le_n_plus_r in e.
        rewrite (Nplus_comm ys).
        rewrite Nrest_plus_nmm.
        apply Nle_nmk in e. destruct e.
        rewrite <- Nplus_assoc.
        rewrite <- H.
        rewrite (Nplus_comm xf).
        rewrite Nplus_assoc.
        rewrite Nrest_plus_nmm.
        rewrite Nrest_plus_nmm.
        rewrite (Nrest_comm xf).
        rewrite Nrest_plus_nmm.
        destruct (Neq_dec (Nmin xf (Nplus x0 xf)) xf).
        { reflexivity. }
        {
          apply Nmin_neq_le in n.
          apply le_n_plus_l_zero in n.
          subst x0. reflexivity.
        }
      }
      {
        apply Nmin_neq_le in n.
        rewrite Nplus_zero_r.
        apply Nle_nmk in n. destruct n. subst ys.
        rename xf into a.
        rename xs into b.
        rename yf into c.
        rename x into d.
        rewrite (Nplus_comm c) in e.
        rewrite <- Nplus_assoc in e.
        apply le_n_plus_r in e.
        rewrite (Nplus_comm c).
        rewrite Nrest_plus_nmm.
        destruct (Neq_dec (Nmin (Nplus a d) b) (Nplus a d)).
        {
          symmetry in e0. apply Nmin_le in e0. clear e0.
          f_equal.
          apply Nle_nmk in e. destruct e. subst b.
          rewrite (Nplus_comm _ x).
          repeat rewrite Nplus_assoc.
          rewrite Nrest_plus_nmm.
          rewrite Nrest_plus_nmm.
          reflexivity.
        }
        {
          apply Nmin_neq_le in n.
          assert(heq:=Nle_antisym).
          specialize (heq _ _ e n).
          clear e n. subst b.
          repeat rewrite Nplus_assoc.
          rewrite Nrest_cancel.
          rewrite Nrest_cancel.
          reflexivity.
        }
      }
    }
    {
      rename xf into a.
      rename xs into b.
      rename ys into c.
      rename yf into d.
      apply Nmin_neq_le in n.
      destruct (Neq_dec (Nmin c d) c).
      {
        symmetry in e. apply Nmin_le in e.
        apply Nle_nmk in e. destruct e. subst d.
        rewrite (Nplus_comm c) in n. rewrite <- Nplus_assoc in n.
        apply le_n_plus_r in n.
        rewrite Nplus_zero_r.
        rewrite (Nplus_comm c).
        rewrite Nrest_plus_nmm.
        destruct (Neq_dec (Nmin a (Nplus b x)) a).
        {
          symmetry in e. apply Nmin_le in e.
          assert(heq:=Nle_antisym).
          specialize (heq _ _ n e).
          clear n e. subst a.
          repeat rewrite Nplus_assoc.
          rewrite Nrest_cancel.
          rewrite Nrest_cancel.
          reflexivity.
        }
        {
          apply Nmin_neq_le in n0. clear n0.
          f_equal.
          apply Nle_nmk in n. destruct n. subst a.
          rewrite (Nplus_comm _ x0).
          repeat rewrite Nplus_assoc.
          rewrite Nrest_plus_nmm.
          rewrite Nrest_plus_nmm.
          reflexivity.
        }
      }
      {
        apply Nmin_neq_le in n0.
        apply Nle_nmk in n0.
        destruct n0. subst c.
        rewrite Nplus_zero_r.
        rewrite (Nplus_comm d). rewrite Nrest_plus_nmm.
        destruct (Neq_dec (Nmin (Nplus a x) b) (Nplus a x)).
        {
          symmetry in e. apply Nmin_le in e.
          apply Nle_nmk in e. destruct e. subst b.
          rewrite Nrest_comm.
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm x0).
          repeat rewrite <- Nplus_assoc.
          rewrite (Nplus_comm _ x0).
          rewrite Nplus_assoc. rewrite Nrest_plus_nmm.
          rewrite (Nplus_comm _ x0).
          rewrite Nrest_plus_nmm.
          rewrite (Nplus_comm d) in n.
          repeat rewrite <- Nplus_assoc in n.
          apply le_n_plus_r in n.
          rewrite Nplus_assoc in n.
          apply le_n_plus_l in n.
          rewrite Nplus_comm in n.
          apply le_n_plus_l_zero in n.
          subst x0.
          reflexivity.
        }
        {
          apply Nmin_neq_le in n0.
          clear n.
          apply Nle_nmk in n0. destruct n0.
          rewrite <- Nplus_assoc. rewrite <- H. rewrite (Nplus_comm _ x0). repeat rewrite Nplus_assoc.
          rewrite Nrest_plus_nmm.
          rewrite Nrest_plus_nmm.
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

































