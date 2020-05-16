package com.whn.binarySearch;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }

    public int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    public int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                left = mid + 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

}
