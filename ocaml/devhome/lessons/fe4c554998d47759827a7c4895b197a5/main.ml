let () = let name : string = "user" and age : (int ref) = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        age := !age + 1 ;
        print_endline ("One year passed...") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        age := !age + 1 ;
        print_endline ("One year passed...") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".")
