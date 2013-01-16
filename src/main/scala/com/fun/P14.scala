package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 12:16 PM
 */
object P14 {

  def duplicate[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case x :: Nil => List(x, x)
    case x :: tail => x :: x :: duplicate(tail)
  }
}
