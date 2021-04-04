

//functions also support Type Reference
fun getGreeting(): String? = "Hello Kotin"

fun sayHello(greeting: String): Unit{//same as void in java, but no need to mention
    print("Hello $greeting")//This $ is called String template
    print(getGreeting())
}

//function as parameter8


fun main() {
    print(getGreeting())
    sayHello("Hi")
}