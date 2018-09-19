class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        while(left < right)
        {
            while(left < right && !Helper(s.charAt(left))) left ++;
            while(left < right && !Helper(s.charAt(right))) right --;
            if(s.charAt(left) != s.charAt(right)) return false;
            left ++; right --;
        }
        return true;
    }
    public boolean Helper(char c)
    {
        if((c >= 'a' && c <='z') || (c >='A' && c <='Z') || (c >='0' && c <= '9')) return true;
        return false;
    }
}
