package org.lukas.scala.impatient.exercises.ch02

def countdown(n: Int): Unit = Range.inclusive(0, n).reverse.foreach(println)

@main def main05(args: String*): Unit = {
  countdown(3)
}
