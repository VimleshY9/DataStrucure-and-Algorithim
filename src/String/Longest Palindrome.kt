package String

/*
* Q. Finding the longest substring in a stringthat is a palindrome.
* input => babad
* ouput => bab
* */
class `Longest Palindrome` {
    fun solve(str:String):String{
        var len = str.length
        var s = 0
        var e = 0
        var cs = 0
        var ce = 0
        var maxLen = Int.MIN_VALUE

            for(i in str.indices){
                cs = i
                ce = i
               // for odd length palindrome
                while(cs>=0 && ce<len && str[cs]==str[ce]){
                    cs--
                    ce++
                                 }
                if(maxLen<(ce-cs+1)){
                   s = cs+1
                    e = ce
                    maxLen = ce-cs+1
                }
                cs = i
                ce = i+1

                // for even length palindrome
                while(cs>=0 && ce<len && str[cs]==str[ce]){
                    cs--
                    ce++
                }
                if(maxLen<(ce-cs+1)){
                    s = cs+1
                    e = ce
                    maxLen = ce-cs+1
                }

        }
       return str.substring(s,e)
    }
}
fun main(){
    println(`Longest Palindrome`().solve("ansbskjkf"))
}