package com.edureka.consumer

import org.apache.spark.streaming.StreamingContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.kafka.KafkaUtils

object KafkaWordCount {
  def main(args: Array[String]): Unit = {
    
    if(args.length <4)
    {
      println("usage KafkaWordCount <zkQuorum> <consumer-group-id> <topic> <number-of-threads>")
      return;
    }
    
    val sparkConf = new SparkConf()
    sparkConf.setAppName("Kafka-WordCount-Example")
    sparkConf.set("spark.ui.enabled", "true");
    
    //Create sparkContext
    
    val sc  = new SparkContext(sparkConf);
    
    //Create sparkStreamingContext
    
    val ssc = new StreamingContext(sc, Seconds(10));
    
    val dsStream = KafkaUtils.createStream(ssc, args(0), args(1), Map(args(2) -> args(3).toInt));//CONSTANT, DEER RIVER RIVER
    val lines = dsStream.map(_._2);//DEER RIVER RIVER
    val words = lines.flatMap(line => line.split(" "));//(DEER,RIVER,RIVER)
    val wordOne = words.map(w => (w,1));// (DEER,1),(RIVER,1),(RIVER,1)
    val wc = wordOne.reduceByKey(_+_);//(DEER,1),(RIVER,2)
    wc.print();
    ssc.start()
    ssc.awaitTermination();
  }
}