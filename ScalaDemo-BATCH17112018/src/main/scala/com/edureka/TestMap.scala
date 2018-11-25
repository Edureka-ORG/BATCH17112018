package com.edureka

object TestMap {
  def main(args: Array[String]): Unit = {
    
    val inputMap = Map("k1" -> "v1",
        "k2" -> "v2")
        
        inputMap.keys.foreach(println)
        inputMap.values.foreach(println)
        println(inputMap.contains("k1"))
        println(inputMap.contains("k5"))
    
  }
}