package com.ls.leetcode.question3.interview150;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int i = 0;
        while (i < n) {
            int j = i;
            int cir = 0;
            int last = 0;
            while (cir != n) {
                int costGas = cost[(j) % n];
                if ((gas[j % n] + last) < costGas) {
                    break;
                } else {
                    last += (gas[j % n] - costGas);
                }
                j++;
                cir++;
            }
            if (cir == n) {
                return i;
            } else {
                i = i + cir + 1;
            }
        }
        return -1;
    }
}
