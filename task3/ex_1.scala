import scala.io.StdIn.readLine

object ex_1 {

  private def modifyString(s : String) : String = {
    var s1 : String = ""
    var result :String = ""
    for (i <- 0 until s.length) {
      if (s(i) == ' ') {
        if (s1.nonEmpty) {
          s1 += " "
          result = s1 + result
          s1 = ""
        }
      }
      else s1+=s(i)
    }
   s1 + ' ' + result}

  def main(args:Array[String]): Unit = {
    val s:String = readLine()
    println(modifyString(s))
  }

}