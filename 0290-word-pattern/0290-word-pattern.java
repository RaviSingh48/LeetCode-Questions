class Solution {
    public boolean wordPattern(String pattern, String s) {
          HashMap<Character,String> hashMap = new HashMap<>();

        int i = 0;

        boolean can = true;
        String[] arr = s.split(" ");
        
        if (arr.length != pattern.length())
            return false;
        
        for (char ch : pattern.toCharArray()){
            if (hashMap.containsKey(ch)){
                if (!Objects.equals(hashMap.get(ch), arr[i])){
                    return false;
                }
            }else {
                // check if i can add this value or there is actually
                // one item has it
                if (hashMap.containsValue(arr[i])){
                    return false;
                }
                hashMap.put(ch,arr[i]);
            }
            i++;
        }

        return can;
    }
}