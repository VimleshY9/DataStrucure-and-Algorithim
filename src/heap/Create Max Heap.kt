package heap

class `Create Max Heap` {

    fun solve(array: IntArray):IntArray{
      for(i in (array.size-2)/2 downTo 0){
          heapify(array, i)
      }
        return array
    }
     fun heapify(array: IntArray, index:Int){
        var i=index
         while (i<(array.size-2)/2){
             var lc = 2*i+1
             var rc = lc+1
             var gi = i
             if(array[gi]<array[rc]){
                 gi = rc
             }
             if(array[gi]<array[lc]){
                 gi = lc
             }

             if(i==gi) break
             var temp = array[i]
             array[i] = array[gi]
             array[gi] = temp
             i = gi
         }
     }
}

fun main(){
    var arr = intArrayOf(15, 8, 70, 80, 10, 5)
    `Create Max Heap`().solve(arr).forEach { println(it) }
}