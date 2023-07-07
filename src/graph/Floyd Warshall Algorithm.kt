package graph

/*
* Q. Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
* If there is no possible path from vertex i to vertex j , B[i][j] = -1
Note: Rows are numbered from top to bottom and columns are numbered from left to right.
* ....................................................
*TC = o(N^3)
* */
class `Floyd Warshall Algorithm` {
    fun solve(A: Array<IntArray>): Array<IntArray> {
        var dist: Array<IntArray> = A
        var v = A.size
        for(i in A.indices){
            for(j in 0 until A[0].size){
                if(dist[i][j]== -1) dist[i][j] = 1000000000
            }
        }
        for(k in 0 until v){
            for(i in 0 until v){
                for(j in 0 until v){
                    dist[i][j] = dist[i][j].coerceAtMost((dist[i][k] + dist[k][j]))
                }
            }
        }
        for(i in A.indices){
            for(j in 0 until A[0].size){
                if(dist[i][j]== 1000000000) dist[i][j] = -1
            }
        }
        return dist
    }
}