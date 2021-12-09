let () =
        let assign (name : string ref) (input:string) : unit =
                name := input
        and print_age (age : int) : unit =
                print_endline ("You are " ^ (string_of_int age) ^ ".")
        and increase_age (age : int ref) : unit = 
                age := !age + 1 ;
                print_endline ("One year passed...")
        and name : string ref = ref "user"
        and age : int ref = ref 33
        and niterations : int = int_of_string Sys.argv.(1) in
        print_endline "What is your name?" ;
        Scanf.scanf "%s" (assign name) ;
        print_endline ("Hello " ^ !name ^ "!") ;
        print_age !age ;
        for _ = 0 to niterations - 1 do
                increase_age age ;
                print_age !age ;
        done
