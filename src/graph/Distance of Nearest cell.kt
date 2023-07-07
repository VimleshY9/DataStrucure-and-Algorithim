package graph

import java.util.*

class `Distance of Nearest cell` {
    fun solve(A: Array<IntArray>): Array<IntArray>? {
        val dist = Array(A.size) { IntArray(A[0].size) }
        val vis = Array(A.size) {
            BooleanArray(
                A[0].size
            )
        }
        val q: Queue<Pair> = LinkedList()
        for (i in A.indices) {
            for (j in A[0].indices) {
                if (A[i][j] == 1) {
                    q.add(Pair(i, j))
                    vis[i][j] = true
                }
            }
        }
        val dx = intArrayOf(1, -1, 0, 0)
        val dy = intArrayOf(0, 0, 1, -1)
        while (!q.isEmpty()) {
            val p = q.poll()
            val x = p.x
            val y = p.y
            vis[x][y] = true
            for (i in 0..3) {
                val di = dx[i]
                val dj = dy[i]
                val newX = x + di
                val newY = y + dj
                val d = dist[x][y]
                if (newX < A.size && newX >= 0 && newY >= 0 && newY < A[0].size && A[newX][newY] == 0 && !vis[newX][newY]) {
                    vis[newX][newY] = true
                    q.add(Pair(newX, newY))
                    dist[newX][newY] = d + 1
                }
            }
        }
        return dist
    }
}

internal class Pair(var x: Int, var y: Int){

}