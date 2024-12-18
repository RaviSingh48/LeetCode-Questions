class Solution {
    public int[] finalPrices(int[] prices) {
       
       int n=prices.length;
       int[] discounted=new int[n];
       for(int i=0;i<n;i++)
       {
        int first=prices[i];
        discounted[i]=first;
        for(int j=i+1;j<n;j++)
        {
            int second=prices[j];
            if(first>=second)
            {
                discounted[i]=first-second;
                break;
            }
        }
       }
       return discounted;
    }
}