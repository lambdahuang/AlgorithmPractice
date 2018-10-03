[636. Exclusive Time of Functions](https://leetcode.com/problems/exclusive-time-of-functions/solution/)

```
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        if(logs.size() == 0) return ans;
        // It feeals that this question would need stack
        // will the input always valid? Say A start at 0 and B start at 1, then later, A end at 3 and B end at 4.
        // How to keep the state of each task? It seems that the array is enough to do this.
        int current_task = -1;
        int time_stamp = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for(String log : logs)
        {
            // we iterate the log
            String[] elem = log.split(":");
            int id = Integer.valueOf(elem[0]);
            int ts = Integer.valueOf(elem[2]);
            boolean isStart = elem[1].equals("start")?true:false;
            if(isStart)
            {
                if(current_task != -1) 
                {
                    // process last task
                    ans[current_task] += ts-time_stamp; //update running time
                    dq.addLast(current_task);
                }
                current_task = id;
                time_stamp = ts;
            }
            else
            {
                    
                ans[current_task] += ts-time_stamp+1;
                if(!dq.isEmpty())
                {
                    int p_id = dq.removeLast();
                    current_task = p_id;
                }
                else
                    current_task = -1;
                time_stamp = ts+1;
            }
            
        }
        // let's make some test case;
        // 0:start:0, 1:start:2, 1:end:5, 0:end:10
        return ans;
    }
}
```
