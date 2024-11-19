class Solution {
    public long maximumSubarraySum(int[] nums, int k) {    
    HashSet<Integer> hs = new HashSet<>();
    int start = 0, end = 0;
    long max = 0, sum =0;  

    while(end<nums.length)
    {
     int temp = nums[end];
     while(hs.contains(temp))
     {
      hs.remove(nums[start]);
      max = max - nums[start];
      start++;
     }

     max = max + temp;
     if((end-start+1)==k)
     {
      sum = Math.max(sum, max);
      max = max - nums[start];
      hs.remove(nums[start]); 
      start++;
     } 
     hs.add(temp);
     end++;
    }

      return sum;
    }
}