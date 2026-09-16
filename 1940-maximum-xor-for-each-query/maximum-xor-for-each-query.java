class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
       int getAns = (int)Math.pow(2, maximumBit) - 1;
        int len = nums.length;
        int xor = nums[0];
        int res[] = new int[len];
        res[len-1] = xor ^ getAns;
        for(int i=1; i<len; i++) {
            xor ^= nums[i];
            
            res[len-i-1] = xor ^ getAns;
        }
        return res;
    }
}