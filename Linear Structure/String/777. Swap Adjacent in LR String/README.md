[777. Swap Adjacent in LR String](https://leetcode.com/problems/swap-adjacent-in-lr-string/)

1. Make sure the sequence of the string with only R and L are the same between start and end.
2. Make sure the each R in the end string can be mapped to a R in start string which is at the same or on the left in start string.
3. We check the L in the similar way to 2


```
class Solution {
    public boolean canTransform(String start, String end) {
        if(!start.replace("X", "").equals(end.replace("X", "")))
           return false;
        int l = 0;
        int r = 0;

        int Rsign = 0;
        int Lsign = 0;
        while(l < start.length() || r < end.length())
        {
            if(l < start.length())
            {
                if(start.charAt(l) == 'R') Rsign ++;
                if(start.charAt(start.length() - 1 - l) == 'L') Lsign ++;
                l ++;
            }
            if(r < end.length())
            {
                if(end.charAt(r) == 'R') Rsign --;
                if(end.charAt(end.length() - 1 - r) == 'L') Lsign --;
                r ++;
            }
            if(Rsign < 0) return false;
            if(Lsign < 0) return false;
        }
        return true;
    }
}
```
