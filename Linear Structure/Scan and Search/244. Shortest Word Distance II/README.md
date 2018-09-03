[244. Shortest Word Distance II](https://leetcode.com/problems/shortest-word-distance-ii/description/)

You can use HashMap to aggregate data.
Given two words, we need to know positions of these two words in the word array.
In finding the related positions, we better to use hashmap where the keys are words and the values are sest of postiions of which corresponding words are at in the array.

By using hashmap, we can convert two words to two sets of numerical positions. We now need to find the shortest distance between two sets.

There are three strategies to do that:

1. The vanilla method would be comparing each elements from two sets and find the minimum difference.

The time complexity would be O(n^2) (n is the size of set)

2. You can also do the prunning on the top of the first method which is you slide two points each pointing to a set, making the movement of points only giving you the smaller minimum value.
A really important reason this method would work is that the element in set is in an increasing order as you put them into the set.

The time complexity would be O(n)

3. You can use treemap which gives the cloeset elements of a given value.

The time complexity would be O(nlgn)

```
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
```

