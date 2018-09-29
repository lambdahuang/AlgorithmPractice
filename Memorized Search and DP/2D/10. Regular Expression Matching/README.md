[10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)

# DFS

```
class Solution {
    public boolean isMatch(String s, String p) {
        //System.out.println(s + " - " + p);
        if(s.length() == 0 && p.length() == 0) 
            return true;
        else 
            if(p.length() == 0) return false;
        if(p.length() >= 2 && p.charAt(1) == '*')
        {
            //System.out.println(s + " - " + p);
            for(int i = 0; i <= s.length(); i++)
            {
                if(
                    (i > 0 && (p.charAt(0) == '.' || s.charAt(i-1) == p.charAt(0)) && isMatch(s.substring(i), p.substring(2))) ||
                    (i == 0 && isMatch(s, p.substring(2)))
                ) 
                    return true;
                else if(i > 0 && !(p.charAt(0) == '.' || s.charAt(i-1) == p.charAt(0)))
                    break;
            }
        }
        else
        {
            if(p.charAt(0) == '.')
            {
                if(s.length() > 0 && isMatch(s.substring(1), p.substring(1))) return true; else return false;
            }
            else if(s.length() > 0 && s.charAt(0) == p.charAt(0) && isMatch(s.substring(1), p.substring(1)))
                return true;
        }
        
        return false;
        
    }
}
```
