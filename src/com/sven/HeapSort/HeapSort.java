package com.sven.HeapSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.cnblogs.com/luomeng/p/10618709.html
 */
public class HeapSort {

    public static void main(String[] args) {
        List<String> s = new ArrayList<Object>();
        int[] nums = new int[] { 16, 7, 3, 20, 17, 8 };
        heapSort(nums);
        Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
    }

    /**
     * 创建堆
     * @param nums 待排序列
     */
    public static void heapSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {  //  创建堆，从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) { //  调整堆结构 + 交换堆顶元素与末尾元素
            int tmp = nums[i];  //  将堆顶元素与末尾元素进行交换
            nums[i] = nums[0];
            nums[0] = tmp;
            adjustHeap(nums, 0, i); //  重新对堆进行调整
        }
    }

    /**
     * 调整成大根堆
     * @param nums      待排序列
     * @param parent    父节点
     * @param length    待排序列尾元素索引
     */
    private static void adjustHeap(int[] nums, int parent, int length) {
        int tmp = nums[parent];         //  将tmp作为父节点
        int lChild = 2 * parent + 1;    //  左孩子
        while (lChild < length) {

            int rChild = lChild + 1;    //  右孩子
            if (rChild < length && nums[lChild] < nums[rChild]) {   //  如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
                lChild++;
            }

            if (tmp >= nums[lChild]) break; //  如果父结点的值已经大于孩子结点的值，则直接结束

            nums[parent] = nums[lChild];    //  把孩子结点的值赋给父结点

            parent = lChild;                //  选取孩子结点的左孩子结点,继续向下筛选
            lChild = 2 * lChild + 1;
        }
        nums[parent] = tmp;
    }
}
