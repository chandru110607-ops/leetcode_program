class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
     int sum=0;
     for(int i=0;i<nums.size();i++){
        int c=0;
        int num=i;
        while(num!=0){
            c+=num&1;
            num=num>>1;
        }
        if(c==k){
            sum+=nums.get(i);
        }
     }   
     return sum;
    }
}