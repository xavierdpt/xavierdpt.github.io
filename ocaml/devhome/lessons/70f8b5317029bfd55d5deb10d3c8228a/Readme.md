# Reading input

It is sometimes useful to gather user input.

One function you can use for this is the `scanf` function from the `Scanf` module.

It takes two arguments: the format string, and a function to consume the input

The format string is `"%s"`, which denotes a string.

And `assign_name` is a function which takes the supplied string and assigns it to the `name` variable.

To do this, we converted the `name` from `string` to `string ref`, so that we `assign_name` can write into it.

We also introduce a second `let ... in ...` binding, so that `assign_name` can refer to the `name` variable from the outer scope.

This is not very robust and there is no error handling. As an exercise, you can try to make this program look better.


