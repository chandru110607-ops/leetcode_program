class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            int size=res.size();
            for(int j=0;j<size;j++){
                List<Integer> temp=new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                if(!res.contains(temp)){
                res.add(temp);
                }
            }
        }
        return res;
    }
}