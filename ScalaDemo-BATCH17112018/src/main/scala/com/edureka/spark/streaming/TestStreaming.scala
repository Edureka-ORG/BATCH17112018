package com.edureka.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.storage.StorageLevel

object TestStreaming {
  
  def main(args: Array[String]): Unit = {
    
    val sparkConf = new SparkConf;
    sparkConf.setAppName("Streaming-DEMO");
    sparkConf.setMaster("local[*]");
    sparkConf.set("spark.eventLog.enabled","true")
    sparkConf.set("spark.ui.enabled","true")
    sparkConf.set("spark.submit.deployMode", "client");
    
    sparkConf.set("spark.eventLog.dir", "/Users/sa356713/git/BATCH17112018/ScalaDemo-BATCH17112018/spark-events")
    val sc = new SparkContext(sparkConf);
    
    val ssc = new StreamingContext(sc,Seconds(5));
    
    val dTextStream = ssc.textFileStream("file:///Users/sa356713/git/BATCH17112018/ScalaDemo-BATCH17112018/InputDir-3")
    //input => DEER RIVER RIVER --> flatMap(input.split(" ") ---> (DEER,RIVER,RIVER)
    
    var fm = (iLine:String) => iLine.split(" ").iterator;
    
    
    val tokens = dTextStream.flatMap(fm); //DEER,RIVER,RIVER
    dTextStream.flatMap( _.split(" ").iterator);
    
    var fn = (x:String) => (x,1)
    
    val filFn = (x:String) => x.length() > 4
    
    val filterData = tokens.filter(filFn)
    tokens.filter((x: String) => x.length() > 4)
    tokens.filter((x) => x.length() > 4)
    tokens.filter(x => x.length() > 4)
    tokens.filter(_.length() > 4)
    
     
    tokens.map(fn);//(DEER,1), (RIVER,1),(RIVER,1)
    tokens.map((x:String) => (x,1));
    val wordOne = tokens.map(x => (x,1));
    
    val gout = wordOne.groupByKey().count;
    
    val rFn = (out:String, token:String) => out+","+token;
    
    filterData.reduce(rFn)
    filterData.reduce(rFn)
    
    filterData.cache();
    filterData.persist()
    filterData.persist(StorageLevel.MEMORY_AND_DISK_SER);
    
    
    val output = tokens.countByValue();
    output.foreachRDD(rdd => rdd.foreach(t => t._1 +","+t._2))
//    output.saveAsTextFiles(prefix, suffix)
    ssc.start();
    ssc.awaitTermination();
    
  }
  
}