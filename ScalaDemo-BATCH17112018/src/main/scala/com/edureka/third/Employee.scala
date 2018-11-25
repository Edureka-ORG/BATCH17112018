package com.edureka.third

class Employee 
{
  
  var _id=0;
  var _name="";
  var _desg="";
  
  
  //Getters
  def id = {
    println("In Getter"+_id);
    _id;
  }
  def name = _name;
  def desg = _desg;
  
  //setters 
  def id_=(_id:Int) = {
    println("In id Setter "+_id)
    this._id = _id;
  }
  def name_=(_name:String) = this._name = _name;
  def desg_=(_desg:String) = this._desg = _desg;
  
  override def toString():String = {
    return s"id = $id, name = $name, desg = $desg";
  }
}