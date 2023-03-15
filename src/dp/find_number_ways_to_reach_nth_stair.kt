package dp/*
* Q. find the number of ways to reach the nth stair when a person can only take 1 or 2 steps at a time
*
* Solution -> will use DP to solve this problem:- The number of ways to reach the ith stair is equal to the sum of the number
*  of ways to reach the (i-1)th stair and the number of ways to reach the (i-2)th stair. This is because we can either take one step
*  from the (i-1)th stair to reach the ith stair, or take two steps from the (i-2)th stair to reach the ith stair.
* */
class find_number_ways_to_reach_nth_stair {
    fun countWays(n: Int): Int {
        var dp = IntArray(n+1)
        dp[0] = 1
        dp[1] = 1
        for(i in 2..n){
            dp[i] = dp[i-1] + dp[i-2]
        }
        return dp[n]
    }
}
fun main(){
    print(find_number_ways_to_reach_nth_stair().countWays(5))
}