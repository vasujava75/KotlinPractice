fun main(args: Array<String>) {
    //println("Hello World!")
    val s:String? =null

    //Child().foo()
    fun foo(list:List<Int>){
        list.forEach{
            if(it==0)  return
            print(it)
        }
        print("xxxx")
    }
    fun foo1(list:List<Int>){
        list.forEach{
            if(it==0)  return@forEach
            print(it)
        }
        print("====")
    }
    fun bar(list:List<Int>){
        for(element in list){
            if(element==0)break
            print(element)
        }
        println("*******")
    }

    foo1(listOf(1,0,3))
    bar(listOf(1,0,3))
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
   // println("Program arguments: ${args.joinToString()}")

    val heroes = listOf(
        Hero("The Captain", 60, Gender.MALE),
        Hero("Frenchy", 42, Gender.MALE),
        Hero("The Kid", 9, null),
        Hero("Lady Lauren", 29, Gender.FEMALE),
        Hero("First Mate", 29, Gender.MALE),
        Hero("Sir Stephen", 37, Gender.MALE))

}

data class Hero(val name:String, val age:Int,val gender: Gender?)

enum class Gender{
    MALE,
    FEMALE
}
interface MyInterface {
    val prop: Int

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class Child : MyInterface {
    override val prop: Int = 29
}

abstract class Polygon {
    abstract fun draw()
}