package dp

/*
* Q. Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
You need to return the length of longest palindromic subsequence.
*................................
* Problem Constraints
1 <= length of(A) <= 103
* ............................
* Input:  A = "bebeeed"
* Output: 4
*
* */

class `Longest Palindromic Subsequence` {

    fun solve(A: String): Int {
        var dp = Array(A.length){IntArray(A.length){-1}}
        return getLPS(A, 0, A.length-1, dp)
    }

    fun getLPS(A: String, i: Int, j:Int, dp:Array<IntArray>):Int{
        if(i==A.length || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j]
        if(A[i]==A[j]){
            dp[i][j] = 1 + getLPS(A, i+1, j-1, dp)

        }
        else{
            dp[i][j] = Math.max(getLPS(A, i+1, j, dp), getLPS(A, i, j-1, dp))

        }
        return dp[i][j]
    }
}

fun main(){
    var  A = "bebeeed"
    print(`Longest Palindromic Subsequence`().solve(A))
}