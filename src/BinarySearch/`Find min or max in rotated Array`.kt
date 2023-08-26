package BinarySearch

/*
* Q. Finding the minimum or maximumelement in a rotated sorted array.
* Input:[4, 5, 6, 7, 0, 1, 2]
Output:[7,0] -> 0 (minimum) or 7 (maximum)
* */
class `Find min or max in rotated Array` {

    fun solve(array: IntArray):IntArray{
      var s = 0
        var e = array.size-1
        while (e>s){
           var m = s + (e-s)/2
            if(array[m]>array[array.size-1]){
                if(m+1<array.size && array[m]>array[m+1]){
                    s = m
                    break
                }
                else
               s = m+1
            }
            else{
                e = m-1
            }
        }
        return if(s!=0) intArrayOf(array[s],array[s+1]) else intArrayOf(array.last(),array.first())

    }


}

fun main(){
    var arr = intArrayOf( 4, 5, 6, 7, 15, 16, 0, 1, 2 )
    `Find min or max in rotated Array`().solve(arr).forEach { println(it) }
}