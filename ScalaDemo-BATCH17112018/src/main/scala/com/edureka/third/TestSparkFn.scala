package com.edureka.third

object TestSparkFn {
  def main(args: Array[String]): Unit = {
    val input = List.range(1, 10);
    
    
    var fn = (x:Int) => println(x);
    input.foreach(fn)
    input.foreach((x:Int) => println(x))
    input.foreach(x => println(x))
    input.foreach(_=> println _)
    input.foreach(println)
    
    
    
    
  }
}