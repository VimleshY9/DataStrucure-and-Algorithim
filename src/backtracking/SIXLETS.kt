package backtracking

/*
*Given a array of integers A of size N and an integer B.
Return number of non-empty subsequences of A of size B having sum <= 1000.
* */
class SIXLETS {

    fun solve(A: IntArray, B: Int): Int {
     var ans = ArrayList<ArrayList<Int>>()
      count(A, B, ArrayList(), 0, 0, ans)
        return ans.size
    }

    fun count(A:IntArray, B:Int, cur:ArrayList<Int>, sum:Int, ind:Int, ans:ArrayList<ArrayList<Int>>){
        if(cur.size==B && sum<=1000){
            ans.add(cur)
            return
        }
        if(ind>A.size-1) return
        cur.add(A[ind])
        var sum1 = sum + A[ind]
        count(A, B, cur, sum1, ind+1, ans)
        sum1 -= cur[cur.size - 1]
        cur.removeAt(cur.size-1)
        count(A, B, cur, sum1, ind+1, ans )
    }

}

fun main(){
    var arr = intArrayOf(5, 17, 100, 11)
    println(SIXLETS().solve(arr, 4))
}