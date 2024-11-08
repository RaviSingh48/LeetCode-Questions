/**
 * 
 * 12344444111
 * 12411144443
 * 
 * 12344444233
 * 
 * 1. First find the point to replace
 * - check from end and first slope going down
 * 12344444111 - find '3'
 * 2. Where to put it ?
 * Find going up slope from end
 * 12444443111
 * 
 * - reverse the part
 * 121113444
 * 
 * 142387987
 * 
 * 142388779
 */

class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = ("" + n).toCharArray();

        // Step 1: Find the first decreasing element from the end
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i == 0)
            return -1; // If no such element is found, return -1

        i--; // Point to the first element of the decreasing sequence

        // Step 2: Find the element just larger than nums[i] from the end
        int j = nums.length - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }

        // Step 3: Swap elements at i and j
        swap(nums, i, j);

        // Step 4: Reverse the sequence after i to get the next smallest lexicographic
        // permutation
        reverse(nums, i + 1, nums.length - 1);

        // Convert back to long and check if it's within the 32-bit integer range
        long ansLong = Long.parseLong(new String(nums));
        return (ansLong > Integer.MAX_VALUE) ? -1 : (int) ansLong;
    }

    private void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(char[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}