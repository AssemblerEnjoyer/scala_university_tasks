class Professor ( val sn : String, val n : String, val p : String ) extends Human ( sn, n, p ) {

  println(this)

  override def toString = s"Преподаватель ${ super.toString }"

  def toProfessor ( h : Human ) : Professor = new Professor ( h.surname, h.name, h.patronymic )

}
