import java.lang.RuntimeException
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

//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
infix fun<E> Collection<E>.shouldContain(element: E): Unit{
    if(!this.contains(element))
        throw RuntimeException()
}

fun main1() {
    val listOfName = listOf("X", "Y", "Z")
    listOfName shouldContain "Z"
}

//If we use lateinit, then no need to initialze with null or blank
//Use case : when properties can be initialized through dependency injection, or in the setup method of a unit test
/*Restrictions: lateinit property type cannot be a primitive type
                lateinit property can not make use of custom getter or setter code
                accessing lateinit property before initialization, will throw UninitializedPropertyAccessExcetion*/
public class MyTest {
    var showAnswerButton: String? = null
    lateinit var person: Person
}
//------------------------DELEGATE PROPERTY----------------------------
/*There are certain common kinds of properties, that, though you can implement them manually every
time you need them, it would be helpful to implement them once and add to a library. Examples include:

Lazy properties: the value gets computed only upon first access.
Observable properties: listeners get notified about changes to this property.
Storing properties in a map, instead of a separate field for each property.*/
class Example {
    var p: String by Delegate()
}

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

fun main() {
    val e = Example()
    println(e.p)
    e.p = "NEW"
    println(lazyValue)//1st time it calls the
    println(lazyValue)
    val user = User()
    user.name = "first"
    user.name = "second"
    val user1 = MutableUser(mutableMapOf(
            "name" to "John Doe",
            "age"  to 25
    ))
    println(user1.name) // Prints "John Doe"
    println(user1.age)  // Prints 25
}
//Delegated Property with lazy
/*lazy() is a function that takes a lambda and returns an instance of Lazy<T> which can
serve as a delegate for implementing a lazy property: the first call to get() executes
the lambda passed to lazy() and remembers the result, subsequent calls to get() simply
return the remembered result.*/
val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

//Observable properties
class User {
    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("$old -> $new")
    }
}

//Storing properties in a map
class MutableUser(val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int     by map
}