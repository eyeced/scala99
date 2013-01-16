package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 4:12 PM
 */
object P22 {
  def range(from: Int, to: Int): List[Int] = {
    if (from > to) throw new IllegalArgumentException("from number cannot be larger than to number")
    else {
      if (from == to) List(from)
      else from :: range(from + 1, to)
    }
  }
}
