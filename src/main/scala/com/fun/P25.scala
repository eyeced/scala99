package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/17/13
 * Time: 3:34 PM
 */
object P25 {
  def randomPermute[A](list: List[A]): List[A] = {
    P23.randomSelect(list.size, list)
  }
}
