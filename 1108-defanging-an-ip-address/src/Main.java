public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String address;

        address = "1.1.1.1";
        System.out.println(solution.defangIPaddr(address));

        address = "255.100.50.0";
        System.out.println(solution.defangIPaddr(address));
    }
}

class Solution {
    public String defangIPaddr(String address) {
        /* 可能需要的输入检查 */
        if (address == null) return null;

        /* StringBuilder 的 initial capacity 是可以计算得到的 */
        StringBuilder builder = new StringBuilder(address.length() + 6);
        int len = address.length();
        for (int i = 0; i < len; i++) {
            char c = address.charAt(i);
            if (c == '.') {
                builder.append("[.]");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}