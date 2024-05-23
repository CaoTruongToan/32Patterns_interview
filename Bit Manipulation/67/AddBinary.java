public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder ans = new StringBuilder();

        while (i >= 0 || j >= 0 || carry != 0) {
            int bit1 = (i >= 0) ? a.charAt(i) - '0' : 0;
            int bit2 = (j >= 0) ? b.charAt(j) - '0' : 0;
            int sum = bit1 + bit2 + carry;
            carry = sum / 2;
            ans.append(sum % 2);
            i--;
            j--;
        }
        

        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        String a = "101";
        String b = "110";
        System.out.println(solution.addBinary(a, b)); 
    }
}
