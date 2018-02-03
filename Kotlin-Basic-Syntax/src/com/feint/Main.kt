package com.feint

import com.sun.org.apache.bcel.internal.generic.FLOAD
import com.sun.tools.corba.se.idl.constExpr.Equal
import org.w3c.dom.ranges.Range
import kotlin.test.assertEquals

fun main(args: Array<String>) {

    //常用类型

    ////基本类型

    //////常量、变量
    val a = 10

    var b = 20

    b = 30

    val c: Int = 10

    println(c)

    //////类型转换

    var typeA: Int = 10_000_000

    var typeB: Float = 10.0f


    println(typeA)


    //////值比较
    val eqA = EqualsTest(10)

    val eqB = EqualsTest(10)

    if (eqA === eqB) {
        println("address equals")
    }

    if (eqA == eqB) {
        println("equals")
    }
    ////字符串

    //////字符串模版

    val strA = "this is a typeA" + typeA

    val strB = "this is a ${typeA} ${eqA.a} ${1 + 2 + 4}"

    //////多行字符串
    val strC = """
       |this is a multi

        |line string
    """.trimMargin()

    println(strC)

    ////数组
    val arrayA = Array<Int>(10) { i: Int ->
        return@Array i + 1
    }

    println(arrayA[0])

    val arrayB = arrayOf(10, 30, 20, 30)


    ////集合类

    val listA = listOf<Int>(10, 230, 20)

    val listB = mutableListOf<Int>(10, 103)

    listB.add(10)

    val mapA = hashMapOf<Int, String>(1 to "one", 2 to "two")

    mapA.forEach { t, u ->
        println("$t:$u")
    }
    listA.forEach { i: Int ->
        println(i)
    }


    //流程控制语句

    ////if else
    if (true) {

    } else if (true) {

    } else {

    }

    ////for
    for (i in 1..10) {
        println("i is $i")
    }
    lab@ for (item in listA) {
        println("list item is $item")
    }

    ////while
//
//    label@while (true){
//        while (true){
//            while (true){
//                break@label
//            }
//        }
//    }
//
//    do {
//
//    }while (true)

    //表达式

    ////if else 表达式

    val eB=true

    val eA=if(eB) 10 else 20

    ////when 表达式

    when(eA){
        10->{

        }
        20->{

        }
    }

    val wA=when(eA){
        10->{

        }
        20->{

        }
        else->{

        }
    }

    val wB=when{
        eA in 1..20-> {

        }

        eA in 21..30->{

        }

        else->{

        }
    }


    val basic:Basic=BasicA()
    val wC =when{
        basic is BasicA->{

        }

        basic is BasicB->{

        }

        else->{

        }
    }

    ////范围表达式
    for(i in (10 downTo 1).step(2)){
        println(i)
    }

}

open class Basic{

}

class BasicA: Basic() {

}

class BasicB: Basic() {

}

class EqualsTest(val a: Int) {
    override fun equals(other: Any?): Boolean {
        return if (other is EqualsTest) a == other.a else false
    }
}


