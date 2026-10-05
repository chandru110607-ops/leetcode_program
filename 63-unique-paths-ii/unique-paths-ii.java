class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int m=og.length;
        int n=og[0].length;
        int[][]grid =new int[m][n];
        if(og[0][0]==1){
            return 0;
        }
        grid[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(og[i][j]==1){
                grid[i][j]=0;
                }
                else{
                    if(i>0){
                        grid[i][j]=grid[i][j]+grid[i-1][j];
                    }
                    if(j>0){
                        grid[i][j]=grid[i][j]+grid[i][j-1];
                }
                }
            }
        }
        return grid[m-1][n-1];
            }
}