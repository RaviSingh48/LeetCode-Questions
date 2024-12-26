class Solution {
    public int count(int[] nums, int target, int i){
        if(i==nums.length){
            if(target==0) return 1;
            return 0;
        }
        int keep= count(nums, target-nums[i], i+1);
        int rem= count(nums, target+nums[i], i+1);
        return keep+rem;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return count(nums, target, 0);
    }
}