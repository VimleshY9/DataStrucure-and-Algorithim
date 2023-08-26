package graph

/*
* Q. Counting the number of islands in abinary matrix.
* Input:
[[1, 1, 0, 0, 0],
[1, 1, 0, 0, 0],
[0, 0, 1, 0, 0],
[0, 0, 0, 1, 1]]
* Output: 3
* Counting the number of islands in a binary matrix is a classic problem in graph theory. An island is a group of connected '1's (representing land) in the matrix. The goal is to count the number of distinct islands
* */
class `Counting the number of islands` {
    fun solve(array: Array<IntArray>):Int{
     var row = array.size
     var col = array[0].size
        var count = 0
     for(i in 0 until row){
         for(j in 0 until col) {
            if(array[i][j] == 1){
                dfs(array, i, j)
                count++
            }
         }
     }
        return count
    }

    private fun dfs(grid: Array<IntArray>, row: Int, col: Int) {
        val numRows = grid.size
        val numCols = grid[0].size
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || grid[row][col] != 1) {
            return
        }
        grid[row][col] = -1 // Mark the cell as visited

        // Explore neighboring cells
        dfs(grid, row - 1, col)
        dfs(grid, row + 1, col)
        dfs(grid, row, col - 1)
        dfs(grid, row, col + 1)
    }
}

fun main(){
    val grid = arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(0, 0, 1, 0, 0),
        intArrayOf(0, 0, 0, 1, 1)
    )
    println(`Counting the number of islands`().solve(grid))
}