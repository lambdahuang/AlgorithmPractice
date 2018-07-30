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
