package org.lukas.scala.impatient.exercises.ch02

def countdown(n: Int): Unit = (0 to n).reverse.foreach(println)

@main def main05(args: String*): Unit = {
  countdown(3)
}
