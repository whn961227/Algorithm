package com.whn.dynamic;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        int len = nums.length;
        int[] dp = Arrays.copyOf(nums, len);
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + dp[i], dp[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
