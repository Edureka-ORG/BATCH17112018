package com.edureka.spark

import org.apache.spark.storage.StorageLevel

object TestTransformations {

  def main(args: Array[String]): Unit = {
    println("In TestTransformations");

    //step -1 : Create spark Configuration

    import org.apache.spark.SparkConf

    val sparkConf = new SparkConf();
    //    sparkConf.setAppName(WordCountDriver.getClass.getName)
    sparkConf.setAppName("TestTransformations");
    //Mandatory -- cluster Manager --deployMode

    //Optionally we can specify  in the Driver class
    //    sparkConf.setMaster("yarn");
    sparkConf.setMaster("local[*]");
    sparkConf.set("spark.submit.deployMode", "client");

    //Step-2 : Create SparkContext --> Environmental Handle

    import org.apache.spark.SparkContext
    val sc = new SparkContext(sparkConf);
    
    
    //Map
    val input = List("dog","salmon","elephant","rat");
    
    val inputRDD = sc.parallelize(input, 2);
    
    val lengthRDD= inputRDD.map(w => w.length())
    
    lengthRDD.collect();
    
    //Filter 
    val intRDD = sc.parallelize(1 to 10, 3);
    
    val filterRDD = intRDD.filter(i => i%2 ==0);
    
    filterRDD.collect()
    
    //GroupByKey
    
    val fn = (x:Int) => x%2==0
    
    var fRDD = intRDD.filter(fn)
        fRDD = intRDD.filter((x:Int) => x%2==0)
        fRDD = intRDD.filter((x) => x%2==0)
        fRDD = intRDD.filter(x => x%2==0)
         fRDD = intRDD.filter(_%2==0)
         
         
    val kvRDD = intRDD.map(
        (x:Int) => 
      if(x%2 ==0) 
        ("even",x) 
        else 
          ("odd",x)
          
      )
      
     
      val gRDD = kvRDD.groupByKey();
    gRDD.collect();
    
    
    //JoinRDD 
    
    val zRDD = inputRDD.zip(lengthRDD);
    
    val anotherInput = List("dog","salmon","elephant","rat","BIGANIMAL");
     val anotherInputRDD = sc.parallelize(anotherInput, 2);
    
    val alengthRDD= anotherInputRDD.map(w => w.length())
     val azRDD = anotherInputRDD.zip(alengthRDD);
    
    val jRDD = zRDD.join(azRDD)
    jRDD.collect()
    
    //intersection
    
    val iRDD = inputRDD.intersection(anotherInputRDD)
    iRDD.collect()
    
    //reduceByKey
    
    val words = Seq("DEER","BEAR","RIVER","CAT","BEAR");
    
    val wordsRDD = sc.parallelize(words, 2);
    
    val oRDD = wordsRDD.map(word => (word,1)) // --> (DEER,1),(BEAR,1),(RIVER,1),(CAT,1),(BEAR,1)
    
    val rfn = (acc:Int, v:Int) => acc+v;
    
    StorageLevel
    
    
    val rKRDD = oRDD.reduceByKey(rfn) ;//DEER,1, 
    //(BEAR,1)(BEAR,1)(BEAR,1)(BEAR,1)(BEAR,1)(BEAR,1)
    
    //BEAR,1,1,1,1,1,1,1
    
    //acc          v        acc = acc+v
    //0            1        1
    //1            1        2
    //2            1        3
    //3            1        4
    
    
    val paras = Seq("DEER RIVER CAT BEAR RIVER","DEER DEER CAT CAT RIVER");
    
    val pRDD = sc.parallelize(paras);
    val wRDD = pRDD.flatMap(iLine => iLine.split(" "));
    
    //DEER RIVER CAT BEAR RIVER  == > Array(DEER,RIVER,CAT,BEAR,RIVER)
    //DEER DEER CAT CAT RIVER  == > Array(DEER,DEER,CAT,CAT,RIVER)
    
    //wRDD = RDD[Array[String]] == > RDD(Array(DEER,RIVER,CAT,BEAR,RIVER), Array(DEER,DEER,CAT,CAT,RIVER))
    
    //wRDD = RDD[String] ==> RDD(DEER,RIVER,CAT,BEAR,RIVER,DEER,DEER,CAT,CAT,RIVER);
    
  }
}