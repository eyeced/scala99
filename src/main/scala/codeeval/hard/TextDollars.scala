package codeeval.hard

/**
 * Created by abhinav on 9/7/14.
 */
object TextDollars extends App {

  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {

  }

  val texts = Array(
    (0, Array("Zero")),
    (1, Array("One", "Ten")),
    (2, Array("Two", "Twenty")),
    (3, Array("Three", "Thirty")),
    (4, Array("Four", "Forty")),
    (5, Array("Five", "Fifty")),
    (6, Array("Six", "Sixty")),
    (7, Array("Seven", "Seventy")),
    (8, Array("Eight", "Eighty")),
    (9, Array("Nine", "Ninety"))
  )
  
  def 
}
