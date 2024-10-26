class Solution {

    // top down

    // static int dp[];
    // static int helper(int n){
    //     if(n==1) return 1;
    //     if(n==2) return 2;

    //     if(dp[n]!=-1) return dp[n];
    //     int a = helper(n-1);
    //     int b = helper(n-2);
    //     return dp[n] = a+b;
    // }

//   Bottom up
    static int helper2(int n){
        if(n==1) return 1;
        if(n==2) return 2;
        int arr[] = new int[n+1];

        arr[1] = 1;
        arr[2] = 2;

        for(int i=3; i<=n; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
    
    public int climbStairs(int n) {

        // dp = new int[50];
        // Arrays.fill(dp,-1);
        return helper2(n);
    }
}