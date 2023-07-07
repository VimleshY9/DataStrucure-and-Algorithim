package dp
/*
Q. Given a 2-D binary matrix A of size N x M filled with 0's and 1's, find the largest rectangle containing only ones and return its area.
.....................................
Problem Constraints
1 <= N, M <= 100
.................................
 A = [
       [1, 1, 1]
       [0, 1, 1]
       [1, 0, 0]
     ]
Output = 4
 As the max area rectangle is created by the 2x2 rectangle created by (0, 1), (0, 2), (1, 1) and (1, 2).

*/


class `Max Rectangle in Binary Matrix` {
    fun maximalRectangle(A: Array<IntArray>): Int {
        var trans = Array(A.size){IntArray(A[0].size){0} }
        var dp = Array(A.size){IntArray(A[0].size){0} }
        for(i in A.indices){
            var max = 0
            for (j in A[0].indices){
              if (A[i][j]==1){
                  max +=1
                  trans[i][j] = max
              }
                else{
                    max = 0
              }
            }
        }
        var h =0
        var w = 0
        var maxArea = 0
        var ans = 0
        for (i in trans.indices){
            for(j in trans[0].indices){
                if(trans[i][j]==0)
                    continue
                    w = trans[i][j]
                    h = 1
                    var k = i
                        while(k>=0){
                            if(trans[k][j] != 0 ){
                               w = Math.min(w, trans[k][j])
                                if(maxArea<(w*h)){
                                    maxArea = w*h
                                    }
                                h++
                                k--
                        }
                          else  k=-1

                    }


            }
            if(ans<maxArea){
                ans = maxArea
            }
        }

       return ans
    }
}

fun main(){
    var rec = `Max Rectangle in Binary Matrix`()
    var dp = Array(3){IntArray(3){0} }
   dp[0][0] = 1
    dp[0][1] = 1
    dp[0][2] = 1
    dp[1][0] = 0
    dp[1][1] = 1
    dp[1][2] = 1
    dp[2][0] = 1
    dp[2][1] = 0
    dp[2][2] = 0
    println(rec.maximalRectangle(dp))
}