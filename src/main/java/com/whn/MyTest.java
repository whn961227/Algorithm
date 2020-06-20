package com.whn;

public class MyTest {
    public void bubbleSort(int[] nums){
        int temp;
        int flag;
        for(int i = nums.length-1; i >= 1; i--){
            flag = 0;
            for(int j = 1; j <= i; j++){
                if(nums[j-1] > nums[j]){
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    flag = 1;
                }
            }
            if(flag == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        new MyTest().bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
