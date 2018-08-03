class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        boolean[][] map = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i ++)
            for(int j = 0; j < grid[0].length; j ++)
                map[i][j] = false;
        int ret = 0;
        for(int i = 0; i < grid.length; i ++)
            for(int j = 0; j < grid[0].length; j ++)
                if(!map[i][j] && grid[i][j] == '1') {DFS(i, j, map, grid); ret ++;}
        return ret;
    }
    public void DFS(int i, int j, boolean[][] map, char[][]grid)
    {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1' || map[i][j]) return;
        map[i][j] = true;
        DFS(i + 1, j, map, grid);
        DFS(i - 1, j, map, grid);
        DFS(i, j + 1, map, grid);
        DFS(i, j - 1, map, grid);
    }
}
