package graph

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

data class hos(var x:Int, var y:Int)
class `Hospitals n Residence` {
    fun solve(A: Array<CharArray>): Int {
        var dist = Array(A.size) { IntArray(A[0].size) { 0 } }
        var vis = Array(A.size) { BooleanArray(A[0].size) { false } }
        var queue = LinkedList<hos>()
        for (i in A.indices) {
            for (j in A[0].indices) {
                if (A[i][j] == 'H') {
                    queue.add(hos(i, j))
                    vis[i][j] = true
                }
            }
        }
        while (queue.isNotEmpty()) {
            var element = queue.poll()
            bfs(A, element.x, element.y)
        }
     return 2
    }

    fun bfs(A: Array<CharArray>, x:Int, y:Int){

    }
}