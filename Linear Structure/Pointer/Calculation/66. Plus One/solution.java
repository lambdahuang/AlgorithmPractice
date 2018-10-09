class Solution {
    public int[] plusOne(int[] digits) {
        int tmp = 1;
        for(int i = digits.length - 1; i >= 0; i --)
        {
            digits[i] += tmp;
            if(digits[i] >= 10) {tmp = 1; digits[i] = digits[i] % 10;}
            else {tmp = 0; break;}
        }
        int[] ans = digits;
        if(tmp != 0)
        {
            ans = new int[digits.length + 1];
            for(int i = 0; i < digits.length; i ++)
                ans[i+1]=digits[i];
            ans[0] = 1;
        }
        return ans;
    }
}
