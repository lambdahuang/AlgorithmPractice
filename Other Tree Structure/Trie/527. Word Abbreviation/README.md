[527. Word Abbreviation](https://leetcode.com/problems/word-abbreviation/)

# Trie

The first and last character is baseline to identify an abbreviate, so you may need to put the last character to the begining of the Trie.


```
class Solution {
    class Trie {
        HashMap<Character, Trie> entries = new HashMap<>();
        HashMap<Character, HashMap<Integer, Integer>> stats = new HashMap<>();
        boolean[] dup = new boolean[26];
        String word;
    }
    public List<String> wordsAbbreviation(List<String> dict) {
        List<String> ret = new ArrayList(dict.size());
        Trie root = new Trie();
        for(String x : dict) genTrie(root, x);
        for(String x : dict) {
            ret.add(TraverseTrie(root, x));
        }
        return ret;
    }
    public void genTrie(Trie root, String x) {
        Trie tmp = root;
        char lc = x.charAt(x.length() - 1);
        tmp.entries.putIfAbsent(lc, new Trie());
        tmp.stats.putIfAbsent(lc, new HashMap());
        tmp = tmp.entries.get(lc); 
        for(int i = 0; i < x.length()-1; i ++) {
            char c = x.charAt(i);
            tmp.entries.putIfAbsent(c, new Trie());
            tmp.stats.putIfAbsent(c, new HashMap());
            HashMap<Integer, Integer> hm = tmp.stats.get(c);

            hm.put(x.length(), hm.getOrDefault(x.length(), 0)+1);
            tmp = tmp.entries.get(c); 
        }
        tmp.word = x;
    }
    public String TraverseTrie(Trie root, String x) {
        if(x.length() <= 3) return x;
        Trie tmp = root;
        int last = 0;
        char lc = x.charAt(x.length() - 1);
        tmp = tmp.entries.get(lc); 
        for(int i = 0; i < x.length()-1; i ++) {
            char c = x.charAt(i);
            HashMap<Integer, Integer> hm = tmp.stats.get(c);
            if(hm.get(x.length()) == 1) {
                last = i;
                break;
            }
            tmp = tmp.entries.get(c); 
        }
        //System.out.println(x + " " + last);
        StringBuilder sb = new StringBuilder();
        if(x.length() - last <= 3)
            return x;
        sb.append(x.substring(0, last + 1));
        sb.append(String.valueOf(x.length() - 2 - last));
        sb.append(x.charAt(x.length() - 1));
        return sb.toString();
    }
}
```
