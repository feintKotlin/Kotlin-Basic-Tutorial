package com.feint

fun main(args: Array<String>) {
    val son = Son()
    println(son.name)

    val sond=SonD()

    sond.name="feint"

    println(sond.name)

    val win=Window()

    win.addListener(object :Listener(){
        override fun a() {

        }
    })

    println(Fruit.APPLE.ordinal)
    println(Color.RED.value)

    println(Request.SUCCESS.req())

    Single.a()

    val s:Parent=Son1()

    when{
        s is Son1->{

        }

        s is Son2->{

        }
    }

    val user=User("feint",20)

    println(user.toString())

    val user2=user.copy()

    if(user==user2){
        println("The Same Value")
    }
    if(user===user2){
        println("The Same Object")
    }

    //componentN
    val (_,age)=user
}


//类的继承
////构造函数

class A constructor(name: String, age: Int) {
    var name: String = ""
    var age: Int = 0

    init {
        this.name = name
        this.age = age
    }
}

class B(var name: String, var age: Int) {

}

class C(name: String) {
    constructor(name: String, age: Int) : this(name) {

    }
}

////继承与重写
open class Basic() {
    var name: String = ""

    constructor(name: String) : this() {
        this.name = name
    }

}

class Son : Basic("name") {

}

open class BasicA() {
    open var name: String = ""
    open fun a() {

    }
}

class SonA() : BasicA() {
    override var name: String = ""
    final override fun a() {

    }
}

abstract class BasicB {
    abstract val name: String

    var age: Int = 0

    abstract fun a()

    fun b() {

    }
}

interface IBasic {
    var age: Int
    fun a() {

    }
}

interface IBasicA {
    fun a() {

    }
}

class SonC(override var age: Int) : IBasic, IBasicA {
    override fun a() {
        super<IBasic>.a()
        super<IBasicA>.a()
    }

}

//属性和字段
class SonD{
    var name:String=""
        get() ="name is $field"

    val age:Int=0
}

class SonE:BasicB{
    override val name: String=""

    val list= mutableListOf<Int>(1,2,4)

    inline val listLenght:Int
        get() = list.size


    lateinit var listA:List<Int>

    constructor(){
        listA=List<Int>(10){it:Int->it+1}
    }

    override fun a() {

    }

}

//特别的类

////嵌套类
class Big{
    inner class Small{

    }

    fun b(){
        val s=Small()
    }
}

abstract class Listener{
    abstract fun a()

}

class Window{
    fun addListener(listener:Listener ){
        listener.a()
    }
}
////枚举类

enum class Fruit{
    APPLE,BANANA
}

enum class Color(val value:Int){
    RED(0xff0000),
    GREEN(0x00ff00)
}

enum class Request{

    SUCCESS{
        override fun req():String{
            return "Success"
        }
    },
    FAILED{
        override fun req(): String {
            return "Failed"
        }
    };

    open fun req():String{
        return "None"
    }
}

////单例类

object Single{
    fun a(){

    }
}

class Container{
    companion object {
        val a:Int=0
        fun doIt(){

        }
    }

    fun a(){
        doIt()
    }
}

fun staticMethod(){

}
////封装类

sealed class Parent{

}

class Son1:Parent(){}

class Son2:Parent(){}

////数据类
data class User(val name:String ,val age:Int)