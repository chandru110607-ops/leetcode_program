class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n=arr.length;
        double low=0,high=1.0;
        while(low<high){
            double mid=low+(high-low)/2;
            int count=0;
            int num=0;
            int den=1;
            double maxfr=0.0;
            int j=1;
            for(int i=0;i<n-1;i++){
                while(j<n && arr[i]>mid*arr[j]){
                    j++;
                }
                count+=(n-j);
                if(j==n)break;
                double fraction=(double)arr[i]/arr[j];
                if(fraction>maxfr){
                    maxfr=fraction;
                    num=arr[i];
                    den=arr[j];

                }
            }
            if(count==k){
                return new int[]{num,den};
            }
            else if(count>k){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        return new int[]{};
    }
}