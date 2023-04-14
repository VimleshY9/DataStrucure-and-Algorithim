package tree.trie
/*
* Given an array of words A (dictionary) and another array B (which contain some words).

You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.

Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.

Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.

NOTE: Try to do this in O(n) time complexity.
* .............................................................
* 1 <= |A| <= 1000

1 <= sum of all strings in A <= 50000

1 <= |B| <= 1000
*
* .........................................................
* Input 1:

A = [ "hat", "cat", "rat" ]
B = [ "cat", "ball" ]
*
*...........................
* Output
* [1, 0]
*
* */
class `Spelling Checker` {
    fun solve(A: Array<String>, B: Array<String>): IntArray {
        var ans = IntArray(B.size)
        var head = TrieNode()
        for(element in A){
            insert(element, head)
        }
        for(j in B.indices){
            ans[j] = if (search(B[j], head)) 1 else 0
        }
        return ans
    }

    private fun insert(word:String, node:TrieNode){
        var curNode = node
        for(i in word.indices){
            if(!curNode.childNode.containsKey(word[i])){
                curNode.childNode[word[i]] = TrieNode()
            }
            curNode = curNode.childNode[word[i]]!!
        }
        curNode.isEnd = true
    }

    fun search(word:String, node:TrieNode):Boolean{
        var curNode = node
        for(i in word.indices){
            if(!curNode.childNode.containsKey(word[i])){
                return false
            }
            curNode = curNode.childNode[word[i]]!!
        }
        return curNode.isEnd
    }

}
class TrieNode {
    var childNode = HashMap<Char, TrieNode>()
    var isEnd: Boolean = false
}




