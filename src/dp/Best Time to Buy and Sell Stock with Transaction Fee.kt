package dp
/*
* Q. You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.
Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
The transaction fee is only charged once for each stock purchase and sale.
*...........................
* Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
* */
class `Best Time to Buy and Sell Stock with Transaction Fee` {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        var dp = Array(prices.size){IntArray(2){-1}}
        return  getMaxProfit(prices, 0, 0, dp, fee)
    }

    fun getMaxProfit(prices: IntArray, day:Int, state:Int, dp:Array<IntArray>, fee:Int):Int{
        if(day>=prices.size){return 0}
        if(dp[day][state]!=-1) return dp[day][state]
        var maxProfit = 0
        //buy stae
        if(state==0){
            maxProfit = Math.max(-prices[day]+getMaxProfit(prices, day+1, 1, dp, fee), getMaxProfit(prices, day+1, 0, dp, fee))
        }
        //sell state
        else if(state==1){
            maxProfit = Math.max((prices[day]+getMaxProfit(prices, day+1, 0, dp, fee))-fee, getMaxProfit(prices, day+1, 1, dp, fee))
        }
        dp[day][state] = maxProfit
        return dp[day][state]
    }
}