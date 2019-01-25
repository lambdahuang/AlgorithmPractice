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

# 2019.1.25 
```
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, HashMap<String, Double>> edges = new HashMap<>();
        for(int i = 0; i < equations.length; i ++)
        {
            String[] equation = equations[i];
            double value = values[i];
            addToMap(equation[0], equation[1], value, edges);
            addToMap(equation[1], equation[0], 1/value, edges);
        }
        double[] ret = new double[queries.length];
        for(int i = 0; i < ret.length; i++)
        {
            //System.out.println("-----------------");
            ret[i] = DFS(queries[i][0], queries[i][1], new HashSet<String>(), edges);
        }
        return ret;
    }
    public double DFS(String source, String target, HashSet<String> visited, HashMap<String, HashMap<String, Double>> edges)
    {   
        if(!edges.containsKey(source)) return -1.0;
        if(source.equals(target)) return 1.0;
        if(visited.contains(source)) return -1.0;
        else
        {
            visited.add(source);
            HashMap<String, Double> tmp = edges.get(source);
            for(Map.Entry<String, Double> edge: tmp.entrySet())
            {
                //System.out.println(source + " - " + edge.getKey());
                double ret = DFS(edge.getKey(), target, visited, edges);
                if( ret != -1.0)
                    return ret * edge.getValue();
            }
            visited.remove(source);
        }
        
        return -1.0;
        
    }
    public void addToMap(String source,
                              String target,
                              double value,
                              HashMap<String, HashMap<String, Double>> edges)
    {
        
        if(edges.containsKey(source))
        {
            HashMap<String, Double> edge = edges.get(source);
            if(!edge.containsKey(target)) edge.put(target, value);
        }
        else
        {
            HashMap<String, Double> edge = new HashMap<String, Double>();
            edge.put(target, value);
            edges.put(source, edge);
        }
    }
}
```
