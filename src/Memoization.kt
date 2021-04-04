import java.time.LocalTime

val map = mutableMapOf<Int, Long>()
fun memfib(k: Int): Long{
    //return map.getOrPut(k){
        return when(k){
            0 -> 1
            1 -> 1
            else -> memfib(k-1) + memfib(k-2)
        }
    //}
}

fun main() {
    /*val startTime = System.currentTimeMillis()
    val result = memfib(45)
    val endTime = System.currentTimeMillis()
    val diff = endTime - startTime
    println("Total Time Taken = $diff millsec")
    println(result)*/
}

typealias Cache = HashMap<String, Boolean>