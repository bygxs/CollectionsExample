package com.biniyam.collectionsexample


// this is created in file actually
// these fucnctional interfaces ONLY hold one abstract function method
 fun interface MyFunctionalInterface {

     fun sayHello():String
}
fun interface  MyFunctionalInterface2 {

    fun incrementByFive(a:Int):Int
}
fun interface stringConcatination {

    fun stringConcat (s1:String, s2:String):String

}