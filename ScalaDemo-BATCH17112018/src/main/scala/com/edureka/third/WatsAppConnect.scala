package com.edureka.third

trait WatsAppConnect {
  def connect(connectURL:String):Boolean;
  def sendMsg(msg:String):Unit;
  def recieveMsg(msg:String):Boolean;
  
  def sendAck(msg:String):Boolean;
}