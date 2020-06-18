package com.whn.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * <p>
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(0, nums, track);
        return res;
    }

    private void backTrack(int i, int[] nums, LinkedList<Integer> track) {
        res.add(new LinkedList<>(track));
        for (int j = i; j < nums.length; j++) {
            track.add(nums[j]);
            backTrack(j + 1, nums, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));
    }
}
