class Solution {
    public double minimumAverage(int[] nums) {
       Arrays.sort(nums);
       int i=0;
       int j=nums.length-1;
       double[] average=new double[nums.length/2];
       while(nums.length/2<=j){
       double min=nums[i];
       double max=nums[j];
       average[i]=(min+max)/2;
       i++;
       j--;
       }
       Arrays.sort(average);
       return average[0];
    }
}