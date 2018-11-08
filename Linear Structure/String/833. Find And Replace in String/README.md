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
