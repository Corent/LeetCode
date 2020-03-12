package com.sven.algorithm093;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C) 1998 - 2018 SOHU Inc., All Rights Reserved.
 * <p>
 *
 * @author: sven
 * @date: 2018/5/19
 */
public class Algorithm093 {
}

class Solution {

    private List<String> ip;
    private List<String> ans;

    public List<String> restoreIpAddresses(String s) {
        ip = new ArrayList<>();
        ans = new ArrayList<>();
        restoreIpAddressesCore(s, 0);
        return ans;
    }

    private void restoreIpAddressesCore(String s, int idx) {
        int cnt = 4 - ip.size();
        if (s == null || s.isEmpty()
                || s.length() - idx < cnt || s.length() - idx > cnt * 4
                || !(cnt >= 0 && cnt <= 4))
            return;

        if (idx == s.length() && cnt == 0) {
            ans.add(ip.get(0) + '.' + ip.get(1) + '.' + ip.get(2) + '.' + ip.get(3));
            return;
        }

        if (idx < s.length()) {
            ip.add(s.substring(idx, idx + 1));
            restoreIpAddressesCore(s, idx + 1);
            ip.remove(ip.size() - 1);
        }

        if (idx + 1 < s.length()) {
            String tmp = s.substring(idx, idx + 2);
            int t = Integer.valueOf(tmp);
            if (t >= 10 && t <= 99) {
                ip.add(tmp);
                restoreIpAddressesCore(s, idx + 2);
                ip.remove(ip.size() - 1);
            }

            if (idx + 2 < s.length()) {
                tmp = s.substring(idx, idx + 3);
                t = Integer.valueOf(tmp);
                if (t >= 100 && t <= 255) {
                    ip.add(tmp);
                    restoreIpAddressesCore(s, idx + 3);
                    ip.remove(ip.size() - 1);
                }
            }
        }
    }
}