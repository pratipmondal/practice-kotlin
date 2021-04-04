import kotlin.math.sqrt

fun squareRoot(k: Int) : Pair<Double, Double>{
    require(k >= 0)
    val root = sqrt(k.toDouble())
    return Pair(root, -root)
}

fun main() {
    val (pos, neg) = squareRoot(16)
    println("positive sqrt = $pos and negative sqrt = $neg")
    val (x, y ,z) = Triple(6, 7, 8)
    println("x = $x, y = $y, z = $z")
    val (k, v) = 16 to 17 //use of infix function as Pair(16, 17)
    //Infix function is allowed as a member function(ie. function inside a class) or extension function
    "hello" concat1 "world"
    val x1 = 5 + 7
    val x2 = 5.plus(7)
}

infix fun String.concat1(other: String): String {
    return this + other
}