package com.edureka.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.storage.StorageLevel

object TestRDDLineage {
  def main(args: Array[String]): Unit = {
     val sparkConf = new SparkConf().setAppName("TestRDDLineage").setMaster("local[*]").set("spark.submit.deployMode", "client");
    
    val sc = new SparkContext(sparkConf);
    
    val r00 = sc.parallelize(0 to 9)
    val r01 = sc.parallelize(0 to 90 by 10)
    r01.persist(StorageLevel.MEMORY_ONLY_2);
    val r10 = r00 cartesian r01
    val r11 = r00.map(n => (n,n))
    
    val r12 = r00 zip r01
    val r13 = r01.keyBy(_/20);
    val r20 = Seq(r11,r12,r13).foldLeft(r10)(_ union _);
    
    //r10 union r11 --> r union r12 --> r union r13
    
  
    
    
    
  }
}