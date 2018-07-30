[278. First Bad Version](https://leetcode.com/problems/first-bad-version/description/)

Pretty simple and straight forward solution.

The only thing you might need to take care is that if a version is good you could simply jump to the next one, but if a version is bad you still have to keep eye on it because it still can be the last bad version.



```
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while(start < end - 1)
        {
            int mid = start / 2 + end / 2;
            if(isBadVersion(mid) == false)
            {
                start = mid + 1;
            }
            else
            {
                end = mid;
            }
        }
        if(isBadVersion(start)==false) return end; else return start;
    }
}
```
