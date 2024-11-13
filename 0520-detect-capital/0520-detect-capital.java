class Solution {
    public boolean detectCapitalUse(String word) {
        int n = word.length();
        boolean a = false;
        if(Character.isUpperCase(word.charAt(0))){
            if(n>1 && Character.isUpperCase(word.charAt(1))){
                a=true;
            }
        }
        for(int i=1;i<n;i++){
            if(a==false){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
            else{
                if(Character.isLowerCase(word.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}