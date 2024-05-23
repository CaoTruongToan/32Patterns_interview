public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int accumulator = 0;
        for (int num : nums) {
            accumulator ^= num;
        }
        return accumulator;
    }

    public static void main(String[] args) {
        int[] nums = {5, 3, 5, 4, 3};
        int result = singleNumber(nums);
        System.out.println(result); 
    }
}
