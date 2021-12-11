# Regular expressions and conditionals

In this lesson, we inspect the name supplied by the user to see if it is a good name.

We do this using regular expressions from the `Str` module.

We use the regular expression `^[A-Z][a-z]+$`, which means an upper case letter, followed by one or more lowercase letters.

We first need to compile the regular expression using `Str.regexp`, because regular expressions are complied into finite state automata, and this is something that can be expensive and should be done only once.

Then we can pass this compiled regular expression to `Str.string_match` to apply it to the supplied name.

The third argument of `Str.string_match` is the position to start matching on the supplied string, which is always 0 in this case for the beginning of the string.

`Str.string_match` returns a boolean, which we use in a `if ... then ... else ...` conditional to print one of two messages depending of the result.

Note that it appears that a semicolon is missing, but this is not true. Semicolons are use to chain multiple expressions one after another, and and if-then-else construct is an expression, so we must only add the semicolon after the complete if-then-else. The body between `if` and `then` it a single expression. The body after `else` is also a single expression, but the semicolon closes the `if-then-else` expression, not the body of the `else` part.

The `Str` module is not part of the standard library, so we must include it in the `libraries` section of the `dune` file.

