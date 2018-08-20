class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        int mark = ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0))? 1: -1;
        long result = recur(Math.abs((long)dividend), Math.abs((long) divisor));
        //System.out.println(result);
        if(mark == -1 && result > (long)(Integer.MAX_VALUE) + 1) return Integer.MAX_VALUE;
        else if(mark == 1 && result > (long)(Integer.MAX_VALUE)) return Integer.MAX_VALUE;
        else return (int)(result * mark);
    }
    public long recur(long dividend, long divisor)
    {
        if(dividend - divisor < 0) return 0;
        long tmp = dividend;
        long di = divisor;
        long steep = 1;
        long step = 0;
        while(tmp - di >= 0)
        {
            tmp -= di;
            di += di;
            step += steep;
            steep += steep;
        }
        return recur(tmp, divisor) + step;
    }
}
