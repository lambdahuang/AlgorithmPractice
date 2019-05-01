[734. Sentence Similarity](https://leetcode.com/problems/sentence-similarity/description/)

hashmap has the function of computeIfAbsent. you may use it to replace the getOrDefault.

```
class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;
        HashMap<String, HashSet<String>> hm = new HashMap<>();
        for(String[] pair : pairs)
        {
            HashSet<String> hs1 = hm.getOrDefault(pair[0], new HashSet());
            hs1.add(pair[1]);
            hm.put(pair[0], hs1);
            
            HashSet<String> hs2 = hm.getOrDefault(pair[1], new HashSet());
            hs2.add(pair[0]);
            hm.put(pair[1], hs2);
        }
        
        for(int i = 0; i < words1.length; i ++)
        {
            if(words1[i].equals(words2[i]) || hm.getOrDefault(words1[i], new HashSet()).contains(words2[i]))
                continue;
            else return false;
        }
        return true;
    }
}
```

# 5.1.2019

It's been a while.

```
class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, List<List<String>> pairs) {
        if(words1.length != words2.length) return false;
        HashMap<String, HashSet<String>> hm = new HashMap<>();
        for(List<String> lst : pairs) {
            String a = lst.get(0);
            String b = lst.get(1);
            addPair(hm, a, b);
            addPair(hm, b, a);
        }
        for(int i = 0; i < words1.length; i ++) {
            if(words1[i].equals(words2[i]) || (hm.containsKey(words1[i]) && hm.get(words1[i]).contains(words2[i])))
                continue;
            else
                return false;
        }
        return true;
    }
    public void addPair(HashMap<String, HashSet<String>> hm, String a, String b) {
        HashSet<String> hs = hm.getOrDefault(a, new HashSet());
        hs.add(b);
        hm.put(a, hs);
    }
}
```
