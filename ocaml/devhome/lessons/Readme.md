
* [Lesson 1: How to print a message on the screen](6c9383c6108f8438c47e5841cea595c2)
```
let () = print_endline "Hello user!"
```
* [Lesson 2: How to print two messages on the screen](00c8a6999f45bbcec57cf9b0777d5af2)
```
let () = print_endline ("Hello user!") ;
        print_endline ("You are 33.")
```
* [Lesson 3: String concatenation](659aa91d17d178fcd85efa66c1cb5bd5)
```
let () = print_endline ("Hello " ^ "user" ^ "!") ;
        print_endline ("You are 33.")
```
* [Lesson 4: Variables](a39d458217b4b440b7566d92b190bfb7)
```
let () = let name = "user" in
        print_endline ("Hello "^ name ^"!") ;
        print_endline ("You are 33.")
```
* [Lesson 5: Typed variables](8fc2679761cbdef8829dcafbed937491)
```
let () = let name : string = "user" in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are 33.")
```
* [Lesson 6: Declaring multiple variables](500aa18fcbf6744600aa02fe13e74357)
```
let () = let name : string = "user" and age : string = "33" in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ age ^ ".")
```
* [Lesson 7: Integer variables](97da4a0e1e41406c38d3683e962f4e75)
```
let () = let name : string = "user" and age : int = 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int age) ^ ".")
```
* [Lesson 8: Reference variables](f9092254c0124cd6546206095344c782)
```
let () = let name : string = "user" and age : (int ref) = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".")
```
* [Lesson 9: Imperative programming with reference variables](fe4c554998d47759827a7c4895b197a5)
```
let () = let name : string = "user" and age : (int ref) = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        age := !age + 1 ;
        print_endline ("One year passed...") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        age := !age + 1 ;
        print_endline ("One year passed...") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".")
```
* [Lesson 10: For loop](45c459dca8314d9926338244c9690c77)
```
let () =
        let name : string = "user" and age : (int ref) = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        for _ = 0 to 2 do
                age := !age + 1 ;
                print_endline ("One year passed...") ;
                print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        done
```
* [Lesson 11: Command line arguments](7304045fd49c0d9543307b3a49a0432e)
```
let () =
        let name : string = "user" and age : int ref = ref 33
        and niterations : int = int_of_string Sys.argv.(1) in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        for _ = 0 to niterations - 1 do
                age := !age + 1 ;
                print_endline ("One year passed...") ;
                print_endline ("You are " ^ (string_of_int !age) ^ ".")
        done
```
* [Lesson 12: Catching exceptions](ed5be84f91591317bea45b1aa5f727e4)
```
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
```
* [Lesson 13: Reading input](70f8b5317029bfd55d5deb10d3c8228a)
```
let () = let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        in print_endline "What is your name?" ;
        let name : string = (Scanf.scanf "%s@\n" Fun.id)
        and age : int ref = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        for _ = 0 to niterations - 1 do
                age := !age + 1 ;
                print_endline ("One year passed...") ;
                print_endline ("You are " ^ (string_of_int !age) ^ ".")
        done
```
* [Lesson 14: Regular expressions and conditionals](74b766983268f36462eb72b7879745ce)
```
let () = let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        in print_endline "What is your name?" ;
        let name : string = (Scanf.scanf "%s@\n" Fun.id)
        and age : int ref = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        if Str.string_match (Str.regexp "^[A-Z][a-z]+$") name 0 then
                print_endline ("That's a good name.")
        else
                print_endline ("I don't like that name.") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        for _ = 0 to niterations - 1 do
                age := !age + 1 ;
                print_endline ("One year passed...") ;
                print_endline ("You are " ^ (string_of_int !age) ^ ".")
        done
```
* [Lesson 15: Validating input](f9c8c7ad2717ceaf9a9b42e5139f4316)
```
let () = let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        in print_endline "What is your name?" ;
        let name : string = (
                let input : string ref = ref (Scanf.scanf "%s@\n" Fun.id)
                and name_regexp : Str.regexp = Str.regexp "^[A-Z][a-z]+$" in
                while not (Str.string_match name_regexp  !input 0) do
                        print_endline ("I don't like that name, try again! What is your name?") ;
                        input := (Scanf.scanf "%s@\n" Fun.id)
                done ; !input
        )
        and age : int ref = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        for _ = 0 to niterations - 1 do
                age := !age + 1 ;
                print_endline ("One year passed...") ;
                print_endline ("You are " ^ (string_of_int !age) ^ ".")
        done
```
* [Lesson 16: Checking if a file exists](eaade4d4ae7bf75e7b7ea81647e16cb6)
```
let () = if Sys.file_exists ".preferences" then
                print_endline ("Preferences file found")
        else
                print_endline ("Preferences file not found") ;
        let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        in print_endline "What is your name?" ;
        let name : string = (
                let input : string ref = ref (Scanf.scanf "%s@\n" Fun.id)
                and name_regexp : Str.regexp = Str.regexp "^[A-Z][a-z]+$" in
                while not (Str.string_match name_regexp  !input 0) do
                        print_endline ("I don't like that name, try again! What is your name?") ;
                        input := (Scanf.scanf "%s@\n" Fun.id)
                done ; !input
        )
        and age : int ref = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        for _ = 0 to niterations - 1 do
                age := !age + 1 ;
                print_endline ("One year passed...") ;
                print_endline ("You are " ^ (string_of_int !age) ^ ".")
        done
```
* [Lesson 17: Creating an empty file](f1c41846f4852e15fe2894aebbcd9c53)
```
let () = if Sys.file_exists ".preferences" then
                print_endline ("Preferences file found")
        else (
                print_endline ("Preferences file not found, creating it") ;
                let file_channel : out_channel = open_out ".preferences" in close_out file_channel ) ;
        let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        in print_endline "What is your name?" ;
        let name : string = (
                let input : string ref = ref (Scanf.scanf "%s@\n" Fun.id)
                and name_regexp : Str.regexp = Str.regexp "^[A-Z][a-z]+$" in
                while not (Str.string_match name_regexp  !input 0) do
                        print_endline ("I don't like that name, try again! What is your name?") ;
                        input := (Scanf.scanf "%s@\n" Fun.id)
                done ; !input
        )
        and age : int ref = ref 33 in
        print_endline ("Hello " ^ name ^ "!") ;
        print_endline ("You are " ^ (string_of_int !age) ^ ".") ;
        for _ = 0 to niterations - 1 do
                age := !age + 1 ;
                print_endline ("One year passed...") ;
                print_endline ("You are " ^ (string_of_int !age) ^ ".")
        done
```
* [Lesson 18: Writing to a file](9db3a296fe6fbfbe81bdc79b6643c035)
```
let () = let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        in print_endline "What is your name?" ;
        let name : string = (
                let input : string ref = ref (Scanf.scanf "%s@\n" Fun.id)
                and name_regexp : Str.regexp = Str.regexp "^[A-Z][a-z]+$" in
                while not (Str.string_match name_regexp  !input 0) do
                        print_endline ("I don't like that name, try again! What is your name?") ;
                        input := (Scanf.scanf "%s@\n" Fun.id)
                done ; !input
        )
        and age : int ref = ref 33 in
        if Sys.file_exists ".preferences" then
                print_endline ("Preferences file found")
        else (
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
```
* [Lesson 19: Reading from a file](84a4720ad77e0a0b6fb66b58e4ae9f79)
```
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
```
* [Lesson 20: Options](2e80561be93d1129c8b90460bb33ee55)
```
let () = let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        and pfe : bool = Sys.file_exists ".preferences"
        in
        if pfe then print_endline "Preferences file found" ;
        let name_from_preferences : string option = 
                if pfe then
                        let file_channel : in_channel = open_in ".preferences" in
                        try let line : string = input_line file_channel in
                            let parts : string list = (String.split_on_char '=' line) in
                            if List.length parts = 2 then
                                    let left = (List.nth parts 0) and right = (List.nth parts 1) in
                                    if left = "username" then Some right else (
                                        print_endline ("Expected key 'username', found key '"^left^"'") ;
                                        close_in file_channel ;
                                        None
                                    )
                            else (
                                print_endline ("Found preference with "^(string_of_int (List.length parts))^" parts") ;
                                close_in file_channel ;
                                None
                            )
                        with | _ -> close_in_noerr file_channel;
                                print_endline ("Could not read preferences file") ;
                                None
                else None in
        let name : string = match name_from_preferences with
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
```
* [Lesson 21: Allowing preferences values to contain an '=' sign.](13ea12c1cb92cc9e385deb1d942d8556)
```
let () = let niterations : int = try int_of_string Sys.argv.(1) with
                | _ -> print_endline "Invalid argument, setting number of iterations to default value 2" ; 2
        and pfe : bool = Sys.file_exists ".preferences"
        in
        if pfe then print_endline "Preferences file found" ;
        let name_from_preferences : string option = 
                if pfe then
                        let file_channel : in_channel = open_in ".preferences" in
                        try let line : string = input_line file_channel in
                            let eq_index : int option = String.index_from_opt line 0 '=' in
                            match eq_index with
                            | None -> print_endline "'=' not found, ignoring line" ; None
                            | Some x -> let left : string = String.sub line 0 x
                                    and right : string = String.sub line (x+1) ((String.length line) - x - 1)  in
                                            if left = "username" then
                                                    if (String.trim right = "") then (
                                                        print_endline ("Empty string value, ignoring line") ;
                                                        close_in file_channel ;
                                                        None
                                                    ) else Some right
                                            else (
                                                print_endline ("Expected key 'username', found key '"^left^"'") ;
                                                close_in file_channel ;
                                                None
                                            )
                        with | _ -> close_in_noerr file_channel;
                                print_endline ("Could not read preferences file") ;
                                None
                else None in
        let name : string = match name_from_preferences with
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
```
