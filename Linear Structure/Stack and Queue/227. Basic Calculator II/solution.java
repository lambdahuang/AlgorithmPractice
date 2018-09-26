class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        int ret = 0;
        Deque<Integer> operands = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        for(int i = 0, j = 0; i <= s.length(); i++)
        {
            if(i == s.length() || !isNumeric(s.charAt(i)))
            {
                int cur = Integer.valueOf(s.substring(j, i));
                operands.addLast(cur);
                if(i != s.length()) operators.addLast(s.charAt(i));
                j = i + 1;
            }
        }
        int count = 0;
        int tmp = operands.removeFirst();
        while(operators.size() != 0)
        {
            char mark = operators.removeFirst();
            if(mark == '+') {count += tmp; tmp = operands.removeFirst();}
            else if(mark == '-') {count += tmp; tmp = -operands.removeFirst();}
            else if(mark == '*') {tmp *= operands.removeFirst();}
            else if(mark == '/') {tmp /= operands.removeFirst();}
        }
        count += tmp;
        return count;
    }
    public boolean isNumeric(char c)
    {
        return (c >= '0' && c <= '9')?true: false;
    }
}
