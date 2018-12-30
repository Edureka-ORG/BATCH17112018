package com.edureka.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds

object NetworkWordCount {
  
  def main(args: Array[String]): Unit = {
    
    //Step-1 : Create SparkStreamingContext
    
    //Create SparkConf
    
    val sparkConf = new SparkConf()
    sparkConf.setAppName("Network-WordCount-Example")
    sparkConf.setMaster("local[*]");
    sparkConf.set("spark.submit.deployMode","client");
    sparkConf.set("spark.ui.enabled", "true");
    
    //Create sparkContext
    
    val sc  = new SparkContext(sparkConf);
    
    //Create sparkStreamingContext
    
    val ssc = new StreamingContext(sc, Seconds(10));
    
    val lines = ssc.socketTextStream("localhost", 8888);
    println("lines"+lines);
    lines.print();
    val words = lines.flatMap(_.split(" "))
    words.print();
    
    val wc = words.countByValue();
    wc.print();
    
    ssc.start();
    
    ssc.awaitTermination();
    
    
;    
  }
  
}