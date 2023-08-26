package heap

/*
* CBT is given, need to check if it's min heap
* intput => 10 18 20 80 90 22
* */
class `Check If is it Min heap` {

    fun solve(array: IntArray):Boolean{
        for(i in 0..(array.size-3)/2){
            if(!(array[i]<array[2*i+1] && array[i]<array[2*i+2])){
                return false
            }
        }
        return true
    }
}

fun main(){
    var arr = intArrayOf(10, 18, 20, 80, 90, 22)
    println(`Check If is it Min heap`().solve(arr))
}