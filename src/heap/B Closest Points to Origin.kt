package heap

import java.util.PriorityQueue

/*
* We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
Here, the distance between two points on a plane is the Euclidean distance.
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
*
* Input => A = [
       [1, 3],
       [-2, 2]
     ]
 B = 1
 * output =>  [ [-2, 2] ]
* */

class `B Closest Points to Origin` {
    fun solve(A: ArrayList<Point>, B: Int): ArrayList<Point> {
        var queue = PriorityQueue<Point>{p1, p2 -> comparePoints(p1, p2) }
        queue.addAll(A.asIterable())
        var ans = arrayListOf<Point>()
        var i = B
        while (i>0 && !queue.isEmpty()){
            ans.add(queue.poll())
            i--
        }
return ans
    }

}

data class Point(val x: Int, val y: Int)
fun comparePoints(p1: Point, p2: Point): Int {
    val dist1 = p1.x * p1.x + p1.y * p1.y
    val dist2 = p2.x * p2.x + p2.y * p2.y
    return dist1 - dist2
}

fun main(){
    var arr = ArrayList<Point>()
    arr.add(Point(1,3))
    arr.add(Point(-2,2 ))
    println(`B Closest Points to Origin`().solve(arr, 1))

}