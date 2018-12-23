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
//    sparkConf.setMaster("local[*]");
//    sparkConf.set("spark.submit.deployMode","client");
    //Step-2 : Create SparkContext --> Environmental Handle
    import org.apache.spark.SparkContext
    val sc = new SparkContext(sparkConf);
    
    val linesRDD = sc.textFile(args(0),3);
//    val localFileRDD = sc.textFile("file:///user/edureka_144865/WordCount.txt");
//     val s3FileRDD = sc.textFile("s3:/buket-name/user/edureka_144865/WordCount.txt");
//     val rdbMSFile = sc.textFile("rdbms:/buket-name/user/edureka_144865/WordCount.txt"); //Wrong
     

    //line (COLUMNS ==1 )
    //DEER RIVER RIVER
    //CAT BEAR RIVER          RDD[Line] == lines
    //RIVER CAT BEAR
    
    //What is a Record ? ---> 30% --> Combination of Attributes with full fledge information 
    //--> have seperator between attributes and termination character between records
    
    //DEER RIVER RIVER  -- Array(DEER,RIVER,RIVER)
    //CAT BEAR RIVER  -- Array(CAT,BEAR,RIVER)
    //RIVER CAT BEAR  -- Array(RIVER,CAT,BEAR)
   
 //N --> 1 Array(DEER,RIVER,RIVER) + Array(CAT,BEAR,RIVER) + Array(RIVER,CAT,BEAR) = Array(DEER,RIVER,RIVER,CAT,BEAR,RIVER,RIVER,CAT,BEAR)
    
    val splitRDD = linesRDD.flatMap(iLine => iLine.split(" "))
    //splitRDD = RDD(DEER,RIVER,RIVER,CAT,BEAR,RIVER,RIVER,CAT,BEAR)
    
    val wordOneRDD = splitRDD.map(w => (w,1))
    //wordsOneRDD = RDD((DEER,1),(RIVER,1),(RIVER,1))
    
    val wcRDD = wordOneRDD.reduceByKey((acc:Int,v:Int) => acc+v);
    wcRDD.saveAsTextFile(args(1))
//    val output = wcRDD.collect();
//    println(output)
    
//    inputRDD.countByValue().foreach(println);
    
  }
}