//There are two specific cases:-
//1. The number that are power of two - fr them just one bit is req
//2. Numbers that not power of two. For these number of bits required would be prevous power of two's bits and the i - previous power of 2 bits
//338
class Solution {
    
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        
        int prevPowerOfTwo = 1;
        for (int i = 1; i <= num; i++) {
            
            
            if (i == prevPowerOfTwo) {
                dp[i] = 1;
                prevPowerOfTwo *= 2;
            }
            else {
                
                dp[i] = dp[prevPowerOfTwo/2] + dp[i - prevPowerOfTwo/2];
            }
        }
        
        return dp;
    }
}
