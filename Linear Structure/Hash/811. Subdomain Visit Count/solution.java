class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hm = new HashMap();
        for(String s : cpdomains)
        {
            String[] arr = s.split(" ");
            int times = Integer.valueOf(arr[0]);
            String[] subdomains = arr[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for(int i = subdomains.length-1; i >= 0; i--)
            {
                sb.insert(0, subdomains[i]);
                String tmp = sb.toString();
                if(hm.containsKey(tmp))
                    hm.put(tmp, hm.get(tmp)+times);
                else
                    hm.put(tmp, times);
                sb.insert(0, ".");
            }
        }
        List<String> arr = new LinkedList();
        for(Map.Entry<String, Integer> e: hm.entrySet())
        {
            arr.add(String.valueOf(e.getValue()) + " " + e.getKey());
        }
        return arr;
    }
}
