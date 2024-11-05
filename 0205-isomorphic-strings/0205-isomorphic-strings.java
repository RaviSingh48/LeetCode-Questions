import java.util.Arrays;
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] ar=new int[s.length()];
        int[] a=new int[t.length()];
        for(int i=0;i<s.length();++i){
            ar[i]=s.charAt(i);
            a[i]=t.charAt(i);
            }
            int j=0;
            sort(ar,a);
            for(j=0;j<s.length()-1;++j){
                if((ar[j]==ar[j+1] && a[j]!=a[j+1]) || (a[j]==a[j+1] && ar[j]!=ar[j+1])){
                    return false;
                }
            }
            sort(a,ar);
             for(j=0;j<s.length()-1;++j){
                if((ar[j]==ar[j+1] && a[j]!=a[j+1]) || (a[j]==a[j+1] && ar[j]!=ar[j+1])){
                    return false;
                }
            }
    System.out.println(Arrays.toString(ar));
    System.out.println(Arrays.toString(a));
    return true;
    }
    void sort(int[] ar,int[] a){
         int flag=0;
            for(int i=0;i<ar.length;++i){
                flag=0;
                for(int j=1;j<ar.length-i;++j){
                    if(ar[j]<ar[j-1]) {
                        int temp = ar[j];
                        int temp1=a[j];
                        a[j]=a[j-1];                      
                        ar[j] = ar[j - 1];
                        a[j-1]=temp1;
                        ar[j - 1] = temp;
                        flag++;
                    }
                }
                if(flag==0){
                    break;
                }
            }
    }
}