let () =
        let print_age (age : int) : unit =
                print_endline ("You are " ^ (string_of_int age) ^ ".")
        and increase_age (age : int ref) : unit = 
                age := !age + 1 ;
                print_endline ("One year passed...")
        and name : string = "user"
        and age : (int ref) = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_age !age ;
        for _ = 0 to 2 do
                increase_age age ;
                print_age !age ;
        done
