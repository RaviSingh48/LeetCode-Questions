class Solution {
    private boolean check(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return false;
        }
        return true;
    }

    public boolean canSortArray(int[] nums) {
        int[] bitCount = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            bitCount[i] = Integer.bitCount(nums[i]);
        }

        int k = 0;
        while (k < nums.length) {
            for (int i = 1; i < nums.length; i++) {
                if (bitCount[i] == bitCount[i - 1] && nums[i] < nums[i - 1]) {
                    // int temp = nums[i];
                    // nums[i]=nums[i-1];
                    // nums[i-1]=temp;
                    nums[i] = nums[i] + nums[i - 1];
                    nums[i - 1] = nums[i] - nums[i - 1];
                    nums[i] = nums[i] - nums[i - 1];
                }
            }
            if (check(nums))
                return true;
            k++;
        }
        return false;
    }
}