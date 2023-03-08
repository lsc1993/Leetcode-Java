package com.ls.leetcode.questionv2.dp;

/**
 * 股票的最大利润
 *
 * https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/solution/gu-piao-de-zui-da-li-run-by-leetcode-sol-0l1g/
 *
 * @author liushuanggo
 * @since 2023-03-09
 */
public class StockMaxProfit {

    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
