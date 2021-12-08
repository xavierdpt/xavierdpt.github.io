# Validating input

Here we use a temporary reference to hold the last user input until it consists of an upper case letter followed by lower case letter.

We store the regular expression in the `name_regexp` variable to not recompile it every time.

And we use a `while ... do ... done` loop to validate the user input.

The operation of reading a string is outsourced to the `read_string` no-arg function, which is actually a 1-arg function taking as input `()` through pattern-mathing, which is the only inhabitant of the `unit` type. That's how no-arg function are defined in OCaml.
