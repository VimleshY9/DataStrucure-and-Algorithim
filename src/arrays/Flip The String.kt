package arrays

import kotlin.math.abs

class `Flip The String` {
    fun flip(A:String):IntArray{
        var currentZeroCounter = 0
        var maxZeroCounter = Int.MIN_VALUE
        var s = -1
        var e = -1
        var l = 0
        for(i in A.indices){
            if(A[i]=='0'){
                currentZeroCounter++
                if(currentZeroCounter>maxZeroCounter){
                    maxZeroCounter = currentZeroCounter
                    s = l
                    e = i
                }
            }
            else{
                currentZeroCounter--
                if(currentZeroCounter<0){
                    currentZeroCounter = 0
                    l = i+1
                }
            }

        }

        if(s<0 && e<0) return intArrayOf()
        return intArrayOf(s+1, e+1)
    }
}

fun main(){
    var ans = `Flip The String`().flip("01100")
   ans.forEach { println(it) }
}