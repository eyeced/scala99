package com.fun

import util.Random

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/16/13
 * Time: 4:51 PM
 */
object P23 {

  def randomSelect[A](index: Int, list: List[A]): List[A] = index match {
    case 0 => List()
    case i => {
      val tup = P20.removeAt(Random.nextInt(list.size), list)
      tup._2 :: randomSelect(index - 1, tup._1)
    }
  }
}
