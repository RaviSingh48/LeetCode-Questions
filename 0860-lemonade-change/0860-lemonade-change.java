class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        
        for (int bill:bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
            } else {
                if (ten > 0) {
                    ten--; 
                } else {
                    five -= 2;
                }

                five--;
            }

            if (five < 0) return false;
        }
        return true;
    }
}