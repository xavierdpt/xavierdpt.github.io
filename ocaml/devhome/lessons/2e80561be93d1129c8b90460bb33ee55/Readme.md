# Options

Option types are great when a value can be potentially missing.

In this case, the user name can be found in the preferences, or not.

If it is found, we can use a variable of type `string option` with the constructor `Some` to hold the value.

If it is not found for any reason, we use the constructor `None`.

We can then later use pattern matching to use the value when it was found, or ask interactively the username when it is not found.

This is done using a `match ... | ... -> ...` construct.
