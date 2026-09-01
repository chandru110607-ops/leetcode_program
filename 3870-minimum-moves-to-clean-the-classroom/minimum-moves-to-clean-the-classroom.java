import java.util.*;

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int sx = -1, sy = -1;
        int[][] litterMap = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterMap[i], -1);
        }
        
        int litterCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    litterMap[i][j] = litterCount++;
                }
            }
        }
        
        if (litterCount == 0) return 0;
        
        int fullMask = (1 << litterCount) - 1;
        
        int[][][] bestEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 0, energy, 0});
        bestEnergy[sx][sy][0] = energy;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1], cmask = curr[2], ce = curr[3], steps = curr[4];
            
            if (cmask == fullMask) {
                return steps;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    char nextChar = classroom[nx].charAt(ny);
                    
                    if (nextChar == 'X') continue;
                    
                    int ne = ce - 1;
                    if (ne < 0) continue;
                    
                    if (nextChar == 'R') {
                        ne = energy;
                    }
                    
                    int nmask = cmask;
                    if (nextChar == 'L') {
                        nmask |= (1 << litterMap[nx][ny]);
                    }
                    
                    if (ne > bestEnergy[nx][ny][nmask]) {
                        bestEnergy[nx][ny][nmask] = ne;
                        queue.offer(new int[]{nx, ny, nmask, ne, steps + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}