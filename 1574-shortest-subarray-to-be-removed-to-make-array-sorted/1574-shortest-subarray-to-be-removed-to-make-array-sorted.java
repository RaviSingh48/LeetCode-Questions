class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (r > 0 && arr[r] >= arr[r - 1]) {
            r--;
        }
        int rmvLength = r;
        while (l < r && (l == 0 || arr[l] >= arr[l - 1])) {
            while (r < arr.length && arr[l] > arr[r]) {
                r++;
            }
            rmvLength = Math.min(rmvLength, r - l - 1);
            l++;
        }
        return rmvLength;
    }
}