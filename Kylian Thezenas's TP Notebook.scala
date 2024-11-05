// Databricks notebook source
// MAGIC %md
// MAGIC #TP
// MAGIC
// MAGIC ##Hello World
// MAGIC TP de programmation fonctionnelle (fp)

// COMMAND ----------

println("X----- Hello World -----X")

// COMMAND ----------

// MAGIC %md
// MAGIC ##Variables
// MAGIC
// MAGIC - scala has two types of variables: mutable and immutable
// MAGIC - Usage of mutable is highly discourage
// MAGIC - a pure fonctional program would never use a mutable variable. So they should be used with caution
// MAGIC - a mutable variable is declared using the word var
// MAGIC - an immutable variable is declared using the keyword val

// COMMAND ----------

var x = 10

// COMMAND ----------

 x = 20

// COMMAND ----------

val y = 10


// COMMAND ----------

y = 20

// COMMAND ----------

// MAGIC %md
// MAGIC the following statement are equivalent
// MAGIC ``` 
// MAGIC val y = 10 
// MAGIC val y: Int = 10 
// MAGIC ```
// MAGIC

// COMMAND ----------

// MAGIC %md
// MAGIC ##Function

// COMMAND ----------

def add(x: Int, y: Int): Int = {
  val sum = x + y 
  return sum
}

// COMMAND ----------

val addedNumbers = add(6,4)

// COMMAND ----------

def addSimple(x: Int, y: Int) = x + y

// COMMAND ----------

// MAGIC %md
// MAGIC ##Higher-Order Functions
// MAGIC a function that takes a function as an input parametern is called a higher-order function
// MAGIC
// MAGIC The encode function takes two input parameters and returns a Long value
// MAGIC - the first input type is an Int
// MAGIC - the second is a function that takes an Int as input and return s a Long
// MAGIC - th body of the encode function multiplies the first input by 10 and then calls the function that it received as an input

// COMMAND ----------

def encode (n: Int, f: (Int) => Long): Long = {
  val x = n * 10
  f(x)
}

// COMMAND ----------

// MAGIC %md
// MAGIC #Function Literals
// MAGIC - a function literal is an ```unnamed``` or ```anonymous function``` in source code
// MAGIC - it can be used in an application just like a string literal
// MAGIC - it can be used as an input to higher-order methode or function
// MAGIC - it can also be assigned to a variable
// MAGIC - a function literal is defined with input parameters in parenthesis, followed by a right arrow and the body of the function
// MAGIC - the body of a function literal in optional curly braces. An example is shown next
// MAGIC ```
// MAGIC (x: Int) => {
// MAGIC   x + 100
// MAGIC }

// COMMAND ----------

val higherOrderFunctionTest1 = encode(10, (x: Int) => (x + 100))

// COMMAND ----------

// MAGIC %md
// MAGIC If the function body consists of a single statement, the curly braces can be ommited. 
// MAGIC
// MAGIC A concise version of the same function literal is :
// MAGIC ```(x: Int) => x + 100 ```

// COMMAND ----------

val higherOrderFuntionTest2 = encode (5, (x: Int) => x + 100)

// COMMAND ----------

// MAGIC %md
// MAGIC The higher-order function encode defined earlier can be used with a function literal :
// MAGIC ```val code = encode (10, (x: Int) => x + 100)```

// COMMAND ----------

val higherOrderFuntionTest3 = encode (5, x=> x + 100)

// COMMAND ----------

// MAGIC %md
// MAGIC a function can be just  ```_```

// COMMAND ----------

val higherOrderFuntionTest4 = encode (5, _ + 100)

// COMMAND ----------

// MAGIC %md
// MAGIC ##Classes
// MAGIC - a class is an objet-ordiented programming concept
// MAGIC - it provides a higher-level programming abstraction

// COMMAND ----------

class Car(mk: String, ml: String, cr: String){
  val make = mk
  val model = ml
  var color = cr 
  def repaint(newColor: String) = {
    color = newColor
  }
}

// COMMAND ----------

val mustang = new Car("Ford", "Mustang", "Red")
val corvette = new Car("GM", "Corvette", "Blue")
corvette.repaint("Yellow")

// COMMAND ----------

// MAGIC %md
// MAGIC ##Singletons
// MAGIC
// MAGIC - One of the common design patterns in objet-oriented programming is to define a class that can be instantiated only once
// MAGIC - A class that can be instantiated only once is called a singleton
// MAGIC
// MAGIC ##Case Classes
// MAGIC - A case class is a class with a case modifier
// MAGIC - All input parameters specified in the definition of a case implicitely get val prefix
// MAGIC

// COMMAND ----------

case class Message(from: String, to: String, content: String)

// COMMAND ----------

val request = Message("Dark Vador", "Luke", "Je suis ton père")

// COMMAND ----------

// MAGIC %md
// MAGIC ##Pattern Matching

// COMMAND ----------

def colorToNumber(color: String): Int = {
  val num = color match {
    case "red" => 1
    case "blue" => 2
    case "yellow" => 3
    case "purple" => 4
    case "pink" => 5
    case "orange" => 6
    case _ => 0
  }
  num
}

// COMMAND ----------

val colorName = "red"
val colorCode = colorToNumber(colorName)
println("The color code for $colorName is $colorCode")

// COMMAND ----------

def f(x: Int, y: Int, operator: String):Double = {
  operator match {
    case "+" => x + y
    case "-" => x - y
    case "*" => x * y
    case "/" => x / y.toDouble
  }
}

// COMMAND ----------

val sum = f(10, 20,"+")
val product = f(10,20,"*")
