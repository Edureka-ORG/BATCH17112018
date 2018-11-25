package com.edureka

object TestForEach 
{
  def main(args: Array[String]): Unit = 
  {
    var args = "Hello";
    
    args.foreach(println);
    
    var x = List(1,2,3);
    
    x.foreach(println)
    
    for(i <- 1 to 5){
      println(i);
    }
    
    
    var in = "Hello World";
    
    println(in.length());
    var r = 1 until in.length();
    println(r)
    
    var sum = 0;
    
    for(i <- r) {
      sum += i;
    }
    println(sum);
    
    for (i <- 1 to 3; j <- 2 to 5)
    {
      println(s"i =$i j $j");
    }
    
    
     for (i <- 1 to 3; j <- 2 to 5; if(i == j))
    {
      println(s"i =$i j $j");
    }
    
    for (i <- 1 to 3; j <- 2 to 5; z = i-j)
    {
      println(s"i =$i j = $j z = $z");
    } 
    
    
    var y = for(i <- r) yield i*2.5;
    y.foreach(println)
    
    println("while");
    
    var a = 10;
    while( a > 0 )
    {
      
      println(a);
      a = a-1
      
    }
    
    var b = 20;
    do {
      println(b)
      b = b-1;
    }while(b > 0)
    
    
      var fn = (x:Int) => println(x);
      
      y.foreach(x => println(x))
    
  }
}