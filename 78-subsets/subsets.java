class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        for(int num:nums){
            int curr=res.size();
            for(int i=0;i<curr;i++){
                List<Integer> newsub=new ArrayList<>(res.get(i));
                newsub.add(num);
                res.add(newsub);
            }
        }
        return res;
    }
}