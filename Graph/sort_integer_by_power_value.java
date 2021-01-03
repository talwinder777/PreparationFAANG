class Solution {
    public int getKth(int lo, int hi, int k) {
     
        int dp[] = new int[1000000];
        
        dp[1] = 1;
        
        List<Pair> res = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            
            if (dp[i] == 0)
                dp[i] = calSteps(i, dp);
            
            res.add(new Pair(i, dp[i]));
            // System.out.println("steps = "+dp[i]);
        }
        
        Collections.sort(res, new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                
                if (p1.steps != p2.steps) {
                    
                    return p1.steps - p2.steps;
                }
                else {
                    return 0;
                }
            }
        });
        
        return res.get(k - 1).number;
    }
    
    public class Pair {
        int number, steps;
        
        public Pair(int number, int steps) {
            this.number = number;
            this.steps = steps;
        }
    }
    
    public int calSteps(int number, int[] dp) {
        
        int steps = 0;
        
        // System.out.println ("number = "+number);
        
        while (number != 1) {
            
            if (dp[number] != 0) {
                steps += dp[number];
                return steps;
            }
            
            number = number % 2 == 0 ? number / 2: (3*number) + 1;
            
            steps++;
        }
        
        return steps;
    }
}
