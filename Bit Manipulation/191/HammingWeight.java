public class HammingWeight {
    public static int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int number = 11;
        System.out.println(hammingWeight(number));  // Output: 3
    }
}
