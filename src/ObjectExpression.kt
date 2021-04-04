
//Object Expression & decorating the object = ThreadSafe SingleTon in Kotlin
object EntityFactory1{
    fun create() = Entity1("id", "name")
}

class Entity1 constructor(val id: String, val name: String){
    override fun toString(): String {
        return "id:$id name:$name"
    }
}

fun main() {
    val entity = EntityFactory1.create()
    print(entity)
}