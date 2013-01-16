package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 11:23 AM
 */
object P13 {

  def encodeDirect[A](list: List[A]): List[(Int, A)] = list match {
    case Nil => Nil
    case x :: Nil => List((1, x))
    case x :: tail => {
      val encodedTail = encodeDirect(tail)
      if (x == encodedTail.head._2) {
        (encodedTail.head._1 + 1, encodedTail.head._2) :: encodedTail.tail
      } else {
        (1, x) :: encodedTail
      }
    }
  }
}
