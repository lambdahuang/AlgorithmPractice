class Solution {
    public int longestLine(int[][] M) {
        if(M.length == 0 || M[0].length == 0) return 0;
        int[][][] map = new int[M.length][M[0].length][4];
        int mx = 0;
        for(int i = 0; i < M.length; i ++)
            for(int j = 0; j < M[0].length; j ++)
            {
                if(M[i][j] == 1)
                {
                    map[i][j][0] = ((i-1>=0)?map[i-1][j][0]:0) + 1;
                    map[i][j][1] = ((j-1>=0)?map[i][j-1][1]:0) + 1;
                    map[i][j][2] = ((i-1>=0 && j-1>=0)?map[i-1][j-1][2]:0) + 1;
                    map[i][j][3] = ((i-1>=0 && j+1<M[0].length)?map[i-1][j+1][3]:0) + 1;
                    mx = Math.max(mx, map[i][j][0]);
                    mx = Math.max(mx, map[i][j][1]);
                    mx = Math.max(mx, map[i][j][2]);
                    mx = Math.max(mx, map[i][j][3]);
                }
            }
        return mx;
    }
}
