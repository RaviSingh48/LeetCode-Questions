class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s_current=new StringBuilder("0");
        for(int i=1;i<n;i++){
            StringBuilder s_prev=s_current;
            StringBuilder s_rev=new StringBuilder();
            for(int j=s_prev.length()-1;j>=0;j--){
                if(s_prev.charAt(j)=='1'){
                    s_rev.append('0');
                }
                else{
                    s_rev.append('1');
                }
            }
            s_current=s_prev.append("1").append(s_rev);
        }
        System.out.println(s_current);
        return s_current.charAt(k-1);
    }
}