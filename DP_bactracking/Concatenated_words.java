class Solution {
    //Set<String> mem = new HashSet<>();
    
    Map<String, Boolean> mem = new HashMap<>();
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        
        Set<String> hs = new HashSet<>();
        
        for(String word: words) {
            hs.add(word);
        }
        
        List<String> res = new ArrayList<>();
        
        for (String word: words) {
            if(isConcat(word, hs)) {
                res.add(word);
            }
        }
        
        return res;
    }
    //make substrings and see if the left or start part of the string is a word in the provided list of inputs. After finding the left or start part, see if the rest if the string is a word in the input, if yes then you have found the two shorter words. If the right part is not in the given list, then recurse on the right part so as to see if the right part has shorter words in it
    public boolean isConcat(String s, Set<String> hs) {
        
        if (mem.containsKey(s))
            return mem.get(s);
                
        for(int i = 1; i < s.length(); i++) {
            
            String first = s.substring(0, i);
            String next = s.substring(i);
            
            if(hs.contains(first)) {
                if (hs.contains(next) || isConcat(next, hs) ) {
                    mem.put(s, true);
                    return true;
                }
                mem.put(next, false);
            }
            
            //mem.put(first, false);
            //mem.put(next, false);
        }
        
        mem.put(s, false);
        return false;
    }
}
