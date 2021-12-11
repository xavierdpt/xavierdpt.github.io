# Reading input

To read input from the standard input, we can use the `scanf` function from the `Scanf` module.

The first argument of `scan` is the format specifier. In this case, we want to read the input string until the end of the line, so we use `%s` to specify a string, and `@\n` to specified to stop at the end of the line.

The second argument is a function that can be used to process the input. In this case, we are not interested to do anything with it, so we use the identity function `id` from the `Fun` module.

We also reordered the instructions so that the "Invalid argument" warning, the question, the input and the rest of the program happen in this order.
