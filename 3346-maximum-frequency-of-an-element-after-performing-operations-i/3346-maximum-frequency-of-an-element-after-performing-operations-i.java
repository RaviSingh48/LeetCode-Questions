class Solution {
    public static final int MAX = (int) 1e5;

    public int maxFrequency(int[] nums, int k, int numOperations) {
        //Stores the frequency of a number in `nums`
        var freqMap = new HashMap<Integer, Integer>();
        //This array will be used to know the maximum frequency possible for a number
        var prefixArray = new int[MAX + 1];

        for (var n : nums) {
            //Update or insert number in `freqMap`
            freqMap.compute(n, (key, val) -> val == null ? 1 : (val + 1));
            
            //To avoid index out of bounds
            if (n + k + 1 < MAX) prefixArray[n + k + 1]--;

            if (n - k < 0) prefixArray[0]++;
            else prefixArray[n - k]++;
        }

        int ans = 0, prefixSum = 0;
        for (int i = 0; i < prefixArray.length; i++) {
            prefixSum += prefixArray[i];
            var freq = freqMap.getOrDefault(i, 0);
            // Here `Math.min(prefixSum - freq, numOperations)` indicates that count of numbers which can be updated to match `i`
            // Remove `freq` to exclude the numbers which are already matching `i`
            ans = Math.max(Math.min(prefixSum - freq, numOperations) + freq, ans);
        }

        return ans;
    }
}