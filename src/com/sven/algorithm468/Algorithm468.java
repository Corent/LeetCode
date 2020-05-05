package com.sven.algorithm468;

public class Algorithm468 {
}

/**
 * http://www.jackieathome.net/archives/668.html
 */
class Solution {
    public String validIPAddress(String IP) {
        if (IP == null || IP.isEmpty() || IP.trim().isEmpty()) return "Neither";

        java.util.regex.Matcher matcher = null;
        java.util.regex.Pattern pipv4 = java.util.regex.Pattern.compile("((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])");

        matcher = pipv4.matcher(IP);
        if (matcher.matches()) return "IPv4";

        java.util.regex.Pattern pipv6 = java.util.regex.Pattern.compile("([0-9a-f]{1,4}(\\:)){7}([0-9a-f]{1,4})");
        matcher = pipv6.matcher(IP.toLowerCase(java.util.Locale.US));
        if (matcher.matches()) return "IPv6";

        return "Neither";
    }
}