package backtracking


/*
* Given an integer array A of size N denoting collection of numbers , return all possible permutations.
No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
A = [1, 2, 3]
* [ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3]
  [2, 3, 1]
  [3, 1, 2]
  [3, 2, 1] ]
* */
class Permutations {

    fun solve(A:IntArray):ArrayList<ArrayList<Int>>{
        var ans = ArrayList<ArrayList<Int>>()
        backtrack(A, mutableListOf(), ans)
        return ans
    }
    private fun backtrack(nums: IntArray, currentPerm: MutableList<Int>, result: ArrayList<ArrayList<Int>>) {
        if (currentPerm.size == nums.size) {
            result.add(ArrayList(currentPerm))
            return
        }
        for (num in nums) {
            if (!currentPerm.contains(num)) {
                currentPerm.add(num)
                backtrack(nums, currentPerm, result)
                currentPerm.removeAt(currentPerm.size - 1)
            }
        }
    }

}

fun main(){
    var arr = intArrayOf(1,2,3)
    Permutations().solve(arr).forEach { println(it) }
}