package com.edureka.spark.sql

object TestUDF {
  def main(args: Array[String]): Unit = {

    import org.apache.spark.SparkConf
    import org.apache.spark.SparkContext
    import org.apache.spark.sql.SparkSession

    val sparkConf = new SparkConf().setAppName("TestUDF-sql-demo").setMaster("local[*]").set("spark.submit.deployMode", "client")

    val spark = SparkSession.builder().config(sparkConf).getOrCreate();
    
    val fnCTOF = (degreeCelcius:Double) => ((degreeCelcius*9.0/5.0)+32.0)
    
    spark.udf.register("CTOF",fnCTOF);
    
    
    val tempJSON = "file:///<YOUR_LOCATION>/temperatures.json";
    
    val tDF = spark.read.json(tempJSON)
    tDF.createOrReplaceTempView("temperature");
    
    spark.sql("select city,CTOF(avgHigh),CTOF(avgLow) from  temperature").show()
    
    
    val fnUpper = (input:String) => input.toUpperCase();
    
    spark.udf.register("UPPER",fnUpper);
    
    spark.sql("select UPPER(city) from  temperature").show()
    
    

  }
}