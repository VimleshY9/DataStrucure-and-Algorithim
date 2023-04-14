package String

/*
* Q. Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
* ............................................................
* Input: s = "anagram", t = "nagaram"
Output: true
* ..............................
* TC = O(n)
* SC = O(N) - hashmap
* */
class `Valid Anagram` {
        fun isAnagram(s: String, t: String): Boolean {
        if(s.length != t.length) return false
        var hm = mutableMapOf<Char, Int>()
        for(ch in s){
            if(hm.containsKey(ch)){
                hm[ch] = hm[ch]!!+1
            }
            else{
                hm[ch] = 1
            }
        }
        for(ch in t){
            if(hm.containsKey(ch) && hm[ch]!!>0){
                hm[ch] = hm[ch]!!-1
            }
            else
                return false
        }
        return true
    }
}