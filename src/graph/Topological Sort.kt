package graph

import java.util.*
import kotlin.collections.ArrayList
/*
* Q. Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.

Return the topological ordering of the graph and if it doesn't exist then return an empty array.

If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
*
* Input => A = 6
 B = [  [6, 3]
        [6, 1]
        [5, 1]
        [5, 2]
        [3, 4]
        [4, 2] ]

*Output => [5, 6, 1, 3, 4, 2]
* */

class `Topological Sort` {
    fun solve(A: Int, B: Array<IntArray>): IntArray? {
        val topo = IntArray(A)
      var  adj = createAdj(A, B)
        val indeg = IntArray(A + 1)
        for (i in 1..A) {
            for (it in adj[i]) {
                indeg[it]++
            }
        }
        val q = PriorityQueue<Int>()
        for (i in 1 until indeg.size) {
            if (indeg[i] == 0) {
                q.add(i)
            }
        }
        var count = 0
        var ind = 0
        while (!q.isEmpty()) {
            val u = q.poll()
            topo[ind++] = u
            for (i in adj[u]) {
                indeg[i]--
                if (indeg[i] == 0) {
                    q.add(i)
                }
            }
            count++
        }
        return if (count < A) {
            IntArray(0)
        } else topo
    }

    fun createAdj(A: Int, B: Array<IntArray>): ArrayList<ArrayList<Int>> {
        val adj = ArrayList<ArrayList<Int>>()
        for (i in 0..A) {
            adj.add(ArrayList())
        }
        for (i in B.indices) {
            adj[B[i][0]].add(B[i][1])
        }
        return adj
    }
}