class Solution {
    public int findMaximumXOR(int[] nums) {
        int max=0;
        int mask=0;
        for(int i=31;i>=0;i--){
            mask=mask|(1<<i);
            Set<Integer> prefix=new HashSet<>();
            for(int num:nums){
                prefix.add(num&mask);
            }
            int target=max|(1<<i);
            for(int prefi:prefix){
                if(prefix.contains(target^prefi)){
                    max=target;
                    break;
                }
            }
        }
        return max;
    }
}