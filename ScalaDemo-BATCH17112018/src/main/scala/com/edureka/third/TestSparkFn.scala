package com.edureka.third

object TestSparkFn {
  def main(args: Array[String]): Unit = {
    val input = List.range(1, 10);
    
    
    var fn = (x:Int) => println(x);
//    input.foreach(fn)
//    input.foreach((x:Int) => println(x))
//    input.foreach(x => println(x))
//    input.foreach(_=> println _)
//    input.foreach(println)
    
//    var fn2 = (x:Int) => 1.5*x;
    
    var output =input.map((x:Int) => 1.5*x);
    
    
//    output.foreach(println)
    
    var fn3 = (x:Int) => "*"*x;
    
    var output2 =input.map(fn3);
    output2.foreach(println)
    
    var bf = (x:Int) => x%2==0
    
    val fo = input.filter(bf)
    
    fo.foreach(println)
    
    input.foreach(print)
    println();
    val fn4 = (acc:Int, a:Int) => {
      
      print("acc: "+acc)
      println(",a: "+a)
      
      acc+a;
    }
    val out = input.reduceLeft(_+_)
    println(out)
    
    
    var sum = 0;
    
    for (i <- input) {
      sum +=i
    }
    
    println(sum)
    
    val str = "Mary had a little lamb";
    val words = str.split(" ")
    words.sortBy(_.length()).foreach(println);
    
    
    
  }
}