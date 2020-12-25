class Solution {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
            
        List<String> res = new ArrayList<>();
        
        // System.out.println("len = "+s.length());
        Set<String> hs = new HashSet<>();
        
        for (String word : wordDict) {
            hs.add(word);
        }
        makeStrings(s, hs, 0, "", res);
        
        return res;
    }
    
    public void makeStrings (String s, Set<String> hs, int start, String concat, List<String> res) {
        
        // if (start > s.length())
        //     return;
        // System.out.println("start = "+start);
        if(start == s.length()) {
            // System.out.println("concat = "+concat);
            res.add(concat.substring(0, concat.length()-1));
            return;
        }
        
        for (int i = start; i <= s.length(); i++) {
            
            if (hs.contains(s.substring(start, i))) {
                
                String prev = concat;
                concat = concat + s.substring(start, i) + " ";
                // System.out.println("concat in = "+concat);
                makeStrings(s, hs, i, concat, res);
                concat = prev;
            }
        }
    }
}
