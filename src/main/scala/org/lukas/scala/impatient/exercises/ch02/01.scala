package org.lukas.scala.impatient.exercises.ch02

import org.lukas.scala.impatient.exercises.Console
import scala.annotation.tailrec
import scala.util.{Try, Success, Failure}
import scala.util.control.NonFatal

// IMPL
def signum(num: Int): Int = num.sign

// TESTS
@main def main01(args: String*): Unit = {
  def testSignum(): Unit = {
    assert(signum(0) == 0)
    assert(signum(13) == 1)
    assert(signum(-13) == -1)
  }

  Try {
    testSignum()
    Console.info("All tests passed!")
  } match {
    case Success(_) => ()
    case Failure(ex) => println(s"Some tests failed: ${ex.getMessage}")
  }
}
