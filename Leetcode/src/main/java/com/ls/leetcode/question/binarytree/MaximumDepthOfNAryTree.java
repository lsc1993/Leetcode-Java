package com.ls.leetcode.question.binarytree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * N 叉树的最大深度
 * 给定一个 N 叉树，找到其最大深度。
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * {}@link https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 *
 * @author liushuanggo@gmail.com
 * @since 2021-4-12
 */
public class MaximumDepthOfNAryTree {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) {
                heights.add(maxDepth(item));
            }
            return Collections.max(heights) + 1;
        }
    }
}
