class Solution {
    public int maxScore(String s) {
        int n=s.length();        
        int maxScore=0;
        int cntZero=0;
        int cntOne=0;

        // Counting all '1's in the string
        for(char ch:s.toCharArray()){
            if(ch=='1') cntOne++;
        }

        // Traverse the string to calculate maximum score
        for(int i=0; i<n-1; i++){
            if(s.charAt(i)=='1') cntOne--;
            else cntZero++;
            
            // Update maxScore
            maxScore=Math.max(maxScore, cntZero+cntOne);
        }


        return maxScore;
    }
}