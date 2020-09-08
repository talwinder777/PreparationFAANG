class Solution {
   
    public int numDistinctIslands(int[][] grid) {
        
        int[][] visited = new int[grid.length][grid[0].length];
        
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < grid.length; i++) {
            
            for(int j = 0; j < grid[0].length; j++) {
                
                if(grid[i][j] == 1) { 
                    
                    String word = dfs(grid, i, j, i, j);
                    
                    if(!set.contains(word)){
                        set.add(word);
                    }
                }
            }
        }
        return set.size();
    }
    
    public String dfs(int grid[][], int i, int j, int oi, int oj) {
        
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return "";
        
        int diff1 = i - oi;
        int diff2 = j - oj;
        
        String word = diff1 + ""+ diff2;
        
        grid[i][j] = 0;
        
        word += dfs(grid, i+1, j, oi, oj);
        
        word += dfs(grid, i, j+1, oi, oj);
        
        word += dfs(grid, i-1, j, oi, oj);
        
        word += dfs(grid, i, j - 1, oi, oj);
        
        return word;
    }
}