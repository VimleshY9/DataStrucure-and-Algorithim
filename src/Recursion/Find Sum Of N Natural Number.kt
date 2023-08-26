package Recursion

class `Find Sum Of N Natural Number` {

    fun solve (n:Int):Int{
        if(n==0) return 0
        return n+solve(n-1)
    }
}

fun main(){
    println(`Find Sum Of N Natural Number`().solve(10))
}
