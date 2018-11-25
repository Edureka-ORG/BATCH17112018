package com.edureka.third

class AndroidWasApp extends WatsAppConnect with Upload {
  def connect(connectURL: String): Boolean = {
   //I WILL USE ANDROID TO CONNECT
    return true;
  }

  def recieveMsg(msg: String): Boolean = {
    println(msg)
    return true;
  }

  def sendAck(msg: String): Boolean = {
    return true
  }

  def sendMsg(msg: String): Unit = {
    println("sent msg: "+msg)
  }

  def upload(data: String): Boolean = {
    true;
  }
  
}