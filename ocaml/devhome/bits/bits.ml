(*
  To see the output in vim, run this command
  :%!utop
  Tip: record this in a macro, such as @r
*)
let x = 50;;
x*x;;
let y = 5 in y*y;;
let a=1 in let b=2 in a+b;;
let sq x = x * x;;
sq 3;;
let is_even x = x mod 2 = 0;;
is_even 5;;
let ordered a b c = a <= b && b <= c;;
ordered 1 2 3 ;;
5.2 +. 4.8;;
let average a b = (a+.b) /. 2.;;
average 5. 20.;;
float_of_int 5;;
let rec frec x = if x > 0 then x + (frec (x-1)) else 1;;
frec 5;;
(* int, float, bool, char, string *)
let rec factorial_x n = match n with | 0 -> 1 | x -> n * (factorial_x (x-1));;
factorial_x 5;;
let rec factorial_n n = match n with | 0 -> 1 | _ -> n * (factorial_n (n-1));;
factorial_n 5;;
let rec factorial_f = function | 0 -> 1 | n -> n * (factorial_n (n-1));;
factorial_f 5;;
"empty list";;
[];;
"simple list";;
[1;2;3];;
"constructed list";;
1::(2::(3::[]));;
"concatenated singletons";;
[1]@[2]@[3];;
"sum of element of list";;
let rec suml mylist = match mylist with | [] -> 0 | head :: tail -> head + suml tail;;
"sum of 1 2 3";;
suml [1;2;3];;
"tuple";;
(1,"hello",true);;
"record";;
type person = { name:string; age:int };;
let frank = { name="frank" ; age=30 };;
frank;;
frank.name;;
"custom type";;
type colour = Red | Blue | Green | RGB of int * int * int;;
[Red ; Blue ; RGB (5,10,15) ];;
"recursive polymorphic type";;
type 'a mytype = Cons1 | Cons2 | More of ('a mytype * 'a);;
More (More (Cons2, 7), 5);;
"create new exception type E2";;
exception E2 of string;;
"introduce raise_exception function";;
let raise_exception b = if b then "ok" else raise (E2 "error");;
"raise and catch exception, good path";;
try raise_exception true with E2 _ -> "oops";;
"raise and catch exception, bad path";;
try raise_exception false with E2 _ -> "oops";;
let r = ref 0;;
r := 100;;
!r;;
r:=5;r:=!r+5;!r;;
let negate x = x := -(!x);;
negate r;;
!r;;
();;
[();();()];;
();();();;
print_string "hello world";;
print_newline ();;
let raise_exception_no_arg x = raise (E2 "error");;
try raise_exception_no_arg () with E2 _ -> "oops";;
for x = 1 to 5 do for y = 1 to 5 do print_string (string_of_int (x*y)) done done;;
let t = ref 1 in while !t < 10 do t := !t + 1 done ; !t ;;
let arr = [|1;2;3|] in arr.(0) <- arr.(2) ; arr;;
type person2 = { name : string ; mutable age : int } ;;
let x = { name = "john" ; age  = 25 } in x.age <- x.age * 2 ; x.age ;;
List.sort compare [1;6;3];;