class Solution {
    public boolean isPowerOfFour(int n) {
        for(int i=0;i<=31;i++){
            long ans=(long)Math.pow(4,i);
            if(ans==n){
                return true;
            }
        }
        return false;
    }
}