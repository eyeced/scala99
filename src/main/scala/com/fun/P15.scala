package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 12:28 PM
 */
object P15 {

  def duplicateN[A](n: Int, list: List[A]): List[A] = list match {
    case Nil => Nil
    case x :: tail => (0 until n).map(i => x).toList ::: duplicateN(n, tail)
  }

}
