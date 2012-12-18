package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/18/12
 * Time: 12:30 PM
 */
object P04 {
  def length[A](list: List[A]): Int = list match {
    case Nil => throw new NullPointerException("List is Nil")
    case x :: Nil => 1
    case x :: l => 1 + length(l)
  }
}
