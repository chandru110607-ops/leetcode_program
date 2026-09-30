class Solution {
    public int countHousePlacements(int n) {
        long mod = 1_000_000_007;
        
        long prev2 = 1;
        long prev1 = 2;
        
        if (n == 1) {
            long totalWays = (prev1 * prev1) % mod;
            return (int) totalWays;
        }
        
        long current = 0;
        for (int i = 2; i <= n; i++) {
            current = (prev1 + prev2) % mod;
            prev2 = prev1;
            prev1 = current;
        }
        
        long totalWays = (current * current) % mod;
        return (int) totalWays;
    }
}