package com.edureka.spark.sql

object SqlDemo 
{
  def main(args: Array[String]): Unit = {
    
    import org.apache.spark.SparkConf
    import org.apache.spark.SparkContext
    import org.apache.spark.sql.SparkSession
    
    
    val sparkConf = new SparkConf().setAppName("Helloworld-sql-demo").setMaster("local[*]").set("spark.submit.deployMode","client")
    
    val spark = SparkSession.builder().config(sparkConf).getOrCreate();
    
    val peopleJson = "file://<YOUR_LOCATION>/people.json";
    
     val pdf = spark.read.json(peopleJson)
     
     pdf.show
     
     pdf.select("name").show()
     
     import spark.implicits._;
     
     pdf.select($"name",$"age"+1).show
     
     pdf.createOrReplaceTempView("people");
     
     spark.sql("select name, age from people").show()
     val df = spark.sql("select name, age from people");
     
     df.select("name").show()
     df.select($"name",$"age"+1).show
  }
}