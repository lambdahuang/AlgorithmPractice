class Solution {
    public String customSortString(String S, String T) {
        char[] array = T.toCharArray();
        int[] map = new int[256];
        for(int i = 0; i < T.length(); i++)
            map[T.charAt(i)] ++;
        StringBuilder sb = new StringBuilder();
        for(char c: S.toCharArray())
        {
            while(map[c] > 0){sb.append(c); map[c]--;}
        }
        for(int i = 0; i < 256; i ++)
        {
            while(map[(char)i] > 0){sb.append((char)i); map[(char)i]--;}
        }
        return sb.toString();
    }
}
