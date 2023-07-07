package dp

class `Regular Expression` {
    fun isMatch(A: String, B: String): Int {

        val dp = Array(A.length + 1){ BooleanArray(B.length + 1){false} }
        return if(isExpressionMatched(A, B, A.length, B.length, dp)) 1 else 0
    }

    fun isExpressionMatched(A: String, B: String, i: Int, j: Int, dp: Array<BooleanArray>): Boolean {
        if (i == 0 && j == 0) return true
        if (j==0 || i==0) return false
        if (dp[i][j]) return dp[i][j]
        if(B[j-1]=='*') {
            dp[i][j] = isExpressionMatched(A, B, i, j - 1, dp) || (i > 0 && isExpressionMatched(A, B, i - 1, j, dp))
        }
        else if (A[i - 1] == B[j - 1] || B[j - 1] == '?') {
            dp[i][j] = isExpressionMatched(A, B, i - 1, j - 1, dp)
        }
        return dp[i][j]
    }

}

fun main(){
    var a = "bbbcbcb"
    var b = "**b"
    print(`Regular Expression`().isMatch(a, b))
}