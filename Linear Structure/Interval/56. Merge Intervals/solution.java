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
    public List<Interval> merge(List<Interval> intervals) {
        int[] begins = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        
        List<Interval> ret = new LinkedList();
        for(int i = 0; i < intervals.size(); i ++)
        {begins[i] = intervals.get(i).start; ends[i] = intervals.get(i).end;}
        Arrays.sort(begins);
        Arrays.sort(ends);
        int l = 1;
        int r = 0;
        while(l <= begins.length)
        {
            if(l < begins.length && begins[l] <= ends[l - 1])
            {
                l++;
            }
            else
            {
                ret.add(new Interval(begins[r], ends[l - 1]));
                r = l;
                l++;
            }
        }
        
        return ret;
    }
}
