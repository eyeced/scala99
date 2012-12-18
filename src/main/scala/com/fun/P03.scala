package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/18/12
 * Time: 12:24 PM
 */
object P03 {
  def nth[A](index: Int, list: List[A]): A = list match {
    case Nil => throw new IndexOutOfBoundsException("No element at this index")
    case x :: l => if (index == 0) x else nth(index - 1, l)
  }
}
