package heap

import java.util.PriorityQueue

/*
*Q. Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification,
*  we can replace any one array element A[i] by -A[i].
You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
*  A = [24, -68, -29, -9, 84]
 B = 4
 * 68 29 9
 * output = 196
*
* */
class `Maximum array sum after B negations` {

    fun solve(B:Int, array: IntArray):Int{
        var queue = PriorityQueue<Int>()
        queue.addAll(array.asIterable())
        var i = B
        while(i>0 && !queue.isEmpty()){
            var no = queue.poll()
            queue.add(-(no))
            i--
                    }
       return queue.sum()
    }
}
fun main(){
    var arr = intArrayOf(24, -68, -29, -9, 84)
    println(`Maximum array sum after B negations`().solve(4, arr))
}