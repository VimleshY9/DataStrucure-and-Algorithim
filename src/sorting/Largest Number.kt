package sorting

import java.util.*


class `Largest Number` {
    fun largestNumber(nums: IntArray): String {
        val strNums = nums.map { it.toString() } // Convert nums to a list of strings
        strNums.sortedWith(Comparator  { a, b->
            // Sort the strings in descending order based on their concatenated values
            (a.toInt()+b.toInt()).compareTo(b.toInt()+a.toInt())
        })
        return if (strNums[0] == "0") "0" else strNums.joinToString("") // Handle the case where all elements are 0
    }

    fun solve(A: IntArray): Int {
        Arrays.sort(A)
        var step = 0
        var p = 1
        while (p < A.size){
            if (A[p] == A[p - 1]) {
                A[p] = A[p] + 1
                step++
            }
            p++
        }
        return step
    }

    fun leastBricks(wall: List<List<Int>>): Int {
        val edgeCounts: MutableMap<Int, Int> = HashMap()
        var maxCount = 0
        for (row in wall) {
            var edgePos = 0
            for (i in 0 until row.size - 1) {
                edgePos += row[i]
                val count = edgeCounts.getOrDefault(edgePos, 0) + 1
                edgeCounts[edgePos] = count
                maxCount = Math.max(maxCount, count)
            }
        }
        return wall.size - maxCount

    }

}

fun main(){
    val nums = intArrayOf(3, 30, 34, 5, 9)
    print(`Largest Number`().largestNumber(nums))
}