class Solution {
    public String intToRoman(int num) {
        int[] roman_num = new int[]{1000, 500, 100, 50, 10, 5, 1};
        char[] roman_char = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        StringBuilder sb = new StringBuilder();
        int remain = num;
        for(int i = 0; i < roman_num.length; i ++)
        {
            int tmp = remain / roman_num[i];
            remain -= tmp * roman_num[i];
            for(int j = 0; j < tmp; j++) sb.append(roman_char[i]);

            if(i % 2 == 0 && roman_num.length - i > 2 && (remain + roman_num[i + 2])/roman_num[i]==1)
            {
                remain -= roman_num[i] - roman_num[i + 2];
                sb.append(roman_char[i+2]);
                sb.append(roman_char[i]);
            }
            else if(i % 2 == 1 && roman_num.length - i > 1 && (remain + roman_num[i + 1])/roman_num[i]==1)
            {
                remain -= roman_num[i] - roman_num[i + 1];
                sb.append(roman_char[i+1]);
                sb.append(roman_char[i]);
            }
        }
        return sb.toString();
    }
}
