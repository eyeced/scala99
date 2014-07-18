package codeeval.hard

import scala.collection.mutable

/**
 * Created by abhinav on 1/7/14.
 */
object Discount extends App {

  var map = new scala.collection.mutable.HashMap[(List[Int], List[Int]), Double]()
  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
  val arr = "Peter Gibbons,Ted Dziuba,Aaron Adelson,Jareau Wade,John Evans,Theodore Donald Kerabatsos,Jeffery Lebowski,Justin Van Winkle,Gabriel Sinkin,Samir Nagheenanajar;Batman No. 1".split(";")
  val products = arr{1}.split(",")
  val names = arr{0}.split(",")
  println(products.toList)
  println(names.toList)
  try {
    println(maxScore(products, names))
  } catch {
    case (e: ArrayIndexOutOfBoundsException) => println("")
  }
    // }

    def maxScore(products: Array[String], names: Array[String]): Double = {
      // keeping larger array in columns and lesser in rows for simplifying computations
      if (products.length <= names.length)
        maxSum2(getMatrix(products, names, true), 0.0, (0 until products.length).toList, (0 until names.length).toList)
      else
        maxSum2(getMatrix(names, products, false), 0.0, (0 until names.length).toList, (0 until products.length).toList)
    }

    def getMatrix(arr1: Array[String], arr2: Array[String], flag: Boolean): Array[Array[Double]] = {
      val matrix = Array.ofDim[Double](arr1.length, arr2.length)
      for {
        i <- 0 until arr1.length
        j <- 0 until arr2.length
      } yield {
        matrix{i}{j} = if (flag) scalabilityScore(arr1{i}, arr2{j}) else scalabilityScore(arr2{j}, arr1{i})
      }
      matrix.foreach(m => println(m.mkString("   ")))
      matrix
    }

    def maxSum(matrix: Array[Array[Double]], acc: List[Double]): List[Double] = {
      if (matrix{0}.length == 1 && matrix.length == 1) acc ::: List(matrix{0}{0})
      else if (matrix{0}.length == 1) acc ::: List(getMax((for { i <- 0 until matrix.length } yield matrix{i}{0}).toList, 0.0))
      else if (matrix.length == 1) acc ::: List(getMax((for { j <- 0 until matrix{0}.length } yield matrix{0}{j}).toList, 0.0))
      else {
        val list = (for {
          j <- 0 until matrix{0}.length
        } yield {

          val slicedMatrix = matrix.zipWithIndex.filter{ case (x, i) => i > 0 }.map{ case (x, i) => x.zipWithIndex.filter{ case (y, k) => k != j}.map{ case (y, k) => y} }
          maxSum(slicedMatrix, acc ::: List(matrix{0}{j}))
        }).toList
        list.sortBy(l => l.foldLeft(0.0)((a, b) => a + b)).last
      }
    }

    def maxSum2(matrix: Array[Array[Double]], acc: Double, iList: List[Int], jList: List[Int]): Double = {
      if (!map.contains((iList, jList))) {
        map.put((iList, jList),
          (iList, jList) match {
            case (x :: Nil, y :: Nil) => acc + matrix{x}{y}
            case (x :: Nil, ys)       => acc + getMax(ys.map(y => matrix{x}{y}), 0.0)
            case (xs, y :: Nil)       => acc + getMax(xs.map(x => matrix{x}{y}), 0.0)
            case (x :: xs, ys)        => getMax(ys.map(y => maxSum2(matrix, acc + matrix{x}{y}, xs, ys.filter(j => j != y))), 0.0)
          })
      }
      map.get((iList, jList)) match {
        case Some(d) => d
        case None    => 0.0
      }
    }

    def getMax(list: List[Double], max: Double): Double = list match {
      case l :: Nil => Math.max(max, l)
      case l :: ls  => getMax(ls, Math.max(max, l))
    }

    def scalabilityScore(product: String, name: String): Double = {
      val ss = evenScore(product, name) + oddScore(product, name)
      if (haveCommonFactors(letters(product).length, letters(name).length))
        ss * 1.5
      else
        ss
    }

    def letters(s: String): String = {
      s.filter(c => (c.toInt > 64 && c.toInt < 91) || (c.toInt > 96 && c.toInt < 123))
    }

    def evenScore(product: String, name: String): Double = {
      if (letters(product).length % 2 == 0)
        letters(name).filter(c => List('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y').contains(c)).length * 1.5
      else
        0.0
    }

    def oddScore(product: String, name: String): Double = {
      if (letters(product).length % 2 == 1)
        letters(name).filter(c => !List('a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y').contains(c)).length
      else
        0.0
    }

    def haveCommonFactors(x: Int, y: Int): Boolean = {
      (for {
        i <- 2 until Math.min(Math.pow(x, 0.5), Math.pow(y, 0.5)).toInt + 1
        if (x % i == 0 && y % i == 0)
      } yield i).length > 0
    }
}
