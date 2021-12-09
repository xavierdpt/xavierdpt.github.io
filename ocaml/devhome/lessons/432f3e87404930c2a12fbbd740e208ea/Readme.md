# An excuse for currying

I was slightly annoying by having to introduce a new `let ... in ...` level simply so that I can assign the `name` variable.

This makes it a good opportunity to introduce currying.

`Scanf.scanf` expects a function that takes a single string, because there is a single string format specifier in the format string.

But we really want to use a function `assign` that takes as arguments a reference to a string, as well as the new value, so that we can assign that string to that reference.

The solution is to bind the `name` to the `string` reference first, then gives this partially applied function to `scanf` so that it can bind the other arguments. This is called "currying", from the name of a guy who liked that kind of things a lot.
