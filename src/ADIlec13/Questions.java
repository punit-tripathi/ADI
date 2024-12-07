package ADIlec13;

public class Questions {
    public static void main(String[] args) {

    }
    int[] arr =new int [50];


    public int climbStairs(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;

        if(arr[n] != 0) return arr[n];
        int res=0;
        res+=climbStairs(n-1);
        res+=climbStairs(n-2);

        return arr[n] = res;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(0,n,nums,dp);
    }

    public int helper(int st,int n,int[] nums,int[] dp){
        if(st >= n) return 0;

        if(dp[st] != -1) return dp[st];

        int left = nums[st] + helper(st + 2,n,nums,dp);
        int right = helper(st + 1,n,nums,dp);

        return dp[st] = Math.max(left,right);
    }
    private int solve(int i, int j, String s1, String s2, int dp[][]) {
        if (i == 0 && j == 0) {
            if (s1.charAt(i) == s2.charAt(j))
                return 0;
            else
                return 1;
        }
        if (j == -1)
            return i + 1;
        if (i == -1)
            return j + 1;

        if (dp[i][j] != -1)
            return dp[i][j];

        int insert = 300000000;
        int replace = 30000000;
        int delete = 30000000;

        if (s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = solve(i - 1, j - 1, s1, s2, dp);
        else {
            insert = 1 + solve(i, j - 1, s1, s2, dp);
            replace = 1 + solve(i - 1, j - 1, s1, s2, dp);
            delete = 1 + solve(i - 1, j, s1, s2, dp);
        }

        return dp[i][j] = Math.min(insert, Math.min(replace, delete));
    }

    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];

        for (int[] I : dp)
            Arrays.fill(I, -1);

        return solve(word1.length() - 1, word2.length() - 1, word1, word2, dp);
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(getMax(nums, 0, nums.length - 2), getMax(nums, 1, nums.length - 1));
    }

    private int getMax(int[] nums, int start, int end) {
        int prevRob = 0, maxRob = 0;

        for (int i = start; i <= end; i++) {
            int temp = Math.max(maxRob, prevRob + nums[i]);
            prevRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }
    static int helper(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int ans = 1;

        for(int i=1; i<n; i++){
            int count = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[i]>arr[j]) count = Math.max(count,dp[j]);
            }
            dp[i] = 1+count;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    public int lengthOfLIS(int[] arr) {
        return helper(arr);
    }
    int recursion(int index , vector<int>&arr , int t)
    {
        if(index == 0)
        {
            if(t % arr[index] == 0)
            {
                return t / arr[index] ;
            }
            else
            {
                return -1 ;
            }
        }

        int not_take = 0 + recursion(index - 1 , arr , t);
        int take = INT_MAX ;
        if(arr[index] < t)
        {
            take = 1 + recursion(index , arr , t - arr[index]);
        }

        return min(take , not_take);
    }

    int memoization(int index , vector<int>&arr , int t , vector<vector<int>>&dp)
    {
        if(index == 0)
        {
            if(t % arr[index] == 0)
            {
                return t / arr[index] ;
            }
            else
            {
                return INT_MAX ;
            }
        }
        if(dp[index][t] != -1) return dp[index][t] ;

        int not_take = 0 + memoization(index - 1 , arr , t, dp);
        int take = INT_MAX ;
        if(arr[index] <= t)
        {
            int ans = memoization(index , arr , t - arr[index], dp);
            if(ans != INT_MAX)
            {
                take = 1+ ans ;
            }
        }

        return dp[index][t] = min(take , not_take);
    }

    int Tabulation(vector<int>& arr , int target)
    {
        int n = arr.size() ;
        vector<vector<int>>dp(n, vector<int>(target+1 , 0));
        for(int t = 0 ; t <= target ; t++)
        {
            if(t % arr[0] == 0) dp[0][t] =  t / arr[0] ;
            else
            {
                dp[0][t] = 1e9 ;
            }
        }

        for(int i = 1 ; i < n ; i++)
        {
            for(int t = 0 ; t <= target ; t++)
            {
                int not_take = 0 + dp[i - 1][t] ;
                int take = INT_MAX ;
                if(arr[i] < t)
                {
                    take = 1 +dp[i][t - arr[i]];
                }

                dp[i][t] =  min(take , not_take);
            }

        }
        int res = dp[n-1][target] ;
        if(res >= 1e9)
        {
            return -1 ;
        }
        return res ;
    }

    int spaceOptimization(vector<int>& arr , int target)
    {
        int n = arr.size() ;
        vector<int>prev(target+1, 0) , cur(target+1, 0) ;
        for(int t = 0 ; t <= target ; t++)
        {
            if(t % arr[0] == 0) prev[t] =  t / arr[0] ;
            else
            {
                prev[t] = 1e9 ;
            }
        }

        for(int i = 1 ; i < n ; i++)
        {
            for(int t = 0 ; t <= target ; t++)
            {
                int not_take = 0 + prev[t] ;
                int take = INT_MAX ;
                if(arr[i] <= t)
                {
                    take = 1 + cur[t - arr[i]];
                }

                cur[t] =  min(take , not_take);
            }

            prev = cur ;
        }

        int res = prev[target] ;
        if(res >= 1e9)
        {
            return -1 ;
        }
        return res ;
    }
    public:
    int coinChange(vector<int>& coins, int amount) {
        int n = coins.size() ;
        // return recursion(n-1, coins , amount);


        /*
        // memoization function call ---->>>>>

        vector<vector<int>> dp(n , vector<int>(amount+1 , -1));
        int res =  memoization(n-1, coins , amount , dp);

        if(res == INT_MAX)
        {
            return -1 ;
        }
        else
        {
            return res ;
        }

        */

        // return Tabulation(coins, amount);

        return spaceOptimization(coins , amount) ;


    }
}
