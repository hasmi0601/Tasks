package com.scala
import scala.io.Source

object Assignment {
    def main(args:Array[String]): Unit = {
      val fname = "C:\\Users\\Hasmita\\IdeaProjects\\ScalaPractice\\src\\main\\scala\\com\\scala\\text.txt"
      val fsource = Source.fromFile(fname)
      var sum=0; var tc=0
      for(line<-fsource.getLines()){
        var i=0; var count=0
        var s:String=""
        for(c<-line){
          if((c>='a' && c<='z') || (c>='A' && c<='Z') || c==' '){
            s+=c
          }
          if(c!=' ')
            tc=tc+1
        }
        //println(s)
        while(i<s.length){
          if(i!=0 && i!=s.length-1) {
            if (s.charAt(i) == ' ' )
              if(s.charAt(i + 1) != ' ')
                    count = count + 1;
          }
          else if(i==s.length-1)
            count=count+1
          i=i+1
        }
        sum=sum+count

        //println(count)
      }
      println("Characters:"+tc)
      println("words: "+sum)
      fsource.close()

    }
}
