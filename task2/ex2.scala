import scala.io.StdIn.readLine

object ex2 {
  def main(args: Array[String]): Unit = {
    val n = readLine().toInt
    for (i<-1 to n) {
      for (j<-1 to i) {
        print(j + " ")
      }
      println()
    }
  }
}
