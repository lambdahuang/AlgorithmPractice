[824. Goat Latin](https://leetcode.com/problems/goat-latin/description/)

Used the `StringBuilder` to construct the string.

The rest of things are pretty straight forward solution.

```
class Solution {
    public String toGoatLatin(String S) {
        if(S.length() == 0) return S;
        String[] arr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i ++)
        {
            if(checkVowel(arr[i]))
            {
                sb.append(arr[i]);
            }
            else
            {
                sb.append(arr[i].substring(1, arr[i].length()));
                sb.append(arr[i].charAt(0));
            }
            sb.append("ma");
            for(int j = 0; j <= i; j++) sb.append('a');
            if(i != arr.length - 1) sb.append(' ');
        }
        return sb.toString();
    }
    public boolean checkVowel(String s)
    {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char c : vowels) if(s.charAt(0) == c) return true;
        return false;
    }
}
```
