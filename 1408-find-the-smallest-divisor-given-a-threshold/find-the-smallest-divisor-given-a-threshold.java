class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l=1;
        int r=0;
        for(int num:nums){
            if(num>r){
                r=num;
            }
        }
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            int curr=0;
            for(int num:nums){
                curr+=(num+mid-1)/mid;
            }
            if(curr<=threshold){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return ans;

    }
}