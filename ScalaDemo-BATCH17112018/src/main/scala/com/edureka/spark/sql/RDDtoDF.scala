package com.edureka.spark.sql

object RDDtoDF {

  def main(args: Array[String]): Unit = {
    import org.apache.spark.SparkConf
    import org.apache.spark.SparkContext
    import org.apache.spark.sql.SparkSession

    val sparkConf = new SparkConf().setAppName("RDD-To-DF").setMaster("local[*]").set("spark.submit.deployMode", "client")

    val spark = SparkSession.builder().config(sparkConf).getOrCreate();

    val input = "file://<YOUR_LOCATION>/employee.txt";

    val empRDD = spark.sparkContext.textFile(input, 2); //"John",28

    //Approach -- 1 Reflection API --> Case classes

    val cEmpRDD = empRDD.map(iLine => iLine.split(",")).map(a => Employee(a(0), a(1).toLong))

    import spark.implicits._;

    var empDf = cEmpRDD.toDF
    empDf.show()
    empDf.printSchema

    //Approach -- 2 : using explict Schema

    val schemaString = "name age"

    val schemaArray = schemaString.split(" "); //schemaArray[0] = name, schemaArray[1] = age

    import org.apache.spark.sql.types.StructField
    import org.apache.spark.sql.types.StringType
    import org.apache.spark.sql.types.StructType
    import org.apache.spark.sql.Row

    val fields = schemaArray.map(str => StructField(str, StringType, nullable = true));

    val schema = StructType(fields);

    val rEmpRDD = empRDD.map(iLine => iLine.split(",")).map(a => Row(a(0), a(1)))

    empDf = spark.createDataFrame(rEmpRDD, schema);

    empDf.show()
    empDf.printSchema

  }

}