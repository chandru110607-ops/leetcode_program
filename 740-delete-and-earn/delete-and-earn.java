class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] points = new int[maxVal + 1];
        for (int num : nums) {
            points[num] += num;
        }

        int prev2 = 0;
        int prev1 = points[0];

        for (int i = 1; i <= maxVal; i++) {
            int current = Math.max(prev1, prev2 + points[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}