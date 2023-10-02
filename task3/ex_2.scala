import scala.annotation.tailrec
import scala.io.StdIn.readLine

object ex_2 {

  @tailrec
  private def modifyStringRecursive(s : String, result : String = "", word : String = "") : String = {
    val stall = s.tail
      if (s.nonEmpty)
        s.head match {
          case ' ' => if (stall.head != ' ') modifyStringRecursive(stall, word + ' ' + result)
                      else modifyStringRecursive(stall, result, word)
          case _ => modifyStringRecursive(stall, result, word + s.head)
        }
      else word + ' ' + result
  }

  def main (args: Array[String]): Unit = {
    val s: String = readLine()
    println(modifyStringRecursive(s))
  }

}