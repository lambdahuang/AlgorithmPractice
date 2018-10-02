class Solution {
    int[] id;
    int[] sz;
    public void union(int x, int y)
    {
        int root_x = getRoot(x);
        int root_y = getRoot(y);
        if(sz[root_x] > sz[root_y])
        {
            id[root_y] = root_x;
            sz[root_x] += sz[root_y];
        }
        else
        {
            id[root_x] = root_y;
            sz[root_y] += sz[root_x];
        }
    }
    public int getRoot(int x)
    {
        while(id[x] != x)
        {
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }
    public boolean find(int x, int y)
    {
        return getRoot(x) == getRoot(y);
    }
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;
        // Create hashmap and map the string to index
        HashMap<String, Integer> hm = new HashMap();
        int words_count = 0;
        for(int i = 0; i < pairs.length; i++)
        {
            if(!hm.containsKey(pairs[i][0]))
                hm.put(pairs[i][0], words_count ++);
            if(!hm.containsKey(pairs[i][1]))
                hm.put(pairs[i][1], words_count ++);
        }
        // initialize the Union Find
        id = new int[words_count];
        sz = new int[words_count];
        for(int i = 0; i < words_count; i ++) {id[i] = i; sz[i] = 1;}
        for(String[] pair : pairs)
        {
            int x = hm.get(pair[0]);
            int y = hm.get(pair[1]);
            union(x, y);
        }
        for(int i = 0; i < words1.length; i ++)
        {
            String x = words1[i];
            String y = words2[i];
            if(x.equals(y)) continue;
            if(hm.containsKey(x) && hm.containsKey(y) && find(hm.get(x), hm.get(y))) continue;
            return false;
        }
        return true;
    }
}
