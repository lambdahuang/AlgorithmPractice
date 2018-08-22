class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet();
        HashSet<Integer> ret = new HashSet();
        for(int x: nums1)
            hs.add(x);
        for(int x: nums2)
            if(hs.contains(x) && !ret.contains(x))
                ret.add(x);
        int[] retArr = new int[ret.size()];
        int i = 0;
        for(int x: ret)
        {
            retArr[i++] = x;
        }
        return retArr;
    }
}
