# Allowing preferences values to contain an '=' sign.

Instead of splitting on `'='`, we can look for the first `'='` character, then use the remainder of the line as the value.

If '=' is not found, the line is ignored.

If the right part is an empty string or a string containing blanks, the line is ignored.

To achieve this, we use the `index_from_opt`, `sub`, `length` and `trim` functions from the `String` module.
