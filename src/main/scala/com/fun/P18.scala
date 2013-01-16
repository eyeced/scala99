package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 1:19 PM
 */
object P18 {

  def slice[A](from: Int, to: Int, list: List[A]): List[A] = list match {
    case Nil => throw new ArrayIndexOutOfBoundsException("from and to parameters should be within the list range")
    case x :: tail => {
      if (from == 0) {
        if (to == 1) List(x) else x :: slice(from, to - 1, tail)
      } else {
        slice(from - 1, to - 1, tail)
      }
    }
  }

}
