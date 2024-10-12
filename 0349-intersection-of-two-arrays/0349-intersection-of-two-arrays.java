class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> st=new HashSet<>();
        Set<Integer> out=new HashSet<>();

        for(int i=0;i<nums1.length;i++)
        st.add(nums1[i]);

         int k=0;
        for(int i=0;i<nums2.length;i++)
        {
            if(st.contains(nums2[i]))
            {
                out.add(nums2[i]);
                st.remove(nums2[i]);
            }
        }
       int output[]=new int[out.size()];
      
      int index = 0;
        for (int num : out) {
            output[index++] = num;
        }
       return output;



    }
}