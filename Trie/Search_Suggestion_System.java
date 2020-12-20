class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        /*
        Approach - we will use trie to store all the corresponding words in a list to a particular character in the following manner:-
            
            step1 :- iterate over the products and store the current word in a arraylist corresponding to that character
            step 2: - iterate over the searchWord and return the lists corresponding to the current character
            
            m - ("mobile","moneypot","monitor")
            mo - ("mobile","moneypot","monitor)
            mou - ("mouse","mousepad")
            mous - ("mouse","mousepad")
            mouse - ("mouse","mousepad")
        */
        Arrays.sort(products);
        
        Trie node = new Trie();
        
        for(String product : products){
            
            Trie current = node;    
            
            for(int i = 0; i < product.length(); i++){
                
                if(current.map[product.charAt(i) - 'a'] == null){
                    
                    current.map[product.charAt(i) - 'a'] = new Trie();
                   
                }
                current = current.map[product.charAt(i) - 'a'];
                if(current.list.size() < 3)
                    current.list.add(product);
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        Trie root = node;
        int i;
        for(i = 0; i < searchWord.length(); i++){
            
            if(root.map[searchWord.charAt(i) - 'a'] != null){
                root = root.map[searchWord.charAt(i) - 'a'];
                res.add(root.list);
            }
            else{
                res.add(new ArrayList<>());
                break;
            }
            
        }
        
        //adding aempty lists
        for(int j = i+1; j < searchWord.length(); j++){
            res.add(new ArrayList<>());
        }
        return res;
        
    } 
    
    
    public class Trie{
        Trie[] map = new Trie[26];
        List<String> list = new ArrayList<>();
    }
}