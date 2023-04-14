package String

/*
* Q. A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.
* ........................................................
* Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
* ......................................................
* TC = O(n)
* SC = O(n) - because of StringBuilder()
* */

class `Valid Palindrome` {
    fun isPalindrome(s: String): Boolean {
        var str = convertToLowerCaseAndRemoveNonAlphanumeric(s)
        var s = 0
        var e = str.length-1
        while(e>=s){
            if(str[e]!=str[s]){
                return false
            }
            e--
            s++
        }
        return true
    }
    private fun convertToLowerCaseAndRemoveNonAlphanumeric(str: String): String {
        val result = StringBuilder()

        for (char in str) {
            if (char.isUpperCase()) {
                result.append(char.toLowerCase())
            }
            else if (char.isLowerCase() || char.isDigit()) {

                result.append(char)
            }
            // Ignore all other characters
        }

        return result.toString()
    }
}