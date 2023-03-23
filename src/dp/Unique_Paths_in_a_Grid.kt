package dp
/*
* Q. Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m). At any instance,
* if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
* Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and empty space is
* marked as 1 and 0 respectively in the grid.
*..................
* Problem Constraints
1 <= n, m <= 100
A[i][j] = 0 or 1
* ..................
* input =>  A = [
        [0, 0, 0]
        [0, 1, 0]
        [0, 0, 0]
     ]
 OutPut => 2
*...........................
*
* TC => O(NM)
* SC => O(NM)
*
* */
class Unique_Paths_in_a_Grid {

    fun uniquePathsWithObstacles(A: Array<IntArray>): Int {
        var dp = Array(A.size+1){IntArray(A[0].size+1){-1}}
        return getUniquePath(A, 0, 0, dp)
    }

    private fun getUniquePath(A: Array<IntArray>, x:Int, y:Int, dp: Array<IntArray>) : Int{
        if(x==A.size-1 && y == A[0].size-1 && A[x][y] == 0){
            return 1
        }
        if(x>A.size-1 || y>A[0].size-1 || A[x][y] == 1) return 0

        if(dp[x][y]!=-1) return dp[x][y]
        dp[x][y] =  getUniquePath(A, x+1, y, dp) + getUniquePath(A, x, y+1, dp)
        return dp[x][y]
    }
}

 fun main(){
     val matrix = Array(3) { IntArray(3) }

// Initialize the values of the matrix
     matrix[0][0] = 0
     matrix[0][1] = 0
     matrix[0][2] = 0
     matrix[1][0] = 0
     matrix[1][1] = 1
     matrix[1][2] = 0
     matrix[2][0] = 0
     matrix[2][1] = 0
     matrix[2][2] = 0

     print(Unique_Paths_in_a_Grid().uniquePathsWithObstacles(matrix))
}