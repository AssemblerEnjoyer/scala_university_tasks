import scala.io.StdIn.readLine

object ex1{
  def main(args: Array[String]): Unit = {
    val x = readLine().toInt.toBinaryString.count(_ == '1')
    println(x)
  }
}