package backtracking

/*
* Q. Given an array of size N of candidate numbers A and a target number B. Return all unique combinations in A where the candidate numbers sums to B.
Each number in A may only be used once in the combination.
*  A = [10, 1, 2, 7, 6, 1, 5]
 B = 8
 * Output =>
 *  [
  [1, 1, 6 ],
  [1, 2, 5 ],
  [1, 7 ],
  [2, 6 ]
 ]
* */
class CombinationSumWithoutRepeating {

    fun solve(arr:IntArray, B:Int):ArrayList<ArrayList<Int>>{
        arr.sort()
        var ans = ArrayList<ArrayList<Int>>()
        UniqueComb(arr, ArrayList(), ans, 0, B, HashSet())
       return ans
    }
    fun UniqueComb(A:IntArray, cur:ArrayList<Int>, ans:ArrayList<ArrayList<Int>>, ind:Int, target: Int, hs:HashSet<ArrayList<Int>>){
      if(target==0){
          if(!hs.contains(cur)) {
              hs.add(ArrayList(cur))
              ans.add(ArrayList(cur))
          }
          return
      }
        if(target<0 || ind>A.size-1) return
      if(A[ind]<=target){
          cur.add(A[ind])
          UniqueComb(A, cur, ans, ind+1, target-A[ind], hs)
          cur.removeAt(cur.size-1)
      }
        UniqueComb(A, cur, ans, ind+1, target, hs)
    }
}
fun main(){
   var arr = intArrayOf(10, 1, 2, 7, 6, 1, 5)
    var B = 8
  CombinationSumWithoutRepeating().solve(arr,B).forEach { println(it) }

}