package com.fun

import util.Random

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/17/13
 * Time: 3:27 PM
 */
object P24 {

  def lotto(numberOfRandom: Int, numMax: Int): List[Int] = {
    (0 until numberOfRandom).map(i => Random.nextInt(numMax)).toList
  }
}
