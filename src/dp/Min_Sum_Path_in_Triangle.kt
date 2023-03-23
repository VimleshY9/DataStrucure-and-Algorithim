package dp

import java.util.*


/*
* Q. Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row
*..............................................
* Problem Constraints
|A| <= 1000
A[i] <= 1000
* ..............................................
* input:
A = [
         [2],
        [3, 4],
       [6, 5, 7],
      [4, 1, 8, 3]
    ]
 Output: 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * .................................................
 * Time Complexity
 * n=row, m=column
 * O(NM)
* */
class Min_Sum_Path_in_Triangle {

    fun minimumTotal(a: ArrayList<ArrayList<Int>>): Int {
        val n = a.size
        val dp = Array(n) { IntArray(a[n - 1].size) }
        Arrays.stream(dp).forEach { b: IntArray? ->
            Arrays.fill(
                b,
                -1
            )
        }
        return getAdjMin(a, 0, 0, dp)
    }

    fun getAdjMin(a: ArrayList<ArrayList<Int>>, i: Int, j: Int, dp: Array<IntArray>): Int {
        if (i > a.size - 2) {
            return a[i][j]
        }
        if (dp[i][j] != -1) return dp[i][j]
        dp[i][j] = a[i][j] + Math.min(getAdjMin(a, i + 1, j, dp), getAdjMin(a, i + 1, j + 1, dp))
        return dp[i][j]
    }
}