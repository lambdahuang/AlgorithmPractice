class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S.toUpperCase().replace("-", ""));
        int length = sb.length();
        for(int i = length - K; i > 0; i -= K) sb.insert(i, '-');
        return sb.toString();
        
    }
}
