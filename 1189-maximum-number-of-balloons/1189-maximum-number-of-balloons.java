class Solution {
    public int maxNumberOfBalloons(String text) {
        String bal="balloon";
        int count=0;
        boolean isFound=true;
        while (true){
            for(int i=0;i<bal.length();i++){
                String a=Character.toString(bal.charAt(i));
                if(text.contains(a)){
                    text=text.replaceFirst(a,"");
                }else{
                    isFound=false;
                    break;
                }
            }
            if(!isFound){
                break;
            }else{
            count++;
            }
        }
        return count;
    }
}