package com.fun

/**
 * The class ${CLASS_NAME}
 * User: abhiso
 * Date: 1/18/13
 * Time: 3:29 PM
 */
object P27 {
  def group[A](sections: List[Int], list: List[A]): List[List[List[A]]] = {
    // if (sections.foldLeft(0)((r,c) => r + c) > list.size) throw new ArrayIndexOutOfBoundsException("Cannot make groups summing up more than the list size")
    sections match {
      case Nil => Nil
      case head :: Nil => List(P26.combinations(head, list))
      case head :: tail => {
        for {
          headComb <- P26.combinations(head, list)
          recGroups <- group(tail, list.filter(l => !headComb.contains(l)))
        } yield headComb :: recGroups
      }
    }
  }

  def group3[A](list: List[A]): List[List[List[A]]] = {
    group(List(2,3,4), list)
  }
}
