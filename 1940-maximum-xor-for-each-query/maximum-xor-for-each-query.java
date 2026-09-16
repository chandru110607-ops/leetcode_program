class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n=nums.length;
        int[] result=new int[n];
        int maxval=(1<<maximumBit)-1;
        int curr=0;
        for(int num:nums){
            curr^=num;
        }
        for(int i=0;i<n;i++){
            result[i]=curr^maxval;
            curr^=nums[n-1-i];
        }
        return result;
    }
}