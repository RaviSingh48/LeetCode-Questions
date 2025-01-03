class Solution {
    public int waysToSplitArray(int[] nums) {
        long tot = 0;
        for(int num : nums){
            tot += num;
        }
        long lef = 0;
        int cnt = 0;
        for(int i=0;i<nums.length-1;i++){
            lef +=nums[i];
            long rig = tot - lef;
            if(lef >= rig){
                cnt++;
            }
        }
        return cnt;
    }
}