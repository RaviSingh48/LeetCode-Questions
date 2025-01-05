class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] psum = new int[n];
        for(int[] shift : shifts){
            int curr = shift[2] == 0 ? -1 : 1;
            psum[shift[0]] += curr;
            if(shift[1] < n - 1){
                psum[shift[1] + 1] -= curr;
            }
        }
        char[] arr = s.toCharArray();
        int currShift = 0;
        for(int i = 0; i < n; i++){
            currShift += psum[i];
            int curr = arr[i] - 'a';
            arr[i] = (char)('a' + ((26 + (curr + (currShift % 26))) % 26));
        }
        return new String(arr);
    }
}