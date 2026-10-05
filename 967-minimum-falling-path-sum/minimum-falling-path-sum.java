class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        for(int row=n-2;row>=0;row--){
            for(int col=0;col<n;col++){
                int down=matrix[row+1][col];
                int leftdiagonal=(col>0)?matrix[row+1][col-1]:Integer.MAX_VALUE;
                int rightdiagonal=(col<n-1)?matrix[row+1][col+1]:Integer.MAX_VALUE;
                matrix[row][col]+=Math.min(down,Math.min(leftdiagonal,rightdiagonal));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int col=0;col<n;col++){
            min=Math.min(min,matrix[0][col]);
        }
        return min;
    }
}