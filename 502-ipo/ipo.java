class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        
        java.util.Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        java.util.PriorityQueue<Integer> maxHeap = new java.util.PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        int i = 0;
        for (int j = 0; j < k; j++) {
            while (i < n && projects[i][0] <= w) {
                maxHeap.offer(projects[i][1]);
                i++;
            }
            
            if (maxHeap.isEmpty()) {
                break;
            }
            
            w += maxHeap.poll();
        }
        
        return w;
    }
}