
  Require Export XD.Definitions.

  (* This is the classic inductive definition of a list *)
  Inductive List {A:Type} : Type :=
  | nil : List
  | cons : A -> List -> List
  .

 (* We declare the scope "maths" to host our custom notations *)
  Declare Scope maths.
  Open Scope maths.

  (* We show the empty list as "_" *)
  Notation "'_'" := nil (only printing) : maths.
  (* And we show the cons constructor as "∘l". *)
  Notation "x ∘l y" := (cons x y) (only printing, at level 60) : maths.

  Notation "[ x ]" := (cons x nil) (only printing) : maths.
  Notation "[ x ; y ; .. ; z ]" :=  (cons x (cons y .. (cons z nil) ..)) (only printing) : maths.

  (* The syntax for expliciting implicit types is quickly verbose, these make it easier *)
  (* LO is a list of A, LOLO is a list of lists of A *)
  Definition LO (A:Type) := List (A:=A).
  Definition LOLO (A:Type) := List (A:=(LO A)).

  (* Classic fixpoint definition of append *)
  Fixpoint append {A:Type} (l l' : LO A) : (LO A) := match l, l' with
  | nil, _ => l'
  | cons head tail, _ => cons head (append tail l')
  end.
  (* With a notation *)
  Notation "x ⋄l y" := (append x y) (only printing, at level 60) : maths. 

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

  (* To convert cons to append in proofs *)
  Lemma cons_append {A:Type} : forall (head:A) (tail:LO A), cons head tail = append (cons head nil) tail.
  Proof.
    intros head tail.
    simpl.
    reflexivity.
  Qed.


  (* Simplification lemma to remove empty lists on the right of append *)
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