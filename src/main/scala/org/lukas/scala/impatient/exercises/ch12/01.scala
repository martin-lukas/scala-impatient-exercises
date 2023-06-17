package org.lukas.scala.impatient.exercises.ch12

@main def main01(args: String*): Unit = {
  println(values(x => x * x, 0, 5))
}

def values(fun: Int => Int, low: Int, high: Int): List[(Int, Int)] = Range
  .inclusive(low, high)
  .map(e => e -> fun(e))
  .toList
