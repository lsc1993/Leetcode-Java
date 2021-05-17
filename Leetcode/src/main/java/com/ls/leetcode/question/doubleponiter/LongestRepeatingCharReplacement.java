package com.ls.leetcode.question.doubleponiter;

/**
 * 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。
 * 在执行上述操作后，找到包含重复字母的最长子串的长度。
 * 注意：字符串长度 和 k 不会超过 104。
 *
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement
 *
 * @author liushuanggo@gmail.com
 * @since 2021-5-17
 */
public class LongestRepeatingCharReplacement {

    /**
     * 滑动窗口
     * 在left到right区间内，统计重复最多的字符
     * 即： right - left = max(char) + k - 1
     * 从头到尾，最长的就是结果
     */
    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
