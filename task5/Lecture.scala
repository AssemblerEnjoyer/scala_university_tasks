class Lecture (group : Group, lecNumb : Short, teacher: Professor) {

  def getLecNumb : Short = lecNumb

  def oneLecture (list : List[Map[Student, Short]] ): List[Map[Student, Short]] = {
    list.map { map =>
      map.map { case ( name, score ) =>
        val randomBoolean = scala.util.Random.nextBoolean() // Генерирует случайное булево значение (true или false)
        if (randomBoolean) ( name, (score + 1).toShort )
        else ( name, score )
      }
    }
  }

  def givePoints ( pointList : List[Map[Student, Short]],
                   visitList : List[Map[Student, Short]] ): List[Map[Student, Short]] =

    pointList.zip(visitList).map {
      case ( points, attendance ) =>
        points.map {
          case ( student, score ) =>
            val attendanceScore = ( 10.0 / lecNumb ).toShort
            val updatedScore = ( score + attendance.getOrElse( student, 0.toShort ) * attendanceScore ).toShort
            ( student, updatedScore )
        }
    }

}
