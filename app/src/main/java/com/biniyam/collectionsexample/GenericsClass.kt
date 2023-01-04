package com.biniyam.collectionsexample

class GenericsClass<T,V> (val t:T, val v:V){  // T for Type kotlin constructor (val t:T)

    fun print(){
        println("first:$t, second:$v")
    }

    // () is constructor in kotlin and : colon is extends
}