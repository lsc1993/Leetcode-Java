package com.ls.leetcode.question.array;

import java.util.PriorityQueue;

/**
 *  最大平均通过率
 *  一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。
 *  给你一个二维数组 classes，其中classes[i] = [passi, totali]，
 *  表示你提前知道了第i个班级总共有totali个学生，其中只有passi个学生可以通过考试。
 * 给你一个整数extraStudents，表示额外有extraStudents个聪明的学生，
 * 他们 一定能通过任何班级的期末考。
 * 你需要给这extraStudents个学生每人都安排一个班级，使得 所有班级的 平均通过率 最大。
 * 一个班级的通过率等于这个班级通过考试的学生人数除以这个班级的总人数。
 * 平均通过率是所有班级的通过率之和除以班级数目。
 * 请你返回在安排这 extraStudents 个学生去对应班级后的 最大平均通过率。
 * 与标准答案误差范围在10-5以内的结果都会视为正确结果
 *
 * https://leetcode.cn/problems/maximum-average-pass-ratio
 *
 * @author liushuanggo
 * @since 2023-02-19
 */
public class MaxAverageRatio {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            long v1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long v2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (v1 == v2) {
                return 0;
            }
            return v1 < v2 ? 1 : -1;
        });

        for (int[] c : classes) {
            pq.offer(new int[] {c[0], c[1]});
        }

        for (int i = 0; i < extraStudents; i++) {
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            pq.offer(new int[]{pass + 1, total + 1});
        }
        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            int pass = arr[0], total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / classes.length;
    }
}
