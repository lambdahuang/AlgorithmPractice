[139. Word Break]()

```
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;
        boolean[] map = new boolean[s.length() + 1];
        map[0] = true;
        for(int i = 0; i < s.length(); i ++)
        {
            if(map[i] != true) continue;
            for(String x : wordDict)
            {
                if(i + x.length() > s.length()) continue;
                String tmp = s.substring(i, i + x.length());
                if(tmp.equals(x)) map[i + x.length()] = true;
            }
        }
        return map[s.length()];
    }
}
```
