class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 0;
        
        for (int num : nums) {
            if (num > right) {
                right = num;
            }
        }
        
        int ans = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long operations = 0;
            
            for (int num : nums) {
                if (num > mid) {
                    operations += (num - 1) / mid;
                }
            }
            
            if (operations <= maxOperations) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
}
