import scala.io.StdIn.readLine

object task3 {

  private def multiplyPair(list1: List[Int], list2: List[Int], list3: List[Int]): List[(Int,Int)] =
    for {
      x <- list1
      y <- list2   if x != y
      z <- list3
      if x * y == z
    } yield (x, y)

  def main (args: Array[String]): Unit = {
    val list1: List[Int] = readLine("Введите элементы первого списка: ").split("\\s+").map(_.toInt).toList
    val list2: List[Int] = readLine("Введите элементы второго списка: ").split("\\s+").map(_.toInt).toList
    val list3: List[Int] = readLine("Введите элементы третьего списка: ").split("\\s+").map(_.toInt).toList

    val a:List[(Int,Int)] = multiplyPair(list1, list2, list3)
    println(a)
    val b:List[(Int,Int)] = multiplyPair(list2, list1, list3)
    println(b)
  }

}