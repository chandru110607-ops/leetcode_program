import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        return Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> freq.get(a).equals(freq.get(b)) ? Integer.compare(b, a) : Integer.compare(freq.get(a), freq.get(b)))
            .mapToInt(Integer::intValue)
            .toArray();
    }
}