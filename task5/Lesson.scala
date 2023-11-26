object Lesson {
  def main(args: Array[String]): Unit = {

    val i : Student = new Student("Мельников", "Артемий", "Дмитриевич")

    val str: String = """Тарасова София Андреевна
                        |Сорокина Ангелина Сергеевна
                        |Алексеев Владимир Михайлович
                        |Тарасов Егор Владимирович
                        |Ковалев Святослав Иванович
                        |Зайцева Варвара Евгеньевна
                        |Авдеев Ярослав Андреевич
                        |Михайлов Юрий Владимирович
                        |Горбачев Демид Юрьевич
                        |Давыдова Мадина Анатольевна
                        |Ситников Артём Сергеевич
                        |Тихомирова София Юрьевна
                        |Александров Фёдор Евгеньевич
                        |Сорокин Фёдор Михайлович
                        |Богомолова Алиса Родионовна""".stripMargin

    val group1 : Group = new Group(4,
                                   "ФИИТ",
                                   411,
                                   HelpFunctions.createListOfStudents(HelpFunctions.splitString(str, 3)))
    group1.addStudent(i)
    group1.printInfo()

    val professor : Professor = new Professor("Иванов", "Иван", "Иванович")
    val programLecture : Lecture = new Lecture(group1, 10, professor)
    val programPractice : Practice = new Practice(group1, 10, 5, professor)
    val exam : Exam = new Exam()
    val programming : Subject = new Subject("Программирование", programLecture, programPractice, exam)

    var lectureList : List[Map[Student, Short]] = HelpFunctions.createPointList(group1.studentsList)
    //HelpFunctions.printMapList(pointList)
    lectureList = programLecture.oneLecture(lectureList)
    println("\nЛекция 1. Посещаемость:")
    HelpFunctions.printMapList(lectureList)

    var practiceList : ( List[Map[Student,Short]], List[Map[Student, Short]] ) = (HelpFunctions.createPointList(group1.studentsList), HelpFunctions.createPointList(group1.studentsList))
    practiceList = programPractice.onePractice(practiceList._1, practiceList._2)
    println("\nПрактика 1. Посещаемость и лабораторные работы:")
    HelpFunctions.printMaps(practiceList._1, practiceList._2)

    val lectures = (programLecture.getLecNumb - 1).toShort
    for (_ <- 1 to lectures) lectureList = programLecture.oneLecture(lectureList)
    println("\nЛекции. Посещаемость:")
    HelpFunctions.printMapList(lectureList)

    val practices = (programPractice.getPracticeNumb - 1).toShort
    for (_ <- 1 to practices) practiceList = programPractice.onePractice(practiceList._1, practiceList._2)
    println("\nПрактики. Посещаемость и лабораторные работы:")
    HelpFunctions.printMaps(practiceList._1, practiceList._2)

    var examList : List[Map[Student, Short]] = HelpFunctions.createPointList(group1.studentsList)
    examList = exam.oneExam(examList)
    println("\nРезультаты экзамена:")
    HelpFunctions.printMapList(examList)

    var scoreList : List[Map[Student, Short]] = HelpFunctions.createPointList(group1.studentsList)
    scoreList = programLecture.givePoints(scoreList, lectureList)
    scoreList = programPractice.givePoints(scoreList, practiceList._1, practiceList._2)
    scoreList = exam.givePoints(scoreList, examList)

    println("\nРезультаты семестра (баллы) :")
    HelpFunctions.printMapList(scoreList)

    println("\nРезультаты семестра (оценки) :")
    HelpFunctions.printMapList(programming.giveGrades(scoreList))
  }
}
