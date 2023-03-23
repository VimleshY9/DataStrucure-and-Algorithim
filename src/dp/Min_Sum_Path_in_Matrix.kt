package dp

/*
* Q. Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
Return the minimum sum of the path.
NOTE: You can only move either down or right at any point in time.
* .........................................
* Problem Constraints
1 <= M, N <= 2000
-1000 <= A[i][j] <= 1000
*.........................................
* input =>  A = [
       [1, 3, 2]
       [4, 3, 1]
       [5, 6, 1]
     ]
 output => 8 --> 1, 3, 2, 1, 1
* */
class Min_Sum_Path_in_Matrix {

    fun minPathSum(A: Array<IntArray>): Int {
        var dp = Array(A.size+1){IntArray(A[0].size+1){1001}}
        return getMinPathSum(A, 0, 0, dp)
    }

    fun getMinPathSum(A: Array<IntArray>, x:Int, y:Int, dp: Array<IntArray>) : Int{
        if(x==A.size-1 && y == A[0].size-1){
            return A[x][y]
        }
        if(x>A.size-1 || y>A[0].size-1) return Int.MAX_VALUE

        if(dp[x][y]!= 1001) return dp[x][y]
        dp[x][y] = A[x][y] + Math.min (getMinPathSum(A, x+1, y, dp), getMinPathSum(A, x, y+1, dp))
        return dp[x][y]
    }
}

fun main(){
    val matrix = Array(3) { IntArray(3) }

// Initialize the values of the matrix
    matrix[0][0] = 1
    matrix[0][1] = 3
    matrix[0][2] = 2
    matrix[1][0] = 4
    matrix[1][1] = 3
    matrix[1][2] = 1
    matrix[2][0] = 5
    matrix[2][1] = 6
    matrix[2][2] = 1

    print(Min_Sum_Path_in_Matrix().minPathSum(matrix))

}

