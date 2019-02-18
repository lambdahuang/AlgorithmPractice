[308. Range Sum Query 2D - Mutable](https://leetcode.com/problems/range-sum-query-2d-mutable/)

Very simple DP question, but beware of the boundry
```
class NumMatrix {
    int[][] map;
    int[][] m;
    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        m=matrix;
        map = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < map.length; i ++){
            for(int j = 0; j < map[0].length; j ++)
            {
                int leftBox = (j-1>=0)?map[i][j-1]:0;
                int upBox = (i-1>=0)?map[i-1][j]:0;
                int upleftBox = (i-1>=0&&j-1>=0)?map[i-1][j-1]:0;
                map[i][j] = upBox + leftBox - upleftBox + matrix[i][j];
                //System.out.print(map[i][j] + " ");
            }
            //System.out.println("");
        }
    }
    public void update(int row, int col, int val) {
        if(m == null) return;
        int diff = val - m[row][col];
        m[row][col] = val;
        for(int i = row; i < map.length; i ++)
            for(int j = col; j < map[0].length; j ++)
                map[i][j] += diff;

        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(m == null) return 0 ;
        if(row1<0 || col1<0 || row2>=m.length || col2>=m[0].length) return 0;
        int upperBox = row1-1>=0?map[row1-1][col2]:0;
        int lefterBox = col1-1>=0?map[row2][col1-1]:0;
        int lefterupperBox = row1-1>=0 && col1-1>=0?map[row1-1][col1-1]:0;

        return map[row2][col2] - upperBox - lefterBox + lefterupperBox;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
```
