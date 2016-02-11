public class AddDigits {
    public int addDigits(int num) {
       return num - 9 * (int)Math.floor((num - 1) / 9);
    }
}