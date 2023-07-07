package arrays

/*
* Q. Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.
* input => A=[2, 1, 6, 4]
* output = 1 => [2, 6, 4] 2+4=6 => after removing element at index 0
* */
class `Special Index` {
    fun solve(A: IntArray): Int {
        val oddps = IntArray(A.size)
        val evenps = IntArray(A.size)
        evenps[0] = A[0]
        oddps[0] = 0
        var count = 0
        var oddsum = 0
        var evensum = 0
        for (i in 1 until A.size) {
            if (i % 2 == 0) {
                evenps[i] = evenps[i - 1] + A[i]
                oddps[i] = oddps[i - 1]
            } else {
                oddps[i] = oddps[i - 1] + A[i]
                evenps[i] = evenps[i - 1]
            }
        }
        for (i in A.indices) {
            if (i > 0) {
                if (i % 2 == 0) {
                    evensum = evenps[i - 1] + (oddps[oddps.size - 1] - oddps[i - 1])
                } else {
                    oddsum = oddps[i - 1] + (evenps[evenps.size - 1] - evenps[i - 1])
                }
            } else {
                evensum = oddps[oddps.size - 1]
                oddsum = evenps[oddps.size - 1] - evenps[0]
            }
            if (evensum == oddsum) {
                count++
            }
        }
        return count
    }

}
