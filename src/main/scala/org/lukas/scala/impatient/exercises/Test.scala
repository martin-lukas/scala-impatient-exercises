package org.lukas.scala.impatient.exercises

import org.lukas.scala.impatient.exercises.Console
import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}
import scala.util.control.NonFatal

object Test {
  def runTests(tests: (String, () => Unit)*): Unit = tests.foreach(fn => {
    Try {
      Console.log(s"Test: ${fn._1}")
      //noinspection ScalaUnusedExpression
      fn._2()
      Console.info("Test passed!")
    } match {
      case Success(_) => ()
      case Failure(ex) => println(s"Some tests failed: ${ex.getMessage}")
    }
  })
}
