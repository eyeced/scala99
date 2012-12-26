package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/26/12
 * Time: 10:54 AM
 */
object P08 {
  def compress[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case x :: Nil => List(x)
    case x :: tail => if (x == tail.head) compress(tail) else x :: compress(tail)
  }
}
