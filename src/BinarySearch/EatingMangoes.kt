package BinarySearch
/*
* Q. you are given a n piles of mangoes, ith piles has A[i] mangoes. you need finish all the mangoes in B hours. you can decide the mangoes per hour eating speed of K, each hour you can eat k mangoes from a pile and pile has less than k mangoes than you have to eal all of them instead and not eating other mangoes during this hour. return the minimum value of k such that you can eat all the mangoes within B hours.
*
* Approach: To solve this problem, we can use a binary search approach to find the minimum eating speed k that allows us to finish all the mangoes within B hours. We can set the lower bound as 1 (minimum possible eating speed) and the upper bound as the maximum number of mangoes in a pile. Then, we perform a binary search on the eating speed range and check if it is possible to finish all the mangoes within B hours for each midpoint value.
*  */


class EatingMangoes {
    fun minEatingSpeed(piles: IntArray, B: Int): Int {
        var left = 1 // Lower bound of eating speed
        var right = getMaxPile(piles) // Upper bound of eating speed
        while (left < right) {
            val mid = left + (right - left) / 2
            val hours: Int = calculateHours(piles, mid)
            if (hours > B) {
                left = mid + 1 // Eating speed is too slow, move to the right
            } else {
                right = mid // Eating speed is sufficient, move to the left
            }
        }
        return left
    }

    private fun getMaxPile(piles: IntArray): Int {
        var maxPile = 0
        for (pile in piles) {
            maxPile = Math.max(maxPile, pile)
        }
        return maxPile
    }
    private fun calculateHours(piles: IntArray, eatingSpeed: Int): Int {
        var hours = 0
        for (pile in piles) {
            hours += Math.ceil(pile.toDouble() / eatingSpeed).toInt()
        }
        return hours
    }
}


fun main() {
    val piles = intArrayOf(3, 6, 7, 11)
    val B = 8
    val mangoes = EatingMangoes()
    val minEatingSpeed: Int = mangoes.minEatingSpeed(piles, B)
    println("Minimum eating speed: $minEatingSpeed")
}