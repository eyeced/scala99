package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 3:58 PM
 */
object P20 {
  def removeAt[A](n: Int, list: List[A]): (List[A], A) = list match {
    case Nil => throw new ArrayIndexOutOfBoundsException("cannot remove element at an index greater than the list size")
    case x :: tail => if (n == 0) (tail, x) else {
      val tup = removeAt(n - 1, tail)
      (x :: tup._1, tup._2)
    }
  }
}
