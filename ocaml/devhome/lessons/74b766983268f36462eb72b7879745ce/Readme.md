# Regular expressions (and conditionals)

In this lesson, we inspect the name supplied by the user to see if it is a good name.

We do this using regular expressions from the `Str` module.

We use the regular expression `^[A-Z][a-z]+$`, which means an upper case letter, followed by one or more lowercase letters.

We first need to compile the regular expression using `Str.regexp`.

Then we can pass this compiled regular expression to `Str.string_match` to apply it to the supplied name.

The third argument of `Str.string_match` is the position to start matching on the supplied string, which is always 0 in this case.

`Str.string_match` returns a boolean, which we use in a `if ... then ... else ...` conditional to print one of two messages depending of the result.

Note that it appears that a semicolon is missing, but this is not true. Semicolons are use to execute multiple expressions one after another, and and if-then-else construct is an expression, so we must only add the semicolon after the complete if-then-else

Finally, the `Str` module is not part of the standard library, so we must include it in the `libraries` section of the `dune`.

