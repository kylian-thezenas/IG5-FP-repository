// Databricks notebook source
// MAGIC %md
// MAGIC ##Programming paradigms
// MAGIC ####Paradigm
// MAGIC - A way of struturing programs. An approach to solve computational problems
// MAGIC ####Main programming paradigms
// MAGIC - `Imperative` : step by step instructions that tell the computer how to perform tasks
// MAGIC - `Fonctionnal`: Computation is trated as the `evaluation` of mathematical functions and avoid changing state
// MAGIC - `Logic` : defining `fact and rules` that describe relationship between different entities
// MAGIC - `Object Oriented` : Programs organized around `object`, which are instance of classes that encapsulate data and behavior. It is descibed as orthogonal to other paradigms, meaning it can be combined with one of the other
// MAGIC ####Function 
// MAGIC - a block of code that takes inputs, performs computations and return a value
// MAGIC ####Method
// MAGIC - a method is a function that is associated with an object or class. in OOP, method are used to define behaviors for an object
// MAGIC ####Procedure
// MAGIC - a procedure is a type of function or methode that does not return a value

// COMMAND ----------

// MAGIC %md
// MAGIC ##Composable
// MAGIC - concept of a combining simple functions to create a complex one  
// MAGIC `f(x) = x * 2`  
// MAGIC `g(x) = x + 2`  
// MAGIC
// MAGIC a new function can be composed using f and g  
// MAGIC &nbsp;`h(x) = f(g(x))`  
// MAGIC &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      ` f(x + 2)`  
// MAGIC &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;      ` (x+ 2) * 2`  

// COMMAND ----------

def f(x: Int): Int = x + 2
def g(x: Int): Int = x + 2
def h(x: Int): Int = f(g(x))

// COMMAND ----------

// MAGIC %md
// MAGIC ##Scala Programming language

// COMMAND ----------

val name: String = "Scala"
val age: Int = 25

// COMMAND ----------

val name: String = "Scala"
val age: Int = "25"

// COMMAND ----------

// MAGIC %md
// MAGIC In python this will works but not in scala :  
// MAGIC `x = "Bob"`  
// MAGIC `print(x)`  
// MAGIC `x = 20`  
// MAGIC `print(x)`

// COMMAND ----------

// MAGIC %md
// MAGIC ##Operator

// COMMAND ----------

val x = 10
val y = 5
val z = x + y

// COMMAND ----------

// MAGIC %md
// MAGIC `+` is not a built-in operator in Scala. It is a method defined in class Int

// COMMAND ----------

val z = x.+(y)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Traits
// MAGIC - In scala it's a way to define an interface that a set of related class can share
// MAGIC - It is an abstraction mechanism that help development of modular, reusable and exensible code
// MAGIC - It's define by a set of method
// MAGIC - An interface in java only includes method signature
// MAGIC - Every class that inherits an interface must provide an implementation of the interface methods

// COMMAND ----------

trait Shape {
  def area(): Int
}

class Square(length: Int) extends Shape {
  def area = length * length
}

class Rectangle(length: Int, width: Int) extends Shape {
  def area = length * width
}

val square = new Square(10)
val area = square.area

// COMMAND ----------

// MAGIC %md
// MAGIC ##Tuples
// MAGIC - A tuples is a `container` for storing elements of differents types
// MAGIC - It is immutable

// COMMAND ----------

val twoElementContainer = (10, "Bob")
val threeElementContainer = ("15", "Franck", true)

// COMMAND ----------

// MAGIC %md
// MAGIC - a tuple is usefull in a situation where we want to group non related element
// MAGIC - if the element are the same type we can use collection 
// MAGIC - a tuple may be more appropriate to use when we have a function that return more than one value
// MAGIC - an element in a tuple has a `one-based inex`
// MAGIC

// COMMAND ----------

val first = threeElementContainer._1
val second = threeElementContainer._2
val third = threeElementContainer._3

// COMMAND ----------

// MAGIC %md
// MAGIC ##Collection
// MAGIC A collection is a container data structure, it contains `zero or more` elements.  
// MAGIC Those following collection are `zero-based inex`
// MAGIC - `Sequence`  
// MAGIC   - Array  
// MAGIC   - List  
// MAGIC   - Vector  
// MAGIC - `Sets`
// MAGIC - `Maps`

// COMMAND ----------

val arr = Array(10, 2, 30, 4)
arr(0) = 50
val first = arr(0)

// COMMAND ----------

val list = List(1, 2, 3, 4)
val list2 = (1 to 20).toList

// COMMAND ----------

val list3 = arr.toList

// COMMAND ----------

list3.isEmpty

// COMMAND ----------

// MAGIC %md
// MAGIC ###Vector
// MAGIC The vector is an hybrid class of list and array. It combines the performance of both

// COMMAND ----------

val v1 = Vector(0, 1, 2, 3, 4, 5)
val v2 = v1 :+ 6
val v3 = v2 :+ 7

// COMMAND ----------

// MAGIC %md
// MAGIC ## Sets
// MAGIC - Sets is an unordered collection of distinct elements
// MAGIC - It does no contains ducplicates
// MAGIC - We can not access element by their index
// MAGIC - Sets support `contains`and `isEmpty`

// COMMAND ----------

val fruits = Set("pomme", "orange", "banane", "ananas", "kiwi")
fruits.contains("fraise")

// COMMAND ----------

// MAGIC %md
// MAGIC ## Map
// MAGIC - Map is a collection of key-value pairs
// MAGIC - In other languages, it knows as dictionnary or hash map
// MAGIC - It is an efficient data structure for looking up a value by it's key

// COMMAND ----------

val capitals = Map("France"->"Paris", "Allemagne"->"Berlin", "Royaume-Uni"->"Londre")
val franceCapital = capitals("France")

// COMMAND ----------

// MAGIC %md
// MAGIC ##Higher-Order Methods on Collection Classes
// MAGIC - The real power of Scala collections comes form their higher-order methods
// MAGIC - A higher-order method takes a function as its input parameter
// MAGIC - It is important to note that higher-order method `does not mutate` a collection
// MAGIC - These includes:
// MAGIC   - map
// MAGIC   - flatmap
// MAGIC   - filter
// MAGIC   - foreach
// MAGIC   - reduce
// MAGIC
// MAGIC #### Map
// MAGIC The map method of scala collection applies its input function to `all the element` in the collection and return `another` collection

// COMMAND ----------

val myList = List(1, 2, 3, 4)
val multipliedList = myList.map(_ * 2)

// COMMAND ----------

// MAGIC %md
// MAGIC #### FlatMap
// MAGIC flatmap is a methopd that is similar to map, but with a key difference: the function you provide to flat map `must return a collection for each element`int the original collection.  
// MAGIC when flatmap is applied, it reutrns a `flattened` collection, `meaning it combines all the collections into one`.  
// MAGIC In contrast map would return `a collection of collection`.

// COMMAND ----------

val line = "scala is (presque) fun"

// COMMAND ----------

val singleSpace = " "

// COMMAND ----------

val words = line.split(singleSpace)

// COMMAND ----------

val arrayOfListOfChars = words.map(_.toList)

// COMMAND ----------

val arrayOfListOfChars = words.flatMap(_.toList)

// COMMAND ----------

// MAGIC %md
// MAGIC #### Filter
// MAGIC This Method is used to filter a collection based on `predicate`.

// COMMAND ----------

val numbers = (1 to 10).toList
val pair = numbers.filter(_%2 == 0)

// COMMAND ----------

// MAGIC %md
// MAGIC #### foreach
// MAGIC this method that is used to applied a function on every element 

// COMMAND ----------

val phrase = List("Scala", "est", "(askip)", "fun")
phrase.foreach(println)

// COMMAND ----------

// MAGIC %md
// MAGIC #### Reduce
