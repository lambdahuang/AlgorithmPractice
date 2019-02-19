[833. Find And Replace in String]()

Use two separate spaces in solving the question, one for the original string, and another for the new string. 

```
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, String> source_map = new HashMap<>();
        HashMap<Integer, String> target_map = new HashMap<>();
        for(int i = 0; i < indexes.length; i ++)
        {
            source_map.put(indexes[i], sources[i]);
            target_map.put(indexes[i], targets[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length();)
        {
            if(source_map.containsKey(i))
            {
                String source = source_map.get(i);
                if(S.substring(i, i + source.length()).equals(source))
                {
                    sb.append(target_map.get(i));
                    i += source.length();
                    continue;
                }
            }
            sb.append(S.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
```


2019.2.19
A different approach optimized for the case that string is super long while the number of replacements is small.

```
class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, String> s= new TreeMap();
        TreeMap<Integer, String> d = new TreeMap();
        for(int i = 0; i < indexes.length; i ++) {
            s.put(indexes[i], sources[i]);
            d.put(indexes[i], targets[i]);
        }
        int i = 0;
        while(i < S.length())
        {
            Integer tmp = s.higherKey(i-1);
            int x = (tmp == null)?S.length():tmp;
            // append the non-changed area
            sb.append(S.substring(i, x));
            i = x;
            // handle the replacement
            if(tmp != null)
            {
                String source = s.get(tmp);
                if(i+source.length() <= S.length() && S.substring(i, i+ source.length()).equals(source))
                {
                    sb.append(d.get(tmp));
                    i += source.length();
                }
                else
                {
                    // take off the key
                    s.remove(tmp);
                    d.remove(tmp);
                }
                
            }
        }
        return sb.toString();
    }
}
```
