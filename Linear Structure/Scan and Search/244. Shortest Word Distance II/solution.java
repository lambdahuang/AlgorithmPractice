class WordDistance {
    HashMap<String, TreeSet<Integer>> hm = new HashMap();    
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i ++)
        {
            if(!hm.containsKey(words[i]))
                hm.put(words[i], new TreeSet());
            TreeSet<Integer> tmp = hm.get(words[i]);
            tmp.add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        if(!hm.containsKey(word1) || !hm.containsKey(word2))
            return 0;
        TreeSet<Integer> st1 = hm.get(word1);
        TreeSet<Integer> st2 = hm.get(word2);
        int min_value = Integer.MAX_VALUE;
        for(Integer i : st1)
        {
            Integer lower = st2.lower(i);
            Integer higher = st2.higher(i);
            if(lower != null) min_value = Math.min(i - lower, min_value);
            if(higher != null) min_value = Math.min(higher - i, min_value);
        }
        return min_value;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
