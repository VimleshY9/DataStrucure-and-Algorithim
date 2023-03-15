/*
* Q. You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
*
Constraints:
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*
* */

class ListNode(var `val`: Int) {
        var next: ListNode? = null
}
class `Add Two Numbers - LinkedList` {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        //  var h1 = reverse(l1)
        //  var h2 = reverse(l2)
        var  h1 = l1
        var h2 = l2
        var head:ListNode? = null
        var temp:ListNode? = null
        var rem = 0
        var flag = true
        while(h1!=null || h2!=null){
            var no1 = 0
            var no2 = 0
            if(h1!=null){
                no1 = h1?.`val`!!
            }
            if(h2!=null){
                no2 = h2?.`val`!!
            }
            var no = no1+no2+rem
            if(no>9)
            { no = getRemainder(no)
                rem = 1
            }
            else
            { rem = 0}
            if(flag){
                temp = ListNode(no)
                flag = false
                head = temp
            }
            else{
                temp?.next = ListNode(no)
                temp = temp?.next
            }
            if(h1!=null)
                h1 = h1?.next
            if(h2!=null)
                h2 = h2?.next
        }
        if(rem==1){
            temp?.next = ListNode(1)
        }

        //  var headN = reverse(head)
        return head
    }
    fun getRemainder(no:Int):Int{
        if(no==10) return 0
        return if(no>10)no%10 else 0
    }
    fun reverse(head:ListNode?):ListNode?{
        var pre:ListNode? = null
        var cur = head
        var h = head
        while(cur!=null){
            var next = cur?.next
            cur?.next = pre
            pre = cur
            cur = next
        }
        h = pre
        return h
    }

}