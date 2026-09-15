class Solution {
    public boolean isPowerOfTwo(int n) {
       for(int i=0;i<=31;i++){
        long ans=(long)Math.pow(2,i);
        if(ans==n){
            return true;
        }
       }
       return false;
    }
}