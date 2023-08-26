package arrays
/*
* Given a collection of intervals, merge all overlapping intervals.
* Input: [[1, 3], [2, 6],[5, 9], [8, 10], [15, 18]]
* Output: [[1, 6], [8, 10], [15, 18]]
* */
class `Merge Intervals` {
    fun solve(points:ArrayList<Interval>):ArrayList<Interval>{
        var ans = ArrayList<Interval>()
        points.sortWith { a, b -> a.first - b.first }
        var current = points[0]
        for(i in 1 until points.size){
            var next = points[i]
            if(next.first<=current.second){
                current.second = Math.max(current.second, next.second)
            }
            else{
                ans.add(current)
                current = next
            }
        }
        ans.add(current)
        return ans
    }
}

fun main(){
    var arr = ArrayList<Interval>()
    arr.add(Interval(1,3))
    arr.add(Interval(2,6))
    arr.add(Interval(8,10))
    arr.add(Interval(15,18))
  `Merge Intervals`().solve(arr).forEach { println(it) }
}

data class Interval(var first:Int=0, var second:Int=0)