



fun main() {
   val list = listOf("Kotlin", "Java", "C++", null, null, "Javascript")
    list
            .filterNotNull()
            .take(3)//only take 1st 3 items in list
            .takeLast(3)//take last 3
            .filter{it.startsWith("K")}
            .map{it.length}
            .forEach{
                println(it)
            }

    list
            .filterNotNull()
            .associate { it to it.length }//convert to Map
            .forEach{
                println("${it.key}, ${it.value}")
            }

    val language = list
            .filterNotNull()
            .find{it.startsWith("foo")}//Kotlin has findLast also
            .orEmpty()
    println(language)
}