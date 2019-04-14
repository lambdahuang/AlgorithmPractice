[679. 24 Game](https://leetcode.com/problems/24-game/)

Intead of calculating one number at each level of recursion, we process two, and then, put back the result into a set along with unprocessed number.
By doing so, we avoid the unreachable situations like (A+B)*(C+D) which are always happend when we use the strategy of processing a number at each leve.

Another werid part I noticed is that at the second line of DFS method, if I replace the condition at return method to `Double.compare(candidates.get(0), 24) == 0`,
the program would unable to achieve some edge cases.
I guess the reason would be because, after a series of calculations, the double number can not be viewed as the 24 in the Double compare function even if it is actually close to 24.

Hard question always teach a lesson to us. The lesson I learned from this question is that you need to break the habit if you find it cannot help you reach the end. 
(In this question, I tried to solve it in the custom way which calculate a number at each level of recursion first which belief of the custom way leads me to a wrond end. SAD..)


```
class Solution {
    public boolean judgePoint24(int[] nums) {
        ArrayList<Double> candidates = new ArrayList(4);
        for(int i : nums) candidates.add((double)i);
        return DFS(candidates);
        
    }
    public boolean DFS(ArrayList<Double> candidates)
    {
        if(candidates.size() == 0) return false;
        if(candidates.size() == 1) return Math.abs(candidates.get(0) - 24) < 1e-6;
        for(int i = 0; i < candidates.size(); i ++)
            for(int j = 0; j < candidates.size(); j ++)
            {
                if(i==j) continue;
                ArrayList<Double> newCandidates = new ArrayList<>();
                // put the old one into the arraylist;
                for(int k = 0; k < candidates.size(); k++) if(k!=i&&k!=j)newCandidates.add(candidates.get(k));
                double x = candidates.get(i);
                double y = candidates.get(j);
                for(int k = 0; k < 4; k ++)
                {
                    if(k == 0) newCandidates.add(x + y);
                    else if(k == 1) newCandidates.add(x - y);
                    else if(k == 2) newCandidates.add(x * y);
                    else if(k == 3 && Double.compare(y, 0)!=0) newCandidates.add(x / y); 
                    else continue;
                    if(DFS(newCandidates)) return true;
                    newCandidates.remove(newCandidates.size() - 1);
                }
            }
        return false;
    }
    
    
}
```

4.13.2019

```
class Solution {
    public boolean judgePoint24(int[] nums) {
        Queue<List<Double>> q = new LinkedList();
        List<Double> s = new ArrayList();
        for(int i: nums) s.add((double)i);
        q.offer(s);
        while(!q.isEmpty()) {
            List<Double> tmp = q.poll();
            if(tmp.size() == 1){
                if(Math.abs(tmp.get(0) - 24.0) < 0.0000001)
                    return true; 
                else 
                    continue; 
            }
            for(int i = 0; i < tmp.size(); i ++) {
                for(int j = i; j < tmp.size(); j ++) {
                    for(int k = 0; k < 4; k ++) {
                        if(i == j) continue;
                        List<Double> n = new ArrayList(tmp.size() - 1);
                        for(int g = 0; g < tmp.size(); g ++) 
                            if(g != i && g != j)n.add(tmp.get(g));
                        n.add(operate(tmp.get(i), tmp.get(j), k));
                        q.offer(n);
                    }
                }
            }
        }
        return false;
    }
    public double operate(double a, double b, int k) {
        if(k == 0) return a + b;
        else if(k == 1) return a - b;
        else if(k == 2) return a * b;
        else return a / b;
    }
}
```
