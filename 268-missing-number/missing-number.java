class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int exsum=n*(n+1)/2;
        int ac=0;
        for(int i=0;i<n;i++){
            ac+=nums[i];
        }
        return exsum-ac;
    }
}