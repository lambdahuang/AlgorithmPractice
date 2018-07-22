class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) return 0;
        char[] sa = s.toCharArray();
        int[] arr = new int[sa.length];
        for(int i = 0; i < sa.length;i ++) arr[i] = p(sa[i]);
        int[] map = new int[arr.length];
        int one = arr[0];
        if(check(one, false)) map[0] = 1; else return 0;
        if(arr.length == 1) return map[0];
        one = arr[1];
        int two = arr[0] * 10+arr[1];
        map[1] += (check(one, false)?1:0);
        map[1] += (check(two, true)?1:0); 

        for(int i = 2; i < map.length; i ++)
        {
            one = arr[i];
            two = arr[i-1]*10+arr[i];
            if(!check(one, false)  && !check(two, true))
            {
                return 0;
            }
            else
            {
                map[i] += (check(one, false)?map[i-1]:0);
                map[i] += (check(two, true)?map[i-2]:0);
            }
        }
        return map[map.length - 1];
    }
    public int p(char x)
    {
        return x - '0';
    }
    public boolean check(int n, boolean two)
    {
        return (two == false && n>=1 && n <=26) || (two == true && n >= 10 && n <= 26);
    }
}
