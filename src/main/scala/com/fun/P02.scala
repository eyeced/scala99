package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/18/12
 * Time: 12:21 PM
 */
object P02 {
  def penultimate[A](list: List[A]): A = list match {
    case Nil => throw new NoSuchElementException("Nil.penultimate called")
    case x :: Nil => throw new NoSuchElementException("Only one element in the list")
    case x :: l => if (l.length == 1) x else penultimate(l)
  }
}
