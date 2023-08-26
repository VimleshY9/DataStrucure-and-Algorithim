package Recursion

/*
* Q. integer n is given, you need to print all the parenthesis of length 2n
*
* TC => n2
* */
class `Print Parenthesis` {

    fun solve(n:Int){
//       parenthesis(n, 0, 2*n, "")
        backTrack("", n, n)
    }

    //Solution-1
    fun parenthesis(count:Int, diff:Int, len:Int, str:String){
        if(len==0){
            println(str)
            return
        }
        if(count>0){
            parenthesis(count-1, diff+1, len-1, "$str (")
        }
        if(diff>0){
            parenthesis(count, diff-1, len-1, "$str )")
        }
    }
// Solution - 2

    fun backTrack(str:String, left:Int, right:Int){
        if(left==0 && right==0){
            println(str)
            return
        }
        if(left>0){
            backTrack("$str ( ", left-1, right)
            }
        if(right>left){
            backTrack("$str )", left, right-1)
        }
    }
}
fun main(){
    `Print Parenthesis`().solve(3)
}











