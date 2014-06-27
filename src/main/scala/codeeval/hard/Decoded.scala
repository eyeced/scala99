package codeeval.hard

/**
 * Created by abhinav on 27/6/14.
 */
object Decoded extends App {
  val source = scala.io.Source.fromFile(args(0))
  val lines = source.getLines.filter(_.length > 0)
  for (l <- lines) {
    println(decode(l))
  }

  def decode(s: String): String = {
    val head_msg = break(s)
    val header = head_msg._1
    val message = head_msg._2
    val keys = header.foldLeft(List[String]()){
      (a, b) => a match {
        case List() => List("0")
        case xs => a ::: List(nextKey(xs.last))
      }
    }
    val keyMap = keys.zipWithIndex.map{ case (h, i) => h -> header{i} }.toMap
    startSeg(message.toList, keyMap)
  }

  def startSeg(list: List[Char], keyMap: Map[String, Char]): String = list match {
    case List('0', '0', '0') => ""
    case _ => decodeStr(list.slice(3, list.length), binaryToInt(list.slice(0, 3)), keyMap)
  }

  def decodeStr(list: List[Char], len: Int, keyMap: Map[String, Char]): String = {
    list.slice(0, len).mkString("") match {
      case s if s.startsWith("1" * len) => startSeg(list.slice(len, list.length), keyMap)
      case s => keyMap.get(s) match {
        case None => ""
        case Some(v) => v + decodeStr(list.slice(len, list.length), len, keyMap)
      }
    }
  }

  def break(s: String): (String, String) = {
    val startIdx = Math.min(s.indexOf('0'), s.indexOf('1'))
    (s.substring(0, startIdx), s.substring(startIdx, s.length))
  }

  def nextKey(key: String): String = {
    if (key.isEmpty) "0"
    else {
      val next = binary(binaryToInt(key.toList) + 1)
      val padded = if (next.length != key.length) (0 until (key.length - next.length)).foldLeft("")((a, b) => a + "0") + next else next
      if (padded.indexOf("0") < 0) (0 until key.length + 1).foldLeft("")((a, b) => a + "0") else padded
    }
  }

  def binary(n: Int): String = n match {
    case 0 => "0"
    case 1 => "1"
    case _ => if (n % 2 == 0) binary(n / 2) + "0" else binary(n / 2) + "1"
  }

  def binaryToInt(s: List[Char]): Int = s match {
    case Nil => 0
    case '0' :: bs => binaryToInt(bs)
    case '1' :: bs => Math.pow(2, s.length - 1).toInt + binaryToInt(bs)
  }
}
