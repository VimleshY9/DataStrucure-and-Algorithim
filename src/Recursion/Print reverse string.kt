package Recursion

class `Print reverse string` {
    fun solve(str:CharArray, s:Int, e:Int):CharArray{
        if(e < s){
          return str
        }
        var temp = str[s]
        str[s] = str[e]
        str[e] = temp
        return solve(str, s+1, e-1)

    }

}

fun main(){
    println(`Print reverse string`().solve("vimlesh".toCharArray(),0, "vimlesh".length-1 ))
}