package linkedList

/*
* Q. Checking if a linked list is a palindrome
* Input: 1->2->3->2->1
Output: True
* */
// this is simple solution for reversing whole linked list but the same can be achieved by reversing the half linkedlist
// by using slow and fast pointers
class `LinkedList Palindrome` {
    fun solve(head:ListNode?):Boolean{
        var pre:ListNode?=null
        var head1 = head
        var cur = head
        while(cur!=null)  {
            var next = cur?.next
            cur?.next = pre
            pre = cur
            cur = next
        }
       while(head1!=null){
           if(head1?.`val` != pre?.`val`) return false
           head1 = head1?.next
           pre = pre?.next
       }
        return true
    }
    }
fun main(){
    var listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode?.next?.next = ListNode(3)
    listNode?.next?.next?.next = ListNode(2)
    listNode?.next?.next?.next?.next = ListNode(1)
println(`LinkedList Palindrome`().solve(listNode))

}