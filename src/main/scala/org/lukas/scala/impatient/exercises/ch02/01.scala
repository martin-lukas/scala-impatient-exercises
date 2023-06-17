package org.lukas.scala.impatient.exercises.ch02

import org.lukas.scala.impatient.exercises.Console
import org.lukas.scala.impatient.exercises.Test.runTests

def signum(num: Int): Int = num.sign

@main def main01(args: String*): Unit = {
  runTests(
    "signum should return sign of numbers" -> (() => {
      assert(signum(0) == 0)
      assert(signum(13) == 1)
      assert(signum(-13) == -1)
    })
  )
}
