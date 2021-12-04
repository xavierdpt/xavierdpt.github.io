module Aux  : sig
        val default_age : int
end = struct
        let default_age=45
end

type person = {
        name : string ;
        age: int ;
}
let john = {
        name = "John Doe" ;
        age = Aux.default_age ;
}
let bar = john.age
