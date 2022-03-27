//https://leetcode.com/problems/shortest-bridge/

class Solution {
    boolean[][] visited, firstLand;
    int[][] map;
    int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    Queue<Pos> queue;

    public int shortestBridge(int[][] grid) {
        int len = grid.length;

        visited = new boolean[len][len];
        firstLand = new boolean[len][len];
        map = grid;
        queue = new LinkedList<>();

        boolean fin = false;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    firstLand[i][j] = true;

                    queue.offer(new Pos(i, j));
                    dfs(i, j);
                    fin = true;
                    break;
                }
            }
            if (fin) {
                break;
            }
        }

        int res = bfs();

        return res;
    }

    int bfs() {
        int len = map.length;
        boolean[][] visited = new boolean[len][len];

        int val = -1;
        while (!queue.isEmpty()) {
            val++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pos peek = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int posX = peek.x + dx[k], posY = peek.y + dy[k];
                    if ((posX < 0 || posX >= len || posY < 0 || posY >= len) 
                            || firstLand[posX][posY] || visited[posX][posY]) {
                        continue;
                    }

                    if (map[posX][posY] == 1) {
                        return val;
                    } else {
                        visited[posX][posY] = true;
                        queue.offer(new Pos(posX, posY));
                    }
                }
            }

        }

        return val;
    }

    void dfs(int x, int y) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int posX = x + dx[i], posY = y + dy[i];
                if (posX >= 0 && posX < map.length &&  posY >= 0 && posY < map.length && !visited[posX][posY]) {
                    visited[posX][posY] = true;
                    if (map[posX][posY] == 1) {
                        firstLand[posX][posY] = true;
                        queue.offer(new Pos(posX, posY));
                        dfs(posX, posY);
                    }
                }
            }
        }
    }
}

