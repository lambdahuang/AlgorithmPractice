[151. Reverse Words in a String]()

```
public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return s;
        String[] arr = s.split(" ");
        StringBuilder ans = new StringBuilder();
        if(arr.length == 0) return "";
        for(String x : arr)
        {
            if(x.length() == 0) continue;
            ans.insert(0, " ");
            ans.insert(0, x);
        }
        if(ans.length() > 0)
            ans.setLength(ans.length() - 1);
        return ans.toString();
    }
}
```
