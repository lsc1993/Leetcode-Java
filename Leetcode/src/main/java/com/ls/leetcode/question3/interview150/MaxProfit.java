package com.ls.leetcode.question3.interview150;

public class MaxProfit {
    public int maxProfit(int prices[]) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
