package com.edureka

//scala
//predef
object TestList {
  def main(args: Array[String]): Unit = {
    val l = List;
    val l1 = Nil;

    val input = 1 :: 2 :: 3 :: Nil;

    input.foreach(println)

    val input2 = List(1, 2, 3);

    input2.foreach(println)

    val dL = List(1, 2.0, 3d, 4f);
    dL.foreach(println)

    val rL = List.range(1, 20);
    rL.foreach(println)

    val fL = List.fill(3)("foo");
    fL.foreach(println);

    val tL = List.tabulate(5)(n => n * 5)
    tL.foreach(println)

    import scala.collection.mutable.ListBuffer;

    val lb = new ListBuffer[String]();
    lb += "first";
    lb.foreach(println)
    lb += ("aaa", "bbb");
    lb.foreach(println)

    lb ++= Array("xx", "yy");
    lb.foreach(println)

    val aL = List(3)
    aL.foreach(println)
    val anL = 1 :: 2 :: aL;
    anL.foreach(println)
    val zL = -1 :: anL::2::Nil;
    zL.foreach(println)

    val dlr= List.range(1, 20);
    dlr.filter(i => i > 2).foreach(println)
    val x = dlr ++ zL;
    x.foreach(println)
    val y = dlr ::: zL;
    y.foreach(println)
    val z = List.concat(dlr,zL);
    z.foreach(println)
    
    
    val lst = List.range(1, 20);
    println(lst)
    println(lst.head)
   println( lst.tail)
   
    val cLc=2 :: List(4,5)
    
    cLc.foreach(println)
    println(sum(cLc));
  }
  
  def sum(l:List[Int]):Int = {
    if(l == Nil) return 0
    l.head+sum(l.tail);
  }
}