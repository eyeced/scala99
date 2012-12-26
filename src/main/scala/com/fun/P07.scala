package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/21/12
 * Time: 3:27 PM
 */
object P07 {
  def flatten[A](list: List[A]): List[Any] = list match {
    case Nil => Nil
    case (head: List[Any]) :: tail => flatten(head) ::: flatten(tail)
    case head :: tail => head :: flatten(tail)
  }
}
