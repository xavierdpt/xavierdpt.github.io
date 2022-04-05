
  Require Export XD.Technical.
  Require Export XD.List.

  (* The actual type does not matter *)
  Parameter _NType : Type.

  (* And we define two levels of lists *)
  Definition _NLevel1 := LO _NType.
  Definition _NLevel2 := LO _NLevel1.

  (* A list of lists is "natural" if all its elements are empty lists *)
  Definition isnatural (l:_NLevel2) := allnil l.

  (* We define Zero as the empty list of empty lists *)
  Definition _Nzero := nil (A:=_NLevel1).

  (* The "successor" function adds an empty list to any lists of list *)
  Definition _Nnext (n:_NLevel2) : _NLevel2 := cons nil n.

  (* zero-l is a "natural" list *)
  Theorem  _Nzero_natural : isnatural _Nzero.
  Proof.
    (* Unfold the definitions *)
    unfold isnatural.
    unfold allnil.
    unfold _Nzero.
    (* allmatch on empty lists is always true anyway *)
    simpl.
    trivial.
  Qed.

  (* Using next_l on a "natural" list yields another "natural" list *)
  Lemma _Nnext_natural : forall (l:_NLevel2), (isnatural l) -> isnatural (_Nnext l).
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
  Definition NN := { l | isnatural l }.

  (* There are two projection functions which retrive the content and the hypothese *)
  Definition Nnumber (t:NN) := proj1_sig t.
  Definition Nhyp (t:NN) := proj2_sig t.

  (* Here we define the strong zero *)
  (* This uses the "exist" constructor from "sig" with zero and a proof that zero is natural. *)
  Definition Nzero := exist _ _Nzero _Nzero_natural.
  Notation "0n" := Nzero (only printing) : maths. 

  (*
    Same idea for the strong next function, although it is maybe a bit more difficult to follow,
    since it use the proof that n is natural to construct the proof that the next number is natural
  *)
  Definition Nnext (n:NN) := exist _
    (_Nnext (Nnumber n))
    (_Nnext_natural (Nnumber n) (Nhyp n)).
  Notation "]n x" := (Nnext x) (only printing, at level 60) : maths. 

  (* Here are one and two *)
  Definition None := Nnext Nzero.
  Notation "1n" := None (only printing) : maths.

  Definition Ntwo := Nnext None.
  Notation "2n" := Ntwo (only printing) : maths.

  (* next is injective *)
  Lemma Nnext_elim : forall n m, Nnext n = Nnext m -> n = m.
  Proof.
    intros nT mT.
    intro hnext.
    inversion hnext as [heq].
    apply proof_irrelevance in heq. 
    exact heq.
  Qed.

  (* If the "number" of a natural is zero_l, then that number is zero *)
  Lemma _Nnumber_nil_zero : forall (n:NN), Nnumber n = _Nzero -> n = Nzero.
  Proof.
    (* intro n as "nT" *)
    intro nT.
    (* intro the equality hypothese *)
    intro heq.
    (* Explode the things of type T into their corresponding lists and hypotheses *)
    destruct nT as [n hn];
    destruct Nzero as [z hz] eqn:heqz.
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
  Lemma _Npredecessor_exists : forall (nT:NN) head tail, Nnumber nT = cons head tail -> exists mT:NN, Nnumber mT = tail.
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
  Theorem Ninduction : forall (P: NN -> Prop),
    (P Nzero) ->  
    (forall n, P n -> P (Nnext n)) -> 
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
      assert(hnz:=_Nnumber_nil_zero).
      specialize (hnz nT).
      (* number nT is nil by definition of nT *)
      simpl in hnz.
      (* and zero_l is nil too *)
      unfold _Nzero in hnz.
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
      assert (hm:=_Npredecessor_exists).
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
      assert (hmn:nT = Nnext mT).
      {
        apply proof_irrelevance.
        (* We know what's inside nT, and a little about what's inside (nextT mT) *)
        simpl.
        (* Here we are down the "next_l" function *)
        unfold _Nnext.
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
      unfold Nnumber in hm.
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
  Definition Nplus (nT mT : NN) : NN :=
    (* Extract the parts from n and m *)
    let (n, hn) := nT in
    let (m, hm) := mT in
    (* Construct the result *)
    let result := append n m in
    (* And binds the proof using the proof above *)
    exist _ result (append_natural n m hn hm).
  Notation "x +n y" := (Nplus x y) (only printing, at level 60) : maths. 
 
  (* Proof that plus is commutative *)
  Theorem Nplus_comm : commutative Nplus.
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
  Theorem Nplus_zero_l : forall n, Nplus Nzero n = n.
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
  Theorem Nplus_zero_r : forall n, Nplus n Nzero = n.
  Proof.
    intro n.
    (* We can use commutativity of addition *)
    rewrite Nplus_comm.
    apply Nplus_zero_l.
  Qed.

  (* (next n) + m = next(n+m) *)
  Lemma Nplus_next_l : forall n m, Nplus (Nnext n) m = Nnext (Nplus n m).
  Proof.
    intros nT mT.
    destruct nT as [n hn];
    destruct mT as [m hm].
    simpl.
    apply proof_irrelevance.
    simpl.
    unfold Nnext.
    reflexivity.
  Qed.

  (* n + (next m) = next(n+m) *)
  Lemma Nplus_next_r : forall n m, Nplus n (Nnext m) = Nnext (Nplus n m).
  Proof.
    intros n m.
    rewrite Nplus_comm.
    rewrite Nplus_next_l.
    rewrite (Nplus_comm m).
    reflexivity.
  Qed.

  (* Proof that plus is associative *)
  Theorem Nplus_assoc : associative Nplus.
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
  Lemma Nplus_elim_zero_l : forall n m, Nplus n m = n -> m = Nzero.
  Proof.
  intro n.
  pattern n;apply Ninduction.
  { intro m. intro h. rewrite Nplus_zero_l in h. exact h. }
  {
    clear n.
    intro n.
    intro ih.
    intro m.
    intro h.
    apply ih.
    clear ih.
    apply Nnext_elim.
    rewrite Nplus_next_l in h.
    exact h.
  }
  Qed.

  (* n + m = m -> n = 0 *)
  Lemma Nplus_elim_zero_r : forall n m, Nplus n m = m -> n = Nzero.
  Proof.
    intros n m h.
    apply Nplus_elim_zero_l with m.
    rewrite Nplus_comm.
    exact h.
  Qed.

  (* next n = n + 1 *)
  Lemma Nnext_eq : forall n, Nnext n = Nplus n None.
  Proof.
    intro n.
    unfold None.
    rewrite Nplus_comm.
    rewrite Nplus_next_l.
    rewrite Nplus_zero_l.
    reflexivity.
  Qed.

  (* "multiplication" of two list repeatitivly applies append on the second list *)
  (* What happens in this function does not really matter as long as
     length (x*y)=length(x)*length(y) *)
  Fixpoint _Nmult (x y:_NLevel2) : _NLevel2 := match x with
  | nil => nil
  | cons head tail => append y (_Nmult tail y)
  end.
  Notation "x *l y" := (_Nmult x y) (only printing, at level 60) : maths. 

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


  (* Now we can define multiplication on T *)
  Definition Nmult (nT mT : NN) : NN :=
    let (n, hn) := nT in
    let (m, hm) := mT in
    let result := _Nmult n m in
    exist _ result (_Nmult_natural n m hn hm).
  Notation "x *n y" := (mult x y) (only printing, at level 60) : maths. 

  (* Multiplication is commutative *)
  Theorem Nmult_comm : commutative Nmult.
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
  Theorem Nmult_one_l : forall n, Nmult None n = n.
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
  Theorem Nmult_one_r : forall n, Nmult n None = n.
  Proof.
    intro n.
    rewrite Nmult_comm.
    apply Nmult_one_l.
  Qed.

  (* x*(y+z) = x*y + x*z *)
  Theorem Nplus_mult_distr_l : forall x y z, Nmult x (Nplus y z) = Nplus (Nmult x y) (Nmult x z).
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
        apply _Nmult_natural.
        { apply hmatchx. }
        { red. unfold allnil. exact hy. }
      }
    }
  Qed.

  (* (x+y)*z = x*z + y*z *)
  Theorem Nplus_mult_distr_r : forall x y z, Nmult (Nplus x y) z  = Nplus (Nmult x z) (Nmult y z).
  Proof.
    intros x y z.
    repeat rewrite (Nmult_comm _ z).
    rewrite Nplus_mult_distr_l.
    reflexivity.
  Qed.


  Theorem _Nplus_mult_dist_r : forall x y z,
    isnatural x -> isnatural y -> isnatural z
    -> _Nmult (append x y) z  = append (_Nmult x z) (_Nmult y z).
  Proof.
    intros x y z hx hy hz.
    assert (h := Nplus_mult_distr_r).
    specialize (h (exist _ x hx)).
    specialize (h (exist _ y hy)).
    specialize (h (exist _ z hz)).
    simpl in h.
    inversion h as [h']. clear h. rename h' into h.
    reflexivity.
  Qed.

  (* Multiplication is associative *)
  Theorem Nmult_assoc : associative Nmult.
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
      rewrite _Nplus_mult_dist_r.
      { reflexivity. }
      { unfold isnatural. unfold allnil. exact hy. }
      { apply _Nmult_natural.
        { unfold isnatural. unfold allnil. exact hmatchx. }
        { unfold isnatural. unfold allnil. exact hy. }
      }
      { unfold isnatural. unfold allnil. exact hz. }
    }
  Qed.

  Lemma Nmult_zero_l : forall n:NN, Nmult Nzero n = Nzero.
    Proof.
    intro nT.
    destruct Nzero as [z hz] eqn:heqz;
    destruct nT as [n hn].
    simpl. apply proof_irrelevance. simpl.
    inversion heqz as [heq]. clear heqz.
    unfold Nzero in *. subst z.
    simpl.
    reflexivity.
  Qed.

  Lemma Nmult_zero_r : forall n:NN, Nmult n Nzero = Nzero.
    Proof.
    intro nT.
    rewrite Nmult_comm.
    rewrite Nmult_zero_l.
    reflexivity.
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


  (* If n + m = 0, then n = 0 and m = 0 *)
  Lemma Nplus_zero : forall (n m:NN), Nplus n m = Nzero -> n = Nzero /\ m = Nzero.
  Proof.
    intro n.
    (* We apply our custom induction principle *)
    pattern n;apply Ninduction.
    (* Base case *)
    {
      intros m heq.
      rewrite Nplus_zero_l in heq.
      subst m.
      split;reflexivity.
    }
    (* Induction case *)
    {
      clear n. intro n. intro ih.
      intros m heq.
      specialize (ih (Nnext m)).
      rewrite Nplus_next in heq.
      specialize (ih heq).
      destruct ih as [ _ hr ].
      (* We can have next m = 0 *)
      inversion hr.
    }
  Qed.

  (* Definition of "less than or equal to" *)
  Definition Nle (n m:NN) := longerOrEqualThan (Nnumber m) (Nnumber n).
  Notation "x <=n y" := (Nle x y) (only printing, at level 60) : maths. 

  (* Definition of "less than" *)
  Definition Nlt (n m:NN) := Nle (Nnext n) m.
  Notation "x <n y" := (Nlt x y) (only printing, at level 60) : maths. 

  (* If n <= m, then next n <= next m *)
  Lemma Nle_next_intro : forall n m, Nle n m -> Nle (Nnext n) (Nnext m).
  Proof.
    (* Destruct n and m into their parts *)
    intros nT mT.
    unfold Nle.
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
  Lemma Nle_plus_l : forall n m, Nle n (Nplus n m).
  Proof.
    (* Destruct n and m into their parts *)
    intros nT mT.
    unfold Nle.
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
  Lemma Nle_trans : forall n m k, Nle n m -> Nle m k -> Nle n k.
  Proof.
    (* Destruct n, m and k into their parts *)
    intros nT mT kT.
    unfold Nle.
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
  Lemma Nle_next : forall a, Nle a (Nnext a).
  Proof.
    intro aT.
    destruct aT as [a ha].
    unfold Nle.
    simpl.
    clear ha.
    induction a as [|head tail ih].
    { trivial. }
    { simpl. apply ih. }
  Qed.

  (* next n <= next m => n <= m *)
  Lemma Nle_next_elim : forall n m, Nle (Nnext n) (Nnext m) -> Nle n m.
  Proof.
    intros nT mT.
    unfold Nle.
    destruct nT as [n hn];
    destruct mT as [m hm].
    simpl.
    clear hn hm.
    intro h.
    (* the hypothese was reduced to the goal during simplification *)
    exact h.
  Qed.

  (* "<" is irreflexive *)
  Lemma Nlt_irrefl : forall n, Nlt n n -> False.
  Proof.
    intro nT.
    unfold Nlt.
    unfold Nle.
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
      unfold _Nnext in ih.
      exact ih.
    }
  Qed.

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

  Lemma Nplus_elim_l : forall n m p, Nplus n m = Nplus n p -> m = p.
  Proof.
    intro n.
    pattern n;apply Ninduction.
    {
    intro m. intro p.
    intro heq.
    repeat rewrite Nplus_zero_l in heq.
    exact heq.
    }
    { 
    clear n. intro n'. intro ih.
    intro m. intro p. intro heq.
    rewrite Nplus_next_l in heq.
    rewrite Nplus_next_l in heq.
    apply Nnext_elim in heq.
    apply ih.
    exact heq.
    }
  Qed.

  Lemma Nplus_elim_r : forall n m p, Nplus m n = Nplus p n -> m = p.
  Proof.
    intros n m p heq.
    apply Nplus_elim_l with n.
    rewrite (Nplus_comm n).
    rewrite (Nplus_comm n).
    exact heq.
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
    unfold isprime.
    intro d.
    pattern d;apply Ninduction.
    (* d = 0 *)
    {
      intro h.
      intro hneq.
      unfold divides in h.
      destruct h as [d' heq].
      rewrite Nmult_zero_l in heq.
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
      rewrite Nnext_eq in heq.
      rewrite Nplus_mult_distr_r in heq.
      rewrite Nmult_one_l in heq.
      unfold three in heq.
      rewrite Nnext_eq in heq.
      assert(kept:=heq).
      apply Nplus_elim_one_r in heq.
      destruct heq as [hl | hr ].
      {
        destruct hl as [d'' heq].
        apply plus_eq_two in heq.
        destruct heq as [heq | [ heq | heq ] ].
        {
          destruct heq as [h'' h].
          subst d''.
          subst q.
          rewrite (Nplus_comm Ntwo) in kept.
          apply Nplus_elim_r in kept.
          apply Nmult_one in kept.
          destruct kept as [_ i].
          inversion i.
        }
        {
          destruct heq as [hl hr].
          subst q. subst d''.
          rewrite Nmult_one_r in kept.
          apply Nplus_elim_r in kept.
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
          rewrite Nmult_zero_r in kept.
          rewrite Nplus_zero_l in kept.
          rewrite <- Nnext_eq in kept.
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
          apply Nmult_zero in hl.
          destruct hl as [h | h].
          {
            subst d'.
            unfold None.
            reflexivity.
          }
          {
            subst q.
            rewrite Nmult_zero_r in kept.
            rewrite Nplus_zero_l in kept.
            rewrite <- Nnext_eq in kept.
            inversion kept.
          }
        }
        {
          destruct h as [hl hr].
          subst u.
          apply Nmult_one in hl.
          destruct hl as [hl hr].
          subst d'.
          subst q.
          rewrite Nmult_one_r in kept.
          repeat rewrite <- next_eq_plus_one in kept.
          inversion kept.
        }
        {
          destruct h as [hl hr].
          subst u.
          assert(heq:=kept).
          rewrite hl in heq.
          apply Nplus_elim_l in heq.
          subst q.
          rewrite Nmult_one_r in hl.
          subst d'.
          exfalso.
          apply hneq.
          unfold three.
          reflexivity.
        }
      }
    }
  Qed.

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

  Theorem Nle_refl : forall n:NN, Nle n n.
  Proof.
    intro nT.
    destruct nT as [n hn].
    unfold Nle.
    simpl.
    clear hn.
    induction n as [|head tail ih].
    { simpl. trivial. }
    { simpl. exact ih. }
  Qed.

  Definition Nle_dec n m : sumbool (Nle n m) (Nle m n).
  Proof.
    destruct n as [n hn];
    destruct m as [m hm].
    unfold Nle.
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

  Definition Neq_dec (n m:NN) : sumbool (n = m) (n <> m).
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

  Definition Nmin n m := match Nle_dec n m with
  | left _ => n
  | right _ => m
  end.

  Definition Nmax n m := match Nle_dec n m with
  | left _ => m
  | right _ => n
  end.

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


  Fixpoint _Nrest {A:Type} (l m: LO A) : (LO A) := match l, m with
  | nil, nil => nil
  | nil, cons _ _ =>  m
  | cons _ _, nil =>  l
  | cons _ tailn, cons _ tailm =>  _Nrest tailn tailm
  end.

  Lemma _Nrest_natural : forall l m, isnatural l -> isnatural m -> isnatural (_Nrest l m).
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

  Definition Nrest (nT mT:NN) := 
    let (n, hn) := nT in
    let (m, hm) := mT in
    let r := _Nrest n m in
    exist _ r (_Nrest_natural n m hn hm).


  Lemma Nrest_cancel : forall n, Nrest n n = Nzero.
  Proof.
    intros (n, hn).
    simpl.
    generalize dependent hn.
    induction n as [|head tail ih].
    { simpl. intro hn. unfold Nzero. apply proof_irrelevance. simpl. unfold _Nzero. reflexivity. }
    {
      intro hn.
      simpl in *.
      unfold isnatural in *.
      unfold allnil in *.
      simpl in *.
      unfold Nzero. unfold _Nzero.
      apply proof_irrelevance.
      simpl.
      destruct hn as [hhead htail].
      unfold isnil in hhead.
      subst head.
      specialize (ih htail).
      unfold Nzero in ih.
      inversion ih.
      rewrite H0.
      unfold _Nzero.
      reflexivity.
    }
  Qed.

  Lemma Nrest_zero_r : forall n, Nrest n Nzero = n.
  Proof.
    intros (n, hn).
    induction n as [|head tail ih].
    simpl. apply proof_irrelevance. simpl. reflexivity.
    simpl. apply proof_irrelevance. simpl. reflexivity.
  Qed.

  Lemma Nrest_comm : forall n m, Nrest n m = Nrest m n.
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

  Lemma Nrest_zero_l : forall n, Nrest Nzero n = n.
  Proof.
    intro n. rewrite Nrest_comm. apply Nrest_zero_r.
  Qed.

  Lemma Nmin_zero_l : forall n, Nmin Nzero n = Nzero.
  Proof.
    intros (n, hn).
    induction n as [|head tail ih].
    { unfold min. simpl. reflexivity. }
    { unfold min. simpl. reflexivity. }
  Qed.

  Lemma Nle_zero_l : forall n, Nle n Nzero -> n = Nzero.
  Proof.
    intros (n,hn).
    unfold Nle.
    induction n as [|head tail ih].
    { simpl. intros _. apply proof_irrelevance. simpl. reflexivity. }
    { simpl. intro f. inversion f. }
  Qed.

  Lemma Nle_antisym : forall n m, Nle n m -> Nle m n -> n = m.
  Proof.
    intros (n,hn) (m,hm).
    unfold Nle.
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


  Lemma Nmin_comm : forall n m, Nmin n m = Nmin m n.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    {
      intro m. rewrite Nmin_zero_l.
      pattern m;apply Ninduction;clear m.
      { unfold min. simpl. reflexivity. }
      {
        intros m ih.
        unfold min.
        destruct (Nle_dec (Nnext m) Nzero).
        { apply Nle_zero_l in n. inversion n. }
        { reflexivity. }
      }
    }
    {
      intros n ih.
      intro m.
      assert (hd:=Ndestruct m).
      destruct hd as [heq|hnext].
      {
        subst m. rewrite Nmin_zero_l. unfold min.
        destruct (Nle_dec (Nnext n) Nzero).
        { apply Nle_zero_l in n0. inversion n0. }
        { reflexivity. }
      }
      {
        destruct hnext as [n' hn'].
        subst m.
        rename n' into m.
        specialize (ih m).
        unfold Nmin.
        destruct (Nle_dec (Nnext n) (Nnext m)).
        {
          destruct (Nle_dec (Nnext m) (Nnext n)).
          { apply Nle_antisym.
          { exact n0. }
          { exact n1. }
        }
        { reflexivity. }
      }
      {
        destruct (Nle_dec (Nnext m) (Nnext n)).
        { reflexivity. }
        {
          apply Nle_antisym.
          { exact n0. }
          { exact n1. }
        }
      }
    }
  }
  Qed.

  Lemma Nmin_zero_r : forall n, Nmin n Nzero = Nzero.
  Proof.
    intro n.
    rewrite Nmin_comm.
    apply Nmin_zero_l.
  Qed.

  Lemma Nmax_zero_l : forall n, Nmax Nzero n = n.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { unfold max. simpl. reflexivity. }
    {
      intros n' ih.
      unfold max. simpl. reflexivity.
    }
  Qed.

  Lemma Nmax_zero_r : forall n, Nmax n Nzero = n.
    Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { unfold max. simpl. reflexivity. }
    {
      intros n ih.
      unfold max.
      simpl.
      reflexivity.
    }
  Qed.

  Lemma Nmax_comm : forall n m, Nmax n m = Nmax m n.
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    { intro m. rewrite Nmax_zero_l. rewrite Nmax_zero_r. reflexivity. }
    {
      intros n' ih.
      intros m.
      unfold Nmax.
      destruct (Nle_dec (Nnext n') m);destruct (Nle_dec m (Nnext n')).
      { apply Nle_antisym. exact n0. exact n. }
      { reflexivity. }
      { reflexivity. }
      { apply Nle_antisym. exact n0. exact n. }
    }
  Qed.

  Lemma Nmin_next : forall n m, Nmin (Nnext n) (Nnext m) = Nnext (Nmin n m).
  Proof.
    intro n.
    pattern n;apply Ninduction;clear n.
    {
      intro m. rewrite Nmin_zero_l.
      unfold Nmin. destruct (Nle_dec (Nnext Nzero) (Nnext m)).
      { reflexivity. }
      { apply Nle_zero_l in n. subst m. reflexivity. }
    }
    {
      intros n ih.
      intro m.
      set (nnn:=Nnext (Nnext n)).
      set (nm:=Nnext m).
      set (nn:=Nnext n).
      unfold Nmin.
      destruct (Nle_dec nnn nm);destruct (Nle_dec nn m).
      { subst nnn. subst nn. reflexivity. }
      { subst nnn. subst nn. subst nm.
        apply Nle_antisym.
        { exact n0. }
        { apply Nle_next_intro. exact n1. }
      }
      { subst nnn. subst nn. subst nm.
        apply Nle_antisym.
        { exact n0. }
        { apply Nle_next_intro. exact n1. }
      }
      { subst nm. reflexivity. }
    }
  Qed.

  Lemma Nrest_next : forall n m, Nrest (Nnext n) (Nnext m) = Nrest n m.
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

  Lemma Nmax_next : forall n m, Nmax (Nnext n) (Nnext m) = Nnext (Nmax n m).
  Proof.
    intros n. pattern n;apply Ninduction;clear n.
    {
      intro m.
      rewrite Nmax_zero_l.
      unfold Nmax.
      destruct (Nle_dec (Nnext Nzero) (Nnext m)).
      { reflexivity. }
      { apply Nle_zero_l in n. subst m. reflexivity. }
    }
    {
      intros n' ih.
      intro m.
      unfold Nmax.
      destruct (Nle_dec (Nnext (Nnext n')) (Nnext m));
      destruct (Nle_dec (Nnext n') m).
      { reflexivity. }
      { apply Nle_antisym. apply Nle_next_intro. exact n0. exact n. }
      { apply Nle_antisym. apply Nle_next_intro. exact n0. exact n. }
      { reflexivity. }
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


  Lemma Nle_zero_r : forall n, Nle Nzero n.
  Proof.
    intros (n, hn). unfold Nle. simpl.
    clear hn. destruct n.
    { simpl. trivial. }
    { simpl. trivial. }
  Qed.

  Lemma Nmin_le : forall x y, x = Nmin x y -> Nle x y.
  Proof.
    intro x.
    pattern x;apply Ninduction;clear x.
    { intros y h. apply Nle_zero_r. }
    {
      intros n ih.
      intros y h.
      destruct (Ndestruct y).
      { subst y. rewrite Nmin_zero_r in h. inversion h. }
      {
        destruct H. subst y. rewrite Nmin_next in h. apply Nnext_elim in h.
        apply Nle_next_intro. apply ih. exact h.
      }
    }
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
      { apply Nle_zero_r. }
      { reflexivity. }
    }
    {
      intros n' ih.
      intro m.
      destruct (Ndestruct m).
      {
        subst m. rewrite Nmin_zero_r. right. split.
        { apply Nle_zero_r. }
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
    subst m. rewrite Nmin_zero_r in *. apply Nle_zero_r.
    destruct H1. subst m. rewrite Nmin_next in H0. apply Nle_next_intro.
    apply H. intro heq. apply H0. apply f_eq. assumption.
    }
  Qed.

Lemma le_n_plus_l : forall n m k, Nle (Nplus n m) (Nplus n k) -> Nle m k.
Proof.
intro n.
pattern n;apply Ninduction;clear n.
{ intros. repeat rewrite Nplus_zero_l in *. assumption. }
{
intros.
repeat rewrite Nplus_next_l in H0.
apply Nle_next_elim in H0.
specialize (H _ _ H0). assumption.
}
Qed.

Lemma le_n_plus_r : forall n m k, Nle (Nplus m n) (Nplus k n) -> Nle m k.
Proof.
intros.
repeat rewrite (Nplus_comm _ n) in H.
apply le_n_plus_l in H.
assumption.
Qed.

Lemma le_n_plus_l_zero : forall n m, Nle (Nplus m n) n -> m = Nzero.
Proof.
intros n m h.
rewrite <- Nplus_zero_l in h.
apply le_n_plus_r in h.
apply Nle_zero_l in h.
assumption.
Qed.
