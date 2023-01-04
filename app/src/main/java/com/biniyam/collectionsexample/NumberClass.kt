package com.biniyam.collectionsexample

class NumberClass<T:Number>(val t:T) {

    fun square():Double{
        return t.toInt()*t.toDouble()
    }

    /*
    These are Functional interfaces

       1.Predicate checks Boolean example in lambda removeIf()
       2.Consumer
       3.Supplier is a get method
       4.Comparator compares two values give +ve or -ve or just 0 zero

     */


}