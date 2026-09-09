import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int n = position.length;
        int low = 1; 
        int high = position[n - 1] - position[0];
        int bestForce = 0;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            int count = 1; 
            int lastPlacedPosition = position[0];
            boolean possible = false;
            
            for (int i = 1; i < n; i++) {
                if (position[i] - lastPlacedPosition >= mid) {
                    count++;
                    lastPlacedPosition = position[i];
                    
                    if (count == m) {
                        possible = true;
                        break;
                    }
                }
            }
            
            if (possible) {
                bestForce = mid; 
                low = mid + 1;   
            } else {
                high = mid - 1;  
            }
        }
        
        return bestForce;
    }
}