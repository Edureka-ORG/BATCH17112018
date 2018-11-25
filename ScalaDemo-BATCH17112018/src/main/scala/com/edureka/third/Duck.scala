package com.edureka.third

class Duck(val size:Int, val age:Int) {
  
  var i=0;
  var j = 0;
  var someThing ="";
  
  def this(size:Int, age:Int,someOther:String){
    this(size,age);
    someThing = someOther;
    
  }
  
  def add(a:Int, b:Int):Int = {
    return a+b;
  }
  
  var fn = (a:Int,b:Int) => a+b
  
}