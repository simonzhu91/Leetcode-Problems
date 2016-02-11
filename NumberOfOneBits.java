public class NumberOfOneBits {
    public int hammingWeight(int n) {
        int count = 0;
        int i = 0;
        while(n != 0){
            // if((n&1)==1)
            count+=n&1;
            n=n >>> 1;
            // if(i < 32)
            //     System.out.println(Integer.toBinaryString(n));
            i++;
        }
        
        return count;
    }
}