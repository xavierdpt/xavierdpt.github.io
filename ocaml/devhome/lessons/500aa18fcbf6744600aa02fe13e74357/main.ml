let () = let name : string = "user" and age : int = 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int age) ^ ".")
