package com.whn.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 输入: "()"
 * 输出: true
 */
public class IsValid {
    public boolean isValid(String s) {
        Stack<Character> left = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                left.push(c);
            else if (!left.isEmpty() && leftOf(c) == left.peek())
                left.pop();
            else
                return false;
        }
        return left.isEmpty();
    }

    private char leftOf(char c) {
        if (c == ')') return '(';
        if (c == '}') return '{';
        else return '[';
    }
}
