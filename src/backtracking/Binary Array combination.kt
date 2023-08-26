package backtracking
/*
* Q. generate all the combination of binary array
* input -> {0 1}
* output ->
* {0 0}, {0,1}, {1, 0}, {1, 1}
*
* */
class `Binary Array combination` {
    fun solve(arr:IntArray):ArrayList<ArrayList<Int>>{
       var ans = ArrayList<ArrayList<Int>>()
        getBinaryArray(arr, ans, arrayListOf())
        return ans
    }
    fun getBinaryArray(arr:IntArray, ans:ArrayList<ArrayList<Int>>, cur:ArrayList<Int>){
        if(cur.size==2){
           ans.add(cur)
            return
        }
        if(cur.size>2)return
        cur.add(0)
        getBinaryArray(arr, ans, cur)
        cur.remove(cur.size-1)
        cur.add(1)
        getBinaryArray(arr, ans, cur)
        cur.remove(cur.size-1)
    }
}

fun main(){
    var arr = intArrayOf(0, 1)
    `Binary Array combination`().solve(arr).forEach { println(it) }
}