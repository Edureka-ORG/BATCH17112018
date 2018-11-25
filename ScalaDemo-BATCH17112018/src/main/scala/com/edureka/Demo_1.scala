package com.edureka

object Demo_1 {
  
  def main(args: Array[String]): Unit = {
    var x = 10;
    if(x < 20)
    {
      println("x is less than 20");
    }else{
      println("x is greater than 20");
    }
    
    var r = {
      var a = 10;
      var b = 20;
      if(a > b) {
         a;
      }else{
        "HELLOWORLD"
      }
    }
    
  }
}