package ADILec5;


        class Solution {
            private int recursion(int index, int[] arr, int t) {
                if (index == 0) {
                    if (t % arr[index] == 0) return t / arr[index];
                    else return -1;
                }

                int notTake = recursion(index - 1, arr, t);
                int take = Integer.MAX_VALUE;
                if (arr[index] <= t) {
                    take = 1 + recursion(index, arr, t - arr[index]);
                }
                return Math.min(take, notTake);
            }

            private int memoization(int index, int[] arr, int t, int[][] dp) {
                if (index == 0) {
                    if (t % arr[index] == 0) return t / arr[index];
                    else return Integer.MAX_VALUE;
                }
                if (dp[index][t] != -1) return dp[index][t];
                int notTake = memoization(index - 1, arr, t, dp);
                int take = Integer.MAX_VALUE;
                if (arr[index] <= t) {
                    int ans = memoization(index, arr, t - arr[index], dp);
                    if (ans != Integer.MAX_VALUE) take = 1 + ans;
                }
                return dp[index][t] = Math.min(take, notTake);
            }

            private int tabulation(int[] arr, int target) {
                int n = arr.length;
                int[][] dp = new int[n][target + 1];
                for (int t = 0; t <= target; t++) {
                    if (t % arr[0] == 0) dp[0][t] = t / arr[0];
                    else dp[0][t] = Integer.MAX_VALUE;
                }
                for (int i = 1; i < n; i++) {
                    for (int t = 0; t <= target; t++) {
                        int notTake = dp[i - 1][t];
                        int take = Integer.MAX_VALUE;
                        if (arr[i] <= t) take = 1 + dp[i][t - arr[i]];
                        dp[i][t] = Math.min(take, notTake);
                    }
                }
                int res = dp[n - 1][target];
                return res >= Integer.MAX_VALUE ? -1 : res;
            }

            private int spaceOptimization(int[] arr, int target) {
                int n = arr.length;
                int[] prev = new int[target + 1];
                int[] cur = new int[target + 1];
                for (int t = 0; t <= target; t++) {
                    if (t % arr[0] == 0) prev[t] = t / arr[0];
                    else prev[t] = Integer.MAX_VALUE;
                }
                for (int i = 1; i < n; i++) {
                    for (int t = 0; t <= target; t++) {
                        int notTake = prev[t];
                        int take = Integer.MAX_VALUE;
                        if (arr[i] <= t) take = 1 + cur[t - arr[i]];
                        cur[t] = Math.min(take, notTake);
                    }
                    prev = cur.clone();
                }
                int res = prev[target];
                return res >= Integer.MAX_VALUE ? -1 : res;
            }

            public int coinChange(int[] coins, int amount) {
                return spaceOptimization(coins, amount);
            }
        }

