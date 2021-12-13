# Accessing environment variables

To access environment variables, we can use the `getenv_opt` function from the `Sys` module.

In this program, wt try to read the number of iterations from the command line

If this fails, either because the argument is missing or because it cannot be parsed to a string, we obtain the value of the `NITERATIONS` environment variable and try to convert it to a string.

If the environment variable `NITERATIONS` is not set, we use the default value 2. And if it is set but the string cannot be parsed into a number, we also use the default value 2 but display a warning.

To the program with the environment variable set, you can do, for example:

```
NITERATIONS=4 ./run_project.bsh
```

To also set the number of iterations on the command line, you can do, for example:
```
NITERATIONS=4 ./run_project.bsh 3
```

