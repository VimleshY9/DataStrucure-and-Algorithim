package linkedList

class `Find the Middle Node` {

    fun solve(head:ListNode?):ListNode?{

        var slow = head
        var fast = head
        while(slow?.next!==null && fast?.next?.next !=null){
            slow = slow?.next
            fast = fast?.next?.next

        }
      return slow

    }
}

fun main(){
    var node = ListNode(1)
    node.next = ListNode(2)
    node?.next?.next = ListNode(3)
    node?.next?.next?.next = ListNode(4)
    node?.next?.next?.next?.next = ListNode(5)

    println(`Find the Middle Node`().solve(node)?.`val`)


}