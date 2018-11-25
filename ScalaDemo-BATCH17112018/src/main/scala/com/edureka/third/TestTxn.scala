package com.edureka.third

object TestTxn {
  def main(args: Array[String]): Unit = {
    val t1 = new Txn(1, "2018-01-01", 123, 232.4);
    val t2 = new Txn(1, "2018-01-01", 123, 232.4);

    val t3 = Txn(1, "2018-01-01", 123, 232.4);

    val vars = Txn.unapply(t1);

    //Apply -- inputvariable --> Create Object
    //unApply --> Object --> give back variables

    println(t1 == t2)

    println(testMatch(1))
    println(testMatch("two"))
    println(testMatch(3))
    println(testMatch(33.2))
  }

  def testMatch(input: Any): Any = {
    input match {
      case 1 => "One"
      case "two" => 2
      case y: Int => y
      case _ => "Other"
    }
  }
}