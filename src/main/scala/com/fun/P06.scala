package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 12/19/12
 * Time: 5:11 PM
 */
object P06 {
  def isPalindrome[A](list: List[A]): Boolean = {
    if (list.isEmpty || list.size % 2 == 0 || list.head == list.last) false
    else isPalindrome(list.tail.dropRight(1))
  }
}
