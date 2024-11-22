class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // Step 1: Copy the array and sort it
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Step 2: Create a rank map
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Step 3: Assign ranks to the elements in the sorted array
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // Step 4: Replace the original array elements with their rank
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }
        
        return result;
    }
}