import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtrack(num, result, 0);
        return result;
    }

    private boolean backtrack(String num, List<Integer> result, int index) {
       
        if (index == num.length() && result.size() >= 3) {
            return true;
        }

        for (int i = index; i < num.length(); i++) {
          
            if (num.charAt(index) == '0' && i > index) {
                break;
            }

            long currNum = Long.parseLong(num.substring(index, i + 1));

            if (currNum > Integer.MAX_VALUE) {
                break;
            }

            int size = result.size();
            
            if (size >= 2 && currNum > result.get(size - 1) + result.get(size - 2)) {
                break; 
            }

           
            if (size <= 1 || currNum == result.get(size - 1) + result.get(size - 2)) {
                result.add((int) currNum);
                
                if (backtrack(num, result, i + 1)) {
                    return true;
                }
                
                result.remove(result.size() - 1);
            }
        }
        
        return false;
    }
}