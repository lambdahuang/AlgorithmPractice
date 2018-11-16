class Solution {
    public boolean isIsomorphic(String s, String t) {
        int index = 0;
        int[] map = new int[256];
        int[] map_reverse = new int[256];
        for(int i = 0; i < 256; i ++) {map[i] = -1; map_reverse[i] = -1;}
        for(int i = 0; i < t.length(); i ++)
        {
            if(map[s.charAt(i)] == -1 && map_reverse[t.charAt(i)] == -1) 
            {
                map[s.charAt(i)] = t.charAt(i);
                map_reverse[t.charAt(i)] = s.charAt(i);
            }
            else if(map[s.charAt(i)] != (int)t.charAt(i) || map_reverse[t.charAt(i)] != (int)s.charAt(i)) 
            {
                return false;
            }
        }
        return true;
    }
}
