class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int flip[] = new int[nums.length];
        for(int i =1;i < nums.length;i++){
            flip[i] = flip[i-1] + (nums[i-1]%2 == nums[i]%2 ? 1: 0);
        }
        boolean ans[] = new boolean[queries.length];
        for(int i = 0;i < ans.length;i++){
            ans[i] = (flip[queries[i][1]] - flip[queries[i][0]]) == 0;
        }
        return ans;
    }
}