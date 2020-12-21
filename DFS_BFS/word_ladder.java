class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String, List<String>> oneEdit = new HashMap<>();
        
        for (String word: wordList) {
            
            for (int i = 0; i < word.length(); i++) {
                
                String key = word.substring(0, i) + '*' + word.substring(i + 1, word.length());
                
                if (!oneEdit.containsKey(key)) {
                    
                    List<String> val = new ArrayList<>();
                    val.add(word);
                    oneEdit.put(key, val);
                }
                else {
                    // System.out.println("list = "+oneEdit.get(key));
                    List<String> val = oneEdit.get(key);
                    val.add(word);
                    oneEdit.put(key, val);
                }
            }
        }
        // System.out.println("map = "+oneEdit);
        
        int steps = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        Set<String> s = new HashSet<>();
        s.add(beginWord);
        while(!q.isEmpty()) {
            
            Pair pair = q.remove();
            String word = pair.word;
            int level = pair.level;
            s.add(word);
            
            
            for (int i = 0; i < word.length(); i++) {
                
                String key = word.substring(0, i) + '*' + word.substring(i + 1, word.length());
                
                if (oneEdit.containsKey(key)) {
                    
                    List<String> children = oneEdit.get(key);
                    
                    for (int j = 0; j < children.size(); j++) {
                        
                        if(children.get(j).equals(endWord)) {
                            return level + 1;
                        }
                        
                        if (!s.contains(children.get(j))) {
                            // s.add(children.get(j));
                            q.add(new Pair(children.get(j), level + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    public class Pair {
        String word;
        int level;
        
        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}
