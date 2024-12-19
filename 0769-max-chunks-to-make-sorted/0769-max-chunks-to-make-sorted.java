class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length; int chunks=0;
        
        //Initializing it to minimum value
        int max = Integer.MIN_VALUE; 


        for(int i = 0; i<n; i++){
            max = Math.max(max, arr[i]);
            
            //if encountered max value we make a chunk
            if(max == i){
                chunks++;
            }
        }

        return chunks;
    }
}