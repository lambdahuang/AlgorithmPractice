[140. Word Break II](https://leetcode.com/problems/word-break-ii/)

# DFS: TLE

The DFS soluton cannot pass the time restriction check.
```
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ret = new LinkedList();
        HashSet<String> hs = new HashSet();
        for(String x : wordDict) hs.add(x);
        DFS(ret, s, new StringBuilder(), 0, hs);
        return ret;
    }
    public void DFS(List<String> ret, String s, StringBuilder sb, int index, HashSet<String> hs)
    {
        if(index == s.length())
        {
            ret.add(sb.toString());
            return;
        }
            
        for(int i = index+1 ; i <= s.length(); i ++)
        {
            String tmp = s.substring(index, i);
            if(hs.contains(tmp))
            {
                int len = sb.length();
                if(len == 0)
                    sb.append(tmp);
                else
                {
                    sb.append(" ");
                    sb.append(tmp);
                }
                DFS(ret, s, sb, i, hs);
                sb.setLength(len);
            }
        }
        return ;
    }
    
}
```

# DFS + DP

To use DP, we need to adjust our DFS logic to enable the state tracking capability. The state we want to keep is to find the processed space-seperated strings of the substring of `s` which is from `ith` to end. By doing so, we do not need to calculate the last part of string for multiple times.


```
class Solution {
    HashMap<Integer, List<String>> hm = new HashMap();
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> hs = new HashSet();
        for(String x : wordDict) hs.add(x);
        List<String> ret = DFS(s, 0, hs);
        return ret;
    }
    public List<String> DFS(String s, int index, HashSet<String> hs)
    {
        StringBuilder sb = new StringBuilder();
        List<String> ret = new LinkedList();
        if(index == s.length())
        {
            ret.add(sb.toString());
            
        }
        else if(hm.containsKey(index))
        {
            return hm.get(index);
        }
        else
        {
            for(int i = index+1 ; i <= s.length(); i ++)
            {
                String tmp = s.substring(index, i);
                if(hs.contains(tmp))
                {
                    int len = sb.length();
                    sb.append(tmp);
                    
                    List<String> temp = DFS(s,i, hs);
                    int tempLen = sb.length();
                    for(String x : temp)
                    {
                        if(x.length() != 0)
                            sb.append(" ");
                        sb.append(x);
                        ret.add(sb.toString());
                        sb.setLength(tempLen);
                    }
                    sb.setLength(len);
                }
            }
        }
        hm.put(index, ret);
        return ret;
    }   
}
```
