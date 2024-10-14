class Solution {
    public int fun(int i, String s,int[] dp) {
        if (i < 0) {
            return 1;
        }
        if (i == 0) {
            return s.charAt(i) == '0' ? 0 : 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int take = 0;

        
        if (s.charAt(i) != '0') {
            take = fun(i - 1, s,dp);
        }

        
        if (i - 1 >= 0 && s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
            take += fun(i - 2, s,dp); 
        }

        return dp[i] = take;
    }

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return fun(s.length() - 1, s,dp);
    }
}