package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/18/12
 * Time: 12:14 PM
 *
 * P01 (*) Find the last element of a list.
 * Example:
 * scala> last(List(1, 1, 2, 3, 5, 8))
 * res0: Int = 8
 */
object P01 {
  def last[T](list: List[T]): T = list(list.length - 1)

  def lastCase[T](list: List[T]): T = list match {
    case x :: Nil => x
    case x :: l => lastCase(l)
    case Nil => throw new NoSuchElementException("Nil.last called on the list")
  }
}
