class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> {
            if(nums[i1] == nums[i2]){
                return i1 - i2;
            }
            return nums[i1] - nums[i2];
        });
        int n = nums.length;
        for(int i = 0 ; i < n; i++){
            minHeap.add(i);
        }
        long result = 0;
        boolean[] visited = new boolean[n];
        while(!minHeap.isEmpty()){
            int i = minHeap.poll();
            if(visited[i]){
                continue;
            }
            result += nums[i];
            if(i > 0){
                visited[i - 1] = true;
            }
            if(i < n - 1){
                visited[i + 1] = true;
            }
        }
        return result;
        
    }
}