// https://leetcode.com/problems/spiral-matrix-ii/submissions/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int i = 0; i < n; i++) {
            res[0][i] = i + 1;
        }

        int nowDir = 0;
        int x = 0, y = n - 1, num = n + 1;
        for (int goN = n - 1; goN >= 1; goN--) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < goN; j++) {
                    x += dir[nowDir][0];
                    y += dir[nowDir][1];
                    res[x][y] = num++;
                }
                nowDir = (nowDir + 1) % 4;
            }
        }
        
        return res;

    }
}
