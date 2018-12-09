package com.edureka.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object TestKeyValuePair 
{
  
  def main(args: Array[String]): Unit = {
    println("TestKeyValuePair");
    
    val sparkConf = new SparkConf().setAppName("TestKeyValuePair").setMaster("local[*]").set("spark.submit.deployMode", "client");
    
    val sc = new SparkContext(sparkConf);
    
    
    val inputData = List("dog","cat","owl","gnu","ant");
    
    val inputRDD = sc.parallelize(inputData, 2);
    
    val lKVRDD = inputRDD.map(w => (w.length,w));
    
    val outRDD = lKVRDD.foldByKey("")(_+","+_);
    outRDD.collect();
    
  }
}