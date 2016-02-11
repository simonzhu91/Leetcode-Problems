public class PowerOfThree {
    // 1. Keep dividing value by 3, if we get to 1, then return true, if we get to 0, then return false - O(Log n)
    // Must end in 3, 9, 7, 1
    // 3, 9, 27, 81, 243, 729
    // Adding up the digits in a number indictes that it is divisible by 3, but does not indicate that it is a power of 3
    public boolean isPowerOfThree(int n) {
        return n > 0 && (1162261467 % n == 0);
        
    }
}