package com.edureka.third

object TestPerson {
  def main(args: Array[String]): Unit = {
    val p1 = Person(1, "aaa");
    val p2 = Person(1, "bbb");
    val p3 = Person(1, "ccc");
    val p4 = Person(1, "ddd");
    
    val persons = List(p1,p2,p3,p4);
    
    persons.foreach(p => println(testMatch(p)))

  }

  def testMatch(person: Person): Any = {
    person match {
      case Person(1, "aaa") => "hello aaa";
      case Person(1, "bbb") => "hello bbb";
      case Person(1, "ccc") => "hello ccc";
      case Person(1, "ddd") => "hello ddd";
      case _ => "Who are you ?";
    }
  }
}