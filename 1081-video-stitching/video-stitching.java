class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] maxReach = new int[time + 1];
        for (int[] clip : clips) {
            int start = clip[0];
            int end = clip[1];
            if (start <= time) {
                maxReach[start] = Math.max(maxReach[start], end);
            }
        }
        
        int count = 0;
        int currentEnd = 0;
        int nextEnd = 0;
        
        for (int i = 0; i < time; i++) {
            nextEnd = Math.max(nextEnd, maxReach[i]);
            if (i == currentEnd) {
                if (currentEnd >= nextEnd) return -1;
                currentEnd = nextEnd;
                count++;
            }
        }
        
        return currentEnd >= time ? count : -1;
    }
}