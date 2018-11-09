class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap();
        for(String x : strs)
        {
            char[] arr = x.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(hm.containsKey(key))
            {
                hm.get(key).add(x);
            }
            else
            {
                List<String> lst = new LinkedList();
                hm.put(key, lst);
                lst.add(x);
            }
        }
        List<List<String>> ans = new LinkedList();
        for(List<String> lst : hm.values())
        {
            ans.add(lst);
        }
        return ans;
    }
}
