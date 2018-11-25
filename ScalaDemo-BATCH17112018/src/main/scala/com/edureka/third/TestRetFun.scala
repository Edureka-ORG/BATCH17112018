package com.edureka.third

object TestRetFun {
  def main(args: Array[String]): Unit = {
    def getURl = urlBuilder(true, "google.com");
    println(getURl("xyz", "query1"));
  }
  
  

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {

    (endPoint: String, query: String) => s"https://$domainName/$endPoint?$query"
  }

}