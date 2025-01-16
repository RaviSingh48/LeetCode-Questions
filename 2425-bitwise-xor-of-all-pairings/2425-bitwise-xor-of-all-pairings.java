class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int x1 = 0, x2 = 0, ans = 0;
        for (int i : nums1) {
            x1 ^= i;
        }
        for (int i : nums2) {
            x2 ^= i;
        }
if (nums2.length % 2 != 0) {
            ans ^= x1;
        }
        if (nums1.length % 2 != 0) {
            ans ^= x2;
        }

        return ans;
    }
}