class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[] dp = new int[n];
        
        for (int j = 0; j < n; j++) {
            dp[j] = grid[0][j];
        }
        
        for (int i = 1; i < n; i++) {
            int[] nextDp = new int[n];
            
            for (int j = 0; j < n; j++) {
                int minPrev = Integer.MAX_VALUE;
                
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        minPrev = Math.min(minPrev, dp[k]);
                    }
                }
                
                nextDp[j] = grid[i][j] + minPrev;
            }
            
            dp = nextDp;
        }
        
        int result = Integer.MAX_VALUE;
        for (int val : dp) {
            result = Math.min(result, val);
        }
        
        return result;
    }
}