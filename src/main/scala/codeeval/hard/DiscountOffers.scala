package codeeval.hard

/**
 * Created by abhinav on 30/6/14.
 */
object DiscountOffers extends App {

  // val source = scala.io.Source.fromFile(args(0))
  // val lines = source.getLines.filter(_.length > 0)
  // for (l <- lines) {
    val arr = "Peter Gibbons,Ted Dziuba,Aaron Adelson,Jareau Wade,John Evans,Theodore Donald Kerabatsos,Jeffery Lebowski,Justin Van Winkle,Gabriel Sinkin,Samir Nagheenanajar;Colt M1911A1,16lb Bowling ball,iPad 2 - 4-pack".split(";")
    val products = arr{1}.split(",")
    val names = arr{0}.split(",")
    println(maxScore(products, names))
  // }

  def maxScore(products: Array[String], names: Array[String]): Double = {
    // keeping larger array in columns and lesser in rows for simplifying computations
    val matrix = if (products.length <= names.length) getMatrix(products, names, true) else getMatrix(names, products, false)
    val list = maxSum(matrix, List())
    println(list)
    list.foldLeft(0.0)(_ + _)
  }

  def getMatrix(arr1: Array[String], arr2: Array[String], flag: Boolean): Array[Array[Double]] = {
    val matrix = Array.ofDim[Double](arr1.length, arr2.length)
    for {
      i <- 0 until arr1.length
      j <- 0 until arr2.length
    } yield {
      matrix{i}{j} = if (flag) scalabilityScore(arr1{i}, arr2{j}) else scalabilityScore(arr2{i}, arr1{j})
    }
    matrix.foreach(m => println(m.mkString("   ")))
    matrix
  }

  // greedy algorithm, get the max from the matrix and use it for ss score
  def maxSum(matrix: Array[Array[Double]], acc: List[Double]): List[Double] = {
    val max = getMatrixMax(matrix)
    if (max._1 == 0.0) acc
    else {
      for {
        i <- 0 until matrix.length
        j <- 0 until matrix{0}.length
        if (i == max._2 || j == max._3)
      } yield {
        matrix{i}{j} = 0.0
      }
      maxSum(matrix, acc ::: List(max._1))
    }
  }

  def getMatrixMax(matrix: Array[Array[Double]]): (Double, Int, Int) = {
    var max = 0.0
    var a = 0
    var b = 0
    for {
      i <- 0 until matrix.length
      j <- 0 until matrix{0}.length
    } yield {
      if (matrix{i}{j} > max) {
        max = matrix{i}{j}
        a = i
        b = j
      }
    }
    (max, a, b)
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
