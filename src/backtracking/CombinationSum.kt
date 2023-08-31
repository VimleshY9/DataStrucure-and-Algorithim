package backtracking

import java.util.*


class CombinationSum {

    fun solve(A: ArrayList<Int>, B: Int): ArrayList<ArrayList<Int>>? {
        val ans = ArrayList<ArrayList<Int>>()
        A.sort()
        findSum(0, B, A, ArrayList(), ans, HashSet())
        return ans
    }

    fun findSum(
        idx: Int,
        target: Int,
        A: ArrayList<Int>,
        ds: ArrayList<Int>,
        ans: ArrayList<ArrayList<Int>>,
        hs: HashSet<ArrayList<Int>?>
    ) {
        if (idx == A.size) {
            if (hs.add(ArrayList(ds))) {
                if (target == 0) {
                    ans.add(ArrayList(ds))
                }
            }
            return
        }
        if (A[idx] <= target) {
            ds.add(A[idx])
            findSum(idx, target - A[idx], A, ds, ans, hs)
            ds.removeAt(ds.size - 1)
        }
        findSum(idx + 1, target, A, ds, ans, hs)
    }
}
fun main(){
    var arr = intArrayOf(2,3,6,7)
    var a1 = arrayListOf<Int>(2,3,6,7)
    CombinationSum().solve(a1,7)?.forEach { println(it) }
}