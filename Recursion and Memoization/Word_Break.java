
//recursive solution without memoization 
//time Complexity - 2^n for reference move to "https://leetcode.com/problems/word-break/discuss/169383/The-Time-Complexity-of-The-Brute-Force-Method-Should-Be-O(2n)-and-Prove-It-Below"
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return partition(s, wordDict, 0);
    }
    
    public boolean partition(String s, List<String> wordDict, int start) {
        if(start == s.length()){
            return true;
        }
        
        for(int i = start; i <= s.length(); i++) {
            
            String wordToLook = s.substring(start, i);
            System.out.println("at index = "+i+" word = "+wordToLook);
            if(wordDict.contains(wordToLook)) {
                //searching till last true word, if reached at length then recurse the
                //return true back
                
                if(partition(s, wordDict, i))
                    return true;
            }
        }
        
        return false;
    }
}


//with memoization

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //store the results in array to avoid multiple calls
        return partition(s, wordDict, 0, new Boolean[s.length()]);
    }
    
    public boolean partition(String s, List<String> wordDict, int start, Boolean[] memo) {
        if(start == s.length()){
            return true;
        }
        
        if(memo[start] != null){
            //System.out.println("inside");
            return memo[start];
        }
        for(int i = start; i <= s.length(); i++) {
            
            String wordToLook = s.substring(start, i);
            //System.out.println("at index = "+i+" word = "+wordToLook);
            if(wordDict.contains(wordToLook)) {
                //searching till last true word, if reached at length then recurse the
                //return true back
                
                if(partition(s, wordDict, i, memo)) {
                    return memo[start] = true;
                }
            }
        }
        
        return memo[start] = false;
    }
}