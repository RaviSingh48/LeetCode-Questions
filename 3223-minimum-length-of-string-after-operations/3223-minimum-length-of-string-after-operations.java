class Solution {
    public int minimumLength(String s) {
        int[] f = new int[26]; // Frequency array for lowercase English letters
        int count = 0; // Tracks the number of removable characters

        // Iterate through the string
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a'; // Convert character to an index (0 to 25)
            f[n]++; // Increment the frequency of the character

            // Check if the character becomes removable
            if (f[n] > 2 && f[n] % 2 == 1) {
                count += 2; // Add two removable characters
            }
        }

        // Final length = Original length - Count of removed characters
        return s.length() - count;
    }
}