class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int bit = 0;
        for (int i = 1; i < derived.length; i++) {
            if (derived[i - 1] == 1) {
                bit = (bit + 1) % 2;
            }
        }
        if ((derived[derived.length - 1] == 0 && bit != 0) || (derived[derived.length - 1] == 1 && bit != 1)) {
            return false;
        }
        return true;
    }
}