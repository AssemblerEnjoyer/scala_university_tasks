import scala.util.Random

object Main {
  def main(args: Array[String]): Unit = {
    val rand = new Random

    var posled: List[(Int, Int)] = List()

    for (i <- 0 to 10) {
      val r1 = rand.between(1, 100)
      val r2 = rand.between(1, 100)
      val newposled = (r1, r2)
      posled = newposled :: posled
    }

    println()
    val sumOp: ((Int, Int)) => Int = {
      case (x, y) => x + y
    }
    val multiOp: ((Int, Int)) => Int = {
      case (x, y) => x * y
    }
    val powerOp: ((Int, Int)) => Double = {
      case (x, y) => math.pow(x, y)
    }
    val divOp: ((Int, Int)) => Int = {
      case (x, y) => x / y
    }

    def parallelProcess(): Unit = {

      var posled_task1: List[Int] = List();
      var posled_task2: List[Int] = List();
      var posled_task3: List[Double] = List();
      var posled_task4: List[Int] = List();
      val thread = new Thread(() => {
        posled.foreach { case (x, y) =>
          posled_task1 = sumOp(x, y) :: posled_task1
          posled_task2 = multiOp(x, y) :: posled_task2
          posled_task3 = powerOp(x, y) :: posled_task3
          posled_task4 = divOp(x, y) :: posled_task4
        }
      })
      val startSingle = System.currentTimeMillis()
      thread.start()
      thread.join()
      val endSingle = System.currentTimeMillis()
      val timeSingleThread = endSingle - startSingle


      var posled_task1_double: List[Int] = List();
      var posled_task2_double: List[Int] = List();
      var posled_task3_double: List[Double] = List();
      var posled_task4_double: List[Int] = List();
      val thread1 = new Thread(() => {
        posled.foreach { case (x, y) =>
          posled_task1_double = sumOp(x, y) :: posled_task1_double
          posled_task2_double = multiOp(x, y) :: posled_task2_double
        }
      })

      val thread2 = new Thread(() => {
        posled.foreach { case (x, y) =>
          posled_task3_double = powerOp(x, y) :: posled_task3_double
          posled_task4_double = divOp(x, y) :: posled_task4_double
        }
      })
      val startDouble = System.currentTimeMillis()
      thread1.start()
      thread2.start()

      thread1.join()
      thread2.join()

      val endDouble = System.currentTimeMillis()
      val timeDoubleThread = endDouble - startDouble


      var posled_task1_quad: List[Int] = List();
      var posled_task2_quad: List[Int] = List();
      var posled_task3_quad: List[Double] = List();
      var posled_task4_quad: List[Int] = List();
      val thread_Quad1 = new Thread(() => {
        posled.foreach { case (x, y) =>
          posled_task1_quad = sumOp(x, y) :: posled_task1_quad
        }
      })

      val thread_Quad2 = new Thread(() => {
        posled.foreach { case (x, y) =>
          posled_task2_quad = multiOp(x, y) :: posled_task2_quad

        }
      })
      val thread_Quad3 = new Thread(() => {
        posled.foreach { case (x, y) =>
          posled_task3_quad = powerOp(x, y) :: posled_task3_quad
        }
      })
      val thread_Quad4 = new Thread(() => {
        posled.foreach { case (x, y) =>
          posled_task4_quad = divOp(x, y) :: posled_task4_quad
        }
      })
      val startQuad = System.currentTimeMillis()
      thread_Quad1.start()
      thread_Quad2.start()
      thread_Quad3.start()
      thread_Quad4.start()

      thread_Quad1.join()
      thread_Quad2.join()
      thread_Quad3.join()
      thread_Quad4.join()
      val endQuad = System.currentTimeMillis()
      val timeQuadThread = endQuad - startQuad

      println(s"Время выполнения для одного потока: $timeSingleThread мс")
      println(s"Время выполнения для двух потоков: $timeDoubleThread мс")
      println(s"Время выполнения для четырех потоков: $timeQuadThread мс")


    }

    parallelProcess()
  }
}
