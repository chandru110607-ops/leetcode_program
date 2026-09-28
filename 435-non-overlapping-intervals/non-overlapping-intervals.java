class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals,Comparator.comparingInt(a->a[1]));
        int prev=0;
        int count=1;
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>=intervals[prev][1]){
            prev=i;
            count++;
            }
        }
        return intervals.length-count;
    }
}