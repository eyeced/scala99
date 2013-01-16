package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 12:47 PM
 */
object P16 {

  def drop[A](n: Int, list: List[A]): List[A] = list match {
    case Nil => throw new ArrayIndexOutOfBoundsException("index out of bound")
    case x :: tail => if (n == 1) tail else x :: drop(n - 1, tail)
  }
}
