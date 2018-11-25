package com.edureka

object TestTuple {
  def main(args: Array[String]): Unit = {
    val t = (1,4,"bob","john");
//    println(t._1);
//    println(t._2);
//    println(t._3);
//    println(t._4);
    
//    t.productIterator.foreach(i => println(i))
//    val t1 = ("EEE","BBB");
//    t1.swap.productIterator.foreach(println)
    println(t.toString());
  }
}