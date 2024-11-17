class Solution {
    public boolean validfun(int[][] matrix,int y, int x){
        int r=matrix.length;
        int c=matrix[0].length;
        int i=y;
        int j=x;
        int temp=matrix[i][j];
        boolean valid=true;
        while(i<r && j<c){
            if(matrix[i][j]!=temp){
                valid =false;
            }
            i++;
            j++;
        }
        return valid;
    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        boolean ans=true;
        int r=matrix.length;
        int c=matrix[0].length;
        for(int j=0;j<c;j++){
           boolean temp=validfun(matrix,0,j);
            if(temp==false){
                ans=false;
            }
        }
        for(int i=1;i<r;i++){
            boolean temp=validfun(matrix,i,0);
            if(!temp){
                ans=false;
            }
        }
        return ans;
    }
}