package org.lukas.scala.impatient.exercises.ch02

import org.lukas.scala.impatient.exercises.Console
import org.lukas.scala.impatient.exercises.Test.runTests

def unicodeProduct(str: String): Long = str.map(_.toLong).product

@main def main06(args: String*): Unit = {
  runTests(
    "unicodeProduct",
    "should return product of all Unicode values" -> (() => {
      assert(unicodeProduct("Hello") == 9415087488L, "1")
      assert(unicodeProduct("Hi") == 7560L, "2")
    })
  )
}
