package dp

/*
* Q. Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
You need to return the length of such longest common subsequence.
*.........................................
* Problem Constraints
1 <= Length of A, B <= 1005
* ...................................................
* Input 1:

 A = "abbcdgf"
 B = "bbadcgf"
 * Output=> 5
 *
* */
class `Longest Common Subsequence` {

    fun solve(A: String, B: String): Int {
        var dp = Array(A.length){IntArray(B.length){-1}}
        return getLCS(A, B, A.length-1, B.length-1, dp)
    }
    fun getLCS(A: String, B: String, i: Int, j:Int, dp: Array<IntArray>) : Int{
        if(i<0 || j<0) return 0
        if(dp[i][j] != -1)return dp[i][j]
        var ans = 0
        if(A[i]==B[j])
            ans = 1+getLCS(A, B, i-1, j-1, dp)
        else
            ans = Math.max(getLCS(A, B, i-1, j, dp), getLCS(A, B, i, j-1, dp))
        dp[i][j] = ans
        return dp[i][j]
    }
}

fun main(){
  var  A = "abbcdgf"
  var  B = "bbadcgf"
  print(`Longest Common Subsequence`().solve(A, B))

}