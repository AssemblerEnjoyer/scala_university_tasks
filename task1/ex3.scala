import scala.io.StdIn.readLine

object ex3 {
  private def weightCalculation(potatoWeight : BigInt, waterWeight : Double, chipsWaterWeight : Double) : Double =
    potatoWeight.toDouble * (1-waterWeight) / (1-chipsWaterWeight)

  def main(args: Array[String]): Unit = {
//    val Array(a,b,c) = readLine.split(" ").map(_.toFloat)
    val inputArray = readLine("Введите 3 числа через пробел: массу картофеля, долю воды в картофеле и долю воды в чипсах: ").split(" ")
    val (a : BigInt, b : Double, c : Double) = (BigInt(inputArray(0)), inputArray(1).toDouble, inputArray(2).toDouble)
    val weight = weightCalculation(a, b, c)
    println(f"$weight%.2f")
  }
}
