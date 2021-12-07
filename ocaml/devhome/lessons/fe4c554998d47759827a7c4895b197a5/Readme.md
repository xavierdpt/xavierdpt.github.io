# Reference variables for imperative programming

Variables in OCaml are immutable, but OCaml also defines records and records can have mutable fields.

References are polymorphic records with a single mutable field which can be of any type, and they come with additional syntax sugar.

If that makes no sense right now, don't panic, the idea of this lesson is to start doing imperative programming in this functional language.

In this program, we convert the `age` variable to a reference-to-int. The type of that is `ref int`. The value is constructed with the `ref` constructor.

Once we have a reference to an int name `age`, we can obtain the value using `!age`, and we can update the value using the `:=` operator.

We use this to increase the age by one several times and print the new value.
