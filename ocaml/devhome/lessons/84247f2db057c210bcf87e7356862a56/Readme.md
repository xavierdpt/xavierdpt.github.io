# Be functional

`Scanf.bscanf` is a bit different from other implementation of this family of features, because it can also returns values directly.

Here, instead of declaring `name` as a string reference, then assigning to it, we direclty assign the result of `bscanf` to `name`.

To do this, we declare an `identity` "function" which simply returns the value it was given. Here it is a string, but it would be quite simple to make it polymorphic so that it can work with any types.

Then `bscanf` itself returns this value to name.
