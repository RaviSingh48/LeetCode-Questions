class Solution {
    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;  // Count of even index positions
        long oddCount = n / 2;         // Count of odd index positions
        
        long result = (power(5, evenCount) * power(4, oddCount)) % MOD;
        return (int) result; 
    }

    private long power(long base, long exp) {
        if (exp == 0) return 1;  // Base case
        long half = power(base, exp / 2);
        half = (half * half) % MOD; // Square the result with modulo
        
        return (exp % 2 == 0) ? half : (half * base) % MOD; 
    }
}
