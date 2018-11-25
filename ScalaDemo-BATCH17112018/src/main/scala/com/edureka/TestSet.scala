package com.edureka

object TestSet {
  def main(args: Array[String]): Unit = {
    val s = Set(1,2,2,3,3,4,4,4,4,5);
    s.foreach(println)
    println(s.head)
    println(s.tail)
    
    val s2 = Set(1,2,2,3,3,4,4,4,4,5,67,8643,433,345)
    val s3 = s ++ s2
    s3.foreach(println)
    s3 foreach println
    
    var i = s.&(s2)
    i = s & s2
    i foreach println
    i intersect s2
    i foreach println
    
    
  }
}