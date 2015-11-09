package maintest

object Test1 {
  def main(arguments: Array[String]) {
    println("Test1.main")
  }
}

object Test2 {
  def main(args: Array[String]) {
    println("Test2.main")
    args.foreach(println)
  }
}

object Test3 {
  def main() {
    println("Test3.main")
  }
}
