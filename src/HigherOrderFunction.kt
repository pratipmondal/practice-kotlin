//Higher order function is a function which : returns another function or takes function as a parameter vale


//forEach is also a higher order function
//? means it's a nullable receiver
//?. is a safe operator
fun printFilteredStrings(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach{
        if(predicate?.invoke(it) == true){
            println(it)
        }
    }
}

val predicate: (String) -> Boolean ={
    it.startsWith("J")
}

fun getPrintPredicate(): (String) -> Boolean{
    return {it.startsWith("K")}
}

fun main() {
    val list = listOf("Kotlin", "Java", "C++")
    printFilteredStrings(list, {x -> x.startsWith("K")})
    printFilteredStrings(list) { x -> x.startsWith("K")}//The 2nd parameter here is a function
    printFilteredStrings(list, fun(it: String): Boolean {
        return it.startsWith("J")
    })
    printFilteredStrings(list, predicate)//passing function as variable
    printFilteredStrings(list){
        it.startsWith("J")
    }
    printFilteredStrings(list, null)
    printFilteredStrings(list, getPrintPredicate())
}