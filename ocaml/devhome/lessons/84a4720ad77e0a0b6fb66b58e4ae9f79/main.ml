let () = let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        and pfe : bool = Sys.file_exists ".preferences"
        in
        if pfe then print_endline "Preferences file found" ;
        let name : string = (
                if pfe then
                        let file_channel : in_channel = open_in ".preferences" in
                        try let line : string = input_line file_channel in
                            let parts : string list = (String.split_on_char '=' line) in
                            if List.length parts = 2 then
                                    let left = (List.nth parts 0) and right = (List.nth parts 1) in
                                    if left = "username" then right else (
                                        print_endline ("Expected key 'username', found key '"^left^"'") ;
                                        close_in file_channel ;
                                        "Unknown1"
                                    )
                            else (
                                print_endline ("Found preference with "^(string_of_int (List.length parts))^" parts") ;
                                close_in file_channel ;
                                "Unknown2"
                            )
                        with | _ -> close_in_noerr file_channel;
                                print_endline ("Could not read preferences file") ;
                                "Unknown3"
                else (
                        print_endline "What is your name?" ;
                        let input : string ref = ref (Scanf.scanf "%s@\n" Fun.id)
                        and name_regexp : Str.regexp = Str.regexp "^[A-Z][a-z]+$" in
                        while not (Str.string_match name_regexp  !input 0) do
                                print_endline ("I don't like that name, try again! What is your name?") ;
                                input := (Scanf.scanf "%s@\n" Fun.id)
                        done ; !input
                )
        )
        and age : int ref = ref 33 in
        if not pfe then (
                print_endline ("Preferences file not found, creating it") ;
                let file_channel : out_channel = open_out ".preferences" in
                        output_string file_channel ("username="^name^"\n") ;
                        close_out file_channel ) ;
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        for _ = 0 to niterations - 1 do
                age := !age + 1 ;
                print_endline ("One year passed...") ;
                print_endline ("You are " ^ (string_of_int !age) ^ ".")
        done
