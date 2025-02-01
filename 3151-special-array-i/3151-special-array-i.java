class Solution {
    public boolean isArraySpecial(int[] nums) {
        
        int n = nums.length;
        
        for(int i = 1; i< n; i++){
            if(nums[i-1] % 2 == nums[i] % 2){
                return false;
            }
        }
        return true;
    }
}