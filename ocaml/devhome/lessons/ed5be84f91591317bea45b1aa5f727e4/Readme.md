# Catching exceptions

The program expects the first argument of the command line to be a number.

When the program is run with no arguments, it throws an exception and terminates.

When the program is run with an argument which cannot be parsed into a number, it throws another kind of exception and terminates.

To catch exception in OCaml, we can use the `try ... with ...` construct, which expect a pattern structure in which we can define different responses for different exceptions.

To catch all exceptions, we use the `_` pattern which matches everything.

The response in this case is to a print a message, then returns the default value `2`.
