
Quite straight forward solution.

Mine solution.
```
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++)
        {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        for(int i = 0; i < end.length - 1; i ++)
            if(end[i] > start[i + 1])
                return false;
        return true;
    }
}
```

Best Practice with Lambda Function 

```
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        for(int i =0; i < intervals.length - 1 ; i++){
            if(intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
}
```
