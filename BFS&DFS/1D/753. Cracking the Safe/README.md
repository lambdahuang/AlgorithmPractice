[753. Cracking the Safe](https://leetcode.com/problems/cracking-the-safe/)

This is a combination lock question
To solve the question, you need to first take a look the [De Bruijn Sequence](https://en.wikipedia.org/wiki/De_Bruijn_sequence) 

A de Bruijn sequence of order n on a size-k alphabet A is a *cyclic* sequence in which every possible length-n string on A occurs exactly once as a substring (i.e., as a contiguous subsequence). Such a sequence is denoted by B(k, n) and has length `k^n`, which is also the number of distinct substrings of length n on A.

There are two important information we can found from this statement: 

1. the sequence is cyclic which means that you can start from anywhere in the sequence to construct the string.

2. the length of the sequence is `k^n`

With these two pre-conditions, we can transform this question into a graph traversing question.

Eventually, we use DFS to try all possible solutions until we find the hamiltonian path, from a starting point given by us, traversing all n-length strings in such sequence.

```
class Solution {
    // Using Trie to create prefix tree and log(n) to find the prefix
    
    public String crackSafe(int n, int k) {
        String start = String.join("", Collections.nCopies(n, "0"));
        StringBuilder sb = new StringBuilder();
        HashSet<String> hs = new HashSet();
        sb.append(start);
        hs.add(start);
        DFS(sb, hs, (int)Math.pow(k, n), n, k);
        return sb.toString();
    }
    public boolean DFS(StringBuilder sb, HashSet<String> hs, int target, int n, int k)
    {
        if(hs.size() == target) return true;
        String prefix = sb.substring(sb.length() - n+1);
        for(char c = '0'; c < (char)('0' + k); c++)
        {
            String tmp = prefix + c;
            if(hs.contains(tmp)) continue;
            sb.append(c);
            hs.add(tmp);
            if(DFS(sb, hs, target, n, k))
                return true;
            sb.setLength(sb.length() - 1);
            hs.remove(tmp);
        }
        return false;
    }
}
```
