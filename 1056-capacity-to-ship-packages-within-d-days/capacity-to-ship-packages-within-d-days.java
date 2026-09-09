class Solution {
    public int shipWithinDays(int[] weights, int days) {
     int l=0;
     int r=0;
     for(int w:weights){
        l=Math.max(l,w);
        r+=w;
     }   
     while(l<r){
        int mid=l+(r-l)/2;
        int need=1;
        int cur=0;
        for(int w:weights){
            if(cur+w>mid){
                need+=1;
                cur=0;
            }
            cur+=w;
        }
if(need>days) l=mid+1;
else r=mid;
     }
     return l;
    }
}