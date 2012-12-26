package com.fun

import com.fun.P09._

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/26/12
 * Time: 1:11 PM
 */
object P10 {
  def encode[A](list : List[A]): List[(Int, A)] = {
    (pack(list)).map(a => (a.size, a.head))
  }
}
