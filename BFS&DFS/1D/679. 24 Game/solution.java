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
