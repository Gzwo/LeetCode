package test;

import java.util.Scanner;

public class TestSampleGenerator {
    public static void main(String[] args) {
        char[] brackets = new char[]{'(', ')'};
        int length = 20;


        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            length = Integer.parseInt(s);
            if (length < 0) break;
            char[] testSample = new char[length];
            for (int i = 0; i < length; i++) {
                testSample[i] = brackets[(int) (Math.random() * brackets.length)];
            }
            System.out.println(String.valueOf(testSample));
        }
    }
}
