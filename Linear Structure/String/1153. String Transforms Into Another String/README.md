[1153. String Transforms Into Another String](https://leetcode.com/problems/string-transforms-into-another-string/)

The trick is to be careful when handling cycling in character replacement.

When the character are less, cycling mapping relationships can be fixed by replace a character to non-existent character. For example, in the case from `abc` to `bca`, we can replace `a` to `d`. After that, we can safely perform `c->a`, `b->c`, and finally `d->b`.

However, this strategy will fail if the destination characters in mappings are full already.
In this case, we cannot use non-existent character anymore.

Therefore, it will be fail if we find the destination characters are `a-z`, which means there must be a loop somewhere, except the case when two strings are exactly the same.

```java
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        Character[] mappings = new Character[26];
        for (int i = 0; i < str1.length(); i++) {
            if(true) {
                if(mappings[str1.charAt(i)-'a'] == null) {
                    mappings[str1.charAt(i)-'a'] = str2.charAt(i);
                } else if (!mappings[str1.charAt(i)-'a'].equals(str2.charAt(i))){
                    return false;
                }
            }

        HashSet<Character> hs = new HashSet();
        for (int i = 0; i < 26; i ++) {
            if(mappings[i] != null)hs.add(mappings[i]);
        }

        return hs.size() != 26;
    }
```