package com.whn.binarySearch;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 现有矩阵 matrix 如下：
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int colLen = matrix.length;
        int rowLen = matrix[0].length;

        for (int i = 0; i < colLen; i++) {
            if (matrix[i][0] > target)
                break;
            if (binarySearch(matrix[i], target))
                return true;
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid])
                return true;
            if (target > nums[mid])
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
