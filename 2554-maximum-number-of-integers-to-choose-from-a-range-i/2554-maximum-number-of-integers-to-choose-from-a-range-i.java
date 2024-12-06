class Solution {
    public int maxCount(int[] banned, int n, int maxSum){ 

        HashSet<Integer> map=new HashSet<>();
        for(int i:banned){
            map.add(i);
        }
        int count=0;
        int sum=0;
        for(int i=1;i<=n;i++){
            if(!map.contains(i))
            {
              sum=sum+i;
           
              if(sum>maxSum){
                return count;
              }
              count++;
            }
        }

        return count; //O(m+n) because it iterates through set and then banned array
    }
}