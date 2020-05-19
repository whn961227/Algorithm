package com.whn.binarySearch;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {

        int left = getMax(weights);
        int right = getSum(weights);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, mid, D)) {
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return left;
    }

    private boolean canFinish(int[] weights, int cap, int d) {
        int days = 0;
        int sum = 0;
        // [1,2,3,4,5,6,7,8,9,10], D = 5
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > cap) {
                i--;
                days++;
                sum = 0;
            }
        }
        return ++days <= d;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    private int getMax(int[] weights) {
        int max = 0;
        for (int weight : weights) {
            max = Math.max(weight, max);
        }
        return max;
    }
}
