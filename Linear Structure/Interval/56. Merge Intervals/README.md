[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/description/)

This question is a variant of the [meeting room question](https://github.com/lambdahuang/AlgorithmPractice/tree/master/Linear%20Structure/Interval/253.%20Meeting%20Rooms%20II)

However, this one has some detail different from the meeting room. 
In the meeting room question, you are looking for the max the distance between the pointer on the end array and the ponter on the start array. 

In this question, all movements of the start ponter means you actually merged two intervals. Therefore, once the start pointer stop moving you gonna create the merged interval.


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
```

And also, I noticed that there is another interesting solution which views each intervals as nodes, and views the overlapping relationships as links, so basically you can solve this question using a map traversal strategy.
