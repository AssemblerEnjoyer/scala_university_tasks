import scala.io.StdIn.readLine

object ex_1 {
  private def multiplyOfThreeNumbers(a:Int, b:Int, c:Int): Int = a * b * c

  def main(args: Array[String]): Unit = {
    println("Введите 3 числа: ")
    val Array(a,b,c) = readLine.split(" ").map(_.toInt)
    println("Произведение равно " + multiplyOfThreeNumbers(a, b, c))
  }
}