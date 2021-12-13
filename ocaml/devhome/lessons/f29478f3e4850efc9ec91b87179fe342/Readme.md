# Reading all the lines

`input_line` throws the exception `End_of_file` when the end of the file is reached.

To read all the lines, we just use an infinite `while true` loop, and catch the `End_of_file` exception to silently close the file.

Any other exception will be caught by the other `_` match clause and trigger a warning.
