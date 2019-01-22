[904. Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets)

```
class Solution {
    public int totalFruit(int[] tree) {
        if(tree.length <= 2) return tree.length;
        int left = 0;
        int right = 2;
        int max = 2;
        int previous_element = 0; // position of the previous different element
        if(tree[1] == tree[0]) previous_element = -1;
        while(right < tree.length)
        {
            if(tree[right] != tree[right-1])
            {
                if(previous_element != -1 && tree[right] != tree[previous_element])
                    left = previous_element + 1;
                previous_element = right - 1;
            }
            max = Math.max(max, right-left+1);
            right ++;
        }
        return max;
    }
}
```

```
class Solution {
    public int totalFruit(int[] tree) {
        if(tree.length <= 2) return tree.length;
        // Sliding window
        int index = 0;
        int last = 0;
        HashMap<Integer, Integer> posOfFr = new HashMap<>();
        int maxlen = 0;
        while(index < tree.length)
        {
            maxlen = Math.max(maxlen, index-last);
            int cur = tree[index];
            boolean seen = posOfFr.containsKey(cur);
            if( !seen && posOfFr.size() > 1)
            {
                // clean the tail
                int key = 0;
                for(Map.Entry<Integer, Integer> par : posOfFr.entrySet())
                {
                    if(par.getKey() != tree[index-1])
                    {
                        last = par.getValue() + 1;
                        key =  par.getKey();
                        break;
                    }
                }
                posOfFr.remove(key);
            }
            posOfFr.put(cur, index);
            //wSystem.out.println(index + " " + last);
            index ++;
        }
        maxlen = Math.max(maxlen, index-last);
        return maxlen;
    }
}
```
