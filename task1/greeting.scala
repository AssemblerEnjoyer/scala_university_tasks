import Config.{name => prefix}

object greeting {
  private def greeting(name: String): Unit = {
    println(prefix + name)
  }

  def main(args: Array[String]): Unit = {
    greeting("Anna")
  }
}