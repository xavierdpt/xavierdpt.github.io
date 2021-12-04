let x = 5
let y = 7

let smart () =
        Format.open_box 0 ;
        Format.print_string "margin = ";
        Format.print_int (Format.get_margin ()) ;
        Format.print_string "; max_indent = ";
        Format.print_int (Format.get_max_indent ()) ;
        Format.print_string "; max_boxes = ";
        Format.print_int (Format.get_max_boxes ()) ;
        Format.print_string "; ";
        Format.print_bool (Format.check_geometry {max_indent=10 ; margin=5}) ;
        Format.close_box () ;
        Format.print_newline ()

let () = for i = 0 to Array.length Sys.argv - 1 ; do
        print_endline Sys.argv.(i) ;
        print_endline (string_of_int x) ;
        print_endline (string_of_int y) ;
        print_endline (string_of_int Foobar.bar) ;
        print_endline Foobar.john.name ;
done ; smart ()
