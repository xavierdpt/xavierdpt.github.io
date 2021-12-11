let () =
        let print_age (age : int) : unit =
                print_endline ("You are " ^ (string_of_int age) ^ ".")
        and increase_age (age : int ref) : unit = 
                age := !age + 1 ;
                print_endline ("One year passed...")
        and age : int ref = ref 33
        and niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        and read_string () = Scanf.scanf "%s\n" (fun x -> x) in
        let name = (
                print_endline "What is your name?" ;
                let input = ref (read_string())
                and name_regexp = Str.regexp "^[A-Z][a-z]+$" in
                while not (Str.string_match name_regexp  !input 0) do
                        print_endline ("I don't like that name, try again! What is your name?") ;
                        input := (read_string())
                done ;
                !input
        ) in
        print_endline ("Hello " ^ name ^ "!") ;
        print_age !age ;
        for _  = 0 to niterations - 1 do
                increase_age age ;
                print_age !age ;
        done
