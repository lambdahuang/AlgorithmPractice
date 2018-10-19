class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] ans = new int[A.length];
        HashMap<Integer, List<Integer>> hm = new HashMap();
        for(int i = 0; i < B.length; i ++)
        {
            List<Integer> lst = hm.getOrDefault(B[i], new LinkedList());
            lst.add(i);
            hm.put(B[i], lst);
        }
        for(int i = 0; i < A.length; i++)
        {
            List<Integer> lst = hm.get(A[i]);
            ans[i] = lst.get(0);
            lst.remove(0);
        }
        return ans;
    }
}
