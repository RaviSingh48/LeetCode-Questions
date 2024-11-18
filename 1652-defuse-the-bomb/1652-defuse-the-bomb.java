class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] ans= new int[code.length];
        if(k==0){
            return ans;
        }
        else if(k>0){
            for(int i=0; i<code.length; i++){
                int s=0;
                for(int j=1; j<=k; j++){
                    s+=code[(i+j)%code.length];
                }
                ans[i]=s;
            }
            return ans;
        }
        else{
            for(int i=0; i<code.length; i++){
                int s=0;
                for(int j=1; j<=-k; j++){
                    s+=code[(i-j+code.length)%code.length];
                }
                ans[i]=s;
            }
            return ans;
        }
    }
}