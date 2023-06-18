package org.lukas.scala.impatient.exercises.ch02

import org.lukas.scala.impatient.exercises.Console
import org.lukas.scala.impatient.exercises.Test.runTests

import scala.annotation.tailrec

def expHeadRec(x: Int, n: Int): Int =
  if (n == 0) 1
  else x * expHeadRec(x, n - 1)

def expTailRec(x: Int, n: Int): Int = {
  @tailrec
  def _exp(x: Int, n: Int, acc: Int): Int =
    if (n == 0) acc
    else _exp(x, n - 1, x * acc)

  _exp(x, n, 1)
}

@main def main10(args: String*): Unit = {
  runTests(
    "expHeadRec",
    "should compute for n > 0" -> (() => {
      assert(expHeadRec(2, 4) == 16)
    }),
    "should compute for n = 0" -> (() => {
      assert(expHeadRec(5, 0) == 1, "1")
      assert(expHeadRec(0, 0) == 1, "2")
    }),
  )
  runTests(
    "expTailRec",
    "should compute for n > 0" -> (() => {
      assert(expTailRec(2, 4) == 16)
    }),
    "should compute for n = 0" -> (() => {
      assert(expTailRec(5, 0) == 1, "1")
      assert(expTailRec(0, 0) == 1, "2")
    }),
  )
}
