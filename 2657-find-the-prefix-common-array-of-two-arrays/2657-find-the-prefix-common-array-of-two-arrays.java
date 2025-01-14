class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] res=new int[n];
        int[] cnt=new int[n+1];

        for(int i=0; i<n; i++){
            cnt[A[i]]++;            
            cnt[B[i]]++;
            res[i]=checkCnt(cnt, n);
        }

        return res;
    }

    int checkCnt(int[] arr, int n){
        int cnt=0;
        for(int i=1; i<=n; i++){
            if(arr[i]==2) cnt++;
        }

        return cnt;
    }
}