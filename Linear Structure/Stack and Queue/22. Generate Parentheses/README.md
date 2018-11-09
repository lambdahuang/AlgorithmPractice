[22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)

The solution is DFS + Stack
In each step of DFS, you can choose to either push `(` into the **stack** or pop the stack by adding `)`.
This solution can separate the status of the stack from the status of the string. 
You keep tracking the status of the stack instead of string to tell whether to add `(` or `)`.

```
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList();
        DFS(0, n, new StringBuilder(), ans);
        return ans;
    }
    public void DFS(int stack, int n, StringBuilder sb, List<String> ans)
    {
        if(n == 0) {ans.add(sb.toString()); return;}
        int len = sb.length();
        if(stack > 0)
        {
            sb.append(")");
            DFS(stack-1, n-1, sb, ans);
            sb.setLength(len);
        }
        if(stack < n)
        {
            sb.append("(");
            DFS(stack+1, n, sb, ans);
            sb.setLength(len);
        }
        return; 
    }
}
```
