package hackerank.contest.funcOct

import java.util.Date

import scala.collection.mutable
import scala.util.Random

/**
 * Created by abhinav on 13/10/14.
 */
object Expressions {

  val operators = List("*", "+", "-")

  def expr(list: List[Int], acc: List[(String, Int)]): String = list match {
    case x :: Nil =>
      val exprs = for {
        e <- acc
        o <- operators
        if compute(e._2, o, x) % 101 == 0
      } yield (e._1 + " " + o + " " + x)
      exprs{0}
    case x :: xs if acc.size == 0 => expr(xs, List(((x % 101).toString, x)))
    case x :: xs =>
      val exprs = for {
        e <- acc
        o <- operators
//      } yield (e._1 + " " + o + " " + x, compute(e._2, o, x))
      } yield (e._1 + " " + o, compute(e._2, o, x))
      val foo = exprs.groupBy { e => e._2 % 101 }.filter { e => e._2.length > 0 }.map(_._2.head).toList
      expr(xs, foo)
  }

  def expr1(list: List[Int], acc: List[(List[String], Int)]): String = list match {
    case x :: Nil =>
      val exprs = for {
        e <- acc
        o <- operators
        if compute(e._2, o, x) % 101 == 0
      } yield (e._1 + " " + o + " " + x)
      exprs{0}
    case x :: xs if acc.size == 0 => expr1(xs, List((List(), x)))
    case x :: xs =>
      val exprs = for {
        e <- acc
        o <- operators
      //      } yield (e._1 + " " + o + " " + x, compute(e._2, o, x))
      } yield (e._1 ::: List(o), compute(e._2, o, x))
      val foo = exprs.groupBy { e => e._2 % 101 }.filter { e => e._2.length > 0 }.map(_._2.head).toList
      expr1(xs, foo)
  }

  def compute(x: Int, op: String, y: Int): Int = op match {
    case "*" => x * (y % 101)
    case "+" => x + (y % 101)
    case "-" => x - (y % 101)
  }

  def calculate(list: List[String]): Int = list match {
    case x :: y :: z :: Nil => compute(x.toInt, y, z.toInt)
    case x :: y :: z :: xs  => calculate(compute(x.toInt, y, z.toInt).toString :: xs)
  }

  def main(args: Array[String]) {
//    Console.readInt()
//    val list = Console.readLine().split(" ").map(_.toInt).toList
//    println(expr(list, List()))
    val r = new Random()
    val t1 = new Date().getTime
    val str = expr((1 to 1000).map { _ => r.nextInt(99) + 1}.toList, List())
    val t2 = new Date().getTime
    println(t2 - t1)
    // println(expr((1 to 99).toList, List()))
  }
}
