class Solution {
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        HashMap<Integer, Integer> hm = new HashMap();
        int max = 0;
        for(String s : arr)
        {
            String[] elem = s.split("\t");
            String filename = elem[elem.length-1];
            int depth = elem.length-1;
            hm.put(depth, filename.length());
            if(filename.indexOf('.') >= 0)
            {
                int len = 0;
                for(int i = 0; i <= depth; i ++)
                {
                    len += 1 + hm.get(i);
                }
                max = Math.max(max, len - 1);
            }
        }
        return max;
    }
    
}
