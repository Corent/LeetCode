package com.sven.algorithm996;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Algorithm996 {
}

/**
 * 参考Algorithm 46 && 47 全排列
 */
class Solution {

    private int ans;
    private int[] nums;
    private List<Integer> permute = new ArrayList<>();
    private boolean[] used;

    private void permute() {
        if (permute.size() == nums.length) {
            ans++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && !used[i - 1] && nums[i] == nums[i - 1]) continue;  // 前一个和当前这个一样，但是前面那个没用过，所以当前这个也该跳过
            if (!permute.isEmpty() && !isSquareful(permute.get(permute.size() - 1) + nums[i])) continue;
            used[i] = true;
            permute.add(nums[i]);
            permute();
            permute.remove(permute.size() - 1);
            used[i] = false;
        }
    }

    private boolean isSquareful(int x) {
        int xx = Double.valueOf(Math.sqrt(x)).intValue();
        return xx * xx == x;
    }

    public int numSquarefulPerms(int[] A) {
        used = new boolean[A.length];
        Arrays.fill(used, false);
        Arrays.sort(A);
        this.nums = A;
        permute();
        return ans;
    }
}