import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.Source

object Words {
  def main(args: Array[String]): Unit = {
    var input=Source.fromFile("C:\\Users\\phreddy\\Documents\\input.txt")
    var map: mutable.HashMap[String,Int]= mutable.HashMap[String,Int]()
    for(line<-input.getLines()){
      var a:Array[String]=line.split(" ")
      for(i<-a){
        if(map.contains(i)){
          map(i)=map(i)+1
        }
        else{
          map(i)=1
        }
      }
    }
    println("word count:")
    map.keys.foreach{i=>
      println(i+":"+map(i))
    }
    var max:Int=0
    var l=new ListBuffer[String]()
    map.keys.foreach{i=>
      if(map(i)>=max) {max=map(i)
      l+=i
      }
    }
    println("words that is repeated max times:")
    for(j<-l){
      println(j+":"+map(j))
    }
  }
}
