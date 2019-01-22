[482. License Key Formatting](https://leetcode.com/problems/license-key-formatting/description/)

While using the char array is the most efficient way to solve this question, I still use the String which give the most clean code.
```
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        S = S.toUpperCase();
        int j = 1;
        boolean slash_mark = false;
        for(int i = S.length() - 1; i >= 0; i--)
        {
            char c = S.charAt(i);
            if(c != '-') {
                if(slash_mark) {sb.insert(0, '-'); slash_mark = false;}
                sb.insert(0, c);
                if(j++ % K == 0 && i != 0) slash_mark = true;
            }
        }
        return sb.toString();
    }
}
```
```
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S.toUpperCase().replace("-", ""));
        int length = sb.length();
        for(int i = length - K; i > 0; i -= K) sb.insert(i, '-');
        return sb.toString();
        
    }
}
```

# 2019.1.22
```
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if(S.length() == 0) return S;
        S = new StringBuilder(S.toUpperCase()).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(char c : S.toCharArray())
        {
            if(c=='-') continue;
            sb.append(c);
            if((i%K)==0)sb.append('-');
            i++;
        }
        if(sb.length() > 1 && sb.charAt(sb.length()-1)=='-') sb.setLength(sb.length()-1);
        return sb.reverse().toString();
        
    }
}
```
