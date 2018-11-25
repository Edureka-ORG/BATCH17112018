package com.edureka.third

import com.edureka.DAO

object TestDuck {
  def main(args: Array[String]): Unit = {
    val d = new Duck(1,2);
    val d1 = new Duck(1,2);
    
    println(d == d1)
    
    DAO.connect("", "", "");
    
//    val d3 = Duck(1,2)
//    val dao3 = DAO.u?
    
    
    
    
  }
}