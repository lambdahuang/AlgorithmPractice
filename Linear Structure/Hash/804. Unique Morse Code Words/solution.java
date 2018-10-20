class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> hs = new HashSet();
        for(String word : words)
        {
            StringBuilder sb = new StringBuilder();
            for(char c : word.toCharArray()v) sb.append(morses[c-'a']);
            String tmp = sb.toString();
            if(!hs.contains(tmp)) hs.add(tmp);
        }
        return hs.size();
    }
}
