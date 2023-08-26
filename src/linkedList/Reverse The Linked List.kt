package linkedList

/*
>> Reversing a linked list of any size.
* Input:
1->2->3->4->5
Output:

5->4->3->2->1->null
* */
class `Reverse The Linked List` {

    fun solve(head:ListNode?):ListNode?{
    var pre:ListNode?=null
     var cur = head
     while(cur!=null)  {
         var next = cur?.next
         cur?.next = pre
         pre = cur
         cur = next
     }
      return pre

    }
}

fun main(){
    var listNode = ListNode(1)
    listNode.next = ListNode(2)
    listNode?.next?.next = ListNode(3)
    listNode?.next?.next?.next = ListNode(4)
    print(`Reverse The Linked List`().solve(listNode))

}
