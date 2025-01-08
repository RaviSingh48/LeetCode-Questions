class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int res = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    res++;
                }
            }
        }

        return res;
    }

    public static boolean isPrefixAndSuffix(String str2, String str1) {
        return str1.startsWith(str2) && str1.endsWith(str2);
    }
}