package dp

import java.util.*


/*
* Q.  Given an array of integers A representing chain of 2-D matices such that the dimensions of ith matrix is A[i-1] x A[i].
Find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications,
but merely to decide in which order to perform the multiplications.
Return the minimum number of multiplications needed to multiply the chain.
* .............................................
* Problem Constraints
1 <= length of the array <= 1000
1 <= A[i] <= 100
*.....................................................
* Input => A = [40, 20, 30, 10, 30]
* Output =>  26000
*
*/



class `Matrix Chain Multiplication` {
    fun solve(A: IntArray): Int {
        var dp = Array(A.size){IntArray(A.size){-1}}
        return getMinMCM(A, 1, A.size-1, dp)
    }
    fun getMinMCM(A: IntArray, i:Int, j:Int, dp: Array<IntArray>):Int{
        if(i>=j) return 0
        if(dp[i][j] != -1) return dp[i][j]
        dp[i][j] = Int.MAX_VALUE
        for(k in i..j){
            dp[i][j] = Math.min(dp[i][j], getMinMCM(A, i, k, dp) + getMinMCM(A, k+1, j, dp) + A[i-1]*A[k]*A[j])
        }
        return dp[i][j]
    }
}

fun main(){
    var A = intArrayOf(40, 20, 30, 10, 30)
    print(`Matrix Chain Multiplication`().solve(A))
    val envelopes = arrayOf(intArrayOf(5, 4), intArrayOf(6, 4), intArrayOf(6, 7), intArrayOf(2, 3))
    Arrays.sort(envelopes) { a: IntArray, b: IntArray -> a[0] - b[0] }
}