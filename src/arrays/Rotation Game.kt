package arrays

import java.util.*

/*
* Q. Given an integer array A of size N and an integer B, you have to print the same array after rotating it B times towards the right.
* */
class `Rotation Game` {

    fun main() {
        val sc = Scanner(System.`in`)
        val len: Int = sc.nextInt()
        val A = IntArray(len)
        for (p in 0 until len) {
            A[p] = sc.nextInt()
        }
        val B: Int = sc.nextInt()
        val noOfRot = B % len
        var i = 0
        var j = len - 1
        while (j > i) {
            val temp = A[j]
            A[j] = A[i]
            A[i] = temp
            i++
            j--
        }
        i = 0
        j = noOfRot - 1
        while (i < j) {
            val temp = A[j]
            A[j] = A[i]
            A[i] = temp
            i++
            j--
        }
        i = noOfRot
        j = len - 1
        while (i < j) {
            val temp = A[j]
            A[j] = A[i]
            A[i] = temp
            i++
            j--
        }
        for (n in 0 until len) {
            print(A[n].toString() + " ")
        }
    }
}