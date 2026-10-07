class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][minProfit + 1];
        dp[0][0] = 1; 

        for (int i = 0; i < group.length; i++) {
            int g = group[i];
            int p = profit[i];
            
            for (int members = n; members >= g; members--) {
                for (int currentProfit = minProfit; currentProfit >= 0; currentProfit--) {
                    int nextProfit = Math.min(minProfit, currentProfit + p);
                    dp[members][nextProfit] = (dp[members][nextProfit] + dp[members - g][currentProfit]) % MOD;
                }
            }
        }

        int totalSchemes = 0;
        for (int members = 0; members <= n; members++) {
            totalSchemes = (totalSchemes + dp[members][minProfit]) % MOD;
        }

        return totalSchemes;
    }
}