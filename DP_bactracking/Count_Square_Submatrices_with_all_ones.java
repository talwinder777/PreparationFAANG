//1277
class Solution {
    public int countSquares(int[][] matrix) {
        
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            
            for (int j = 0; j < matrix[0].length; j++) {
                
                //skip the first row and column, we will add the cells value after this if block. Also if current cell is zero then that can not make square of any size
                if (i != 0 && j != 0 && matrix[i][j] != 0) {
                    
                    matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]));
                
                }
                
                ans += matrix[i][j];
            }
        }
        
        return ans;
        
    }
}
