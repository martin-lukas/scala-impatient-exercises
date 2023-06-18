package org.lukas.scala.impatient.exercises.ch02

import org.lukas.scala.impatient.exercises.Console
import org.lukas.scala.impatient.exercises.Test.runTests
import scala.annotation.tailrec

def productForLoop(str: String): Long = (for (c <- str) yield c.toLong).product

def product(str: String): Long = str.map(_.toLong).product

def productHeadRecursive(str: String): Long =
  if (str.isEmpty) 1
  else str(0).toLong * productHeadRecursive(str drop 1)

def productTailRecursive(str: String): Long = {
  @tailrec
  def _product(str: String, acc: Long): Long = {
    if (str.isEmpty) acc
    else _product(str drop 1, acc * str(0).toLong)
  }

  _product(str, 1)
}

@main def main06to09(args: String*): Unit = {
  runTests(
    "product - for loop",
    "should return product of all Unicode values" -> (() => {
      assert(productForLoop("Hello") == 9415087488L, "1")
      assert(productForLoop("Hi") == 7560L, "2")
    }),
  )
  runTests(
    "product",
    "should return product of all Unicode values" -> (() => {
      assert(product("Hello") == 9415087488L, "1")
      assert(product("Hi") == 7560L, "2")
    }),
  )
  runTests(
    "product - head-recursive",
    "should return product of all Unicode values" -> (() => {
      assert(productHeadRecursive("Hello") == 9415087488L, "1")
      assert(productHeadRecursive("Hi") == 7560L, "2")
    }),
  )
  runTests(
    "product - tail-recursive",
    "should return product of all Unicode values" -> (() => {
      assert(productTailRecursive("Hello") == 9415087488L, "1")
      assert(productTailRecursive("Hi") == 7560L, "2")
    }),
  )
}
