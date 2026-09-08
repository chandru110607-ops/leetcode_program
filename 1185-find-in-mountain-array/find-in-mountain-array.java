/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int n=arr.length();
        int l=0;
        int r=n-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(arr.get(mid)<arr.get(mid+1)){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        int peak=l;
        l=0;
        r=peak;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr.get(mid)==target){
                return mid;
            }
            if(arr.get(mid)<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        l=peak+1;
        r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr.get(mid)==target){
                return mid;
            }
            if(arr.get(mid)>target){
            l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }
}