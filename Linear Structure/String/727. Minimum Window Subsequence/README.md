[727. Minimum Window Subsequence](https://leetcode.com/problems/minimum-window-subsequence/)

# Naive Solution O(MN)

The idea is simple.
We first find the substring contains T, then we reduce left boundrary of substring to find the optmized solution.

```
class Solution {
    public String minWindow(String S, String T) {
        if(!verify(T, S))
            return "";
        int left = 0;
        int right = 0;
        int[] cmap = new int[256];
        String minS = S;
        while(right <= S.length()) {
            if(verify(T, S.substring(left, right))) {
                if(right - left < minS.length()) minS = S.substring(left, right);
                left ++;
            }
            else {
                right ++;
            }
        }
        
        return minS;
    }
    public boolean verify(String t, String s) {
        int  j = 0;
        for(int i = 0; i < s.length() && j < t.length(); i ++) {
            if(s.charAt(i) == t.charAt(j)) j ++;
        }
        if(j == t.length()) return true; else return false;
    }
}
```

# Two pointer Optmized Solution

This is based on the naive solution, but we do the optimization by doing a revserve traversing to find the optmized solution.
The reverse traversing is happened if we find the substring contains T.
We start from the end of the substring, which means the end of T and end of substring is aligned. 
We then traverse back from the end to the start of T, we move pointer on S if the T[i] == S[j].
With the end aligned, we can then find the another substring from the original substring, which also contains the entire T.

In average case, this optmized version allows us to find the optmization in O(N) time.

The worst case, this method would take O(MN).


```
class Solution {
    public String minWindow(String S, String T) {
        int left = 0, right = 0;
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        String tmp = S + "x";
        while(left < S.length()) {
            if(s[left] == t[right]) {
                if(right == t.length-1) {
                    int curleft = left;
                    while(right >= 0) 
                        if(t[right] == s[left]) {right--; left --;} else left --;
                    if(curleft - left < tmp.length()) 
                        tmp = S.substring(left + 1, curleft + 1);
                    right = 0;
                    left += 2;
                }
                else {
                    left ++;
                    right ++;
                }
            } else {
                left ++;
            }
        }
        
        if(tmp.length() > S.length()) return ""; else return tmp;
    }
}
```

# DP

To solve the question with DP, we fist set up the definition to the DP vector.

DP[i][j] means T[0...i] can be contained by S[x...j] and DP[i][j] = the largest possible starting point of x.

if T[i]==S[j] then DP[i][j] = Max(DP[i][j], DP[i-1][j-1]);
else DP[i][j] = Max(DP[i][j], DP[i][j-1]);

The final code is here:
We use a boolean map to tell exploited entries from unexploited entires.

```java
class Solution {
    public String minWindow(String S, String T) {
        int[][] dp = new int[T.length()+1][S.length()+1];
        boolean[][] map = new boolean[T.length()+1][S.length()+1];
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        String ret = S + "s";
        map[0][0] = true;
        for(int j = 1; j <= s.length; j ++) {dp[0][j] = j; map[0][j] = true;}
        for(int i = 0; i < t.length; i ++) {
            for(int j = 0; j < s.length; j ++) {
                if(s[j] == t[i]) {
                    if(!map[i][j]) continue;
                    dp[i+1][j+1] = Math.max(dp[i][j], dp[i+1][j+1]);
                    map[i+1][j+1] = true;
                    if(i == t.length-1) {
                        if(j+1 - dp[i+1][j+1] < ret.length()) {
                            ret = S.substring(dp[i+1][j+1], j +1);
                        }
                    }
                } else {
                    if(!map[i][j]) continue;
                    dp[i][j+1] = Math.max(dp[i][j+1], dp[i][j]);
                    map[i][j+1] = true;
                }
                
            }
        }
        if(ret.length() > S.length())
            return "";
        else
            return ret;
    }
}
```

6/13/2020

DP

```java
class Solution {
class Solution {
    public String minWindow(String S, String T) {
        int[][] stats = new int[S.length() + 1][T.length() + 1];
        int tmp = -1;
        for (int i = 0; i < S.length(); i ++) {
            if(S.charAt(i) == T.charAt(0)) {
                tmp = i;
            }
            stats[i][0] = tmp;
        }


        for(int j = 1; j < T.length(); j ++) {
            tmp = -1;
            for (int i = j; i < S.length(); i ++){
                if(S.charAt(i) == T.charAt(j)) {
                    tmp = stats[i-1][j-1];
                }
                stats[i][j] = tmp;
            }
        }
        int start = -1;
        int len = Integer.MAX_VALUE;
        for ( int i = T.length()-1; i < S.length(); i ++) {
            if(stats[i][T.length()-1] != -1) {
                if (i - stats[i][T.length()-1] + 1 < len) {
                    start = stats[i][T.length()-1];
                    len = i-stats[i][T.length()-1] + 1;    
                }
                
            }
        }
        
        if(start != -1)
            return S.substring(start, start + len);
        else
            return "";
    }
}
}
```