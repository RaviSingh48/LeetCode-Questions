
class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> inStack = new HashMap<>();
        HashMap<Character, Integer> freq = new HashMap<>(); //to maintain the frequency of each characters
        
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); ++i){
            char ch = s.charAt(i);
            
            if(inStack.containsKey(ch) == true){ //means that character is already present, decrese its freq by 1
                freq.put(ch, freq.getOrDefault(ch, 0) - 1);
                continue;
            }
            
            while(stk.size() > 0 && stk.peek() > ch && freq.get(stk.peek()) >= 1){
                inStack.remove(stk.peek());
                stk.pop();
            }
                
            stk.push(ch); //push in stack
            inStack.put(ch, 1); //store in inStack map
            freq.put(ch, freq.getOrDefault(ch, 0) - 1); //remove count by one of that ch
        }
        
        StringBuilder res = new StringBuilder();
        while(stk.size() > 0){
            res.insert(0, stk.pop());
        }
        return res.toString();
    }
}