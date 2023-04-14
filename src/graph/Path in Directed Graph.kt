package graph

class `Path in Directed Graph` {
    fun solve(A: Int, B: Array<IntArray>): Int {
        val graph = HashMap<Int, MutableList<Int>>()
        val visited = HashSet<Int>()
        for (edge in B) {
            if (!graph.containsKey(edge[0])) {
                graph[edge[0]] = mutableListOf()
            }
            graph[edge[0]]!!.add(edge[1])
        }

        // Define a DFS (Depth-First Search) function to traverse the graph
        fun dfs(node: Int): Boolean {
            if (node == A) {
                return true
            }
            visited.add(node)
            for (neighbor in graph[node] ?: emptyList()) {
                if (neighbor !in visited) {
                    if (dfs(neighbor)) {
                        return true
                    }
                }
            }
            return false
        }

        return if (dfs(1)) 1 else 0
    }

}