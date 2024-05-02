import scala.collection.mutable

object String_operations {
  def isDigit(i : Char): Boolean={
    if(i>=48 && i<=57){
      return true
    }
    return false
  }
  def Precedence(i:Char):Int={
    //var r:Int=0
    if(i=='*' || i=='/') 2
    else 1

  }
  def result(a:Int,b:Int,op:Char):Int= op match{
    //var r:Int=0
        case '+' => a+b
        case '-' => a-b
        case '*' => a*b
        case '/' => a/b
        //case _ => 0
  }
  def main(args: Array[String]): Unit = {
    var s="1/4+2*(4/7+8)"
    var op=mutable.Stack[Char]()
    var value=mutable.Stack[Int]()
    var num=0; var operand:Char=0; var val2=0; var val1=0; var res=0
    for(i<-s){
      if(isDigit(i)) {num=num*10+(i-'0'); println(num);}
      else if(i=='+' || i=='-' || i=='*' || i=='/'){
        println(num)
        if(num!=0){ value.push(num); num=0}
        println("value check:"+value)
        if(op.isEmpty) op.push(i)
        else{
          println(Precedence((op.top))+" "+Precedence(i))
          if(!op.isEmpty && op.top!='(' && Precedence(op.top)>=Precedence(i)){
            operand=op.pop()
            val2=value.pop()
            val1=value.pop()
            res=result(val1,val2,operand)
            op.push(i)
            value.push(res)
          }
          else op.push(i)
        }
      }
      else if(i=='(') {if(num!=0) { value.push(num); num=0;}
        op.push(i)}
      else if(i==')') {
        if(num!=0){ value.push(num); num=0}
        if(!op.isEmpty && op.top!='('){
          operand = op.pop()
          val2 = value.pop()
          val1 = value.pop()
          res = result(val1, val2, operand)
          value.push(res)
          if(op.top=='(') op.pop()
        }
      }
      println("value:"+value)
      println("op:"+op)
    }
    if(num!=0) value.push(num); num=0
    while(!op.isEmpty){
      operand = op.pop()
      val2 = value.pop()
      val1 = value.pop()
      res = result(val1, val2, operand)
      value.push(res)
    }
    if(op.isEmpty) println(value.pop())
  }

}
