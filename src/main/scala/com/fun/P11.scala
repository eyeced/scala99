package com.fun

import P09._

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/26/12
 * Time: 1:19 PM
 */
object P11 {
  def encodeModified[A](list: List[A]): List[Any] = {
    (pack(list)).map(a => if (a.size > 1) (a.size, a.head) else a.head)
  }
}
