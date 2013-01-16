package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 1:03 PM
 */
object P17 {

  def split[A](n: Int, list: List[A]): List[List[A]] = list match {
    case Nil => throw new ArrayIndexOutOfBoundsException("n cannot be larger than the list size")
    case x :: tail => if (n == 1) List(List(x), tail) else {
      val splitList = split(n - 1, tail)
      List(x :: splitList.head, splitList.last)
    }
  }
}
