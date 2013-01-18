package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/17/13
 * Time: 3:36 PM
 */
object P26 {

  def combinations[A](n: Int, list: List[A]): List[List[A]] =  {
    if (n == 1) list.map(l => List(l))
    else {
      list match {
        case Nil => Nil
        case head :: tail => {
          (for {
            combs <- combinations(n - 1, tail)
          } yield head :: combs) ::: combinations(n, tail)
        }
      }
    }
  }
}
