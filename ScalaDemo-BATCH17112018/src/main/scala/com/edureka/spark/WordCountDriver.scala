package com.edureka.spark


object WordCountDriver 
{
  def main(args: Array[String]): Unit = {
    
    println("In WordCountDriver");
    
    //step -1 : Create spark Configuration
    
    import org.apache.spark.SparkConf
    
    val sparkConf = new SparkConf();
//    sparkConf.setAppName(WordCountDriver.getClass.getName)
    sparkConf.setAppName("WordCountDriver");
    //Mandatory -- cluster Manager --deployMode
    
    //Optionally we can specify  in the Driver class
//    sparkConf.setMaster("yarn");
    sparkConf.setMaster("local[*]");
    sparkConf.set("spark.submit.deployMode","client");
    
    
    //Step-2 : Create SparkContext --> Environmental Handle
    
    import org.apache.spark.SparkContext
    val sc = new SparkContext(sparkConf);
    
    //TODO BUSINESS LOGIC - in terms of RDD + functions
    
    val input = List("DEER","BEAR","BEAR");

//    input.length;
    
//    val inputRDD = sc.parallelize(input);
    //val inputRDD = RDD.textFile("hdfs:/user/edureka_144865/WordCount.txt");
    val inputRDD = sc.textFile("hdfs:/user/edureka_144865/WordCount.txt");

    val wordOneRDD = inputRDD.map(w => (w,1))
    
    val wcRDD = wordOneRDD.reduceByKey(_+_);
    
    val output = wcRDD.collect();
    
    println(output)
    
//    inputRDD.countByValue().foreach(println);
    
  }
}