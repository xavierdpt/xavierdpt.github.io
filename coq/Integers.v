
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

  Definition _ZRel (x y:PairOf NN) := Nplus (first x) (second y) = Nplus (second x) (first y).


  Theorem _ZRel_equivalence : equivalence _ZRel.
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
      unfold _ZRel.
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
  Definition _ZCond p := first p = Nzero \/ second p = Nzero.
  (* Set of representatives *)
  Definition ZZ := { p | _ZCond p }.

  (* We prove that all pairs of naturals are represented by at least one representative *)
  Lemma _Z_representation : forall (p:PairOf NN), exists (z:ZZ), _ZRel p (proj1_sig z).
  Proof.
    (* We work on that pair *)
    intro p.
    (* It's made of two parts *)
    destruct p as [pf ps].
    (* Let's recall what ZRel is *)
    unfold _ZRel.
    simpl.
    (* We'll proceed by induction over pf *)
    pattern pf;apply Ninduction;clear pf.
    (* Base case: pf = 0 *)
    {
      (* The representative is (0,ps) *)
      set(zp:=pair Nzero ps).
      (* Proving that it satisfies the representative condition is simple *)
      assert(zh:_ZCond zp).
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
          assert (zh:_ZCond zp).
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
          assert (zh:_ZCond zp).
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
        assert (zh:_ZCond zp).
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

  Definition _Z_representative (p:PairOf NN) :=
    match p with
    | pair pf ps => let m := Nmin pf ps in
      match (Neq_dec m pf) with
      | left _ => pair Nzero (Nrest ps pf)
      | right _ => pair (Nrest pf ps) Nzero
      end
    end.

  Lemma _Z_representative_ok : forall (p:PairOf NN), _ZCond (_Z_representative p).
  Proof.
    intro p.
    destruct p as [pf ps].
    unfold _ZCond.
    unfold _Z_representative.
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

  Lemma _Z_uniqueness : forall (zx zy:ZZ),
    let zxp := proj1_sig zx in
    let zyp := proj1_sig zy in
    _ZRel zxp zyp -> zxp = zyp.
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

    unfold _ZRel in heqv.
    unfold proj1_sig, first, second in heqv.
    simpl.
    unfold _ZCond in hx, hy.
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


  Definition _Zplus (x y : PairOf NN) : (PairOf NN) := match x, y with
  | pair xf xs, pair yf ys => pair (Nplus xf yf) (Nplus xs ys)
  end.

  Lemma _Zplus_comm : commutative _Zplus.
  Proof.
    red. intros x y.
    destruct x as [xf xs];
    destruct y as [yf ys].
    simpl.
    rewrite (Nplus_comm yf).
    rewrite (Nplus_comm ys).
    reflexivity.
  Qed.

  Lemma _Zplus_assoc : associative _Zplus.
  Proof.
    red.
    intros x y z.
    destruct x as [xf xs].
    destruct y as [yf ys].
    destruct z as [zf zs].
    unfold _Zplus.
    repeat rewrite Nplus_assoc.
    reflexivity.
  Qed.


  Definition Zmake (x : PairOf NN) := exist _ (_Z_representative x) (_Z_representative_ok x).

  Definition Zplus (x y : ZZ) : ZZ :=
    let (xp, hx) := x in
    let (yp, hy) := y in
    Zmake (_Zplus xp yp).

  Lemma _Zzero_ok : _ZCond (pair Nzero Nzero).
  Proof.
    unfold _ZCond. simpl. left. reflexivity.
  Qed.

  Lemma _Zone_ok : _ZCond (pair Nzero None).
  Proof.
    unfold _ZCond. simpl. left. reflexivity.
  Qed.

  Lemma _Zone_opp_ok : _ZCond (pair None Nzero).
  Proof.
    unfold _ZCond. simpl. right. reflexivity.
  Qed.

  Definition Zzero := exist _ (pair Nzero Nzero) _Zzero_ok.
  Definition Zone := exist _ (pair Nzero None) _Zone_ok.
  Definition Zone_opp := exist _ (pair None Nzero) _Zone_opp_ok.



  Lemma Zplus_zero_l : forall x:ZZ, Zplus x Zzero = x.
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

  Lemma Zplus_zero_r : forall x:ZZ, Zplus Zzero x = x.
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

  Lemma Zplus_comm : forall x y, Zplus x y = Zplus y x.
  Proof.
    intros (x,hx) (y,hy).
    apply proof_irrelevance.
    simpl.
    apply f_eq.
    rewrite _Zplus_comm.
    reflexivity.
  Qed.

  Lemma _Zplus_repr : forall x y, _Z_representative (_Zplus x y) = _Z_representative (_Zplus x (_Z_representative y)).
  Proof.
    intros [xf xs] [ys yf].
    unfold _Z_representative. unfold _Zplus.
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


  Lemma Z_plus_assoc : forall x y z:ZZ, Zplus (Zplus x y) z = Zplus x (Zplus y z).
  Proof.
    intros x y z.
    destruct x as [x hx];
    destruct y as [y hy];
    destruct z as [z hz].
    unfold Zplus.
    apply proof_irrelevance.
    simpl.
    rewrite <- _Zplus_repr.
    rewrite (_Zplus_comm (_Z_representative _)).
    rewrite <- _Zplus_repr.
    rewrite (_Zplus_comm z).
    rewrite _Zplus_assoc.
    reflexivity.
  Qed.

  Lemma Zplus_one_opp : Zplus Zone Zone_opp = Zzero.
  Proof.
    destruct Zone as [x hx] eqn:heqx.
    destruct Zone_opp as [y hy] eqn:heqy.
    destruct Zzero as [z hz] eqn:heqz.
    destruct x as [xf xs] eqn:heqxp.
    destruct y as [yf ys] eqn:heqyp.
    destruct z as [zf zs] eqn:heqzp.
    apply proof_irrelevance.
    simpl.
    remember (Neq_dec _ _) as d eqn:heqd.
    unfold Zone, Zone_opp, Zzero in heqx, heqy, heqz.
    inversion heqx;inversion heqy;inversion heqz.
    subst xf xs yf ys zf zs.
    destruct d.
    { rewrite Nplus_zero_l. rewrite Nplus_zero_r. rewrite Nrest_cancel. reflexivity. }
    { rewrite Nplus_zero_l. rewrite Nplus_zero_r. rewrite Nrest_cancel. reflexivity. }
  Qed.

  (*
    Let P be a predicate on the integers.
    If P is hold for 0,
      and for any z, when P holds for z, then P holds for z+1
      and for any z, when P holds for z, then P holds for z-1
    then P holds for any z
  *)
  Lemma Zinduction : forall (P:ZZ->Prop),
    (P Zzero) ->
    (forall z, P z -> P (Zplus z Zone)) ->
    (forall z, P z -> P (Zplus z Zone_opp)) ->
    forall z, P z.
  Proof.
    (* The predicate *)
    intros P.
    (* Predicate is true for zero *)
    intro hz.
    (* P z -> P (z+1) *)
    intro hip.
    (* P z -> P (z-1) *)
    intro him.
    (* We want to prove that P applies to any z, such as that one *)
    intro z.
    (* z consists of a pair of natural numbers with a proof that it is a representative of its equivalence class *)
    destruct z as [x hx] eqn:heqz.
    (* Here's the condition *)
    unfold _ZCond in hx.
    (* The pair itself is made of two natural integers *)
    destruct x as [xf xs ] eqn:heqx.
    (* The condition is more readable now *)
    simpl in hx.
    (* We can look at the two possibilites *)
    destruct hx as [hx|hx].
    (* Here's when the left number is zero *)
    {
      subst xf.
      (* We fold z to ease proving what z is equal to later *)
      rewrite <- heqz.
      (* Some renaming *)
      rename z into xz.
      rename x into xp.
      rename xs into x.
      rename heqx into heqxp.
      rename heqz into heqxz.
      (* Prepare the induction *)
      generalize dependent x. intro x.
      generalize dependent xp.
      generalize dependent xz.
      (* We're doing induction on x *)
      pattern x;apply Ninduction; clear x.
      (* x = 0 *)
      {
        intros.
        (* To prove that xz is equal to Zzero, we have to deal with proof irrelevance *)
        assert (H:xz = Zzero).
        {
          (* Unfold the values *)
          subst xz. unfold Zzero.
          (*
            Apply proof irrelevance to get rid of the hidden two proofs of the same thing.
            They are not shown, but they are there.
          *)
          apply proof_irrelevance.
          (* Simplify to focus on the payload *)
          simpl.
          (* And we have equality *)
          reflexivity.
        }
        (* We are now free to substitute xz with Zzero *)
        rewrite H.
        (* And that hz *)
        exact hz.
      }
      (* Induction case *)
      {
        (* x' and induction hypothesis *)
        intro x'.
        intro ih.
        (* We want to prove that P holds for (0, x' + 1) *)
        intro.
        intro.
        intro.
        intro.
        (* We will use hip, but will feed (0, x') to our induction hypothesis *)
        remember (pair Nzero x') as yp.
        (* yp is the representative of an equivalence class *)
        assert (hy:_ZCond yp).
        {
          (* The condition to be a representative is to have the left or the right of the pair at zero. *)
          unfold _ZCond.
          (* Substitute with the value and simplify *)
          rewrite Heqyp. simpl.
          (* And we can make that true *)
         left. reflexivity.
        }
        (* Now we can create the corresponding integer yz *)
        remember (exist _ yp hy) as yz.
        (* And we use that in our induction *)
        specialize (ih yz).
        specialize (ih yp).
        specialize (ih Heqyp).
        (* So by induction, P holds for (0, x'), we will give that to hip *)
        specialize (hip yz).
        (* Now we need to prove that xz = yz + 1, and that's messy *)
        assert (Zplus yz Zone = xz).
        {
          (* Start we some substitutions *)
          subst xz.
          subst yz.
          (* Unfold the value of Zone *)
          unfold Zone.
          (* Unfold some functions *)
          unfold Zplus.
          unfold _Zplus.
          (* Here we have a match, the correct thing to do is usually to break it intos its parts *)
          destruct yp.
          (* This introduced an equality in Heqyp, we can use it to retrieve the corresponding values *)
          inversion Heqyp.
          (* An substitute those *)
          subst s. subst n.
          (* Some easy rewriting *)
          rewrite Nplus_zero_l.
          (* Now we unfold the rest and get a big mess *)
          unfold Zmake.
          simpl.
          (* And we apply proof irrelevance on that mess *)
          apply proof_irrelevance.
          simpl.
          (* Some more rewriting *)
          rewrite Nmin_zero_l.
          (* Nice, Neq_dec should simplify now *)
          simpl.
          (* More rewriting *)
          rewrite Nrest_zero_r.
          rewrite Nnext_eq.
          (* And we have equality! *)
          reflexivity.
        }
        (* Now we can identify xz with yz + 1 *)
        rewrite <- H.
        (* apply hip to get to yz *)
        apply hip.
        (* apply ih to get to the equality requirement *)
        apply ih.
        (* and another round of proof irrelevance *)
        subst yz.
        subst yp.
        apply proof_irrelevance.
        simpl.
        (* And we have equality *)
        reflexivity.
      }
    }
    (* Here's when the right number is zero *)
    {
      (* It's almost an exact copy of the other case, but using 'him' instead of 'hip' *)
      subst xs.
      rewrite <- heqz.
      rename z into xz.
      rename x into xp.
      rename xf into x.
      rename heqx into heqxp.
      rename heqz into heqxz.
      generalize dependent x. intro x.
      generalize dependent xp.
      generalize dependent xz.
      (* Induction *)
      pattern x;apply Ninduction; clear x.
      (* x = zero *)
      {
        intros.
        assert (xz=Zzero).
        { subst xz. unfold Zzero. apply proof_irrelevance. simpl. reflexivity. }
        rewrite H. exact hz.
      }
      (* Induction case *)
      {
        intros x' ih.
        intros xz xp.
        intro heqxp.
        intro heqxz.
        clear hz hip.
        (* We're going to use (x', 0) here *)
        remember (pair x' Nzero) as yp.
        assert (hy:_ZCond yp).
        { unfold _ZCond. rewrite Heqyp. simpl. right. reflexivity. }
        remember (exist _ yp hy) as yz.
        specialize (ih yz).
        specialize (ih yp).
        specialize (ih Heqyp).
        specialize (him yz).
        (* Here we show that xz = yz + (-1) *)
        assert (xz = Zplus yz Zone_opp).
        {
          subst xz. subst yz. subst yp. unfold Zone_opp.
          unfold Zplus.
          unfold _Zplus.
          rewrite Nplus_zero_r.
          unfold Zmake.
          unfold _Z_representative.
          apply proof_irrelevance.
          simpl.
          rewrite Nmin_zero_r.
          (* This time, the Neq_dec does not simplify very easily *)
          destruct (Neq_dec Nzero (Nplus x' None)).
          {
            (* 0 = x' + 1 has no solution, so that's not the right branch *)
            rewrite <- Nnext_eq in e. inversion e.
          }
          {
            (* That's the right branch *)
            rewrite Nrest_zero_r. rewrite Nnext_eq. reflexivity.
          }
        }
        (* No we can complete this second part *)
        rewrite H. apply him.
        apply ih.
        subst yz. subst yp. apply proof_irrelevance. simpl. reflexivity.
      }
    }
  Qed.


  Definition _Zmult (x y : PairOf NN) : (PairOf NN) := match x, y with
  | pair xf xs, pair yf ys => pair
    (Nplus(Nmult xf yf) (Nmult xs ys))
    (Nplus(Nmult xf ys) (Nmult xs yf))
  end.

  Definition Zmult (x y : ZZ) : ZZ :=
    let (xp, hx) := x in
    let (yp, hy) := y in
    Zmake (_Zmult xp yp).

  Lemma _Zmult_comm : commutative _Zmult.
  Proof.
    red.
    intros x y.
    destruct x as [a b] eqn:heqx.
    destruct y as [c d] eqn:heqy.
    unfold _Zmult.
    f_equal.
    { rewrite (Nmult_comm c). rewrite (Nmult_comm d). reflexivity. }
    { rewrite (Nmult_comm c). rewrite (Nmult_comm d). rewrite Nplus_comm. reflexivity. }
  Qed.

  Lemma Zmult_comm : commutative Zmult.
  Proof.
    red.
    intros x.
    apply Zinduction.
    {
      unfold Zmult.
      apply proof_irrelevance.
      unfold _Zmult.
      destruct x as (xp, xph) eqn:heqx.
      destruct Zzero as (zp, zph) eqn:heqz.
      destruct xp as [xf xs] eqn:hexp.
      destruct zp as [zf zs] eqn:heqzp.
      inversion heqz.
      subst zf. subst zs.
      rewrite Nmult_zero_r.
      rewrite Nplus_zero_l.
      rewrite Nmult_zero_r.
      rewrite Nmult_zero_l.
      rewrite Nplus_zero_l.
      rewrite Nmult_zero_l.
      rewrite Nplus_zero_r.
      reflexivity.
    }
    {
      intros z h.
      unfold Zmult.
      apply proof_irrelevance.
      unfold Zplus.
      unfold _Zmult.
      unfold _Zplus.
      destruct x as (xp, xph) eqn:heqx.
      destruct z as (zp, zph) eqn:heqz.
      destruct Zone as (op, oph) eqn:heqo.
      destruct zp as [zpf zps] eqn:heqzp.
      destruct op as [opf ops] eqn:heqop.
      destruct xp as [xpf xps] eqn:heqxp.
      remember (Zmake (pair (Nplus zpf opf) (Nplus zps ops))) as u.
      destruct u as [up uh] eqn:hequ.
      destruct up as [upf ups] eqn:hequp.
      unfold _ZCond in *.
      simpl in xph, zph, oph, uh.
      rewrite (Nmult_comm upf).
      rewrite (Nmult_comm ups).
      rewrite (Nmult_comm upf).
      rename xpf into a.
      rename ups into b.
      rename xps into c.
      rename upf into d.
      rewrite (Nplus_comm (Nmult a b)).
      rewrite (Nmult_comm b).
      reflexivity.
    }
    {
      intros z h.
      unfold Zmult.
      apply proof_irrelevance.
      unfold Zplus.
      unfold _Zmult.
      unfold _Zplus.
      destruct x as (xp, xph) eqn:heqx.
      destruct z as (zp, zph) eqn:heqz.
      destruct Zone_opp as (op, oph) eqn:heqo.
      destruct zp as [zpf zps] eqn:heqzp.
      destruct op as [opf ops] eqn:heqop.
      destruct xp as [xpf xps] eqn:heqxp.
      remember (Zmake (pair (Nplus zpf opf) (Nplus zps ops))) as u.
      destruct u as [up uh] eqn:hequ.
      destruct up as [upf ups] eqn:hequp.
      unfold _ZCond in *.
      simpl in xph, zph, oph, uh.
      rename xpf into a.
      rename upf into b.
      rename xps into c.
      rename ups into d.
      repeat rewrite (Nmult_comm b).
      repeat rewrite (Nmult_comm d).
      rewrite (Nplus_comm (Nmult c b)).
      reflexivity.
    }
  Qed.

  Lemma _Zmult_assoc : associative _Zmult.
  Proof.
    red.
    intros [a b] [c d] [e f].
    simpl.
    f_equal.
    {
      repeat rewrite Nplus_mult_distr_l.
      repeat rewrite Nplus_mult_distr_r.
      repeat rewrite Nmult_assoc.
      repeat rewrite Nplus_assoc.
      apply f_eq.
      rewrite Nplus_comm.
      repeat rewrite Nplus_assoc.
      reflexivity.
    }
    {
      repeat rewrite Nplus_mult_distr_l.
      repeat rewrite Nplus_mult_distr_r.
      repeat rewrite Nmult_assoc.
      repeat rewrite Nplus_assoc.
      apply f_eq.
      rewrite Nplus_comm.
      repeat rewrite Nplus_assoc.
      reflexivity.
    }
  Qed.

  Lemma _Zmult_repr : forall x y, _Z_representative (_Zmult x (_Z_representative y)) = _Z_representative (_Zmult x y).
  Proof.
    intros x y.
    destruct x as [a b].
    destruct y as [c d].
    simpl.
    destruct (Neq_dec _) as [d1l|d1r].
    {
      symmetry in d1l. apply Nmin_le in d1l.
      simpl.
      destruct (Neq_dec _) as [d2l|d2r].
      {
        symmetry in d2l. apply Nmin_le in d2l.
        destruct (Neq_dec ) as [d3l|d3r].
        {
          symmetry in d3l. apply Nmin_le in d3l.
          rewrite Nmult_zero_r in *.
          rewrite Nplus_zero_l in *.
          rewrite Nmult_zero_r in *.
          rewrite Nplus_zero_r in *.
          rewrite Nplus_zero_l in *.
          apply f_eq.
          remember (Nrest d c) as dc.
          apply Nle_nmk in d1l. destruct d1l. subst d.
          rewrite Nplus_comm in Heqdc. rewrite Nrest_plus_nmm in Heqdc.
          subst dc.
          remember (Nmult b x) as g.
          apply Nle_nmk in d2l.
          destruct d2l.
          subst g.
          rename x into d.
          rename x0 into e.
          rewrite Nplus_mult_distr_l in d3l.
          rewrite Nplus_mult_distr_l in d3l.
          repeat rewrite Nplus_assoc in d3l.
          apply le_n_plus_l in d3l.
          apply Nle_nmk in d3l. destruct d3l.
          rename x into f.
          rewrite Nplus_mult_distr_l.
          rewrite Nplus_mult_distr_l.
          remember (Nmult a d) as ad.
          rewrite <- H in H0.
          rewrite <- H.
          remember (Nmult b d) as bd.
          rewrite (Nplus_comm bd).
          rewrite Nrest_plus_nmm.
          subst bd.
          remember (Nmult b c) as bc.
          rewrite (Nplus_comm bc) in H0.
          repeat rewrite Nplus_assoc in H0.
          apply Nplus_elim_l in H0.
          rewrite (Nplus_comm bc) in H0.
          apply Nplus_elim_r in H0.
          subst f.
          remember (Nmult a c) as ac.
          remember (Nmult b d) as bd.
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm ac).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bd).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bc).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bd).
          rewrite Nrest_plus_nmm.
          reflexivity.
        }
        {
          apply Nmin_neq_le in d3r.
          apply Nle_nmk in d1l. destruct d1l.
          rewrite Nmult_zero_r in *.
          rewrite Nplus_zero_l in *.
          rewrite Nmult_zero_r in *.
          rewrite Nplus_zero_r in *.
          rewrite Nplus_zero_l in *.
          subst d.
          rewrite (Nplus_comm c) in*.
          rewrite Nrest_plus_nmm in *.
          repeat rewrite Nplus_mult_distr_l in d3r.
          remember (Nmult a c) as ac.
          remember (Nmult a x) as ax.
          remember (Nmult b c) as bc.
          remember (Nmult b x) as bx.
          rewrite (Nplus_comm _ ac) in d3r.
          repeat rewrite Nplus_assoc in d3r.
          apply le_n_plus_l in d3r.
          apply le_n_plus_r in d3r.
          assert (h:=Nle_antisym).
          specialize (h _ _ d3r d2l).
          clear d3r d2l.
          subst ac ax bc bx.
          repeat rewrite Nplus_mult_distr_l.
          rewrite <- h.
          clear h.
          rewrite Nrest_cancel.
          remember (Nmult a c) as ac.
          remember (Nmult a x) as ax.
          remember (Nmult b c) as bc.
          repeat rewrite <- Nplus_assoc.
          rewrite (Nplus_comm ac).
          repeat rewrite Nplus_assoc.
          rewrite Nrest_cancel.
          reflexivity.
        }
      }
      {
        apply Nmin_neq_le in d2r.
        repeat rewrite Nmult_zero_r in *.
        repeat rewrite Nplus_zero_l in *.
        repeat rewrite Nplus_zero_r in *.
        destruct (Neq_dec _) as [d3l|d3r].
        {
          symmetry in d3l. apply Nmin_le in d3l.
          apply Nle_nmk in d1l. destruct d1l. subst d.
          rewrite (Nplus_comm c) in *.
          rewrite Nrest_plus_nmm in *.
          repeat rewrite Nplus_mult_distr_l in *.
          remember (Nmult a c) as ac.
          remember (Nmult b x) as bx.
          remember (Nmult b c) as bc.
          remember (Nmult a x) as ax.
          repeat rewrite <- Nplus_assoc in d3l.
          apply le_n_plus_r in d3l.
          rewrite Nplus_comm in d3l.
          apply le_n_plus_r in d3l.
          assert (ha:=Nle_antisym).
          specialize (ha _ _ d3l d2r).
          rewrite ha.
          rewrite Nrest_cancel.
          rewrite (Nplus_comm ax).
          repeat rewrite Nplus_assoc.
          rewrite Nrest_cancel.
          reflexivity.
        }
        {
          apply Nmin_neq_le in d3r.
          apply Nle_nmk in d1l. destruct d1l. subst d.
          rewrite (Nplus_comm c) in *.
          rewrite Nrest_plus_nmm in *.
          repeat rewrite Nplus_mult_distr_l in *.
          repeat rewrite <- Nplus_assoc in *.
          apply le_n_plus_r in d3r.
          remember (Nmult a x) as ax.
          remember (Nmult a c) as ac.
          remember (Nmult b x) as bx.
          remember (Nmult b c) as bc.
          rewrite (Nplus_comm ax) in d3r.
          apply le_n_plus_l in d3r.
          clear d2r.
          apply Nle_nmk in d3r.
          destruct d3r.
          rewrite <- H.
          rewrite (Nplus_comm ax).
          rewrite Nrest_plus_nmm.
          repeat rewrite <- Nplus_assoc.
          rewrite (Nplus_comm _ x0).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm ac).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bc).
          rewrite Nrest_plus_nmm.
          reflexivity.
        }
      }
    }
    {
      apply Nmin_neq_le in d1r.
      destruct (Neq_dec _) as [d2l|d2r].
      {
        symmetry in d2l. apply Nmin_le in d2l.
        repeat rewrite Nmult_zero_r in *.
        repeat rewrite Nplus_zero_l in *.
        repeat rewrite Nplus_zero_r in *.
        simpl.
        destruct (Neq_dec _) as [d3l|d3r].
        {
          symmetry in d3l. apply Nmin_le in d3l.
          apply Nle_nmk in d1r. destruct d1r. subst c.
          rewrite (Nplus_comm d) in *. rewrite Nrest_plus_nmm in *.
          repeat rewrite Nplus_mult_distr_l in *.
          remember (Nmult a x) as ax.
          remember (Nmult b x) as ac.
          remember (Nmult a d) as bx.
          remember (Nmult b d) as bd.
          repeat rewrite <- Nplus_assoc in d2l.
          apply le_n_plus_r in d2l.
          rewrite (Nplus_comm bx) in d2l.
          apply le_n_plus_r in d2l.
          apply Nle_nmk in d2l. destruct d2l. rewrite <- H.
          rewrite (Nplus_comm ax). rewrite Nrest_plus_nmm.
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bx).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bd).
          rewrite Nrest_plus_nmm.
          reflexivity.
        }
        {
          apply Nmin_neq_le in d3r.
          apply Nle_nmk in d1r. destruct d1r. subst c.
          rewrite (Nplus_comm d) in *.
          rewrite Nrest_plus_nmm in *.
          repeat rewrite Nplus_mult_distr_l in *.
          remember (Nmult a x) as ax.
          remember (Nmult a d) as ad.
          remember (Nmult b d) as bd.
          remember (Nmult b x) as bx.
          repeat rewrite <- Nplus_assoc in d2l.
          apply le_n_plus_r in d2l.
          rewrite Nplus_comm in d2l.
          apply le_n_plus_l in d2l.
          apply Nle_nmk in d2l. destruct d2l. rewrite <- H.
          rewrite (Nrest_comm ax).
          rewrite (Nplus_comm ax).
          rewrite Nrest_plus_nmm.
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm x0).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm ad).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm ax).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bd).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm ad).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bd).
          rewrite Nrest_plus_nmm.
          subst ax bx ad bd.
          rewrite <- H in d3r.
          rewrite Nplus_comm in d3r.
          apply le_n_plus_l_zero in d3r.
          subst x0.
          reflexivity.
        }
      }
      {
        apply Nmin_neq_le in d2r.
        simpl.
        repeat rewrite Nmult_zero_r in *.
        repeat rewrite Nplus_zero_l in *.
        repeat rewrite Nplus_zero_r in *.
        destruct (Neq_dec _) as [d3l | d3r].
        {
          symmetry in d3l. apply Nmin_le in d3l.
          simpl.
          apply Nle_nmk in d1r. destruct d1r. subst c.
          rewrite (Nplus_comm d) in *. rewrite Nrest_plus_nmm in *.
          repeat rewrite Nplus_mult_distr_l in *.
          remember (Nmult a x) as ax.
          remember (Nmult b d) as bd.
          remember (Nmult a d) as ad.
          remember (Nmult b x) as bx.
          repeat rewrite <- Nplus_assoc in d2r.
          apply le_n_plus_r in d2r.
          rewrite Nplus_comm in d2r.
          apply le_n_plus_r in d2r.
          assert(ha:=Nle_antisym  _ _ d3l d2r).
          rewrite <- ha.
          rewrite Nrest_cancel.
          rewrite (Nplus_comm ad).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm ad).
          rewrite Nrest_cancel.
          reflexivity.
        }
        {
          apply Nmin_neq_le in d3r.
          apply Nle_nmk in d1r. destruct d1r as [x d1r]. subst c.
          rewrite (Nplus_comm d) in *.
          rewrite Nrest_plus_nmm in *.
          repeat rewrite Nplus_mult_distr_l in *.
          remember (Nmult a x) as ax.
          remember (Nmult b x) as bx.
          remember (Nmult a d) as ad.
          remember (Nmult b d) as bd.
          repeat rewrite <- Nplus_assoc in d2r.
          apply le_n_plus_r in d2r.
          rewrite Nplus_comm in d2r.
          apply le_n_plus_r in d2r.
          clear d2r.
          apply Nle_nmk in d3r. destruct d3r. rewrite <- H.
          rewrite (Nplus_comm bx). rewrite Nrest_plus_nmm.
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bx).
          repeat rewrite Nplus_assoc.
          rewrite (Nplus_comm bd).
          rewrite Nrest_plus_nmm.
          reflexivity.
        }
      }
    }
  Qed.

  Lemma Zmult_assoc : associative Zmult.
  Proof.
    red.
    intros x y z.
    unfold Zmult.
    unfold Zmake.
    apply proof_irrelevance.
    simpl.
    destruct x as [xp xh] eqn:hex.
    destruct y as [yp yh] eqn:hey.
    destruct z as [zp zh] eqn:hez.
    simpl.
    assert (R:=_Zmult_repr).
    rewrite R.
    rewrite (_Zmult_comm).
    rewrite R.
    rewrite (_Zmult_comm).
    repeat rewrite _Zmult_assoc.
    reflexivity.
  Qed.



