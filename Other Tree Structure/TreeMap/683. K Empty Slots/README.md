[683. K Empty Slots](https://leetcode.com/problems/k-empty-slots/description/)
# TreeMap

```
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> ts = new TreeSet();
        for(int i = 0; i < flowers.length; i ++)
        {
            int today = flowers[i];
            Integer p = ts.lower(today);
            Integer n = ts.higher(today);
            if(p != null && today-p-1 == k) return i+1;
            if(n != null && n-today-1 == k) return i+1;
            ts.add(today);
        }
        return -1;
    }
}
```

# Scan 
```
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        boolean[] map = new boolean[flowers.length];
        for(int i = 0; i < flowers.length; i++)
        {
            int index = flowers[i] - 1;
            map[index] = true;
            boolean mark = true;
            for(int j = index + 1; j < flowers.length && j < index + k + 1; j ++)
                if(map[j]) {mark = false; break;}
            if(mark && index + k + 1 < flowers.length && map[index + k + 1]) return i + 1;
            mark = true;
            for(int j = index - 1; j >= 0 && j > index - k - 1; j --)
                if(map[j]) {mark = false; break;}
            if(mark && index - k - 1 >= 0 && map[index - k - 1]) return i + 1;
        }
        return -1;
    }
}
```

2019.2.8

# TreeMap

```
class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        if(k >= flowers.length) return -1;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i = 0; i < flowers.length; i ++)
        {
            Integer higher = ts.higher(flowers[i]);
            Integer lower =  ts.lower(flowers[i]);
            if(higher != null && higher - flowers[i] - 1 == k)
                return i + 1;
            else if (lower != null && flowers[i] - lower - 1 == k)
                return i + 1;
            ts.add(flowers[i]);
        }
        return -1;
    }
}
```
