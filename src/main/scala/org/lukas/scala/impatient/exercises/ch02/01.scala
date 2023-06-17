package org.lukas.scala.impatient.exercises.ch02

import org.lukas.scala.impatient.exercises.Console
import org.lukas.scala.impatient.exercises.Test.runTests

def signum(num: Int): Int = num.sign

@main def main01(args: String*): Unit = {
  runTests(
    "signum",
    "should return 0 for 0" -> (() => {
      assert(signum(0) == 0)
    }),
    "should return 1 for positive numbers" -> (() => {
      assert(signum(13) == 1)
    }),
    "should return -1 for negative numbers" -> (() => {
      assert(signum(-13) == -1)
    }),
  )
}
