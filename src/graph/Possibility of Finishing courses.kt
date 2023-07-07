package graph

import java.util.LinkedList
import java.util.Queue

class `Possibility of Finishing courses` {
    fun solve(A: Int, B: IntArray, C: IntArray): Int {
        var adj:MutableList<MutableList<Int>> = MutableList(A+1){ mutableListOf() }
        var q:Queue<Int> = LinkedList()
        for(i in B.indices)
        {
            adj[B[i]].add(C[i])
        }
        var ind = IntArray(A+1)
        for (element in C){
            ind[element]++
        }
        for (i in 1..A){
            if(ind[i]==0){
               q.add(i)
            }
        }
        while (!q.isEmpty()){
            var c = q.poll()
            for (i in adj[c]){
                ind[i]--
                if(ind[i]==0){
                    q.add(i)
                }
            }
        }
        for (i in 1..A){
            if(ind[i]!=0){
                return 0
            }
        }
        return 1
    }
}

fun main(){
    val ans = `Possibility of Finishing courses`()
    val B = intArrayOf(1,2,3,4,5,8)
    val C = intArrayOf(2,3,4, 5,6,7)
    println(ans.solve(8, B, C))
}