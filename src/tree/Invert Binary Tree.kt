package tree

class `Invert Binary Tree` {
    fun invertTree(root: TreeNode?): TreeNode? {
        if(root == null) return null
        var leftNode = invertTree(root.left)
        var rightnode = invertTree(root.right)
        var temp = leftNode
        root.left = rightnode
        root.right = leftNode
        return root
    }
}
  class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
 }

fun main(){

    var name:String? = "vimlesh"
    var ans = name?.also {
        "welcome $it"
        it.plus("yadav")
    }?:null
    println(ans)
    val person = Person("vimlesh", 29)
    val ans1 = person.run {
        "name is $name and $age"
    }
    var ans2 = person.let {
        "name is ${it.name} and ${it.age}"
    }
    var ans3 = with(person) {
        "$name is $age years old."
    }
    var ans4 = person.also {
        "name is ${it.name}"
    }
    println(ans4)
}

data class Person(val name:String, val age:Int)