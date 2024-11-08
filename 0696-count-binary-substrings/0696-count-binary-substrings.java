class Solution {
    public int countBinarySubstrings(String s) {
        int count=0;
        int prev=0;
        int curr=1;
        for(int i=1;i<s.length();i++)
        {
            if(s.charAt(i-1)==s.charAt(i))
            {
                curr++;
            }
            else
            {
                prev =curr;
                curr=1;
            }
            if(prev>=curr)
            {
                count++;
            }
        }
        return count;
    }
}