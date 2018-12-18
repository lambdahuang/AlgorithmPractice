

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> hs = new HashSet();
        HashMap<String, Integer> hm = new HashMap();
        for(String s : banned) hs.add(s.toLowerCase());
        String[] arr = paragraph.toLowerCase().split(" |!|\\?|'|,|;|\\.");
        String freWord = null;
        int frequence = 0;
        for(String s : arr)
        {
            if(s.length() == 0 || hs.contains(s)) continue;
            int tmp = hm.getOrDefault(s, 0) + 1;
            hm.put(s, tmp);
            if(tmp > frequence)
            {
                frequence = tmp;
                freWord = s;
            }
        }
        return freWord;
    }
}
