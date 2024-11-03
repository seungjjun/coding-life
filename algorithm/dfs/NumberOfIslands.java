package com.dev.allinone;

/**
 * https://leetcode.com/problems/number-of-islands
 */
public class NumberOfIslands {

    private static int[] dx = new int[]{0, 1, 0, -1};
    private static int[] dy = new int[]{1, 0, -1, 0};

    private boolean[][] visited;

    public int numIslands(char[][] grid) {
        int answer = 0;
        visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    answer++;
                    dfs(i, j, grid);
                }
            }
        }

        return answer;
    }

    private void dfs(int y, int x, char[][] grid) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < grid[0].length && nextY >= 0 && nextY < grid.length) {
                if (!visited[nextY][nextX] && grid[nextY][nextX] == '1') {
                    dfs(nextY, nextX, grid);
                }
            }
        }
    }

}
