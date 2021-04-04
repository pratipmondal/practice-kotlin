//In higher order lamda function use inline function if the content of inline function is smaller in size
//If you write a function as inline, it will not create new object & instead will just copy the content of the inline function


fun main() {
    inlineFunction { println("Calling Inline Function") }
    inlineFunction { println("Calling Inline Function") }
    inlineFunction { println("Calling Inline Function") }
}

inline fun inlineFunction(fn: () -> Unit){
    fn()
    println("Code Inside Inline Function")
}