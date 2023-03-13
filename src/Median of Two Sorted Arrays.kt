/*
* Q. Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
* The overall run time complexity should be O(log (m+n)).
*
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
*
Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*
* */

class `Median of Two Sorted Arrays` {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var m = nums1.size
        var n = nums2.size
        var result = IntArray(m+n)
        var p1 = 0
        var p2 = 0
        var i = 0
        while(p1<m && p2<n){
            if(nums1[p1]>nums2[p2]){
                result[i++]=nums2[p2++]
            }
            else{
                result[i++]=nums1[p1++]
            }
        }
        if(p1<m){
            while(p1<m){
                result[i++]=nums1[p1++]}
        }
        if(p2<n){
            while(p2<n){
                result[i++]=nums2[p2++]}
        }
        var median = (m+n)/2
        return if((m+n)%2==0){
            ((result[median].toDouble()+result[median-1].toDouble())/2)
        } else{
            result[median].toDouble()
        }
    }
}