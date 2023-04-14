package arrays

/*
* Q. Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
* ....................................................
* Input: nums = [2,7,11,15], target = 9
Output: [0,1]
* .....................................
* TC = O(n), SC = O(n)
* */
class `Two Sum` {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for(i in nums.indices){
            val element = target - nums[i]
            if(map.containsKey(element )){
                return intArrayOf(map[element]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}