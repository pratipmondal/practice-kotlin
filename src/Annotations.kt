
@JvmName("filterStrings")
fun filter(list: List<String>){

}
@JvmName("filterInts")
fun filter(list: List<Int>){

}

//Kotlin sees these 2 functions a List<Any>
//Hence, to distinguise we need to define @JvmName, though kotlin will call by real name
//But Java will call with filterStrings or filterInts