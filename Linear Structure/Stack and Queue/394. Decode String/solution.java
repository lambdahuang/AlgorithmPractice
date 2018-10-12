class Solution {
    public String decodeString(String s) {
        if(s.length() == 0) return s;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i < s.length())
        {
            if(isNumber(s.charAt(i)))
            {
                int start = i;
                while(i < s.length() && isNumber(s.charAt(i))) i++;
                int repeat = Integer.valueOf(s.substring(start, i));
                int stack = -1;
                i++;
                start = i;
                while(i < s.length() && stack < 0)
                {
                    if(s.charAt(i) == '[')
                        stack --;
                    else if(s.charAt(i) == ']')
                        stack ++;
                    i++;
                }
                String compo = decodeString(s.substring(start, i-1));
                for(int j = 0; j < repeat; j ++) sb.append(compo);
            }
            else
            {
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
    public boolean isNumber(char c)
    {
        return c >= '0' && c <= '9'? true : false;
    }
}
