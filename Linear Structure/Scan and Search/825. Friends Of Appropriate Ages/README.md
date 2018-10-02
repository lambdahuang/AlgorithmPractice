[825. Friends Of Appropriate Ages](https://leetcode.com/problems/friends-of-appropriate-ages/solution/)

#TreeMap
```
class Solution {
    public int numFriendRequests(int[] ages) {
        if(ages.length <=1) return 0;
        Arrays.sort(ages);
        int[] map = new int[ages.length];
        TreeMap<Integer, Integer> tm_lower_bound = new TreeMap();
        TreeMap<Integer, Integer> tm_higher_bound = new TreeMap();
        for(int i = 0; i < ages.length;i ++)
            if(i == 0 || ages[i] != ages[i-1])
                tm_lower_bound.put(ages[i], i);
        for(int i = ages.length-1; i >= 0;i --)
            if(i == ages.length-1 || ages[i] != ages[i+1])
                tm_higher_bound.put(ages[i], i);
        for(int i = 0; i < ages.length; i ++)
        {
            if(i == 0 || ages[i]!=ages[i-1])
            {
                int lowerBound = (int)(ages[i] *0.5+7);
                int higherBound = ages[i];
                Integer tmp;
                tmp = tm_lower_bound.higherKey(lowerBound);
                int indexLowerBound = tm_lower_bound.get(tmp);
                int indexHigherBound = tm_higher_bound.get(ages[i]);
                map[i] = Math.max(indexHigherBound - indexLowerBound, 0);
                //System.out.println(i + " " + map[i]);
            }
            else
            {
                map[i] = map[i-1];
            }
        }
        int count = 0;
        for(int x: map) count+=x;
        return count;
    }
}
```
