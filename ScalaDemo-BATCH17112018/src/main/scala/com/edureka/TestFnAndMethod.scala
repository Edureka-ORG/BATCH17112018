package com.edureka

object TestFnAndMethod {
  
  
  def main(args: Array[String]): Unit = {
    
//    println(rec(5))
    
//    println(argsFn());
//    println(argsFn(2))
//    println(argsFn(b=2));
//    println(argsFn(b=20,a=10));
    
    println(fact(20))
    
    
    
  }
  
  var fnAdd = (i:Int,j:Int) => i+j;
  
  def add(i:Int, j:Int):Int = {
//    return i+j;
    i+j;
  }
  
  
  def rec(a:Int):Int = {
    println(a);
    if(a ==0 ) return 1 else return a*rec(a-1);
  }
  
  
  def argsFn(a:Int = 0, b:Int = 0) :Int = {
    def argsNesTFn(a:Int, b:Int):Int = {
      println(s"Nested Function a=$a, b=$b");
      
    return a+b
    }
    argsNesTFn(a,b);
  }
  
  def fact(i:Int):Long = 
  {
    
    def factN(i:Int, acc:Int):Long = {
      if(i == 0) return acc else i*factN(i-1,acc)
    }
    factN(i,1)
  }
  
  
  def proc(i:Int) = {
    println(i)
  }
  
  
  
}