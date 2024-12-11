class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && (nums[j] - nums[i]) <= k * 2) {
                j++;
            }
            ans = Math.max(ans, j - i);
        }

        return ans;
    }
}