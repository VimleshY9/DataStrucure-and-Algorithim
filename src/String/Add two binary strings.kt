package String

class `Add two binary strings` {
    fun addBinary(a: String, b: String): String {
        val result = StringBuilder()
        var carry = 0
        var i = a.length - 1
        var j = b.length - 1

        while (i >= 0 || j >= 0 || carry > 0) {
            var sum = carry
            if (i >= 0) {
                sum += a[i] - '0'
                i--
            }
            if (j >= 0) {
                sum += b[j] - '0'
                j--
            }

            result.insert(0, sum % 2)
            carry = sum / 2
        }

        return result.toString()
    }
}
    fun main() {
        val a = "101"
        val b = "1101"
        val sum = `Add two binary strings`().addBinary(a, b)
        println("Sum: $sum")
    }

