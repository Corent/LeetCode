package com.sven.algorithm287;

public class Algorithm287 {
}

/**
 * https://blog.csdn.net/qq_17550379/article/details/83893104
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

/**
 * https://blog.csdn.net/JSJWR/article/details/80357815
 */
class Solution2 {

    public int findDuplicate(int[] nums) {

        int len = nums.length;
        int start = 1, end = len, half = 0;
        while (start < end){
            int middle = start + (end - start) / 2;
            half = count(nums, start, middle);

            if (half > middle - start + 1){
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        if (start == end){
            half = count(nums, start, end);
            if (half > 1) return start;
        }

        return -1;

    }

    //计算数组中大小范围为start~end的元素个数
    public int count(int[] nums, int start, int end){
        if (start > end) return 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= start && nums[i] <= end) {
                cnt ++;
            }
        }
        return cnt;
    }
}


class Solution3 {

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n - 1] < 0) return nums[i];
            nums[n - 1] = -nums[n - 1];
        }
        return -1;
    }
}