public class ReverseBits {
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 8; i++) {  // Số bit 8-bit
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.printf("%08d\n", Integer.parseInt(Integer.toBinaryString(reverseBits(n))));
    }
}
