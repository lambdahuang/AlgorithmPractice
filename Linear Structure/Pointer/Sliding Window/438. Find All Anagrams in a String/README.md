I used the sliding windows to keep tracking on the numbers of all characters.


```
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new LinkedList();
        if(s.length() < p.length()) return ret;
        char[] arr = s.toCharArray();
        int[] map = new int[26];
        for(int i = 0; i < p.length(); i ++) map[p.charAt(i) - 'a'] ++;
        for(int i = 0; i < p.length(); i ++) map[s.charAt(i) - 'a'] --;
        if(checkMap(map)) ret.add(0);
        for(int i = p.length(); i < s.length(); i++)
        {
            map[arr[i-p.length()] - 'a'] ++;
            map[arr[i] - 'a'] --;
            if(checkMap(map)) ret.add(i-p.length() + 1);
        }
        return ret;
    }
    public boolean checkMap(int[] map)
    {
        for(int i = 0; i < map.length; i ++)
            if(map[i] > 0) return false;
        return true;
    }
}
```
