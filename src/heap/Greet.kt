package heap

import kotlin.properties.Delegates


class Greet(val name:String) {
    var b = "vimlesh"
    private val a:String? by lazy { null }
    operator fun invoke(title: String){
        println("$name - $title")
    }
}
fun main(){
    var ans = Greet("vimlesh")
    ans("yadav")
    ans.invoke("yadav1")
}