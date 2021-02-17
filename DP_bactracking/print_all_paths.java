class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        helper(0, graph, path, res);
        return res;
    }
    
    public void helper(int node, int[][] graph, List<Integer> path, List<List<Integer>> res) {
        
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int nei: graph[node]) {
            // System.out.println("nei = "+nei);
            path.add(nei);
            helper(nei, graph, path, res);
            path.remove(path.size() - 1);
        }
    }
}
