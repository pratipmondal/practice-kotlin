interface PersonInfoProvider{
    val providerInfo : String//Default value is not allowed & hence has to be overriden in SubClass
    fun printInfo(person: Person) {
        println(providerInfo)
        person.printInfo()
    }
}

interface SessionInfoProvider{
    fun getSessionId() : String
}

open class BasicInfoProvider : PersonInfoProvider, SessionInfoProvider {
    override val providerInfo: String
        get() = "BasicInfoProvider"

    open val sessionIdPrefix = "Session"//if we add protected modifier then it can be accessed by child class only

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("additional print statement")
    }

    override fun getSessionId(): String {
        return sessionIdPrefix
    }
}

//Type Checking & Type Casting

fun main() {
    val provider = BasicInfoProvider()
    provider.printInfo(Person())
    provider.getSessionId()

    checkTypes(provider)
    val provider1 = FancyInfoProvider()

    //Annomyous Inner Class with OBJECT EXPRESSION
    val provider2 = object : PersonInfoProvider{
        override val providerInfo: String
            get() = "New Infor Provider"

        fun getSessionId() = "id"
    }
    provider2.getSessionId()
}

fun checkTypes(infoProvider: PersonInfoProvider){
    if(infoProvider !is SessionInfoProvider){
        println("not a SessionInfoProvider")
    }else{
        println("is a SessionInfoProvider")
        //TypeCasting
        (infoProvider as SessionInfoProvider).getSessionId()
        infoProvider.getSessionId() //Compiler is doing smart casting
    }
}