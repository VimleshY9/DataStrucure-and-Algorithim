package dp

import java.util.*


class `Minimum Falling Path Sum` {
//    fun solve(A: Array<IntArray>): Int {
//    /* var sum  = Int.MAX_VALUE
//        var dpPreMin = Array(A.size){IntArray(A[0].size)}
//        var dpPostMin = Array(A.size){IntArray(A[0].size)}
//        var preMin = Int.MAX_VALUE
//        var postMin = Int.MAX_VALUE
//        for(i in A.indices){
//            for (j in A[0].indices){
//              preMin = Math.min(preMin, A[i][j])
//              dpPreMin[i][j] = preMin
//              postMin = Math.min(postMin,A[A.size-1-i][A.size-1-j])
//                dpPostMin[A.size-1-i][A.size-1-j]=postMin
//            }
//        }
//
//        for(i in A.indices){
//            var k = i+1
//            var currentSum = A[0][i]
//            var m2 = A[0][i]
//            while (k<A[0].size){
//
//                if(i==0){
//
//                 if(A[k][i+1]==dpPreMin[k][i+1]){
//                     m2 += dpPostMin[k][i+1]
//                 }
//                    else{
//                        m2 += Math.min(dpPreMin[k][i+1], dpPostMin[k][i+1])
//                 }
//
//                }
//                else if(i==A.size-1){
//                    if(A[k][i] == dpPostMin[k][i-1] ){
//                        m2 += dpPreMin[k][i-1]
//                    }
//                    else{
//                        m2 += Math.min(dpPreMin[k][i-1], dpPostMin[k][i-1])
//                    }
//
//                }
//                else{
//                    var m1= Math.min(dpPreMin[k][i+1], dpPreMin[k][i-1])
//                    m2 += Math.min(m1, Math.min(dpPostMin[k][i+1], dpPostMin[k][i-1]))
//                }
//
//                k++
//            }
//            if(m2<sum){
//                sum = m2
//            }
//        }
//        return  sum*/
//
//    }
open fun solve(A: Array<IntArray>): Int {
    val dp = Array(A.size) { IntArray(A[0].size) }
    for (i in A.indices) {
        Arrays.fill(dp[i], 1000000000)
    }
    return paths(A, 0, 0, dp)
}

    fun paths(A: Array<IntArray>, r: Int, prevInd: Int, dp: Array<IntArray>): Int {
        if (r >= A.size) {
            return 0
        }
        var sum = Int.MAX_VALUE
        for (i in A[r].indices) {
            if (r == 0 || i != prevInd) {
                if (dp[r][i] != 1000000000) {
                    sum = Math.min(sum, dp[r][i])
                } else {
                    val s = A[r][i] + paths(A, r + 1, i, dp)
                    dp[r][i] = s
                    sum = Math.min(sum, s)
                }
            }
        }
        return sum
    }
}
fun main(){
    var rec = `Minimum Falling Path Sum`()
    var dp = Array(3){IntArray(3){0} }
    dp[0][0] = 17
    dp[0][1] = 14
    dp[0][2] = 19
    dp[1][0] = 12
    dp[1][1] = 18
    dp[1][2] = 9
    dp[2][0] = 20
    dp[2][1] = 10
    dp[2][2] = 1
    println(rec.solve(dp))
}