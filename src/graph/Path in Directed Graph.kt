package graph

import java.util.*

class `Path in Directed Graph` {
    fun solve(A: Int, B: Array<IntArray>): Int {
        val g = buildAdjacencyList(A, B)
        val vis = BooleanArray(A + 1)
        for (i in 1..A) {
            if (!vis[i]) {
                BFS(g, 1, A, vis)
            }
        }
        val isPath = vis[A]
        return if (isPath) 1 else 0
    }

    private fun BFS(g: MutableList<MutableList<Int>>, s: Int, d: Int, vis: BooleanArray) {
        val q: Queue<Int> = LinkedList()
        q.add(s)
        vis[s] = true
        while (q.size > 0) {
            val u = q.poll()
            for (i in g[u].indices) {
                val v = g[u][i]
                if (!vis[v]) {
                    q.add(v)
                    vis[v] = true
                }
            }
        }
    }

    private fun buildAdjacencyList(A: Int, B: Array<IntArray>): MutableList<MutableList<Int>> {
        var g = MutableList(A+1){
            mutableListOf<Int>()}

        for (i in B.indices) {
            val u = B[i][0]
            val v = B[i][1]
            g[u].add(v)
        }
        return g
    }

}