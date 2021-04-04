


//By Default Kotlin Classes are closed or can't be extended
//Need to add open keyword before BasicInfoProvider
class FancyInfoProvider : BasicInfoProvider(){
    override val sessionIdPrefix: String
        get() = "FancySession"

    override val providerInfo: String
        get() = "FancyInfoProvider"

    override fun printInfo(person: Person) {
        super.printInfo(person)
        println("FancyInfo")
    }
}