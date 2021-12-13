let () =
        let identity (input:string) : string = input
        and print_age (age : int) : unit =
                print_endline ("You are " ^ (string_of_int age) ^ ".")
        and increase_age (age : int ref) : unit = 
                age := !age + 1 ;
                print_endline ("One year passed...")
        and age : int ref = ref 33
        and niterations : int = try int_of_string Sys.argv.(1) with
                | Invalid_argument _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
                | Failure _ -> print_endline "Failure, setting number of iterations to default value 2" ; 2
        in
        print_endline "What is your name?" ;
        let name = Scanf.scanf "%s" identity in
        print_endline ("Hello " ^ name ^ "!") ;
        print_age !age ;
        for _ = 0 to niterations - 1 do
                increase_age age ;
                print_age !age ;
        done
