import scala.io.StdIn.readLine

object ex_3 {

  private def weightCalculation(potatoWeight: Float, waterWeight: Float, chipsWaterWeight: Float): Float =
    potatoWeight * (1 - waterWeight) / (1 - chipsWaterWeight)

  private val scalaCurried: Float => Float => Float => Float = (weightCalculation _).curried

  private def handMadeCurried [A, B, C, D] (f : (A, B, C) => D) : A => B => C => D = a => b => c => f (a, b, c)
  private val curriedWeightCalc: Float => Float => Float => Float = handMadeCurried(weightCalculation)

  def main(args: Array[String]): Unit = {
    val Array(a, b, c) = readLine.split(" ").map(_.toFloat)
//    val weight1 = curriedWeightCalc(90)
//    val weight2 = weight1(b)
//    val weight3 = weight2(0.1F)
//    println(f"$weight3%.2f")
    val weight = scalaCurried(a)
    println(weight)
    val weight2 = weight(b)
    println(weight2)
    val weight3 = weight2(c)
    println(f"$weight3%.2f")
    val weight4 = curriedWeightCalc(a)
    val weight5 = weight4(b)
    val weight6 = weight5(c)
    println(f"$weight6%.2f")
  }

}