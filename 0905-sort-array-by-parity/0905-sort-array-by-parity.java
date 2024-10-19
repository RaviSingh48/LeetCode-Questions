public class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        int e = 0;
        int o = nums.length - 1;
        
        for (int num : nums) {
            if (num % 2 == 0) {
                ans[e] = num;
                e++;
            } else {
                ans[o] = num;
                o--;
            }
        }
        
        return ans;
    }
}