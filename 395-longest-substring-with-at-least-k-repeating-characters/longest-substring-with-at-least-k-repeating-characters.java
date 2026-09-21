class Solution {
    public int longestSubstring(String s, int k) {
        int n=s.length();
        int[]arr=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
        }
        for(int i=0;i<n;i++)
        {
            if(arr[s.charAt(i)-'a']<k)
            {
                int left=longestSubstring(s.substring(0,i),k);
                int right=longestSubstring(s.substring(i+1),k);
                return Math.max(left,right);           }
        }
        return n;
    }
}