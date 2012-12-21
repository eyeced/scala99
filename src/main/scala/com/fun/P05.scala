package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/18/12
 * Time: 12:34 PM
 */
object P05 {
  def reverse[T](list: List[T]): List[T] = list match {
    case Nil => Nil
    case x :: Nil => List(x)
    case x :: l => reverse(l) ::: List(x)
  }
}
