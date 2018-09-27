class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] steps = {{-2,1},{-2,-1},{2,1},{2,-1},{1,-2},{1,2},{-1,2},{-1,-2}};
        double[][] map = new double[N][N];
        map[r][c] = 1;
        for(;K > 0; K--)
        {
            double[][] nmap = new double[N][N];
            for(int i = 0; i < N; i++)
                for(int j = 0; j < N; j++)
                {
                    if(map[i][j] == 0) continue;
                    for(int[] step : steps)
                    {
                        int x = i + step[0];
                        int y = j + step[1];
                        if(validCheck(x, y, N)){
                            nmap[x][y] += map[x][y] + map[i][j] / 8.0;
                        }
                    }
                }
            map = nmap;
        }
        double cons = 0;
        for(double[] row : map)
            for(double entry: row)
                {cons += entry;}
        return cons;
    }
    public boolean validCheck(int r, int c, int N)
    {
        if(r >= 0 && r < N && c >= 0 && c < N) return true; else return false;
    }

}
