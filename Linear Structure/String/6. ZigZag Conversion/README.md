[6. ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)


```
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        StringBuilder[] lst = new StringBuilder[numRows];
        for(int i = 0; i < lst.length; i ++)
            lst[i] = new StringBuilder();
        int peroid = numRows * 2 - 2;
        for(int i = 0; i < s.length(); i ++)
        {
            char c = s.charAt(i);
            int pos = i % peroid;
            if(pos < numRows)
                lst[pos].append(c);
            else
                lst[numRows - 1 - (pos - numRows + 1)].append(c);
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder x: lst)
            sb.append(x.toString());
        
        return sb.toString();
    }
}
```
