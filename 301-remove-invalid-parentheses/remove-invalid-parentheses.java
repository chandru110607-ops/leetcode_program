class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        dfs(s, 0, left, right, res);
        return res;
    }

    private void dfs(String s, int start, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                res.add(s);
            }
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                String curr = s.substring(0, i) + s.substring(i + 1);
                if (r > 0 && s.charAt(i) == ')') {
                    dfs(curr, i, l, r - 1, res);
                } else if (l > 0 && s.charAt(i) == '(') {
                    dfs(curr, i, l - 1, r, res);
                }
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}