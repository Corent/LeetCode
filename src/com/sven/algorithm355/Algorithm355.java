package com.sven.algorithm355;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Algorithm355 {
}

/**
 * 合并 K 个有序链表的算法
 * https://blog.csdn.net/haut_ykc/article/details/102687729
 */
class Twitter {

    private Map<Integer, Set<Integer>> fans;
    private Map<Integer, Set<Integer>> idols;
    private TreeSet<PostedTwitter> postedTwitters;

    /** Initialize your data structure here. */
    public Twitter() {
        fans = new HashMap<>();
        idols = new HashMap<>();
        postedTwitters = new TreeSet<>((o1, o2) -> Long.valueOf(o2.orderId - o1.orderId).intValue());
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        postedTwitters.add(new PostedTwitter(userId, tweetId));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> idolSet = idols.getOrDefault(userId, new HashSet<>());
        return postedTwitters.stream().filter(pt -> idolSet.contains(pt.userId) || pt.userId == userId).limit(10)
                .map(pt -> pt.tweetId).collect(Collectors.toList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        Set<Integer> fanSet = fans.getOrDefault(followeeId, new HashSet<>());
        fanSet.add(followerId);
        fans.put(followeeId, fanSet);
        Set<Integer> idolSet = idols.getOrDefault(followerId, new HashSet<>());
        idolSet.add(followeeId);
        idols.put(followerId, idolSet);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!fans.containsKey(followeeId)) return;
        fans.get(followeeId).remove(followerId);
        if (!idols.containsKey(followerId)) return;
        idols.get(followerId).remove(followeeId);
    }
}

class PostedTwitter {
    private static int order = 0;
    public int userId;
    public int tweetId;
    public long orderId;
    public PostedTwitter(int userId, int tweetId) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.orderId = order++;
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */