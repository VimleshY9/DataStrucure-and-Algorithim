package Recursion

/*
* Write a program to find the factorial of the given number A using recursion.
Note: The factorial of a number N is defined as the product of the numbers from 1 to N.
* */
class `Find Factorial` {
    fun solve(A: Int): Int {
        return if (A <= 1) 1 else A * solve(A - 1)
    }
}
fun main(){
    println(`Find Factorial`().solve(4))
}