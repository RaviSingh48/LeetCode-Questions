// import java.util.ArrayList;
// import java.util.Collections;

class Solution {
    public int largestInteger(int num) {
        String s = String.valueOf(num);
        int n = s.length();
        
        ArrayList<Integer> evens = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();
        
        // Separate the digits into even and odd lists
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit % 2 == 0) {
                evens.add(digit);
            } else {
                odds.add(digit);
            }
        }
        
        // Sort both lists in descending order
        Collections.sort(evens, Collections.reverseOrder());
        Collections.sort(odds, Collections.reverseOrder());
        
        // Reconstruct the largest possible integer
        StringBuilder result = new StringBuilder();
        int evenIndex = 0, oddIndex = 0;
        for (int i = 0; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit % 2 == 0) {
                result.append(evens.get(evenIndex++));
            } else {
                result.append(odds.get(oddIndex++));
            }
        }
        
        // Convert the result to an integer and return
        return Integer.parseInt(result.toString());
    }
}