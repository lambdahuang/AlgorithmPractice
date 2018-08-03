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

UnionFind with Weighted QuickUnion

```
class Solution {
    int[][] dirs = {{0, -1}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int res = 0;
        if( grid == null || grid.length == 0) return res;
        if( grid[0] == null || grid[0].length == 0 ) return res;
        int row = grid.length;
        int col = grid[0].length;
        
        int[] unionSet = new int[row * col];
        Arrays.fill(unionSet, -1);
        int[] size = new int[row * col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0 ; j < col; j++) {
                int id = col * i + j;
                if ( grid[i][j] == '1' && unionSet[id] == -1) {
                    res++;
                    unionSet[id] = id;
                    size[id] = 1;
                    
                    for (int[] dir : dirs) {
                        int indexX = i + dir[0];
                        int indexY = j + dir[1];

                        if( isValid(indexX, indexY , row , col) && grid[indexX][indexY] == '1'){
                            int pos = col * indexX + indexY;
                            int root = find(unionSet, pos);
                            if (root != id) {
                                res--;
                                // WeightedQuickUnion
                                id = union(id, root, unionSet, size);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
    
    //quick find with path compression 
    public int find(int[] unionSet, int id) {
        while (unionSet[id] != id) {
            unionSet[id] = unionSet[unionSet[id]];
            id = unionSet[id];
        }
        return i;
    }
    // WeightedQuickUnion
    public int union(int root1, int root2, int[] unionSet, int[] size) {
        if (size[root1] < size[root2]) {
            unionSet[root1] = root2;
            size[root2] += size[root1];
            //size[root1] = size[root2];
            return root2;
        } else {
            unionSet[root2] = root1;
            size[root1] += size[root2];
            //size[root2] = size[root1];
            return root1;
        }
    }
    
    private boolean isValid( int x , int y , int row , int col){
        return x >=0 && x < row && y >= 0 && y < col;
    }
}
```
