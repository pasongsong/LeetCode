//https://leetcode.com/problems/allocate-mailboxes/
class Solution {
    int MAX = 10000000;

    public int minDistance(int[] houses, int k) {
        int houseNum = houses.length;
        Arrays.sort(houses);
        int[][] dp = new int[houseNum][k];
        int[][] cost = new int[houseNum][houseNum];

        for (int i = 0; i < houseNum; i++) {
            for (int j = 0; j < houseNum; j++) {
                int median = houses[(i + j) / 2];
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += Math.abs(median - houses[l]);
                }
                cost[i][j] = sum;
            }
        }
        for (int i = 0; i < houseNum; ++i) {
            Arrays.fill(dp[i], -1);
        }
        return solve(houses, k, 0, 0, dp, cost);
    }

    public int solve(int[] houses, int k, int pos, int curK, int[][] dp, int[][] cost) {
        if (pos == houses.length) {
            if (curK == k) {
                return 0;
            } else {
                return MAX;
            }
        }
        
        if (curK == k) {
            return MAX;
        }
        
        if (dp[pos][curK] != -1) {
            return dp[pos][curK];
        }

        int answer = MAX;
        for (int i = pos; i < houses.length; ++i) {
            answer = Math.min(answer, solve(houses, k, i + 1, curK + 1, dp, cost) + cost[pos][i]);
        } // i+1부터 나머지 재귀

        dp[pos][curK] = answer;
        return answer;
    }
}
