[929. Unique Email Addresses](https://leetcode.com/problems/unique-email-addresses/)

A standard string question. Please remember String.split(param), param is the regular expression.

```
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hs = new HashSet();
        for(String s : emails)
        {
            String[] parts = s.split("@");
            String namePart = parts[0];
            String domainPart = parts[1];
            // Process Name
            namePart = namePart.split("\\+")[0];
            namePart = namePart.replace(".", "");
            String newEmail = namePart + "@" + domainPart;
            hs.add(newEmail);
        }
        return hs.size();
    }
}
```
