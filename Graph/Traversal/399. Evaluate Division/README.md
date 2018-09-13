[399. Evaluate Division](https://leetcode.com/problems/evaluate-division/description/)

Traversal problem you can use union-find, DFS, BFS.

# BFS

```
class Solution {
    HashMap<String, List<String>> hm = new HashMap();
    HashMap<String, List<Double>> weighthm = new HashMap();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {    
        double[] ret = new double[queries.length];
        for(int i = 0; i < equations.length; i ++)
        {
            String start = equations[i][0];
            String end = equations[i][1];
            double weight = values[i];
            List<String> lst = hm.getOrDefault(start, new LinkedList());
            List<Double> wlst = weighthm.getOrDefault(start, new LinkedList());
            lst.add(end);
            wlst.add(weight);
            hm.put(start, lst); weighthm.put(start, wlst);
            
            lst = hm.getOrDefault(end, new LinkedList());
            wlst = weighthm.getOrDefault(end, new LinkedList());
            lst.add(start);
            wlst.add(1/weight);
            hm.put(end, lst); weighthm.put(end, wlst);
        }
        for(int k = 0; k < queries.length; k++)
        {
            String target = queries[k][1];
            Queue<String> q = new LinkedList();
            Queue<Double> qR = new LinkedList();
            q.offer(queries[k][0]);
            qR.offer(1.0);
            HashSet<String> visited = new HashSet();
            ret[k] = -1.0;
            if(!hm.containsKey(target)) continue;
            while(!q.isEmpty())
            {
                String tmp = q.poll();
                Double tmpResult = qR.poll();
                if(visited.contains(tmp)) continue; else visited.add(tmp);
                if(tmp.equals(target)) {ret[k] = tmpResult; break;}
                if(hm.containsKey(tmp))
                {
                    List<String> lst = hm.getOrDefault(tmp, new LinkedList());
                    List<Double> wlst = weighthm.getOrDefault(tmp, new LinkedList());
                    for(int j = 0; j < lst.size(); j++)
                    {
                        q.offer(lst.get(j));
                        qR.offer(wlst.get(j) * tmpResult);
                    }
                }
            }
            
        }
        return ret;
    }
}
```
