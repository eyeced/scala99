package codeeval.easy

/**
 * Created by abhinav on 5/7/14.
 */
object OddNumbers extends App {
  (1 until 100).filter(x => x % 2 == 1).foreach(x => println(x))
}
