class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int elem : nums){
            xor^=elem;
        }
        int[] res =new int[2];
        int lowestSetBit=xor&(xor*(-1));
        for(int elem : nums){
            if((lowestSetBit&elem)==0){
                res[0]^=elem;
            }
            else{
                res[1]^=elem;
            }
        }
        return res;
    }
}