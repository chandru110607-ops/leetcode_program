class Solution {
    public boolean canPartition(int[] nums) {
        int ts=0;
        for(int num:nums){
            ts+=num;
        }
        if(ts%2!=0){
            return false;
        }
        int tar=ts/2;
        boolean[] dp=new boolean[tar+1];
        dp[0]=true;
        for(int num:nums){
            for(int j=tar;j>=num;j--){
                dp[j]=dp[j]||dp[j-num];
            }
        }
        return dp[tar];
    }
}