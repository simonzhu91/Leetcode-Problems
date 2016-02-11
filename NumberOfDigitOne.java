public class NumberOfDigitOne {
    
   
public int countDigitOne(int n) {
    int remain;
    int acc = 0;
    int numIndex = 0;
    int factor = 1;
    int count = 0;
    while (n > 0) {
        remain = n % 10;
        n /= 10;
        if (remain == 1)
            count += numIndex + acc + 1;
        else if (remain > 1)
            count += remain * numIndex + factor;
        acc += remain * factor;
        numIndex += 9 * numIndex + factor;
        factor *= 10;
    }

    return count;
}
}