class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int addon = 0;
        while(addon != 0 || i < a.length() || i < b.length())
        {
            int tmp = addon;
            if(i < a.length())
                tmp += a.charAt(a.length() - i - 1) - '0';
            if(i < b.length())
                tmp += b.charAt(b.length() - i - 1) - '0';
            if(tmp >= 2) {tmp = tmp % 2; addon = 1;} else {addon = 0;}
            sb.append(String.valueOf(tmp));
            i ++;
        }
        return sb.reverse().toString();
    }
}
