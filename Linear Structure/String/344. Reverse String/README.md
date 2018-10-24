[344. Reverse String](https://leetcode.com/problems/reverse-string/)

```
class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
}
```

```
class Solution {
    public String reverseString(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length/ 2;i ++)
        {
            char tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        }
        return new String(arr);
    }
}
```
