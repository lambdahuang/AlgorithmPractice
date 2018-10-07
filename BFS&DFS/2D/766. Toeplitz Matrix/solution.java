class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // Topology Traversal
        Deque<Integer> xDeque = new ArrayDeque<>();
        Deque<Integer> yDeque = new ArrayDeque<>();
        xDeque.addFirst(matrix[0].length-1);
        yDeque.addFirst(0);
        while(!xDeque.isEmpty())
        {
            int qSize = xDeque.size();
            Integer previous = null;
            for(int i = 0; i < qSize; i ++)
            {
                int x = xDeque.removeLast();
                int y = yDeque.removeLast();
                int val = matrix[y][x];
                if(y+1<matrix.length)
                {
                    xDeque.addFirst(x);
                    yDeque.addFirst(y+1);
                }
                if(y==0 && x-1>=0)
                {
                    xDeque.addFirst(x-1);
                    yDeque.addFirst(y);
                }

                //System.out.println(previous + " " + val);
                if(previous != null && !previous.equals(val))
                    return false;
                if(previous == null)
                    previous = val;
            }
        }
        return true;
    }
}
