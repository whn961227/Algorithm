package com.whn.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0)
            return new int[]{};
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {   // [0    1   2  3   4    5   6  7]
            map.put(i, T[i]);                  // [73, 74, 75, 71, 69, 72, 76, 73]
        }
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {                      //   0  1
                stack.push(i);                          //   1
            } else {
                if (map.get(i) <= map.get(stack.peek())) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && map.get(i) > map.get(stack.peek())) {
                        Integer index1 = stack.pop();
                        res[index1] = i - index1;
                    }
                    stack.push(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int num : new DailyTemperatures().dailyTemperatures(new int[]{34, 80, 80, 34, 34, 80, 80, 80, 80, 34})) {
            System.out.print(num + " ");
        }
    }
}
