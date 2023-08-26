package arrays
/*
* Q. Integer array is given and you need find the second-smallest value
* input => {1, 9, 1, 2, 2, 1, 4, 5, 2 ,8}
* output => 2
* */

class `Find the second smaller number` {

    fun solve(arr: Array<Int>):Int{
        var s1 = Int.MAX_VALUE
        var s2 = arr[0]
        for(i in 1 until arr.size){
          if(s1<s2){
              var temp = s2
              s2 = s1
              s1 = temp
          }
            else if(s1>s2 && s1>arr[i] && s2!=arr[i]){
                s1 = arr[i]
          }
        }
       return s1
    }

}


fun main(){
    var arr = arrayOf(1, 9, 1, 2, 2, 1, 4, 5, 2 ,8)
    println(`Find the second smaller number`().solve(arr))
}