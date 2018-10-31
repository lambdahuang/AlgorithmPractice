[218. The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/)

```
class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new LinkedList();
        int[][] seq = new int[buildings.length * 2][2];
        for(int i = 0, j = 0; i < buildings.length; i++, j+=2)
        {
            seq[j][0] = buildings[i][0];
            seq[j][1] = buildings[i][2];
            
            seq[j+1][0] = buildings[i][1];
            seq[j+1][1] = -buildings[i][2];
        }
        Arrays.sort(seq, new Comparator<int[]>(){
            public int compare(int[] A, int[] B)
            {
                return A[0]-B[0]!=0?A[0]-B[0]:B[1]-A[1];
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer A, Integer B)
            {
                return B-A;
            }
        });
        int cur = 0;
        pq.add(0);
        for(int i = 0; i < seq.length; i ++)
        {
            int x = seq[i][0];
            int y = seq[i][1];
            if(y < 0) 
                pq.remove(-y);
            else 
                pq.add(y);
            int c = pq.peek();
            if(c != cur) {ans.add(new int[]{x, c}); cur = c;}
        }
        return ans;
    }
}
```
