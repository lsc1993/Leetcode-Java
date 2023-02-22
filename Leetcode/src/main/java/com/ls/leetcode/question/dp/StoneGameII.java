package com.ls.leetcode.question.dp;

/**
 * 爱丽丝和鲍勃继续他们的石子游戏。许多堆石子排成一行，每堆都有正整数颗石子piles[i]。
 * 游戏以谁手中的石子最多来决出胜负。
 * 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。
 * 在每个玩家的回合中，该玩家可以拿走剩下的前X堆的所有石子，
 * 其中1 <= X <= 2M。然后，令M = max(M, X)。
 * 游戏一直持续到所有石子都被拿走。
 * 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。
 *
 * https://leetcode.cn/problems/stone-game-ii
 *
 * @author liushuang
 * @since 2023-02-22
 */
public class StoneGameII {

    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int sum = 0;
        /* dp[i][j]表示：剩余[i:len - 1]时，M=j的情况下，先取的人获得最多的石子。
         * 其中 i 是状态，M是选择
         */
        int[][] dp = new int[len][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            sum += piles[i];
            for (int M = 1; M <= len; M++) {
                if (i + 2 * M >= len) {
                    dp[i][M] = sum;
                } else {
                    for (int x = 1; x <= 2 * M; x++) {
                        dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(x, M)]);
                    }
                }
            }
        }
        return dp[0][1];
    }
}
