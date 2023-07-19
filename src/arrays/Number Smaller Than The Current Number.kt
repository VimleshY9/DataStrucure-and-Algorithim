package arrays

/*
*Given the interger A of n elements, for each A[i] find out how many elements are smaller than it, that is, for each A[i] you have to count the valid j's such that j!=i and A[j]<A[i]
*...........
* Constrains
* 1<=N<=10^5
* 0<=A[i]<=1000
* */


class `Number Smaller Than The Current Number` {
    fun solve(A: IntArray): IntArray? {
        val fre = IntArray(1001)
        val presum = IntArray(1001)
        val ans = IntArray(A.size)
        var sum = 0
        for (i in A.indices) {
            fre[A[i]] = fre[A[i]] + 1
        }
        for (i in fre.indices) {
            sum += fre[i]
            presum[i] = sum
        }
        for (i in A.indices) {
            if (A[i] == 0) ans[i] = 0 else ans[i] = presum[A[i] - 1]
        }
        return ans
    }
}