class Student ( val sn : String, val n : String, val p : String ) extends Human ( sn, n, p ) {

  println(this)

  override def toString : String = s"${ super.toString }"

}
