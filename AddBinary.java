package LeetCode;

public class AddBinary {
    public String addBinary(String a, String b) {
        int num1 = Integer.parseInt(a, 2);
        int num2 = Integer.parseInt(b, 2);
        return Integer.toBinaryString(num1 + num2);
    }

    public static void main(String[] args) {
        String a = "11", b = "1";
        System.out.println(new AddBinary().addBinary(a, b));
    }
}
