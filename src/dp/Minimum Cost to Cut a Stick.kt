package dp

/*
* Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
You should perform the cuts in order, you can change the order of the cuts as you wish.
The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.
Return the minimum total cost of the cuts.
*
*
* */
class `Minimum Cost to Cut a Stick` {
    fun minCost(n: Int, cuts: IntArray): Int {
        var allcuts = IntArray(cuts.size+2)
        allcuts[0] = 0;
        allcuts[cuts.size+1] = n;
        for(i in 0..cuts.size-1){
            allcuts[i+1]= cuts[i]
        }
        allcuts.sort()
        var dp = HashMap<String, Int>()

        return getMinCost(0, allcuts.size-1, allcuts, dp )
    }

    fun getMinCost(left:Int, right:Int, cuts: IntArray, dp: HashMap<String, Int>):Int{
        if(left+1==right){
            return 0;
        }
        var minCost = Int.MAX_VALUE
        var key = "$left - $right"
        if(dp.containsKey(key)){
            return dp?.get(key)!!
        }
        for(k in left+1..right-1){
            val cost = cuts[right]-cuts[left] + getMinCost(left, k, cuts, dp)+
                    getMinCost(k, right, cuts, dp)
            minCost = Math.min(minCost, cost)
        }
        dp.put(key, minCost)
        return minCost
    }
}