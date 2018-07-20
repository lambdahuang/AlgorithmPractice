An interesting question. I've been aksed the same one when I interviewed with Yelp in 2016.
This question is the followup question of `252. Meeting Room`

There are various types of solutions: heap, sorting, but they all shared the same priciple which is the pruning.

Either sorting or heap helps you to handle the operation the most recently happend.

Looking into the most recently operation gives you the understand of whehter we need to assign a new room or release a room that is previously assigned.

Here is my program logic:

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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i = 0; i < intervals.length; i ++)
        {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int startP = 0;
        int endP = 0;
        int max = 0;
        while(startP < intervals.length)
        {
            if(start[startP] < end[endP])
                startP++;
            else
                endP++;
            max = Math.max(max, startP - endP);
        }
        return max;
    }
}
```
