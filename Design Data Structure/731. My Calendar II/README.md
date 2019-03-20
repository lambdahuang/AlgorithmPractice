[731. My Calendar II](https://leetcode.com/problems/my-calendar-ii/)

This question is not tricky but be careful, you don't want to experience stupid error caused by your carelessness.

```
class MyCalendarTwo {
    int[] startA = new int[1000];
    int[] endA = new int[1000];
    int len = 0;
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
        //System.out.println("-----");
        int startI = 1;
        int endI = 0;
        //System.out.println(start + " | " + end + " len=" + len);
        while(startI < len && endI < len)
        {
            int curStart = startA[startI];
            int curEnd = endA[endI];
            //System.out.println(startI + " - " + endI);
            //System.out.println(curStart + " * " + curEnd);
            if(curStart < curEnd)
            {
                if(startI - endI == 1)
                {
                    //System.out.println(curStart + " - " + curEnd);
                    //System.out.println(start + " (-) " + end);
                    // curStart - curEnd
                    if((start <= curStart && end > curStart) ||
                       (start < curEnd && end >= curEnd) || 
                      (start >= curStart && end <= curEnd))
                        return false;
                }
                startI++;   
            }
            else
                endI++;
        }   
        startA[len] = start;
        endA[len] = end;
        len++;
        Arrays.sort(startA, 0, len);
        Arrays.sort(endA, 0, len);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
```

# Mar 20 2019

```
class MyCalendarTwo {

    int[] starts = new int[0];
    int[] ends = new int[0];
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
        int[] fStarts = new int[starts.length+1];
        int[] fEnds = new int[ends.length+1];
        for(int i = 0; i < starts.length; i ++) {
            fStarts[i] = starts[i];
            fEnds[i] = ends[i];
        }
        fStarts[fStarts.length-1] = start;
        fEnds[fStarts.length-1] = end;
        Arrays.sort(fStarts);
        Arrays.sort(fEnds);
        int s = 0;
        int e = 0;
        while(s < fStarts.length) {
            if(fStarts[s] < fEnds[e]) s ++;
            else e ++;
            if(s-e>2) return false;
        }
        starts = fStarts;
        ends = fEnds;
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
```

There would be a better way to solve this question in O(n) but I'm super lazy to write the code.
