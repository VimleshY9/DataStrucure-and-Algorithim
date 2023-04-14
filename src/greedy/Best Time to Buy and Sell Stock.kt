package greedy

/*
* Q. You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*
*.........................................
* Input: prices = [7,1,5,3,6,4]
Output: 5
* .............................
* TC = O(N)
* SC = O(1)
* */
class `Best Time to Buy and Sell Stock` {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var profit = 0
        for(price in prices ){
            if(minPrice>price){
                minPrice = price
            }
            else if(price-minPrice>profit){
                profit = price-minPrice
            }
        }

        return profit
    }
}

fun main(){

}