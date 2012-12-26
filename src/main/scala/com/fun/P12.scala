package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/26/12
 * Time: 2:57 PM
 */
object P12 {
  def decode[A](list: List[(Int, A)]): List[A] = {
    for {
      (len, a) <- list
      i <- 0 to len-1
    } yield a
  }
}
