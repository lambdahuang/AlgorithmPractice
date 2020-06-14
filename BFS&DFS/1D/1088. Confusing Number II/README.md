# [1088. Confusing Number II](https://leetcode.com/problems/confusing-number-ii/)

The strategy itself is not hard: genetate the confusing number using a recursion method, however, the challenge is how to avoid trigger the boundary.

```java

    public boolean isConfusingNumber(int N) {
        int x = (int)Math.log10(N) + 1;
        char[] digits = new char[x];
        for (int i = 0, tmp = 10; i < x; i ++,tmp*=10){
            digits[i] = (char)(N % tmp);
        }
        if (x % 2 == 1) {
            if (digits[x/2] == 6 || digits[x/2] == 9) 
                return true;
            else if (checkDigit(digits[x/2]))
                return false;
        }

        int tmpR = 10;
        int tmpL = (int)Math.pow(10, x-1);
        boolean ret = false;
        for (int i = 0; i < (x / 2); i ++, tmpR *= 10, tmpL /= 10) {
            int r = (N / (tmpR / 10)) % 10;
            int l = N % (tmpL * 10)/tmpL;
            if (checkDigit(l) || checkDigit(r)) return false;
            if (checkMirror(l, r) || checkMirror(r, l)) ret = true;
        }
        return ret;
    }
    public boolean checkMirror(int l, int r) {
        if (l == 1 && r != 1) return true;
        if (l == 0 && r != 0) return true;
        if (l == 6 && r != 9) return true;
        if (l == 9 && r != 6) return true;
        if (l == 8 && r != 8) return true;
        return false;
    }
    
    public boolean checkDigit(int x) {
        if (x != 0 && x != 1 && x != 6 && x != 8 && x != 9) 
            return true;
        else
            return false;
    }
    
```