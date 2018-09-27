[688. Knight Probability in Chessboard](https://leetcode.com/problems/knight-probability-in-chessboard/)

I first took the BFS to solve the question but didn't pass the memory check.
After peek the solution, I realized that DP is necessary.

One dead-end I went into was that I was trying to keep tracking each chess movement states instead of calculating probability states.

```
class Solution {
    class Coodinator
    {
        public int c;
        public int r;
        public Coodinator(int _c, int _r)
        {
            c = _c;
            r = _r;
        }
    }
    public double knightProbability(int N, int K, int r, int c) {
        if(K == 0) return 1.0;
        Deque<Integer> dqp = new ArrayDeque<>();        
        dqp.addLast(cti(r, c, N));
        double p = 0;
        int valid = 0;
        int base = (int)Math.pow(8, K);
        while(K >= 0)
        {
            int qSize = dqp.size();
            //System.out.println("----" + K);
            valid = 0;
            for(int j  = 0; j< qSize; j ++)
            {
                int i = dqp.removeFirst();
                Coodinator co = itc(i, N);
                if(!validCheck(co.r, co.c, N)) continue; else valid ++;
                //System.out.println(co.r + "," + co.c);
                if(cti(co.r-2, co.c+1, N) >= 0) dqp.addLast(cti(co.r-2, co.c+1, N));
                if(cti(co.r+2, co.c+1, N) >= 0) dqp.addLast(cti(co.r+2, co.c+1, N));
                if(cti(co.r-2, co.c-1, N) >= 0) dqp.addLast(cti(co.r-2, co.c-1, N));
                if(cti(co.r+2, co.c-1, N) >= 0) dqp.addLast(cti(co.r+2, co.c-1, N));
                if(cti(co.r-1, co.c+2, N) >= 0) dqp.addLast(cti(co.r-1, co.c+2, N));
                if(cti(co.r+1, co.c+2, N) >= 0) dqp.addLast(cti(co.r+1, co.c+2, N));
                if(cti(co.r-1, co.c-2, N) >= 0) dqp.addLast(cti(co.r-1, co.c-2, N));
                if(cti(co.r+1, co.c-2, N) >= 0) dqp.addLast(cti(co.r+1, co.c-2, N));
            }
            K --;
        }
        return (double)valid / (double)base;
    }
    public boolean validCheck(int r, int c, int N)
    {
        if(r >= 0 && r < N && c >= 0 && c < N) return true; else return false;
    }
    public int cti(int r, int c, int N)
    {
        if(validCheck(r, c , N))
            return r * N + c;
        else
            return -1;
    }
    public Coodinator itc(int i, int N)
    {
        return new Coodinator(i / N, i % N);
    }
}
```

```
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
```
