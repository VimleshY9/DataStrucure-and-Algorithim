package backtracking

import java.util.*


/*
* Given a set of distinct integers A, return all possible subsets.

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The list is not necessarily sorted.
*
* input => A = [1, 2, 3]
* Output =>
* [
 [] -> fun i=0
 [1] -> fun i=1
 [1, 2] -> fun i=2
 [1, 2, 3] -> fun i=3 ->
 [1, 3]
 [2]
 [2, 3]
 [3]
]
* */

class Subset {
    fun solve(A: ArrayList<Int>): ArrayList<ArrayList<Int>>? {
//        Collections.sort(A)
        val ans = ArrayList<ArrayList<Int>>()
        ans.add(ArrayList())
        get(A, ArrayList<Int>(), ans, 0)
        return ans
    }

    operator fun get(A: ArrayList<Int>, cur: ArrayList<Int>, ans: ArrayList<ArrayList<Int>>, ind: Int) {
        if (ind == A.size) {
            return
        }
        cur.add(A[ind])
        ans.add(ArrayList(cur))
        get(A, cur, ans, ind + 1)
        cur.removeAt(cur.size - 1)
        get(A, cur, ans, ind + 1)
    }
}

fun main(){
    var arr = arrayListOf(1, 2, 3)
    Subset().solve(arr)?.forEach {
        it.forEach { println(it) } }
}