package graph

class `Cycle in Directed Graph` {
    companion object {
        var isBipartate = false
    }
    fun solve(A: Int, B: Array<IntArray>): Int {
        var adj:MutableList<MutableList<Int>> = mutableListOf()
        for(i in 0 ..A){
            adj.add(mutableListOf())
        }
        for(i in B.indices){
            adj[B[i][0]].add(B[i][1])
        }
        var vis = IntArray(A+1){0}
        for(i in 1..A){
            if(vis[i]==0){
                dfs(vis, i, adj)
            }
        }
        return if(isBipartate) 1 else 0
    }
    fun dfs(vis:IntArray, v:Int, adj:MutableList<MutableList<Int>>){
        vis[v] = 1
        for(i in adj[v]){
            if(vis[i]==0){
                dfs(vis, i, adj)
            }
            else if(vis[i]==1){
                isBipartate = true
            }
        }
        vis[v] = 2

    }

}

fun main(){
    var ans = `Cycle in Directed Graph`()
    val B = intArrayOf(2,3,6,7)
    val C = intArrayOf(2,3,4,5)
    var a = Array(4){IntArray(4)}
    a[0][0] = 1
    a[0][1] = 2
    a[1][0] = 2
    a[1][1] = 3
    a[2][0] = 3
    a[2][1] = 4
    a[3][0] = 4
    a[3][1] = 2


println(ans.solve(4,a))
}