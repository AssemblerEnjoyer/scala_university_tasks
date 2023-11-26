object HelpFunctions {

  // Разделение многострочной строки (строки вида """ abc """) на список строк с заданным интервалом разделения
  def splitString ( input : String, n : Int ) : List[String] = {
    val lines = input.stripMargin.trim.split("\n")
    lines.flatMap { line =>
      line.replace("\r", "").split(" ").grouped(n).map(_.mkString(" "))
    }.toList
  }

  // Создание списка студентов из списка строк
  def ListOfStudents ( names: List[String] ) : List[Student] = {
    var lst: List[Student] = null
    for (n <- names) {
      val fn = n.split(" ")
      val s: Student = new Student(sn = fn(0), n = fn(1), p = fn(2))
      lst = s :: lst
    }
    lst.reverse
  }

  def createListOfStudents(names: List[String]): List[Student] =  names.map(name => new Student(name.split(" ")(0),
    name.split(" ")(1), name.split(" ")(2)))

  // Получение всех имен списка студентов в виде строки
  def getNames ( studentsList : List[Student] ) : String = {
    val stall = studentsList.tail
    if ( stall.nonEmpty ) studentsList.head.toString + "\n" + getNames(stall)
    else studentsList.head.toString + "\n"
  }

  // Создание списка студентов с баллами
  def createPointList ( lst : List[Student] ) : List[Map[Student, Short]] = lst.map(key => Map(key -> 0.toShort))

//  // Шаблон оценивания
//  private def getGrade(score: Short): String =
//    score match {
//      case s if (0 to 59).contains(s) => "2"
//      case s if (60 to 75).contains(s) => "3"
//      case s if (76 to 89).contains(s) => "4"
//      case s if (90 to 100).contains(s) => "5"
//      case _ => "N/A"
//    }
//
//  // Выставление оценок в конце семестра
//  def giveGrades ( lst : List[Map[Student, Short]] ) : List[Map[Student, String]] =
//    lst.map { stdMap => stdMap.map { case (student, score) => (student, getGrade(score)) } }
//
  def printMapList ( list : List [Map[_,_]] ) : Unit = {
    list.foreach { map =>
      map.foreach { case (key, value) =>
        print(s"$key : $value")
      }
      println()
    }
  }

  def printMaps (list1: List [Map[Student,_]], list2: List [Map[Student,_]]):Unit = {
    list1.zip(list2).foreach {
      case (map1, map2) =>
        map1.foreach { case (key, value1) =>
          println(s"$key: $value1 ${map2.getOrElse(key, "")}")
        }
    }
  }

}