package dp

/*
* Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character
*......................................................
* Problem Constraints
1 <= length(A), length(B) <= 450
* .......................................................
* Input:
 A = "abad"
 B = "abac"
Output => 1
* */
class `Edit Distance` {
    fun minDistance(A: String, B: String): Int {
        var dp = Array(A.length){IntArray(B.length){-1}}
        return getED(A, B, A.length-1, B.length-1, dp)
    }
    fun getED(A: String, B: String, i: Int, j:Int, dp: Array<IntArray>) : Int{
        if(i<0 || j<0) return Math.abs(i-j)
        if(dp[i][j] != -1)return dp[i][j]
        var ans = 0
        if(A[i]==B[j])
            ans = getED(A, B, i-1, j-1, dp)
        else
        {var e1 =  Math.min(getED(A, B, i-1, j, dp), getED(A, B, i, j-1, dp))
            ans = 1+Math.min(e1, getED(A, B, i-1, j-1, dp))
        }
        dp[i][j] = ans
        return dp[i][j]
    }
}

fun main(){
   var A = "abad"
   var B = "abac"
   print(`Edit Distance`().minDistance(A, B))
}