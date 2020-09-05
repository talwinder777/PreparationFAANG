class Solution {
    
    
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie tr = new Trie();
        //Trie pointer;
        for(String word : words){
            Trie pointer = tr;
            for(int i = 0; i < word.length(); i++) {
                
                if(pointer.map[word.charAt(i) - 'a'] == null){
                    
                    pointer.map[word.charAt(i) - 'a'] = new Trie();
                
                }
                pointer = pointer.map[word.charAt(i) - 'a']; 
            }
            
            pointer.isWord = true;
        }
        
        List<String> res = new ArrayList<>();
        int[][] visited;
         for(int i = 0; i < board.length; i++) {
            
            for(int j = 0 ;j < board[0].length; j++) {
                
                visited = new int[board.length][board[0].length];
                System.out.println("for charcetr "+board[i][j]);
                if((tr.map[board[i][j] - 'a']) != null){
                    
                    dfs(board, words, tr, res, i, j, visited, "");
                }
            }
        }
        
        return res;
        
    }
    
    public void dfs(char[][] board, String[] words, Trie tr, List<String> res, int i, int j, int[][] visited, String word) {
        
        if (board[i][j] == '#')
            return;
        if(tr.map[board[i][j] - 'a'] == null){
            return;
        }
        word += board[i][j];
        if(tr.map[board[i][j] -'a'].isWord == true){
            System.out.println("inside true at cordinates i = "+i+" j = "+j);
            //word += board[i][j];
            //if(!res.contains(word))
            res.add(word); 
            tr.map[board[i][j] - 'a'].isWord = false;
           // res.add(word);
            
        }
        
        
        System.out.println(" "+ word);
        //visited[i][j] = 1;
        char letter = board[i][j];
        board[i][j] = '#';
        
        if(i + 1  <  board.length)
            dfs(board, words, tr.map[letter - 'a'], res, i + 1, j , visited, word);
        if(j + 1  <  board[0].length)
            dfs(board, words, tr.map[letter - 'a'], res, i, j + 1, visited, word);
        if(i - 1  >=  0)
            dfs(board, words, tr.map[letter - 'a'], res, i - 1, j , visited, word);
        if(j - 1  >=  0)
            dfs(board, words, tr.map[letter - 'a'], res, i, j - 1, visited, word);
        
        board[i][j] = letter;

    } 
    
    public class Trie{
        Trie[] map = new Trie[26];
        boolean isWord = false;
    }
}
