import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        backtrack(res, new StringBuilder(), num, target, 0, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval) {
                res.add(path.toString());
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();
            if (pos == 0) {
                path.append(curr);
                backtrack(res, path, num, target, i + 1, curr, curr);
                path.setLength(len);
            } else {
                path.append("+").append(curr);
                backtrack(res, path, num, target, i + 1, eval + curr, curr);
                path.setLength(len);
                
                path.append("-").append(curr);
                backtrack(res, path, num, target, i + 1, eval - curr, -curr);
                path.setLength(len);
                
                path.append("*").append(curr);
                backtrack(res, path, num, target, i + 1, eval - multed + multed * curr, multed * curr);
                path.setLength(len);
            }
        }
    }
}