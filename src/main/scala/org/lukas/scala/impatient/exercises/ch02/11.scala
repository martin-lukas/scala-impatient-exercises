package org.lukas.scala.impatient.exercises.ch02

import org.lukas.scala.impatient.exercises.Console
import org.lukas.scala.impatient.exercises.Test.runTests

import java.time.LocalDate
import scala.annotation.tailrec
import scala.util.Try

class DateInterpolationException(val msg: String) extends Exception

implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
  def date(args: Any*): LocalDate = args.toList match
    case List(first: Int, second: Int, third: Int) =>
      sc.parts.toList match
        case List("", "-", "-", "") => // separated by dashes
          LocalDate.of(first, second, third)
        case _ =>
          throw DateInterpolationException("The arguments should be separated by dashes.")
    case List(first, second, third) =>
      throw new DateInterpolationException("The arguments must be of type Int.")
    case _ =>
      throw new DateInterpolationException("You must provide 3 arguments to construct a date.")
}

@main def main11(args: String*): Unit = {
  runTests(
    "date interpolation",
    "should return LocalDate instance" -> (() => {
      assert(date"${2022}-${1}-${1}".getClass == classOf[LocalDate])
    }),
    "should return correct LocalDate date from '$year-$month-$day' string" -> (() => {
      val dateRes = date"${2022}-${1}-${1}"
      assert(dateRes.getYear == 2022)
      assert(dateRes.getMonthValue == 1)
      assert(dateRes.getDayOfMonth == 1)
    }),
    "should throw error if the arguments are not separated by dashes." -> (() => {
      assert(Try(date"${2022}/${1}/${1}").isFailure)
    }),
    "should throw error if some arguments are not Ints." -> (() => {
      assert(Try(date"${2022}-${"1"}-${1}").isFailure)
    }),
    "should throw error if less than 3 arguments provided." -> (() => {
      assert(Try(date"${2022}-${1}").isFailure)
    }),
    "should throw error if no arguments are provided." -> (() => {
      assert(Try(date"2022-01-01").isFailure)
    }),
  )
}
