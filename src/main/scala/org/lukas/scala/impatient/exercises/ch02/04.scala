package org.lukas.scala.impatient.exercises.ch02

@main def main04(args: String*): Unit = {
  // Java
  // for (int i = 10; i >= 0; i--) System.out.println(i);
  // Scala
  Range.inclusive(0, 10).reverse.foreach(println)
}
