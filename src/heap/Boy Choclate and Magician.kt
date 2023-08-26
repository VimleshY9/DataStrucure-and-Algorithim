package heap

import java.util.Collections
import java.util.PriorityQueue

/*
* Q. Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
Find the maximum number of chocolates that the kid can eat in A units of time.
* */
class `Boy Choclate and Magician` {
    fun solve(A:Int, arr:IntArray):Int{
        var queue = PriorityQueue<Int>(Collections.reverseOrder())
        queue.addAll(arr.asList())
        var i = A
        var maxChoclate =0
        while(i>0 && !queue.isEmpty()){
            var no = queue.poll()
           maxChoclate += no
            queue.add(no/2)
            i--
        }
        return maxChoclate
    }
}

fun main(){
    println(`Boy Choclate and Magician`().solve(5, intArrayOf(2, 4, 6, 8, 10)))
}