package linkedList
/*
* Q. You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
* ..............................
* Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
* ..................................................
* TC = O(m+n)
* SC = O(1)
*
* */
class `Merge Two Sorted LinkedList` {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        var head = ListNode(0)
        var tailnode = head

        while(l1!=null && l2!=null){
            if(l1.`val`> l2?.`val`!!){
                tailnode?.next = l2
                l2 = l2?.next
            }
            else{
                tailnode?.next = l1
                l1 = l1?.next
            }
            tailnode = tailnode?.next!!

        }
        if(l1 != null){
            tailnode?.next = l1
        }
        if(l2 != null){
            tailnode?.next = l2
        }
        return head.next

    }
}
class ListNode(var `val`: Int) {
     var next: ListNode? = null
     }