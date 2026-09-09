class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long tf=(long)m*k;
        if(tf>bloomDay.length){
            return -1;
        }
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int day:bloomDay){
            low=Math.min(low,day);
            high=Math.max(high,day);
        }
        while(low<high){
            int mid=low+(high-low)/2;
            int bou=0;
            int cons=0;
            for(int day:bloomDay){
                if(day<=mid){
                    cons++;
                    if(cons==k){
                        bou++;
                        cons=0;
                    }
                }
                else{
                    cons=0;
                }
            }
            if(bou>=m){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}