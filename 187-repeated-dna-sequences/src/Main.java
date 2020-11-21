import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // 11111111111111111111
//        System.out.println(Integer.toBinaryString(1048575));

        Solution solution = new Solution();
        String s;
        List<String> repeated;


//        s = "TAAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("=============== case 1 ===============");
        s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        repeated = solution.findRepeatedDnaSequences(s);
        for (String r : repeated) {
            System.out.println(r);
        }


        System.out.println("=============== case 2 ===============");
        s = "AAAAAAAAAAAAA";
        repeated = solution.findRepeatedDnaSequences(s);
        for (String r : repeated) {
            System.out.println(r);
        }

        System.out.println("=============== case 3 ===============");
        s = "AAAAAACCCCAAAAAACCCCGGGGGGGGGGTTTTTTTTTTGGGGGCGGGGGGTTTTT";
        repeated = solution.findRepeatedDnaSequences(s);
        for (String r : repeated) {
            System.out.println(r);
        }
    }
}

class Solution {

    // 1048575
    private int MOD = 1048575;
    private static final int[] map = new int[128];

    static {
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;
    }

    public List<String> findRepeatedDnaSequences(String s) {
        /* 基因序列非法（空），或基因序列长度不足 */
        if (s == null || s.length() <= 10) {
            return new ArrayList<>();
        }

        int n = s.length();
        List<String> repeated = new ArrayList<>(s.length());
        Set<Integer> seen = new HashSet<>(s.length());
        Set<Integer> collected = new HashSet<>(s.length());

        /* 初始化 */
        Integer cur = 0;
        for (int i = 0; i < 10; i++) {
            cur = encode(cur, s.charAt(i));
//            System.out.println(Integer.toBinaryString(cur));
        }
        seen.add(cur);

        /* 遍历 */
        for (int i = 10; i < n; i++) {
            cur = encode(cur, s.charAt(i));
            if (collected.contains(cur)) {
                continue;
            }
            if (seen.contains(cur)) {
                collected.add(cur);
                repeated.add(decode(cur));
            } else {
                seen.add(cur);
            }
        }

        return repeated;
    }

    private String decode(Integer code) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int geneCode = code & 3;
            if (geneCode == 0) {
                builder.append('A');
            } else if (geneCode == 1) {
                builder.append('C');
            } else if (geneCode == 2) {
                builder.append('G');
            } else /* geneCode == 3 */ {
                builder.append('T');
            }
            code >>= 2;
        }
        return builder.reverse().toString();
    }

    private Integer encode(Integer pre, char gene) {
        return ((pre << 2) + map[gene]) & MOD;

    }
}