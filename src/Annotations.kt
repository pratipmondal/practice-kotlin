//Kotlin sees these 2 functions a List<Any>
//Hence, to distinguise we need to define @JvmName, though kotlin will call by real name
//But Java will call with filterStrings or filterInts

@JvmName("filterStrings")
fun filter(list: List<String>){

}
@JvmName("filterInts")
fun filter(list: List<Int>){

}

@JvmOverloads//This annotaion will create 3 different overloaded functions in compiled code
fun fooMethod(name: String="Harry", location: String="USA"){

}

fun main() {
    fooMethod("")
}