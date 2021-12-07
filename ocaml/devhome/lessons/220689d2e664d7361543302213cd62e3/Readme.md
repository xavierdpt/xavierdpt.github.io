# Functions for imperative programming

It's starting to become maybe a bit complicated here.

We extracted the priting of the age to a function `print_age`.

This function takes an integer `age` as it's sole argument, and uses it to display the age.

Every function in OCaml has a return type. In other well-known languages such as Java, C or C++, the return type of functions which return nothing is called `void`. In OCaml, it is called `unit`.

We also define the `increase_age` function to increase the age and display a message. The sole argument of this function is a reference to an int (`int ref`), and also returns nothing so it's return type is `unit`. It consists of a sequence of two expressions, one for incrementing the age and one to display the message.

We then use these functions in the sequence instead of duplicating the code.
