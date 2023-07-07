package arrays

/*
* You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.

Note :
1. Try to figure out the contribution of A[i] in the sum of all subarray sums.
2. In another word, for A[i], try to find count of A[i] in entire subarray sums.
*
* */
class `Sum of All Subarrays` {
    fun subarraySum(A: IntArray): Long {
        var sum: Long = 0
        for (i in A.indices) {
            sum += (i + 1) * 1L * (A.size - i) * A[i]
        }
        return sum
    }
}