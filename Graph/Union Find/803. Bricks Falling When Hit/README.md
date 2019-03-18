[803. Bricks Falling When Hit](https://leetcode.com/problems/bricks-falling-when-hit/)

# BFS (TLE)

In doing BFS, after removal of the hited bricks, we check all other bricks starting from the roof and see if they drop or not.
```
class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] ret = new int[hits.length];
        for(int k = 0; k < hits.length; k++) {
            int[] hit = hits[k];
            if(grid[hit[0]][hit[1]] == 0) { ret[k] = 0; continue; }
            grid[hit[0]][hit[1]] = 0;
            Deque<int[]> dq = new ArrayDeque<>();
            HashSet<Integer> visited = new HashSet();
            for(int i = 0; i < grid[0].length; i ++) { 
                if(grid[0][i] == 0) continue;
                grid[0][i] += 1; dq.addFirst(new int[]{0, i}); 
            }
            while(!dq.isEmpty()) {
                int qSize = dq.size();
                for(int i = 0; i < qSize; i ++) {
                    int[] pos = dq.removeLast();
                    int id = pos[0] * 200 + pos[1];
                    if(visited.contains(id)) continue;
                    visited.add(id);
                    grid[pos[0]][pos[1]] += 1;
                    if(pos[0] > 0 && grid[pos[0]-1][pos[1]] == 1)
                        dq.addFirst(new int[]{pos[0]-1, pos[1]});
                    if(pos[0] < grid.length-1 && grid[pos[0]+1][pos[1]] == 1) 
                        dq.addFirst(new int[]{pos[0]+1, pos[1]});
                    if(pos[1] > 0 && grid[pos[0]][pos[1]-1] == 1) 
                        dq.addFirst(new int[]{pos[0], pos[1]-1});
                    if(pos[1] < grid[0].length-1 && grid[pos[0]][pos[1]+1] == 1) 
                        dq.addFirst(new int[]{pos[0], pos[1]+1});
                    
                }
            }
            for(int i = 0; i < grid.length; i ++)
                for(int j = 0; j < grid[0].length; j ++)
                    if(grid[i][j] == 1) 
                        {ret[k] ++; grid[i][j]=0;}
                    else if(grid[i][j] == 2)
                        grid[i][j] --;
        }
        return ret;
    }
}
```

# Reversed sequence and Union-Find
We can starts from the end state which all bricks already being removed. Add each removed brick back to the graph and use union find to see the weight change of the omni corner. The omni corner is a virtual idea which is being connected by all roof bricks.

'''
class Solution {
    int[] pt;
    int[] wz;
    int H = 0; // height
    int W = 0; // width
    int omni;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] ret = new int[hits.length];
        if(grid.length == 0) return ret;
        H = grid.length;
        W = grid[0].length;
        omni = H * W;
        pt = new int[H * W + 1];
        wz = new int[H * W + 1];
        for(int i = 0;i < pt.length; i ++) pt[i] = i;
        Arrays.fill(wz, 1);
        for(int i = 0; i < hits.length; i ++)
            if(grid[hits[i][0]][hits[i][1]] == 0) 
                ret[i] = -1;
            else
                grid[hits[i][0]][hits[i][1]] = 0;
        for(int i = 0; i < grid.length; i ++)
            for(int j = 0; j < grid[0].length; j ++) {
                if(i == 0 && grid[i][j] != 0) union(translate(j, i), omni);
                else if(grid[i][j] == 1){
                    if(j-1 >= 0 && grid[i][j-1] == 1) union(translate(j-1, i),  translate(j, i));
                    if(i-1 >= 0 && grid[i-1][j] == 1) union(translate(j, i-1), translate(j, i));
                }
            }
        int[] vd = {0, 1, 0, -1};
        int[] hd = {-1, 0, 1, 0};
        for(int i = hits.length - 1; i >= 0 ; i --) {
            if(ret[i] == -1) {
                ret[i] = 0;
                continue;
            } else {
                int before = wz[omni];
                grid[hits[i][0]][hits[i][1]] = 1;

                if(hits[i][0] == 0)
                    union(omni, translate(hits[i][1], hits[i][0]));

                for(int j = 0; j < 4; j++) {
                    int x = hits[i][1] + hd[j];
                    int y = hits[i][0] + vd[j];
                    if(0 <= x && x < W && 0 <= y && y < H && grid[y][x] == 1)
                        union(translate(x, y), translate(hits[i][1], hits[i][0]));
                }
                /*
                System.out.println(i + " " + before + " " + wz[omni]);
                for(int k = 0; k <= omni; k ++) 
                    System.out.print(k + "-" + pt[k] +"-" + wz[k] + " ");
                System.out.println("");
                */
                if(wz[omni] > before)
                    ret[i] = wz[omni] - before - 1;
            }
        }
        return ret;
        
    }
    public void union(int A, int B) {
        int Aroot = getRoot(A);
        int Broot = getRoot(B);
        if(Aroot == Broot) return;
        if(Aroot == omni) {
            pt[Broot] = pt[Aroot];
            wz[Aroot] += wz[Broot];
        } else if (Broot == omni){
            pt[Aroot] = pt[Broot];
            wz[Broot] += wz[Aroot];
        } else {
            pt[Aroot] = pt[Broot];
            wz[Broot] += wz[Aroot];
        }
    }
    public int getRoot(int A) {
        int tmp = A;
        while(pt[tmp] != tmp) {
            pt[tmp] = pt[pt[tmp]];
            tmp = pt[tmp];
        }
        return tmp;
    }
    public boolean find(int A, int B) {
        return getRoot(A) == getRoot(B);
    }

    public int translate(int x, int y) {
        return y * W + x;
    }
}
'''
