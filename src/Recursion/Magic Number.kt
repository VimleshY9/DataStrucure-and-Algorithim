package Recursion

/*
* Q. Given a number A, check if it is a magic number or not.
A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by adding the sum of the digits
* after every addition. If the single digit comes out to be 1, then the number is a magic number.
*
* Example => input => 83557
*  Sum of digits of (83557) = 28
 Sum of digits of (28) = 10
 Sum of digits of (10) = 1.
 Single digit is 1, so it's a magic number. Return 1.
 * => it's a magic number
 *
* */
class `Magic Number` {

    fun solve(n:Int):Int{
        var no = n;
        while(no>=10){
           no = magicNo(no)
        }
        return if(no==1) 1 else 0
    }

    fun magicNo(n:Int):Int{
    if(n<10){
        return n
    }
    return n%10+magicNo(n/10)
    }

}

fun main(){
    println(`Magic Number`().solve(1291))
}