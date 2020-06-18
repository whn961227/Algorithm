package com.whn;

/**
 * 实现输入的两个三进制数进行相加。两个三进制数以字符串形式传入
 * <p>
 * num1="121", num2="1212"
 * "2110"
 */
public class Test2 {

    public String plus(String num1, String num2) {
        return convertToBase3(convertToBase10(num1) + convertToBase10(num2));
    }


    public int convertToBase10(String num) {
        int num10 = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            num10 = 3 * num10 + (c - '0');
        }
        return num10;
    }

    public String convertToBase3(int num) {
        String res = "";
        if (num < 0) {
            num = 0 - num;
            res += "-";
        }
        StringBuilder sb = new StringBuilder();
        do {
            int mod = num % 3;
            sb.append((char) ('0' + mod));
            num = num / 3;
        } while (num > 0);
        res += sb.reverse().toString();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Test2().plus("121", "1212"));
    }
}
