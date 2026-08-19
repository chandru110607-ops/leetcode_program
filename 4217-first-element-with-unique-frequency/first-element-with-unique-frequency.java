class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int count : freq.values()) {
            freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
        }
        
        for (int num : nums) {
            int currentFreq = freq.get(num);
            if (freqCount.get(currentFreq) == 1) {
                return num;
            }
        }
        
        return -1;
    }
}