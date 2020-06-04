package com.sven.algorithm1233;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Algorithm1233 {

    public static void main(String[] args) {
        List<String> folders = new Solution().removeSubfolders(new String[] { "/c/d/e","/c/f", "/a","/a/b","/c/d" });
        System.out.println(folders);
    }
}

class Solution {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, Comparator.naturalOrder());
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < folder.length; ) {
            int j = i + 1;
            while (j < folder.length && isParentFolder(folder[i], folder[j])) j++;
            ans.add(folder[i]);
            i = j;
        }
        return ans;
    }

    private boolean isParentFolder(String folder1, String folder2) {
        if (folder1.equals(folder2)) return true;
        int len1 = folder1.length(), len2 = folder2.length();
        return folder2.startsWith(folder1) && len2 > len1 && folder2.charAt(len1) == '/';
    }
}