Don't try to find a solution that solves this question only relying on math.

You have to go handle task by task.

```
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char task : tasks) map[task - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue(26, Collections.reverseOrder());
        for(int i: map) if(i != 0) pq.offer(i);
        int time = 0;
        while(!pq.isEmpty())
        {
            List<Integer> lst = new ArrayList(26);
            int tmp = n;
            while(tmp >= 0)
            {
                if(!pq.isEmpty())
                {
                    int head = pq.poll();
                    if(head > 1) lst.add(head - 1);
                }
                else if(lst.size() == 0)
                    break;
                time ++;
                tmp --;
            }
            for(int i : lst)
                pq.add(i);
        }

        return time;
    }
}
```
