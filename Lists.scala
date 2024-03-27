import scala.collection.mutable
import scala.util.control.Breaks._

object Lists {
  def main(args: Array[String]): Unit = {
    //without using frequency count
    var l1=List(1,2,3)
    var l2=List(1,2,3,3)
    /*val a=l1.sorted
      val b=l2.sorted
      println(a.equals(b))*/
    println(l1.equals(l2))

    //using frequency count
    var map1:mutable.HashMap[Int,Int]=mutable.HashMap()
    var map2:mutable.HashMap[Int,Int]=mutable.HashMap()
    for(i<-l1){
      if(map1.contains(i)){
        map1(i)=map1(i)+1
      }
      else{
        map1(i)=1
      }
    }
    for (i <- l2) {
      if (map2.contains(i)) {
        map2(i) = map2(i) + 1
      }
      else {
        map2(i) = 1
      }
    }
    var flag=0
    breakable {
      for (i <- l1) {
        if (map2.contains(i)) {
          if (map2(i) != map1(i)) {
            flag = 1;
          }
        }
      }
    }
    if(flag==1) println("false") else println("true")
  }

}
