class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0;
        int h=nums[n-1]-nums[0];
        while(l<h){
            int mid=l+(h-l)/2;
            if(countPairs(nums,mid)>=k){
                h=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    private int countPairs(int[] nums, int maxDistance) {
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > maxDistance) {
                left++;
            }
            count += right - left;
        }
        
        return count;
}
    }