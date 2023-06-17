package org.lukas.scala.impatient.exercises.ch02

@main def main01(args: String*): Unit = {
  println(s"Signum of 13 is ${signum(13)}")
  println(s"Signum of -13 is ${signum(-13)}")
  println(s"Signum of 0 is ${signum(0)}")
}

def signum(num: Int): Short =
  if (num == 0) 0
  else if (num > 0) 1
  else -1
