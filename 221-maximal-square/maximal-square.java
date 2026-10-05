class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
    }
    int r=matrix.length;
    int c=matrix[0].length;
    int maxs=0;
    int[] dp=new int[c+1];
    int prev=0;
    for(int i=1;i<=r;i++){
        for(int j=1;j<=c;j++){
            int t=dp[j];
            if(matrix[i-1][j-1]=='1'){
                dp[j]=Math.min(Math.min(dp[j],dp[j-1]),prev)+1;
                maxs=Math.max(maxs,dp[j]);
            }
            else{
                dp[j]=0;
            }
            prev=t;
        }
    }
    return maxs*maxs;
    }
}