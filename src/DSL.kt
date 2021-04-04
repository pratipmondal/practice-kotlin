import java.lang.RuntimeException


infix fun<E> Collection<E>.shouldContain(element: E): Unit{
    if(!this.contains(element))
        throw RuntimeException()
}

fun main() {
    val listOfName = listOf("X", "Y", "Z")
    listOfName shouldContain "Z"
}