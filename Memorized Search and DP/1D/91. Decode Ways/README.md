[91. Decode Ways](https://leetcode.com/problems/decode-ways/description/)

Optimal solution: **DP**

The tricky part of this question is that there is some internal logic you need to discover before writing the solution.

For example, `01` is not a legitimate case for the question, you can't simply view it as a counterpart of `1`.

The solution is using a Fibonacci-like method.

a state of map[i] can be represented by a polynomial contains variables of map[i-1] and map[i-2].

If the `nums[i]` is greater or equal than 1 and shorter and equal than 26, we add the map[i-1] to map[i]

If the `nums[i-1] * 10 + nums[i]` is greater or equal than 10 and shorter and equal than 26, we add the map[i-2] to map[i]


```

class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        char[] sa = s.toCharArray();
        int[] arr = new int[sa.length];
        for(int i = 0; i < sa.length;i ++) arr[i] = p(sa[i]);
        int[] map = new int[arr.length];
        int one = arr[0];
        if(check(one, false)) map[0] = 1; else return 0;
        if(arr.length == 1) return map[0];
        one = arr[1];
        int two = arr[0] * 10+arr[1];
        map[1] += (check(one, false)?1:0);
        map[1] += (check(two, true)?1:0);

        for(int i = 2; i < map.length; i ++)
        {
            one = arr[i];
            two = arr[i-1]*10+arr[i];
            if(!check(one, false)  && !check(two, true))
            {
                return 0;
            }
            else
            {
                map[i] += (check(one, false)?map[i-1]:0);
                map[i] += (check(two, true)?map[i-2]:0);
            }
        }
        return map[map.length - 1];
    }
    public int p(char x)
    {
        return x - '0';
    }
    public boolean check(int n, boolean two)
    {
        return (two == false && n>=1 && n <=26) || (two == true && n >= 10 && n <= 26);
    }
}

```

Although we already have the fastest solution, I still wish to shed light on some non-optimal solutions as well.

DFS `O(2^n)`
```
class Solution {
    public int numDecodings(String s) {
        if( s.length() == 0 ) return 0;
        return helper(s,0);
    }
    public int helper(String s, int index){
        int len = s.length();
        if( index == len ) return 1;
        if(s.charAt(index) == '0') return 0;
        int res = helper(s,index+1);
        if( index < len - 1 && ( s.charAt(index) == '1' || (s.charAt(index) == '2' && s.charAt(index+1) < '7'))){
            res += helper(s,index+2);
        }
        return res;
    }
}
```

Memorize DFS `O(2^n)`
```
class Solution {
    public int numDecodings(String s) {
        if( s == null || s.length() == 0 ) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        return helper(s,0,map);
    
    }
    public int helper(String s, int index, Map<Integer,Integer> map){
        if( map.containsKey(index)) return map.get(index);
        if( index == s.length() ) return 1; // see if the recursion can reach the end
        char cur = s.charAt(index);
        if( cur == '0')  return 0;
        int res = 0;
        res += helper(s,index+1,map);
        if( index < s.length() - 1 && ( cur == '1' || (cur == '2' && s.charAt(index+1) < '7'))){
            res += helper(s,index+2,map);
        }
        map.put(index,res);
        return res;
        
    }
}
```
