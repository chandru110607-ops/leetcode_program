class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int r=0;
        for(int pil:piles){
            r=Math.max(r,pil);
               }
               while(l<=r){
                int mid=l+(r-l)/2;
                long he=0;
                for(int pile:piles){
                    he+=(pile+mid-1)/mid;
                }
                if(he<=h){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
               }
               return l;
    }
}