Pretty straight forward solution: DFS.

```
class Solution {
    char[][] map = new char[][]{
        {' '},
        {'*'},
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        List<String> ret = new LinkedList();
        if(digits.length() == 0) return ret;
        DFS(ret, digits.toCharArray(), 0, new StringBuilder());
        return ret;
    }
    public int DFS(List<String> ret, char[] digits, int index, StringBuilder sb)
    {
        if(index == digits.length)
        {
            ret.add(sb.toString());
            return 0;
        }
        char[] curMap = map[digits[index] - '0'];
        for(char x : curMap)
        {
            sb.append(x);
            DFS(ret, digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        return 0;
    }
}
```

Although I noticed that there is a BFS soluition as well, but I do think that the DFS method is better for understanding.
Here is the BFS soluton:

```
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if ( digits == null || digits.length() == 0 ) return res;
        res.add("");
        String[] keys = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] nums = digits.toCharArray();
        for(int i = 0 ;i < nums.length ; i++){
            int num = nums[i] - '0';
            List<String> list = new ArrayList<>();
            String cur = keys[num];
            for( int j = 0 ; j < cur.length(); j++ ){
                for( String str : res ){
                    list.add(str + cur.charAt(j));
                }
            }
            res = list;
        }
        return res;
    }
}
```

I do wish to emphasize the importance of the algorithm analysis.

The time complexity of this algorithm is O([2~3]^n)
