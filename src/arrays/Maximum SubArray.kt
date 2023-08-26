package arrays

/*
* Finding the maximum sum sub-array of agiven array.
*
* Input:
[-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output:
[4, -1, 2, 1]
* */
class `Maximum SubArray` {

    fun solve(arr:IntArray):IntArray{
      var s = 0
        var e = 0
        var s1 = 0
        var maxSum = Int.MIN_VALUE
        var curSum = 0
        for(i in arr.indices){
            curSum += arr[i]
            if(curSum>maxSum){
                maxSum = curSum
                e=i
                s1=s
            }
            if(curSum<=0){
                curSum = 0
                s = i+1
            }
        }
        var ans = IntArray(e-s1+1)
        var j = 0
        for(i in s1..e){
           ans[j++] = arr[i]
        }
        return ans
    }
}

fun main(){
    var arr = arrayOf(-2, 1, -3, -4, -1, 2, 1, 8, 4)
    `Maximum SubArray`().solve(arr.toIntArray()).forEach { println(it) }
}