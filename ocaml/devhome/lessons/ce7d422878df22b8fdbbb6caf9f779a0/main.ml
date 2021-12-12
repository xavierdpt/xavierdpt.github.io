let () = let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        and pfe : bool = Sys.file_exists ".preferences"
        and preferences : (string,string) Hashtbl.t = Hashtbl.create 0
        in
        if pfe then (
                print_endline "Preferences file found" ;
                let file_channel : in_channel = open_in ".preferences" in
                try let line : string = input_line file_channel in
                    match String.index_from_opt line 0 '=' with
                    | None -> ()
                    | Some x -> let left : string = String.sub line 0 x
                            and right : string = String.sub line (x+1) ((String.length line) - x - 1)  in
                                    if (String.trim right = "") then ()
                                    else Hashtbl.add preferences left right ;
                        close_in file_channel
                        with | _ -> close_in_noerr file_channel;
                                print_endline ("Could not read preferences file")
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
