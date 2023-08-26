package Recursion

class `Implement Power Function` {

    fun solve(A:Int, B:Int, C:Int):Int{
        var ans = power(A, B/2, C)
        ans = (ans%C*ans%C)%C
       return if(B%2==0) ans else (ans%C*A%C)%C
    }
    fun power(A:Int, B:Int, C:Int):Int{
        if(B==1){
            return A
        }

            return ((B%C)*(power(A, B-1, C)%C)%C)

    }
}

fun main(){
    println(`Implement Power Function`().solve(1000,89,9))
}