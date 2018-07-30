class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] Ad = adjacentMatrix(A);
        int[][] Bd = adjacentMatrix(B);
        int[][] ret = new int[A.length][B[0].length];
        HashMap<Integer, List<Integer>> hm = new HashMap();
        for(int i = 0; i < Bd.length; i++)
        {
            List<Integer> lst = hm.getOrDefault(Bd[i][0], new LinkedList());
            lst.add(Bd[i][1]);
            hm.put(Bd[i][0], lst);
        }
        for(int i = 0; i < Ad.length; i ++)
        {
            List<Integer> lst = hm.getOrDefault(Ad[i][1], null);
            if(lst == null) continue;
            for(int c : lst)
            {
                int Atmp = A[Ad[i][0]][Ad[i][1]];
                int Btmp = B[Ad[i][1]][c];
                ret[Ad[i][0]][c] += Atmp * Btmp;
            }
        }
        return ret;
    }
    public int[][] adjacentMatrix(int[][] x)
    {
        List<int[]> lst = new LinkedList();
        for(int i = 0; i < x.length; i ++)
            for(int j = 0; j < x[0].length; j ++)
                if(x[i][j] != 0)
                    lst.add(new int[]{i, j});
        return lst.toArray(new int[lst.size()][2]);
    }
}
