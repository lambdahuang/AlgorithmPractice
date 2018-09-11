class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new LinkedList();
        DFS(ret, s, 0, 0, '(', ')');
        return ret;
    }
    public int DFS(
        List<String> ret,
        String s,
        int start_pointer,
        int safe_area,
        char delimiter_left,
        char delimiter_right)
    {
        int counter = 0;
        for(int i = start_pointer; i < s.length();  i++)
        {
            if(s.charAt(i) == delimiter_left) counter ++;
            else if(s.charAt(i) == delimiter_right) counter --;
            if(counter < 0)
            {
                // unbalanced delimiter has been found, remove from previous
                for(int j = safe_area; j <= i; j ++)
                {
                    if(s.charAt(j) == delimiter_right && 
                       (j == safe_area || s.charAt(j-1)!=delimiter_right))
                    {
                        DFS(ret, s.substring(0, j) + s.substring(j + 1), i, j, delimiter_left, delimiter_right);
                    }
                }
                return 0;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if(delimiter_left == '(')
            DFS(ret, reversed, 0, 0, ')', '(');
        else
            ret.add(reversed);
        return 0;
            
    }
    
}


