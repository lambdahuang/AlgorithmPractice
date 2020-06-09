# [809. Expressive Words](https://leetcode.com/problems/expressive-words/)

```java
class Solution {
    class CharMapElement {
        int n;
        char c;
        public CharMapElement(int N, char C){
            this.n = N;
            this.c = C;
        }
    }
    public int expressiveWords(String S, String[] words) {
        HashMap<Integer, CharMapElement> shm = getCharMap(S);
        int ret = 0;
        for(String s: words) {
            HashMap<Integer, CharMapElement> thm = getCharMap(s);
            if(thm.size() != shm.size()) continue;
            boolean matched = true;
            for(int i = 0; i < thm.size(); i ++) {
                CharMapElement el = thm.get(i);
                CharMapElement sl = shm.get(i);
                if(el.c == sl.c && el.n == sl.n)
                    continue;
                else if(el.c == sl.c && sl.n > el.n && sl.n >= 3)
                    continue;
                else {
                    matched = false;
                    break;
                }
            }
            if(matched) ret ++;
        }
        return ret;
    }
    public HashMap<Integer, CharMapElement> getCharMap(String x) {
        HashMap<Integer, CharMapElement> hm = new HashMap<>();
        for(int i = 0, j = 0, l = 0; i <= x.length(); i ++) {
            if(i == x.length() || (i > 0 && x.charAt(i) != x.charAt(i-1))) {
                hm.put(j++, new CharMapElement(i - l, x.charAt(i-1)));
                l = i;
            }
        }
        return hm;
    }
}
```

## 2020/06/09

Very straight forward solution.

```java
class Solution {
    public int expressiveWords(String S, String[] words) {
        int ret = 0;
        for (String word : words) {
            if (isStretchy(S, word)) ret ++;
        }
        return ret;
    }

    public boolean isStretchy(String s, String w) {
        int i = 0;
        int j = 0;
        while(i < s.length() && j < w.length()) {
            String groupS = getGroup(s, i);
            String groupW = getGroup(w, j);
            int gap = groupS.length() - groupW.length();

            if(!groupS.contains(groupW) || (!groupS.equals(groupW) && groupS.length() < 3))
                return false;

            i += groupS.length();
            j += groupW.length();
        }
        return i == s.length() && j == w.length();
    }

    public String getGroup(String x, int start) {
        int i = 0;
        for (i = start + 1; i < x.length() && x.charAt(i) == x.charAt(i-1); i ++);
        return x.substring(start, i);
    }
}
```
