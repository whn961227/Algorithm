package com.whn.binarySearch;

/**
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 */
public class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
//        // piles最大值
//        int max = getMax(piles);
//        for (int speed = 1; speed < max; speed++) {
//            // 以speed是否能在H小时内吃完香蕉
//            if(canFinish(piles, speed, H)){
//                return speed;
//            }
//        }
//        return max;

        int left = 1;
        int right = getMax(piles);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, h)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canFinish(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += timeOf(pile, speed);
        }
        return time <= h;
    }

    private int timeOf(int pile, int speed) {
        int res = pile / speed;
        if (pile % speed > 0)
            res += 1;
        return res;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}
