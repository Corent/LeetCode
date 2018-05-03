package com.sven.algorithm071;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 27/04/2018
 */
public class Algorithm071 {
}

class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        while (path.startsWith("/")) path = path.substring(1);
        while (path.endsWith("/")) path = path.substring(0, path.length() - 1);
        String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir: dirs) {
            switch (dir) {
                case ".": case "": break;
                case "..":
                    if (!stack.isEmpty()) stack.pop();
                    break;
                default:
                    stack.add(dir);
                    break;
            }
        }
        List<String> list = new ArrayList<>(stack);
        path = list.stream().reduce("", (a, b) -> a + "/" + b);
        return path.length() != 0? path: "/";
    }
}