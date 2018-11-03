[93. Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/)

The challenge is that you need to find all edge cases such as:
00.xxx.xxx.xxx
010.xxx.xxx.xxx

This code does not pruning which is bad, you can try yourself : )

```
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new LinkedList();
        DFS(s, 0, 0, new StringBuilder(), ans);
        return ans;
    }

    public int DFS(String s, int index, int depth, StringBuilder sb, List<String> ans)
    {
        if(depth == 4)
        {
            if(index != s.length()) 
                return 0;
            else
                ans.add(sb.toString().substring(0, sb.length() - 1));
        }
        else
        {
            for(int i = 1; i <= 3 && index + i <= s.length(); i ++)
            {
                String tmp = s.substring(index, index + i);
                int restlen = s.length() - index - i;
                if(helper(tmp) && restlen >= (3-depth) && restlen <= (3-depth)*3)
                {
                    sb.append(tmp);
                    sb.append('.');
                    DFS(s, index + i, depth + 1, sb, ans);
                    sb.setLength(sb.length() - tmp.length() - 1);
                }
            }
        }
        return 0;
    }
    public boolean helper(String s)
    {
        int x = Integer.valueOf(s);
        if(s.charAt(0) == '0' && x > 0) 
            return false;
        if(x == 0 && s.length() > 1)
            return false;
        return x < 256 && x >= 0;
    }
}
```
