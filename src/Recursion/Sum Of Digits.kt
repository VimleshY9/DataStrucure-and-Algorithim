package Recursion

/*
* Q. Given a number A, we need to find the sum of its digits using recursion.
* */

class `Sum Of Digits` {
    fun solve(A: Int): Int {
        return sum(A, 0)
    }

    fun sum(A: Int, s: Int): Int {
        return if (A < 10) {
            s + A
        } else sum(A / 10, s + A % 10)
    }
}

fun main(){
    println(`Sum Of Digits`().solve(29992))
}