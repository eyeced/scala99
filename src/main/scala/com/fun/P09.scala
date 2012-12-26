package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/26/12
 * Time: 11:57 AM
 */
object P09 {
  def pack[A](list: List[A]): List[List[A]] = {
    def innerPack(innerList: List[List[A]]): List[List[A]] = innerList match {
      case Nil => Nil
      case x :: Nil => List(x)
      case x :: tail => if (x.head == tail.head.head) innerPack((tail.head.head :: x) :: tail.tail) else x :: innerPack(tail)
    }
    innerPack(list.map(a => List(a)))
  }
}
