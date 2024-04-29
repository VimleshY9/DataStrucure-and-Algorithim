package backtracking

import java.util.*


/*
* Q. Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
Q. A = [1, 17, 8]
* Output - 2
*
* * */
class `Number of Squareful Arrays` {
    var count = 0
    var set: MutableSet<String> = HashSet()
    fun solve(A: IntArray): Int {
        if (A.size == 1) return if (isSquare(A[0])) 1 else 0
        countAllWays(0, A)
        return count
    }

    private fun countAllWays(i: Int, A: IntArray) {
        if (i == A.size) {
            if (set.add(A.contentToString())) count++
            return
        }
        for (j in i until A.size) {
            swap(A, i, j)
            if (i == 0 || isSquare(A[i - 1] + A[i])) {
                countAllWays(i + 1, A)
            }
            swap(A, i, j)
        }
    }

    private fun swap(A: IntArray, i: Int, j: Int) {
        val temp = A[i]
        A[i] = A[j]
        A[j] = temp
    }

    private fun isSquare(n: Int): Boolean {
        val sqrt = Math.sqrt(n.toDouble()).toInt()
        return sqrt * sqrt == n
    }

}

fun main(){
    println(`Number of Squareful Arrays`().solve(intArrayOf(1, 17,8)))
}
