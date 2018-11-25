package com.edureka

object TestArray {
  def main(args: Array[String]): Unit = {
    val a = Array(1, 2, 3);
    println(a(0))
    println(a(1))
    println(a(2))
    //   println(a(3))

    val b = new Array[Int](3);
    b(0) = 2
    b(1) = 3
    b(2) = 4;
    b.foreach(println)

    println("ARRAY BUFFER");
    import scala.collection.mutable.ArrayBuffer;

    val ab = new ArrayBuffer[Int]();
    ab += 1
    ab.foreach(println)
    ab += (2, 3, 4)
    ab.foreach(println)

    ab ++= Array(4, 5, 6)
    ab.foreach(println)

  }
}