package hackerank.contest.funcoct

import java.util.Date

import scala.annotation.tailrec
import scala.collection
import scala.collection.mutable.ArrayBuffer
import scala.collection.parallel.mutable
import scala.util.Random

/**
 * Created by abhinav on 13/10/14.
 */
object Expressions {

  val operators = List("*", "-", "+")

  val arr = new Array[List[(String, Int)]](201).map { _ => new collection.mutable.LinkedList[(String, Int)] }

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
      } yield (e._1 + " " + o + " " + x, compute(e._2, o, x))
      val map = exprs.groupBy { e => e._2 % 101 }
      if (map.keySet.contains(0)) {
        val str = map.get(0).get.head._1
        str + " * " + xs.mkString(" * ")
      } else {
        val foo = map.filter { e => e._2.length > 0 }.map(_._2.head).toList
        // println((end - start) + "  " + (end - end1) + " " + foo.size)
        expr(xs, foo)
      }
  }

  @tailrec
  def expr1(list: List[Int], acc: Array[(String, Int)]): String = list match {
    case x :: Nil =>
      val exprs = for {
        e <- acc
        o <- operators
        if compute(e._2, o, x) % 101 == 0
      } yield (e._1 + " " + o + " " + x)
      exprs{0}
    case x :: xs if acc.size == 0 => expr1(xs, Array((x.toString, x)))
    case x :: xs =>
      val a = new Array[Boolean](101) // initialize array to all false values
      val buf = new ArrayBuffer[(String, Int)]()
      acc.foreach { e =>
        operators.foreach{ o =>
          val foo = compute(e._2, o, x)
          val bar = if ((foo % 101) < 0) (foo % 101) + 101 else foo % 101
          if (!a{bar}) {
            buf.append((e._1 + " " + o + " " + x, foo))
            if (bar == 0)
            // buf.append((" ", foo))
            a{(bar)} = true
          }
        }
      }
        expr1(xs, buf.toArray)
  }

  def compute(x: Int, op: String, y: Int): Int = op match {
    case "*" => x % 101 * y
    case "+" => x % 101 + y
    case "-" => x % 101 - y
  }

  def calculate(list: List[String]): Int = list match {
    case x :: y :: z :: Nil => compute(x.toInt, y, z.toInt) % 101
    case x :: y :: z :: xs => calculate(compute(x.toInt, y, z.toInt).toString :: xs)
  }

  def main(args: Array[String]) {
//    Console.readInt()
//    val list = Console.readLine().split(" ").map(_.toInt).toList
//    println(expr(list, List()))
    val r = new Random
    val list = (1 to 10000).map { _ => r.nextInt(99) + 1 }.toList
    val start = new Date().getTime
    // val str = expr1(list, Array())
    val e1 = new Date().getTime
    println(e1 - start)
    val str1 = expr(list, List())
    val e2 = new Date().getTime
    // println(str)
    println(str1)
    println(calculate(str1.split(" ").toList))
    println(e1 - start)
    println(e2 - e1)
  }
}
