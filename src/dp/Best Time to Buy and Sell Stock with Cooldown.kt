package dp
/*
* Q. You are given an array prices where prices[i] is the price of a given stock on the ith day.
Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
* ......................................................
* Output=> Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
* */
class `Best Time to Buy and Sell Stock with Cooldown` {
    fun maxProfit(prices: IntArray): Int {
        var dp = Array(prices.size){IntArray(3){-1}}
        return  getMaxProfit(prices, 0, 0, dp)
    }

    fun getMaxProfit(prices: IntArray, day:Int, state:Int, dp:Array<IntArray>):Int{
        if(day>=prices.size){return 0}
        if(dp[day][state]!=-1) return dp[day][state]
        var maxProfit = 0
        //buy stae
        if(state==0){
            maxProfit = Math.max((-prices[day]+getMaxProfit(prices, day+1, 1, dp)), getMaxProfit(prices, day+1, 0, dp))
        }
        //sell state
        else if(state==1){
            maxProfit = Math.max((prices[day]+getMaxProfit(prices, day+1, 2, dp)), getMaxProfit(prices, day+1, 1, dp))
        }
        //cooldown
        else{
            maxProfit = getMaxProfit(prices, day+1, 0, dp)
        }
        dp[day][state] = maxProfit;
        return dp[day][state]
    }
}