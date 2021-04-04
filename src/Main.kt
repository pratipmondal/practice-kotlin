
//In Kotlin String can't be null, but ? makes it possible
val name: String? = null //this is readable only
var greeting: String? = null
//Kotlin support Type Inferences, ie. No need to write String after name
val name1 = "Nate"
var greeting1 = null

fun main() {
    //If Else
    if(greeting != null){
        print(greeting)
    }else{
        println("Hi")
    }
    //When in Kotlin like Switch in Java
    when(greeting){
        null -> print("Hi")
        else -> print(greeting)//default in java switch
    }

    //if else can be used as expression
    val greetingToPrint = if(greeting != null) greeting else "Hi"
    print(greetingToPrint)
    //when can be also used as expression
    val greetingToPrint1 = when(greeting){
        null -> "Hi"
        else -> greeting
    }
}