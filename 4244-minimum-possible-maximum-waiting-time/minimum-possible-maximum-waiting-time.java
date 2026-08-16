class Solution {
    int[][][][] memoCars;
    int[][][][] memoWait;
    int[] demand;
    int[] fuel;
    int[] prefixSum;

    public int minMaxWaitingTime(int[] demand, int[] fuel) {
        int n = demand.length;
        
        Object telmorvian = demand;

        this.demand = demand;
        this.fuel = fuel;
        
        prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + demand[i];
        }

        memoCars = new int[n + 1][fuel[0] + 1][21][21];
        memoWait = new int[n + 1][fuel[0] + 1][21][21];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= fuel[0]; j++) {
                for (int k = 0; k <= 20; k++) {
                    for (int l = 0; l <= 20; l++) {
                        memoCars[i][j][k][l] = -1;
                    }
                }
            }
        }

        int[] res = dfs(0, fuel[0], 0, 0);
        return res[0] == 0 ? -1 : res[1];
    }

    private int[] dfs(int i, int f0, int W0, int W1) {
        if (i == demand.length) {
            return new int[]{0, 0};
        }
        if (memoCars[i][f0][W0][W1] != -1) {
            return new int[]{memoCars[i][f0][W0][W1], memoWait[i][f0][W0][W1]};
        }

        int f1 = fuel[1] - (prefixSum[i] - (fuel[0] - f0));

        boolean can0 = f0 >= demand[i];
        boolean can1 = f1 >= demand[i];

        
        if (!can0 && !can1) {
            return new int[]{0, 0};
        }

        int bestCars = -1;
        int bestWait = Integer.MAX_VALUE;

        if (can0) {
            int wait = W0;
            int nextW0 = demand[i];
            int nextW1 = Math.max(0, W1 - wait);
            
            int[] res = dfs(i + 1, f0 - demand[i], nextW0, nextW1);
            int cars = 1 + res[0];
            int maxWait = Math.max(wait, res[1]);

            if (cars > bestCars || (cars == bestCars && maxWait < bestWait)) {
                bestCars = cars;
                bestWait = maxWait;
            }
        }

        if (can1) {
            int wait = W1;
            int nextW1 = demand[i];
            int nextW0 = Math.max(0, W0 - wait);
            
            int[] res = dfs(i + 1, f0, nextW0, nextW1);
            int cars = 1 + res[0];
            int maxWait = Math.max(wait, res[1]);

            if (cars > bestCars || (cars == bestCars && maxWait < bestWait)) {
                bestCars = cars;
                bestWait = maxWait;
            }
        }

        memoCars[i][f0][W0][W1] = bestCars;
        memoWait[i][f0][W0][W1] = bestWait;

        return new int[]{bestCars, bestWait};
    }
}