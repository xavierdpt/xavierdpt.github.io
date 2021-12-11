# Reference variables

In functional programming languages, variables are immutable.

But in the imperative paradigm, variables are mutable.

To support imperative programming with mutable variables, OCaml defines the `ref` data type.

To declare a mutable value, use the `ref` constructor, for example, `ref 33`. The type of this variable is `int ref`.

To obtain the value of a reference variable, use the exclamation mark, as in `!age`.

