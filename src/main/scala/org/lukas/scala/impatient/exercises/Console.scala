package org.lukas.scala.impatient.exercises

object Console {
  private val ANSI_GREEN = "\u001B[32m"
  private val ANSI_RED = "\u001B[31m"
  private val ANSI_RESET = "\u001B[0m"

  def log(msg: String): Unit = println(msg)

  def info(msg: String): Unit = println(ANSI_GREEN + msg + ANSI_RESET)

  def error(msg: String): Unit = println(ANSI_RED + msg + ANSI_RESET)
}
