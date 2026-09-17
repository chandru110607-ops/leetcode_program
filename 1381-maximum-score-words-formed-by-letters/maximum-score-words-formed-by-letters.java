class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] count = new int[26];
        for (char c : letters) {
            count[c - 'a']++;
        }
        
        return backtrack(words, count, score, 0);
    }

    private int backtrack(String[] words, int[] count, int[] score, int index) {
        if (index == words.length) return 0;

        int maxScore = backtrack(words, count, score, index + 1);

        int wordScore = 0;
        boolean canForm = true;
        
        for (char c : words[index].toCharArray()) {
            count[c - 'a']--;
            wordScore += score[c - 'a'];
            if (count[c - 'a'] < 0) {
                canForm = false;
            }
        }

        if (canForm) {
            maxScore = Math.max(maxScore, wordScore + backtrack(words, count, score, index + 1));
        }

        for (char c : words[index].toCharArray()) {
            count[c - 'a']++;
        }

        return maxScore;
    }
}