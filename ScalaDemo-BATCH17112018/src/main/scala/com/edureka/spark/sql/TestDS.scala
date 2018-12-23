package com.edureka.spark.sql

object TestDS 
{
  def main(args: Array[String]): Unit = {
    
    val e1 = Employee("aaa",111);
    val e2 = Employee("bbb",222);
    
    val e3 = Employee("ccc",333);
    val e4 = Employee("ddd",444);
    val e5 = Employee("eee",555);
    
    
    val emps = List(e1,e2,e3,e4,e5);
    
//    emps.toDS
    
    
     import org.apache.spark.SparkConf
    import org.apache.spark.SparkContext
    import org.apache.spark.sql.SparkSession
    
    
    val sparkConf = new SparkConf().setAppName("Dataset-sql-demo").setMaster("local[*]").set("spark.submit.deployMode","client")
    
    val spark = SparkSession.builder().config(sparkConf).getOrCreate();
     
     import spark.implicits._;
     
   val empDS= emps.toDS();
   
  }
}