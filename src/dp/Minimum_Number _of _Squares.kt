package dp
/*
* Q. Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
*
* Problem Constraints
1 <= A <= 105
*
* example => A = 6
*  Possible combinations are : (1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 1^2) and (1^2 + 1^2 + 2^2).
 Minimum count of numbers, sum of whose squares is 6 is 3.
 *
 * TC => O(n)
* */
import kotlin.math.floor
import kotlin.math.min
import kotlin.math.sqrt

class `Minimum_Number _of _Squares` {
    fun countMinSquares(A: Int): Int {
        var dp = IntArray(A+1){-1}
        return getMinSquare(A, dp)
    }

    private fun getMinSquare(A:Int, dp: IntArray):Int{
        if(A==0) return 0
        if(dp[A] != -1) return dp[A]
        var ans = A
        for(i in 1..floor( sqrt(A.toDouble())).toInt()){
            ans = min(ans, 1+getMinSquare(A-(i*i), dp))
        }
        dp[A] = ans
return dp[A]
    }
}

fun main(){
   print(`Minimum_Number _of _Squares`().countMinSquares(6))
}