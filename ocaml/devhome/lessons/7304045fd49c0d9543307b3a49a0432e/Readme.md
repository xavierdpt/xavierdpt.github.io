# Command line arguments

In this program, we store the iteration count in a variable `niterations` which is read from the command line.

The command line arguments are made available in the `argv` variable of the `Sys` module.

The 0th element is the name of the program, and the 1th element is the first argument in on the command line.

Accessing element `i` uses the quite peculiar `.(i)` syntax.

We then use `int_of_string` to convert this string value to an integer.

Use `./run_project.bsh 5` to run the program for five iterations.
