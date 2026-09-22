import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> ans=new ArrayList<>();
         Arrays.sort(candidates);
         find(0,target,candidates,new ArrayList<>(),ans);
         return ans;
    }
    public void find(int start,int target,int[] nums,List<Integer> current,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(nums[i]>target) break;
            if(i>start && nums[i]==nums[i-1]) continue;
            current.add(nums[i]);
            find(i+1,target-nums[i],nums,current,ans);
            current.remove(current.size()-1);
        }
    }
}