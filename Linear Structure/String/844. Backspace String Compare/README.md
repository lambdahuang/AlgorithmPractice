[844. Backspace String Compare](https://leetcode.com/problems/backspace-string-compare/)

```
class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] arr1 = S.toCharArray();
        char[] arr2 = T.toCharArray();
        int arr1_len = 0;
        for(int i = 0; i < arr1.length; i++)
            if(arr1[i] == '#') arr1_len = arr1_len>0?arr1_len-1:0; else arr1[arr1_len++] = arr1[i];
        int arr2_len = 0;
        for(int i = 0; i < arr2.length; i++)
            if(arr2[i] == '#') arr2_len = arr2_len>0?arr2_len-1:0; else arr2[arr2_len++] = arr2[i];
        if(arr1_len != arr2_len) return false;
        
        for(int i = 0; i < arr1_len; i ++)
        {
            if(arr1[i] != arr2[i]) return false;
        }
            
        return true;
    }
}
```

2019.1.28
```
class Solution {
    public boolean backspaceCompare(String S, String T) {
        S = process(S);
        T = process(T);
        return S.equals(T);
    }
    public String process(String s)
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i ++)
        {
            char c = s.charAt(i);
            if(c>= 'a' && c <= 'z') sb.append(c);
            else if(sb.length() > 0)sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }
}
```
