class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph.length == 0) return true;
        HashSet<Integer> visited = new HashSet();
        Queue<Integer> q = new ArrayDeque();
        HashSet<Integer> A = new HashSet();
        HashSet<Integer> B = new HashSet();
        int j = 0;
        while(j < graph.length)
        {    
            //System.out.println(j);
            q.offer(j);
            A.add(j);
            boolean ret = true;
            int currentVisited = 0;
            boolean mark = true;
            while(!q.isEmpty())
            {
                int qSize = q.size();
                for(int i = 0; i < qSize; i++)
                {
                    int current = q.poll();
                    if(visited.contains(current)) continue; else visited.add(current);
                    currentVisited++;
                    if(mark && B.contains(current) || 
                       !mark && A.contains(current)) return false;
                    for(int r : graph[current])
                    {
                        q.offer(r);
                        if(mark) B.add(r); else A.add(r);
                    }
                }
                mark = !mark;
            }            
            while(j < graph.length && visited.contains(++j));
        }
        return true;
    }
}
