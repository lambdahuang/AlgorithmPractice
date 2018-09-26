class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0) return "";
        String ret = s;
        int[] tg = new int[256];
        int[] map = new int[256];
        for(char c : t.toCharArray()) tg[c] ++;
        int i = 0;
        while(i < s.length() && !isValid(tg, map)) map[s.charAt(i++)] ++;
        if(!isValid(tg, map)) return "";
        int j = 0;
        i-=1;
        map[s.charAt(i)] -= 1;
        while(i < s.length())
        {
            map[s.charAt(i)] ++;
            while(j <= i &&
                  map[s.charAt(j)]-1>=tg[s.charAt(j)]) 
            {
                map[s.charAt(j)]--;
                j++;
            }
            if(i - j + 1 < ret.length()) ret = s.substring(j, i + 1);
            i++;
        }
        return ret;
        
    }
    public boolean isValid(int[] tg, int[] map)
    {
        for(int i = 0; i < tg.length; i++)
            if(tg[i] > map[i]) return false;
        return true;
    }
}
