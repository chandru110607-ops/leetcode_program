class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,(int)1e9);
        dp[0]=0;
        for(int i=0;i<n;i++){
            int wallsp=time[i]+1;
            for(int j=n;j>0;j--){
                dp[j]=Math.min(dp[j],dp[Math.max(0,j-wallsp)]+cost[i]);
            }
        }
        return dp[n];
    }
}