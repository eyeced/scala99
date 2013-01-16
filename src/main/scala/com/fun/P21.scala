package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 4:08 PM
 */
object P21 {
  def insertAt[A](a: A, n: Int, list: List[A]): List[A] = list match {
    case Nil => Nil
    case head :: tail => if (n == 0) a :: head :: tail else a :: insertAt(a, n - 1, tail)
  }
}
