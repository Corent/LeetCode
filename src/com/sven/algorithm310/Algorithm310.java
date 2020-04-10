package com.sven.algorithm310;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Algorithm310 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // List<Integer> list = solution.findMinHeightTrees(6, new int[][] {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}});
        List<Integer> list = solution.findMinHeightTrees(3, new int[][] {{0, 1}, {0, 2}});
        System.out.println(list);
    }
}

/**
 * 类剥洋葱求解
 * https://blog.csdn.net/lllllyt/article/details/82914006
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return new ArrayList<Integer>() {{ add(0); }};
        Set<Integer> set = null;
        Map<Integer, Set<Integer>> map = new HashMap<>();   //  构建图
        for (int i = 0; i < edges.length; i++) {
            set = map.containsKey(edges[i][0])? map.get(edges[i][0]): new HashSet<>();
            set.add(edges[i][1]);
            map.put(edges[i][0], set);
            set = map.containsKey(edges[i][1])? map.get(edges[i][1]): new HashSet<>();
            set.add(edges[i][0]);
            map.put(edges[i][1], set);
        }

        Set<Integer> nodes = map.keySet();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int node: nodes) { //  把叶子节点放入队列
            if (map.get(node).size() == 1) {
                queue.addLast(node);
            }
        }
        /**
         * 每个树最多有两个MHTs。假如有三个或多个可以作为MHTs的根节点，根据树的定义，每两个节点都可以找到一条路径连接起来，树是一个强连通的图，不存在简单环，则至少一个一个或多个比其余节点高，则大于三个MHTs不成立。
         */
        while (n > 2) {
            int size = queue.size();
            n -= size;
            for (int i = 0; i < size; i++) {    //  依次去除叶子节点，吧新的叶子节点加入队列
                int node = queue.pollFirst();
                int next = map.get(node).iterator().next();
                set = map.get(next);
                set.remove(node);
                map.remove(node);
                if (set.size() == 1) queue.addLast(next);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) ans.add(queue.pollFirst());
        return ans;
    }
}