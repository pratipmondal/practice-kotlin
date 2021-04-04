import java.time.LocalTime
//Kotlin has defined that which operators of LocalTime classes you can overload
//Java doesn't allow it & Scala allows anything to overload, but Kotlin is in middle & it controls
fun main() {
    var time = LocalTime.now()
    println(time)
    time++
    println(time)
    val a = "test"
    val b = "testMethod"
    println(a in b)
    var s = "Hello"
    println(s--)
    println(s)

    val a1 = BingoNumber("test1", 21)
    val a2 = BingoNumber("test2", 36)
    println(a1.compareTo(a2))
    println(a1 < a2)
    println(a2 > a1)
}

operator fun LocalTime.inc(): LocalTime = plusHours(4)

operator fun String.dec(): String {
    return toUpperCase()
}

class BingoNumber(val name: String, val age: Int){
    operator fun compareTo(other: BingoNumber): Int{
        return when{
            age < other.age -> -1
            age > other.age -> 1
            else -> 0
        }
    }
}