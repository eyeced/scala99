package codeeval.medium

/**
 * Created by abhinav on 29/6/14.
 */
object Endianness extends App {

  java.nio.ByteOrder.nativeOrder match {
    case java.nio.ByteOrder.LITTLE_ENDIAN => println("LittleEndian")
    case java.nio.ByteOrder.BIG_ENDIAN    => println("BigEndian")
  }
}
