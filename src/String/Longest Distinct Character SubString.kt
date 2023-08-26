package String

/*
* Finding the longest substring with distinctcharacters
Input:
"abcabcbb"
Output:
"abc"
* */
class `Longest Distinct Character SubString` {
    fun solve(str: String):String{
        var hs = HashSet<Char>()
        var s = 0
        var e = 0
        var s1 = 0
        var sum = Int.MIN_VALUE
        var curSum = 0
        for(i in str.indices){
            if(hs.contains(str[i])){
                if(str[s]==str[i]){
                    curSum--
                    hs.remove(str[s])
                }
                else{
                    while(str[s]!=str[i]){
                        hs.remove(str[s])
                        s++
                        curSum--
                    }
                }
                s += 1
            }
            else{
                hs.add(str[i])
                curSum++
            }
            if(curSum>sum){
                e = i
                sum = curSum
                s1 = s
            }
        }
        return str.substring(s1,e+1)
    }
}

fun main(){
    var str = "abcabcbb"
    println(`Longest Distinct Character SubString`().solve(str))
}