package arrays

import java.util.*

/*
* Q. Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
* ...................................................................
* Input: s = "()[]{}"
Output: true
* */
class `Valid Parentheses` {
    fun isValid(s: String): Boolean {
        var stack = Stack<Char>()
        for(element in s){
            var ch = element
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch)
            }
            else if(!stack.isEmpty() && stack.peek() == '(' && ch == ')')
                stack.pop()
            else if(!stack.isEmpty() && stack.peek() == '{' && ch == '}')
                stack.pop()
            else if(!stack.isEmpty() && stack.peek() == '[' && ch == ']')
                stack.pop()
            else
                stack.push(ch)
        }

        return stack.isEmpty()
    }
}