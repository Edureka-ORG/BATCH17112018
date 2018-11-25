package com.edureka.third

object TestWatsApp {
  def main(args: Array[String]): Unit = {
    val android =new AndroidWasApp();
    println(android.recieveMsg("test"))
    android.sendMsg("msg");
    println(android.recieveMsg("msg"))
  }
}