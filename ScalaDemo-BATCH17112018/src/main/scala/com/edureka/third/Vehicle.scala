package com.edureka.third

class Vehicle(speed:Float) {
val mph:Float = speed;  
def race() = println("The vehicle is racing with speed: "+speed)
}

class Car(speed:Int) extends Vehicle(speed:Int) {
  println(mph);
  
  override def race() = println("the car is racing with speed: "+speed);
}
