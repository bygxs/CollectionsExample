package com.biniyam.collectionsexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.annotation.RequiresApi
import java.util.LinkedList
import java.util.function.Consumer
import java.util.function.Predicate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // the difference between arrayList and linkedList
        //listExemple()
        // setExemple()
        //mapExample()
        // lambdaExample()
        //mapExample()
       // genericsExample()
       // predicateExample()
       // comparatorExample()
        consumerExample()


    }

    fun listExemple() {
        val arrayList = arrayListOf<Item>() // objects of the list are items empty
        val linkedList = LinkedList<Item>()

        // first list
        val i = Item("Bill", 1)
        arrayList.add(i)

        arrayList.add(Item("Bosse", 2322))
        arrayList.add(Item("Brenen", 3433))
        arrayList.add(Item("Bosse", 2322)) // here double identical items can be listed

        // second list

        linkedList.add(Item("Bill", 1))
        linkedList.add(Item("Bosse", 2))
        linkedList.add(Item("Brian", 3))

        val listView2 = findViewById<ListView>(R.id.list_view_bottom)
        val arrayAdapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, linkedList)
        listView2.adapter = arrayAdapter2


        val listView = findViewById<ListView>(R.id.list_view_top)
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        listView.adapter = arrayAdapter
    }

    fun setExemple() {
        val hashSet = hashSetOf<Item>()
        val linkedHashSet = linkedSetOf<Item>()


        //list 1
        hashSet.add(Item("Bill", 1))
        hashSet.add(Item("Bosse", 2))
        hashSet.add(Item("Brian", 3))
        hashSet.add(Item("Bill", 15))
        hashSet.add(Item("Bill", 1))  // sets only unique items are listed like Bill 1

        // list 2
        linkedHashSet.add(Item("Bill", 1))
        linkedHashSet.add(Item("Bosse", 2))
        linkedHashSet.add(Item("Brian", 3))
        linkedHashSet.add(Item("Bill", 15))
        linkedHashSet.add(Item("Bill", 1))

        //Abstract interfaces Generics class
        /* Generics General classes
        take whatever instead of specifying and binding it to one or two data types Generics uses all or
        whatever data type
        public class GenericsClass<T>{
            T t; //T for type
        }
                */

        // Consumer.  Java.util.function
        //Predicate.    takes type paramenter


        val listView1 = findViewById<ListView>(R.id.list_view_top)
        // adapter doesnt work normally change it tolist()
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, hashSet.toList())
        listView1.adapter = arrayAdapter


        val listView2 = findViewById<ListView>(R.id.list_view_bottom)
        val arrayAdapter2 =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, linkedHashSet.toList())
        listView1.adapter = arrayAdapter2


    }

    // databases use maps
    fun mapExample() {
        val hashMap = hashMapOf<String, Item>()
        val linkedHashMap = linkedMapOf<String, Item>()

        // list 1

        // instead of .add we use .set to add
        hashMap.set("a", Item("Bill", 3563))
        hashMap.set("b", Item("Bosse", 856))
        hashMap.set("c", Item("Banarne", 2299))
        hashMap.set("c", Item("Banarne", 229))

        // list 2
        // instead of .add we use .set to add
        linkedHashMap.set("a", Item("Bill", 3563))
        linkedHashMap.set("b", Item("Bosse", 856))
        linkedHashMap.set("c", Item("Banarne", 2299))
        linkedHashMap.set("c", Item("Banarne", 229))

        val listView1 = findViewById<ListView>(R.id.list_view_top)
        val arrayAdapter1 =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, hashMap.toList())
        listView1.adapter = arrayAdapter1

        val listView2 = findViewById<ListView>(R.id.list_view_bottom)
        val arrayAdapter2 =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, linkedHashMap.toList())
        listView2.adapter = arrayAdapter2

    }

    fun lambdaExample() {

        val msg = MyFunctionalInterface { "hello there" }

        val f = MyFunctionalInterface2 { it + 5 } //a -> a+5

        val s = stringConcatination { a, b -> a + b }

        val list = listOf<String>("Bill", "Doll", "Bob")


        println("message is: ${msg.sayHello()}")
        println("the number is: ${f.incrementByFive(22)}")
        println("the concatnated string is: ${s.stringConcat("first", "second")}")

        list.forEach { names -> println(names) } // this is Consumer

    }

    fun genericsExample() {
        val i = GenericsClass<Int,Int>(1,1)
        val d = GenericsClass<Double,String>(1.0,"hey")
        val s = GenericsClass<String,String>("hej","One Hej")
        val item = GenericsClass<Item,Int>(Item("Biniye",111),4)


        val number = NumberClass<Int>(2)

        i.print()
        d.print()
        s.print()
        item.print()

        println(number.square())


    }
    @RequiresApi(Build.VERSION_CODES.N)
    fun predicateExample(){

        val persons= arrayListOf<String>("Bill","Björn","Nööt")
        println(persons)

        persons.removeIf {kannel -> kannel[2] =='ö'}// kannel is input and kannel[2] =='ö' is output

        println(persons)
        persons.removeIf {kannel -> kannel.contains('ö') }// another way


    }

    fun comparatorExample(){
        val persons= arrayListOf<String>("Bill","Arnold","Björn","Nööt")

        println(persons)

        val reversedPersons = persons.reversed() as ArrayList<String>

        println(persons)



        persons.sortWith{a,b-> a.compareTo(b)}
        println(persons)


        persons.sortWith{a,b-> b.compareTo(a)}
        println(persons)


    }
    fun consumerExample(){
        val hashMap = hashMapOf<Int, Item>()


        // list 1

        // instead of .add we use .set to add
        hashMap.set(1, Item("Bill", 3563))
        hashMap.set(2, Item("Bosse", 856))
        hashMap.set(3, Item("Banarne", 2299))

        hashMap.keys.forEach{p-> println(p) }
        hashMap.values.forEach{p-> println(p) }


    }


}