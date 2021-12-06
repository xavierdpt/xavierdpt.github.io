# String concatenation

It is often useful to build strings from smaller parts.

To do this, we can use the string concatenation operator `^`.

But then the `print_endline` function will be applied only to the first part, so we use parentheses to apply the function to the whole result of the concatenations.

The program in `main.ml` also prints the string `Hello user!`, but using string concatenation to create the string.
