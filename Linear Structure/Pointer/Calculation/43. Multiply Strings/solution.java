class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        StringBuilder sb = new StringBuilder();
        sb.append("0");
        for(int i = 0; i < num1.length(); i ++)
        {
            int t = num1.charAt(i) - '0';
            for(int j = 0; j < num2.length(); j ++)
            {
                int x = num2.charAt(j) - '0';
                int r = t * x;
                AddUp(sb, i + j, r);
            }
        }
        return sb.reverse().toString();
    }

    public void AddUp(StringBuilder sb, int position, int num)
    {
        while(num!=0) {
            while(position >= sb.length()) sb.append('0');
            int cur = (position<sb.length()?(sb.charAt(position)-'0'):0) + num%10;
            sb.setCharAt(position, (char)(cur%10+'0'));
            num=num/10+cur/10;;
            position++;
        }
        
        
        
        return;
    }
}
