class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(int i : hand)
            tm.put(i, tm.getOrDefault(i, 0) + 1);
        int minimum = tm.firstKey();
        while(tm.size() != 0)
        {
            Integer tmp = tm.firstKey();
            Integer pre = null;
            for(int i = 0; i < W; i++)
            {
                if(tmp == null || (pre != null && !tmp.equals(pre+1)))
                    return false;
                if(tm.get(tmp) == 1)
                    tm.remove(tmp);
                else
                    tm.put(tmp, tm.get(tmp) - 1);
                pre = tmp;
                tmp = tm.higherKey(tmp);
            }
        }
        return true;
    }
}
