package org.lukas.scala.impatient.exercises.ch12

//noinspection ScalaUnusedExpression
@main def main02(args: String*): Unit = {
  val fn = (str: String) => println(str)
  val l: List[(String, (String) => Unit)] = List("fn" -> fn)
  l.head._2("hello")
}
//  val arr = Array(1, 2, 3)
//  println("Array: " + arr.mkString(","))
//  val last = arr.reduceLeft()
//}
