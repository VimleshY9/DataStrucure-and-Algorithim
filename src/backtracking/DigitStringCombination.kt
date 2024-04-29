package backtracking


/*
* Q. Given a digit string A, return all possible letter combinations that the number could represent.
A mapping of digit to letters (just like on the telephone buttons) is given below
* The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
NOTE: Make sure the returned strings are lexicographically sorted.
*
* input = 23
* output =  ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
*
* */
data class MapDigit (val digit:Int, val arr: CharArray)
class DigitStringCombination {
    fun solve(A: String):ArrayList<String> {
        val map = HashMap<Int, String>()
        val res = ArrayList<String>()
        val sb = StringBuilder()
        map.put(0,"0");
        map.put(1,"1");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        helper(A,0, res, sb, map);
        return res;
    }
    private fun helper(A: String, k: Int, res:ArrayList<String>, sb:StringBuilder, map:HashMap<Int, String>) {
        if (k == A.length) {
            res.add(sb.toString())
            return
        }
        val pr: String? = map.get(("" + A[k]).toInt())
        if (pr != null) {
            for (i in pr.indices) {
                sb.append(pr?.get(i))
                helper(A, k + 1, res, sb, map)
                sb.deleteCharAt(k)
            }
        }
    }

    }

fun main(){
    DigitStringCombination().solve("23").forEach { println(it) }
}