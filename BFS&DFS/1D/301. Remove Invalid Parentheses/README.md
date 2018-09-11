[301. Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/description/)

This is quite interesting question, the first thing you need to solve is how to verify valid parentheses string.

# Brute-force BFS

The first solution I come up with first is to use BFS. In each round, we take one character from the string and validate it.

Once we find the validate one, we stop diverge into next level.

```
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> lst = new LinkedList();
        if(s.length()==0) {lst.add(s); return lst;}
        Queue<String> q = new LinkedList();
        HashSet<String> hs = new HashSet();
        q.add(s);
        while(!q.isEmpty())
        {
            int qsize = q.size();
            for(int n = 0; n < qsize; n ++)
            {
                String x = q.poll();
                if(isValid(x)) lst.add(x);
                for(int i = 0; i < x.length(); i ++)
                {
                    String tmp = x.substring(0, i) + x.substring(i+1);
                    if(!hs.contains(tmp)) {hs.add(tmp); q.add(tmp);}
                }
            }
            if(lst.size() != 0) break;
        }
        return lst;
    }
    public boolean isValid(String s)
    {
        if(s.length() == 0)return true;
        int count = 0;
        int[] map_p = new int[s.length()];

        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(') count ++;
            if(s.charAt(i) == ')') count --;
            if(count < 0) return false;
            map_p[i] = count;
        }
        if(count == 0)
            return true;
        else
            return false;
        
    }
    
}
```

# Two-pointer pruning
The brute-force  method is time consuming in which the time complexity would be O(2^n * n).
The following method use the same idea as the previous one, but add pruning strategy which reduce the time complexity into

```
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new LinkedList();
        DFS(ret, s, 0, 0, '(', ')');
        return ret;
    }
    public int DFS(
        List<String> ret,
        String s,
        int start_pointer,
        int safe_area,
        char delimiter_left,
        char delimiter_right)
    {
        int counter = 0;
        for(int i = start_pointer; i < s.length();  i++)
        {
            if(s.charAt(i) == delimiter_left) counter ++;
            else if(s.charAt(i) == delimiter_right) counter --;
            if(counter < 0)
            {
                // unbalanced delimiter has been found, remove from previous
                for(int j = safe_area; j <= i; j ++)
                {
                    if(s.charAt(j) == delimiter_right && 
                       (j == safe_area || s.charAt(j-1)!=delimiter_right))
                    {
                        DFS(ret, s.substring(0, j) + s.substring(j + 1), i, j, delimiter_left, delimiter_right);
                    }
                }
                return 0;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(delimiter_left == '(')
            DFS(ret, reversed, 0, 0, ')', '(');
        else
            ret.add(reversed);
        return 0;
            
    }
    
}


```
