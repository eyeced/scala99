package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 1:34 PM
 */
object P19 {
  def rotate[A](n: Int, list: List[A]): List[A] = {
    if (n > list.size) throw new ArrayIndexOutOfBoundsException("cannot rotate more than the list size")
    else {
      def rotateLeft(n: Int, list: List[A]): List[A] = list match {
        case Nil => Nil
        case x :: tail => if (n > 0) rotateLeft(n - 1, tail ::: List(x))  else list
      }
      if (n > 0) rotateLeft(n, list) else rotateLeft(list.size + n, list)
    }

  }
}
