let () =
        let name : string = "user" and age : int ref = ref 33
        and niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        for _ = 0 to niterations - 1 do
                age := !age + 1 ;
                print_endline ("One year passed...") ;
                print_endline ("You are " ^ (string_of_int !age) ^ ".")
        done
