



//class Person(_firstName: String, _lastName: String){
    //val firstName: String = _firstName
    //val lastName: String = _lastName

    /*init {//another way of initializing
        firstName = _firstName
        lastName = _lastName
    }*/
//}

class Person(val firstName: String, val lastName: String){//Primary Constructor
    var nickName: String? = null
        //Overriding default getter/setter
        set(value1){
            field = value1
            println("the new nickname is $value1")
        }
        get(){
            println("the returned value is $field")
            return field
        }

    fun printInfo(){
        //?: takes the right-hand value if the left-hand value is null (the elvis operator)
        val nickNameToprint = nickName ?: "no nickname"
        println("$firstName $lastName $nickNameToprint")
    }

    init {//init blocks run first in the order, then secondary
          //constructor runs
        println("init 1")
    }

    constructor(): this("Peter", "Parker") {//Secondary Constructor
        println("Secondary Constructor")
    }

    init {
        println("init 2")
    }
}