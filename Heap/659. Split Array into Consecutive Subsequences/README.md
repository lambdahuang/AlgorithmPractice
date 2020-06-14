#[659. Split Array into Consecutive Subsequences](https://leetcode.com/problems/split-array-into-consecutive-subsequences/)

Every element from left to right will be "joined" with a smaller element if it is possible.
The joining priority is defined as follows:

For an element X,

1. If there is a single element X-1 in the list, then we join X with X-1 to form an consecutive array.

2. If there are multiple one, we should prioritize the joining based on the initial element of the consecutive subarray.

After processing all elements from the smallest to the largest following this logic: we try to see the generated subarray whether or not all contain more than 3 elements.

```java
class Solution {
    public class PQNode {
        public int index;
        public int value;
        public PQNode(int index_, int value_) {
            index = index_;
            value = value_;
        }
    };
    public boolean isPossible(int[] nums) {
        int[] mappings = new int[nums.length];
        int[] stats = new int[nums.length];
        for (int i = 0; i < mappings.length; i ++) mappings[i] = i;
        
        PriorityQueue<PQNode> pq = new PriorityQueue<PQNode>(
            (x, y) -> (x.value == y.value? (y.index - x.index):(x.value - y.value))
        );
        for (int i = 0; i < nums.length; i ++) {
            while(!pq.isEmpty() && pq.peek().value < nums[i]-1) {
                pq.poll();
            }
            if (pq.isEmpty()) {
                pq.add(new PQNode(mappings[i], nums[i]));
                stats[i] ++;
            } else {
                PQNode tmp = pq.peek();

                if (tmp.value == nums[i]-1) {
                    pq.poll();
                    pq.add(new PQNode(mappings[tmp.index], nums[i]));
                    stats[mappings[tmp.index]] ++;
                    mappings[i] = mappings[tmp.index];
                } else {
                    pq.add(new PQNode(mappings[i], nums[i]));
                    stats[mappings[i]] ++;
                }
                // System.out.println(i + " - " + tmp.index + " - " + tmp.value + " - " + mappings[tmp.index]);
            }
        }
        
        for (int i = 0; i < stats.length; i ++) {
            // System.out.print(stats[i] + " ");

            if (stats[i] > 0 && stats[i] < 3) return false;
        }
        // System.out.println("");

        return true;
    }

}
```