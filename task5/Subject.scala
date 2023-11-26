class Subject ( val subName : String, val subLecture : Lecture, val subPractice : Practice, exam: Exam) {

  // Шаблон оценивания
  private def getGrade(score: Short): String =
    score match {
      case s if (0 to 59).contains(s) => "2"
      case s if (60 to 75).contains(s) => "3"
      case s if (76 to 89).contains(s) => "4"
      case s if (90 to 100).contains(s) => "5"
      case _ => "N/A"
    }

  // Выставление оценок в конце семестра
  def giveGrades(lst: List[Map[Student, Short]]): List[Map[Student, String]] =
    lst.map { stdMap => stdMap.map { case (student, score) => (student, getGrade(score)) } }

}