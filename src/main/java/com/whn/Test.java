package com.whn;

import java.util.Stack;

/**
 * 计算表达式的值并输出。表达式由若干个数字和运算符(只包含加号和减号)构成。
 * 备注：表达式中的数字均为正数
 * <p>
 * 10+23+5
 * 28
 */
public class Test {
    public int analysis(String expression) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9')
                num = 10 * num + (c - '0');
            if (!(c >= '0' && c <= '9') || i == expression.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.peek();
            stack.pop();
        }
        return res;
    }
}
