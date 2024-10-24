class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int p1=0;
        int p2=1;
        int n=nums.length;
        while(p1<n && p2<n){
            while(p1<n && nums[p1]%2==0)p1+=2;
            while(p2<n && nums[p2]%2!=0)p2+=2;
            if(p1>=n || p2>=n)break;
            int x=nums[p1];
            nums[p1]=nums[p2];
            nums[p2]=x;
        }
        return nums;
    }
}