//Leetcode 79
class Solution {
    
    public boolean exist(char[][] board, String word) {
        
        
        for(int i = 0; i < board.length; i++) {
            
            for(int j = 0; j < board[0].length; j++) {
                
                if(board[i][j] == word.charAt(0)) {
                    
                    if(dfs(i, j, board, word, 0))
                        return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, int j, char[][] board, String word, int ind) {
        
        if(ind == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(ind)) {
            return false;
        }
       
        
        char temp = board[i][j];
        board[i][j] = '1';
        
        boolean ans = dfs(i + 1, j, board, word, ind + 1) ||dfs(i, j + 1, board, word, ind + 1) || dfs(i  - 1, j, board, word, ind + 1) || dfs(i, j - 1, board, word, ind + 1);
      
        board[i][j] = temp;
        return ans;
    }
}
