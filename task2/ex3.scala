import scala.io.StdIn.readLine

object ex3 {
  def main(args: Array[String]) : Unit = {
    val x : String = readLine()
    val pattern = "^[a-z_]+$"
      x match {
        case x if { x.startsWith("_") || x.endsWith("_") || x.contains("__") || !x.matches(pattern)} => println(false)
        case _ => println(true)
    }
  }
}
