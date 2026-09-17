class Solution {
    public int maxProduct(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++)
            {
               if(!hasCommonLetters(words[i],words[j])){
                int pro=words[i].length()*words[j].length();
                count=Math.max(count,pro);
               }
            }
        }
        return count;
    }
    private boolean hasCommonLetters(String w1, String w2) {
        boolean[] letters = new boolean[26];
        for (int i = 0; i < w1.length(); i++) {
            letters[w1.charAt(i) - 'a'] = true;
        }

        for (int i = 0; i < w2.length(); i++) {
            if (letters[w2.charAt(i) - 'a']) {
                return true;
            }
        }
        return false;
    }
}