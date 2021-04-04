



fun main() {
    val interestingThings = arrayOf("Kotlin", "Programming", "Books")
    println(interestingThings.size)
    println(interestingThings[0])
    println(interestingThings.get(0))

    for (interestingThing in interestingThings){
        println(interestingThing)
    }

    interestingThings.forEach {
        println(it)
    }

    interestingThings.forEach {
        x -> println(x)
    }

    interestingThings.forEachIndexed { index, inter ->
        println("$inter is at index $index")
    }

    val inter = listOf("Kotlin", "Programming", "Books")
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    map.forEach{key, value -> println("$key --- $value")}

    //interestingThings.add is not possible because by defaullt kotlin Collections are immutable

    val x = mutableListOf("Kotlin", "Programming", "Books")
    x.add("Dogs")

    sayHello("Hi", "Kotlins", "Programming");
    //Spread Operator = * = If you want to pass Array in vararg
    sayHello("Hi", *interestingThings);
    //Named parameter, but limitation is that all the params you have to use named parameter
    greetPerson(greeting = "hi", name = "Pratip")
    //Default value in function greetPerson1
    greetPerson1()//Even no need any params, it will take default values

    val person = Person("Pratip", "Mondal")
    person.firstName
    person.nickName = "pratmond"
    println(person.nickName)
    person.printInfo()


}

fun sayHello(greeting: String, vararg items: String){
    items.forEach { item ->
        println("$greeting $item")
    }
}

fun greetPerson(greeting: String, name: String) = println("$greeting $name")
fun greetPerson1(greeting: String = "Hello", name: String = "Kotlin") = println("$greeting $name")