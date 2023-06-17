package org.lukas.scala.impatient.exercises

import org.lukas.scala.impatient.exercises.Console
import scala.annotation.tailrec
import scala.util.{Failure, Success, Try}
import scala.util.control.NonFatal

object Test {
  def runTests(name: String, tests: (String, () => Unit)*): Unit = {
    Console.log(s"Test: $name")
    val results = tests.map(fn => {
      Try {
        Console.log(s"Case: ${fn._1}")
        //noinspection ScalaUnusedExpression
        fn._2()
      }.recoverWith {ex =>
        Console.error(s"Case ${ex.getMessage}")
        Failure(ex)
      }
    })
    val failures = results.count(_.isFailure)
    if (failures == 0) {
      Console.info("All tests passed!")
    } else {
      Console.error(s"${tests.size - failures} of ${tests.size} tests passed.")
    }
    println()
  }
}
