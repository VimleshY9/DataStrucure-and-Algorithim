package linkedList

/*
*Q. Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
* ...............................................................
* Input: head = [3,2,0,-4], pos = 1
Output: true
* .....................................
* TC = O(n)
*
* */
class `Linked List Cycle` {
    fun hasCycle(head: ListNode?): Boolean {
        var sp = head
        var fp = head
        var flag = false
        while(sp?.next != null && fp?.next?.next != null && flag==false) {
            sp = sp?.next
            fp = fp?.next?.next
            if(sp==fp)
            { flag = true}
        }
        return flag
    }
    fun isMatch(A: String, B: String): Int {
        var dp = Array(A.length){IntArray(B.length){-1}}
        return if(isPatternMatched(A, B, A.length-1, B.length-1, dp)==1)  1 else 0
    }

    fun isPatternMatched(A: String, B: String, i: Int, j:Int, dp: Array<IntArray>):Int{
        if(i<0 && j<0)return 1
        if(i<0 || j<0) return 0
        if(A[i] != B[j] && B[j] != '*') return 0
        if(dp[i][j] != -1) return dp[i][j]
        if(A[i]==B[j] || B[j] == '.'){
            dp[i][j] = isPatternMatched(A, B, i-1, j-1, dp)
        }
        else{
            dp[i][j] =  isPatternMatched(A, B, i, j-1, dp)
        }
        return dp[i][j]
    }
}

fun main(){
    print(`Linked List Cycle`().isMatch("ac", "ab*c"))
}