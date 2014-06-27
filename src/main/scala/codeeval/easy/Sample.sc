val list = List(List("a", "b", "c"), List("d", "e", "f"), List("g", "k", "l"))

def combinations(chars: List[String], combs: List[String]): List[String] = combs match {
  case List() => chars
  case _ =>
  for {
    ch <- chars
    c <- combs
  } yield ch + c
}

def getCombinations(listOfChars: List[List[String]]): List[String] = listOfChars match {
  case l :: Nil => l
  case l :: ls => combinations(l, getCombinations(ls))
}

getCombinations(list)


"Hello".substring(0, 5)