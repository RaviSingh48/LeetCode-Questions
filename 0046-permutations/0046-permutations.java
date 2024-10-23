class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteRec(nums, 0, result);
        return result;
    }

    private void permuteRec(int[] nums, int currentIndex, List<List<Integer>> result) {
        if (currentIndex == nums.length - 1) {
            List<Integer> currentPermutation = new ArrayList<>();
            for (int num : nums) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for (int index = currentIndex; index < nums.length; index++) {
            swap(nums, currentIndex, index);
            permuteRec(nums, currentIndex + 1, result);
            swap(nums, currentIndex, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}