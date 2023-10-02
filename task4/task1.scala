import scala.annotation.tailrec
import scala.io.StdIn.readLine

object task1{

  private def partition(a: List[Int], l: Int, r: Int): (List[Int], Int) = {
    val v = a((l + r) / 2)
    var i = l
    var j = r
    var updatedList = a

    while (i <= j) {
      while (updatedList(i) < v) {
        i += 1
      }
      while (updatedList(j) > v) {
        j -= 1
      }
      if (i >= j) {
        return (updatedList, j)
      }
      val temp = updatedList(i)
      updatedList = updatedList.updated(i, updatedList(j))
      updatedList = updatedList.updated(j, temp)
      i += 1
      j -= 1
    }
    (updatedList, j)
  }

  @tailrec
  private def findOrderStatistic(left: Int, right: Int, array: List[Int], k: Int): Int = {

    val (newArray, mid) = partition(array, left, right)

    if (mid == k) {
      newArray(mid)
    } else if (k < mid) {
      findOrderStatistic(left, mid, newArray, k)
    } else {
      findOrderStatistic(mid + 1, right, newArray, k)
    }
  }

  def main(args: Array[String]): Unit = {
    val input: String = readLine("Введите элементы: ")
    val array: List[Int] = input.split("\\s+").map(_.toInt).toList
    val k: Int = readLine("Введите порядок: ").toInt

    val result = findOrderStatistic(0, array.length - 1, array, k - 1)
    println(s"$k-порядковая статистика: $result")
  }

}