package Recursion

class `Find Ath Number In Fibonaci Series` {

    fun findAthFibonacci(A: Int): Int {
        if(A==1) return 0
        if(A==2) return 1
        return find(A, 2, 1, 1)

    }

    fun find(A:Int, count:Int, f:Int, s:Int):Int{
        if(count==A){
            return s
        }
        var temp = s
        var s1 = f+s
        var f1 = temp
      return  find(A, count+1, f1, s1)
    }
}

fun main(){
    println(`Find Ath Number In Fibonaci Series`().findAthFibonacci(12))
}