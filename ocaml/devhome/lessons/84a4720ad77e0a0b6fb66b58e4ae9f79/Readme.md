# Reading from a file

To read from a file, we use `open_in` to open the file for reading, then `input_line` to read a line from the file.

Then parsing the input is always more difficult than writing it. In this case, we expect the preferences file to contain a single line with one '=' sign, the left part of it being `"username"` and the right part being the username previously entered by the user. If we find that, we return it (in the variable name `right`). If anything goes wrong, we return a predefined constant `UnknownX` where `X` is a digit.

We store whether the preference file exists in the variable `pfe`. If true, we try reading the username from the preference file, otherwise, we collect the user's name from standard input, as before.

To parse the input, we use the `split_on_char` function from the `String` module, which return a list of string, and we use the `length` and `nth` functions from the `List` module to inspect the parts.

If opening the file produces an exception, we close it using the `close_in_noerr` function. But if the file is read correctly, then we close it using the `close_in` function.
