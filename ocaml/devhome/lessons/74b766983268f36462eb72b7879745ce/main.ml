let () =
        let print_age (age : int) : unit =
                print_endline ("You are " ^ (string_of_int age) ^ ".")
        and increase_age (age : int ref) : unit = 
                age := !age + 1 ;
                print_endline ("One year passed...")
        and age : int ref = ref 33
        and niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        in
        print_endline "What is your name?" ;
        let name : string = Scanf.bscanf Scanf.Scanning.stdin "%s" (fun (input:string) : string -> input) in
        print_endline ("Hello " ^ name ^ "!") ;
        if Str.string_match (Str.regexp "^[A-Z][a-z]+$") name 0 then
                print_endline ("That's a good name.")
        else
                print_endline ("I don't like that name.") ;
        print_age !age ;
        for _  = 0 to niterations - 1 do
                increase_age age ;
                print_age !age ;
        done
