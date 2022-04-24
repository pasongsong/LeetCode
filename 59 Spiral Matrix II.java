// https://leetcode.com/problems/spiral-matrix-ii/submissions/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
        for (int i = 0; i < n; i++) {
            res[0][i] = i + 1;  //첫 줄 채우기
        }

        int nowDir = 0;
        int x = 0, y = n - 1, num = n + 1;       // 오른쪽, 아래, 왼쪽 위
        for (int goN = n - 1; goN >= 1; goN--) { // 이 방향대로 n-1, n-1, n-2, n-2, ... 1, 1 이렇게 진행됨
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < goN; j++) {
                    x += dir[nowDir][0];
                    y += dir[nowDir][1];    // 좌표 이동
                    res[x][y] = num++;      // 숫자 채우기
                }
                nowDir = (nowDir + 1) % 4;  // 방향대로 goN 만큼 갔으면 방향 전환
            }
        }
        
        return res;

    }
}
