class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] tempNum  = nums1.clone();
        Arrays.sort( tempNum );
        long totalDiff = 0;
        
        for( int i = 0 ; i < nums1.length; i++ )
            totalDiff += Math.abs( nums1[i]-nums2[i] );
        
        long result = totalDiff;
        for( int i= 0; i < nums2.length; i++ )
        {
            int index = find_index( tempNum, nums2[i]);
            
            int leftIndex = index == 0 ? index : index-1;
            int rightIndex = index == tempNum.length ? index-1 : index;
            
            int diff = Math.min( Math.abs( nums2[i] - tempNum[leftIndex] ), Math.abs( nums2[i] - tempNum[rightIndex] ) );
            
            result = Math.min( result, totalDiff-Math.abs(nums1[i] -nums2[i] ) + diff);
           
        }
    return (int) ( result % 1000000007);    
    }
    
    public int find_index(int[] arr, int K)
    {

        int left = 0;
        int right = arr.length-1;

        // Traverse the search space
        while (left < right)
        {
            int mid = (left + right) / 2;
            
            if (arr[mid] == K)
                return mid;
            else if (arr[mid] > K)
                right = mid;
            else
                left = mid + 1;
        }

        // Return insert position / Minimal left index which satisfies arr[left ] > K
        return left;
    }
}