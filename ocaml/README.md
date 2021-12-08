


# Docker setup

We use docker to work in a more predictable environment.

To install docker on an ubuntu-like system, you can probably do the following:

```
sudo apt-get install docker.io
sudo usermod -G docker -a `id -un`
```

Then logout and log back in to access get the docker group permissions, or use this command to start a new shell with the new permissions
```
su `id -un`
```

Use `create.bsh` to create the docker image.

Use `enter.bsh` to start the docker image and enter the development environment.

# Development environment setup

Use `init_opam.bsh` to initialize opam.

Source `setenv.source` to import the opam environment variables.

Use `init_ocaml_4.13.1.bsh` to install the latest version of OCaml (currently 4.13.1) in the development environment.

Source `setenv.source` to switch to the installed OCaml version.

Use `init_dune.bsh` to install dune (build systep)
Use `init_utop.bsh` to install `utop` (better REPL)
Use `init_merlin.bsh` to install merlin (vim support)

To create a new project, adapt `create_helloword_project.bsh`. The helloworld project is already created.


# helloworld project

`helloworld` is a dune project with some example code

`helloworld.ml` and `foobar.ml` are source files

`foobar.mli` is an interface source file

`dune` and `dune-project` are dune configuration files

Use `build_project.bsh` to build the project

Use `run_project.bsh` to run the program

# Miscellaneous

`links.txt` contains some useful links

`bits/bits.ml` contains some syntax collected from the documentation which will be sorted out later.
