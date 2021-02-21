//1100
class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        
        int ans = 0;
        for (int right = 0; right < S.length(); right++) {
            
            char c = S.charAt(right);
            
            //1. keep on removing character(character at left position in the string) from set untill the current character becomes unique
            //2. remove character from left if the window is greater than K
            while(hs.contains(c) || right - left + 1 > K) {
                hs.remove(S.charAt(left++));
            }
            
            hs.add(c);
            // at any point check if the cond is true
            if (right - left + 1 == K) {
                ans++;
            }
        }
        
        return ans;
    }
}
