package com.edureka.third

object TestHOFn {
  def main(args: Array[String]): Unit = {
    
    println(sumInts(1,10))
    println(operationInts(simple,1,10));
    
    println(sumSqrs(1, 10))
     println(operationInts(sq,1,10));
    
     println(sumFacts(1, 10))
     println(operationInts(fact,1,10));
    
      println(sumCubs(1, 10))
     println(operationInts(cube,1,10));
      
      println(operationInts(pf,1,4));
      
     println(operationInts((x:Int) => x*x*x*x*x,1,4));
     println(operationInts((x:Int) => x*x*x*x*x,1,4));
     

    
    
  }
  
  
  //sumInts --> 1,10 --> 1+2+3+4+5+6+7+8+9+10
  //sumSqrs --> 1,10 --> 1*1+2*2+3*3+4*4+5*5+6*6+7*7+8*8+9*9+10*10
  //sumFacts --> 1,10 --> 1!+2!+3!+4!+5!+6!+7!+8!+9!+10!
  //sumCubs --> 1,10 --> 1*1*1+2*2*2+3*3*3+4*4*4+5*5*5+6*6*6+7*7*7+8*8*8+9*9*9+10*10*10
  def operationInts(f:Int => Int,a:Int, b:Int):Int = {
    if(a>b) return 0 else f(a)+operationInts(f,a+1,b)
  }
  
  
  def pf(a:Int) = a*a*a*a
  
  def simple(a:Int) = a;
  
  def sumInts(a:Int, b:Int):Int = {
    if(a>b) return 0 else simple(a)+sumInts(a+1,b)
  }
  
  def sq(a:Int):Int = a*a;
  def sumSqrs(a:Int, b:Int):Int = {
    if(a>b) return 0 else sq(a)+sumSqrs(a+1,b)
  }
  
  def fact(a:Int):Int = {
    if(a ==0) return 1 else a*fact(a-1)
  }
  def sumFacts(a:Int, b:Int):Int = {
   if(a>b) return 0 else fact(a)+sumFacts(a+1,b)
  }
  
  def cube(a:Int):Int = a*a*a;
  
  def sumCubs(a:Int, b:Int):Int = {
    if(a>b) return 0 else cube(a)+sumCubs(a+1,b)
  }
}