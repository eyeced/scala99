package codeeval.easy

/**
 * Created by abhinav on 5/7/14.
 */
object Tables extends App {

  (1 until 13).foreach(n => println((1 until 13).map(x => (x * n).toString).map(i => " " * (4 - i.length) + i).mkString("").trim))
}
