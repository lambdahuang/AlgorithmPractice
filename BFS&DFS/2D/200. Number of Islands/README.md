[200. Number of Islands](https://leetcode.com/problems/number-of-islands/description/)

Classical question which you can solve if usng DFS, BFS, or UnionFind.

For simplicity, I use DFS. However, you might ask interviewer how large would the matrix be.

It's quite important because the usually you would meet the problem if you use more than 10,000 units of stack space.

```
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
```
