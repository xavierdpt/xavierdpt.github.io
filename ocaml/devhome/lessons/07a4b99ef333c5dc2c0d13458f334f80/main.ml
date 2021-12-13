let () = Random.self_init ();
        let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> let default = match Sys.getenv_opt "NITERATIONS" with
                        | Some x -> (try int_of_string x with
                                | _ -> print_endline "Invalid environment value for NITERATIONS, using hardcoded value 2" ;
                                       2)
                        | None -> 2 in
                print_endline ("Invalid argument, setting number of iterations to default value "^(string_of_int default)) ;
                default
        and pfe : bool = Sys.file_exists ".preferences"
        and preferences : (string,string) Hashtbl.t = Hashtbl.create 0
        in
        if pfe then (
                print_endline "Preferences file found" ;
                let file_channel : in_channel = open_in ".preferences" in
                try while true do
                        let line : string = input_line file_channel in
                        match String.index_from_opt line 0 '=' with
                        | None -> ()
                        | Some x -> let left : string = String.sub line 0 x
                                    and right : string = String.sub line (x+1) ((String.length line) - x - 1)  in
                                            if (String.trim right = "") then ()
                                            else Hashtbl.add preferences left right
                done with
                | End_of_file ->
                        close_in_noerr file_channel;
                | _ ->
                        print_endline ("Could not read preferences file") ;
                        close_in_noerr file_channel
        ) ; 
        let name : string = match Hashtbl.find_opt preferences "username" with
                | Some x -> print_endline "Using name from preferences" ; x
                | None -> (print_endline "What is your name?" ;
                let input : string ref = ref (Scanf.scanf "%s@\n" Fun.id)
                and name_regexp : Str.regexp = Str.regexp "^[A-Z][a-z]+$" in
                while not (Str.string_match name_regexp  !input 0) do
                        print_endline ("I don't like that name, try again! What is your name?") ;
                        input := (Scanf.scanf "%s@\n" Fun.id)
                done ; !input)
        and age : int ref = ref (1 + Random.int 100) in
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
