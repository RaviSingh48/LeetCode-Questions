class Solution {
   public boolean validUtf8(int[] data) {
        int size = data.length;
        if (size == 0) {
            return false;
        }

        for (int index = 0; index < size; index++) {
            int bitCount = getUnicodeBytesCount(data[index]);
            if (bitCount == -1 || size - index < bitCount) {
                return false;
            }
            
            for (int subIndex = 1; subIndex < bitCount; subIndex++) {
                if (getLastNBits(data[++index], 2) != 0b10) {
                    return false;
                }
            }
        }

        return true;
    }

    public int getUnicodeBytesCount(int firstByte) {
        if (getLastNBits(firstByte, 1) == 0b0) {
            return 1;
        } else if (getLastNBits(firstByte, 3) == 0b110) {
            return 2;
        } else if (getLastNBits(firstByte, 4) == 0b1110) {
            return 3;
        } else if (getLastNBits(firstByte, 5) == 0b11110) {
            return 4;
        } else {
            return -1;
        }
    }

    public int getLastNBits(int digit, int n) {
        int shift = 8 - (Math.max(n, 0));

        return ((digit >> shift) & (0b11111111 >> shift));
    }
}