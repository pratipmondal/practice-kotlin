import java.util.*

//Companion Object is a object source of instance of another class
//Companion object has access to it's private properties
//There is nothing called static in Kotlin but companion object is same like static in Kotlin
interface IdProvider{
    fun getId(): String
}

enum class EntityType{
    HELP, EASY, MEDIUM, HARD
}
class Entity private constructor(val id: String){
    companion object Factory: IdProvider{
        const val id = "id"
        fun create() = Entity(id)
        fun create1() = Entity(getId())
        override fun getId(): String {
            return "123"
        }
    }
}

object EntityFactory{
    fun create(type: EntityType) : Entity2{
        val id = UUID.randomUUID().toString()
        val name = when(type){
            EntityType.EASY -> type.name
            EntityType.MEDIUM -> type.name
            EntityType.HARD -> "Hard"
            EntityType.HELP -> type.name
        }
        return when(type){
            EntityType.EASY -> Entity2.Easy(id, name)
            EntityType.MEDIUM -> Entity2.Medium(id, name)
            EntityType.HARD -> Entity2.Hard(id, name, 2f)
            EntityType.HELP -> Entity2.Help
        }
    }
}

//Sealed Class vs Enum Class
/*Sealed class here have value Easy, Medium, Hard but look that
Hard has one extra parameter, this is the difference*/
sealed class Entity2{
    object Help : Entity2(){
        val name = "Help"
    }
    data class Easy(val id: String, val name: String): Entity2()
    data class Medium(val id: String, val name: String): Entity2()
    data class Hard(val id: String, val name: String, val multiplier: Float): Entity2()
}
//data classes are a concise manner of writing immutable data class
//Also, data class generate equals(), hasCode() , toString() automatically
//Also data class provides an extra copy() function
// === checks whether same references of not

fun Entity2.Medium.printInfo(){//printInfo() is the extension function
    println("Medium class: $id")
}

val Entity2.Medium.info: String//info is a Extension Properties
    get() = "some info"

fun main() {
    val entity = Entity.Factory.create()
    val entity1 = Entity.create()
    Entity.id

    val entity2: Entity2 = EntityFactory.create(EntityType.EASY)
    val msg = when(entity2){
        Entity2.Help -> "help class"
        is Entity2.Easy -> "easy class"
        is Entity2.Medium -> "medium class"
        is Entity2.Hard -> "hard class"
    }
    println(msg)

    val entity3 = Entity2.Easy("id", "name")
    val entity4 = entity3.copy(name = "new name")

    //Extension Function or Properties to an existing class
    Entity2.Medium("id", "name").printInfo()
    val entity5 = Entity2.Medium("id", "name")
    entity5.info

}