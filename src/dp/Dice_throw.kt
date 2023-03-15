package dp
/*
* Q. Given sum A, number of ways you can get that sum with dice roll[1-6].

As the number of ways can be large return its modulo by 1e9 + 7.
*
* Problem Constraints
1 <= A <= 10 2
*
* A = 3
* The four possible ways to obtain 3 are: [1, 1, 1], [1, 2], [2, 1] and [3].
*  */
class Dice_throw {
    fun solve(A: Int): Int {
        var dp = IntArray(A+1){-1}
        return getSum(A, dp)
    }

    private fun getSum(A: Int, dp: IntArray):Int{
        if(A==0) return 1
        if(dp[A] != -1) return dp[A]
        var sum = 0
        for(i in 1..A){
            if(i<=6 && A-i>=0)
                sum = (sum%1000000007 + getSum(A-i, dp)%1000000007)%1000000007
            else
                break
        }
        dp[A] = sum
        return dp[A]
    }
}

fun main(){
    // if A = 9
    print(Dice_throw().solve(9))
}