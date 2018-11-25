package com.edureka.third

import com.edureka.DAO

object TestEmp {
  def main(args: Array[String]): Unit = {
    val e = new Employee;
    e.id_=(1);
    println(e.id)
    
    
//    e.id+=1
//    e.id*=2
//    e.id/=3
//    e.id==4
    e.id-=5
    println(e.id)
    DAO.connect("", "", "");
    println(DAO.i);
  }
}