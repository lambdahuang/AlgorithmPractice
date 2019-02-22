[642. Design Search Autocomplete System](https://leetcode.com/problems/design-search-autocomplete-system/)


```
class AutocompleteSystem {
    class Trie {
        Trie[] entries = new Trie[256];
        String sentence = null;
        int times = 0;
        int weight = 0;
    }
    Trie root = new Trie();
    Trie cur = root;
    StringBuilder sb = new StringBuilder();
    public AutocompleteSystem(String[] sentences, int[] times) {
        for(int i = 0; i < sentences.length; i ++) {
            AddTrie(sentences[i], times[i]);
        }
    }
    private void AddTrie(String s, int time)
    {
        Trie tmp = root;
        Deque<Trie> stack = new ArrayDeque<>();
        for(int j = 0; j < s.length(); j ++) {
            char c = s.charAt(j);
            tmp.entries[c] = tmp.entries[c]==null?new Trie():tmp.entries[c];
            stack.addFirst(tmp);
            tmp = tmp.entries[c];
        }
        tmp.sentence = s;
        tmp.times += time;
        while(!stack.isEmpty()) {
            tmp = stack.pollFirst();
            tmp.weight += time;
        }
    }
    private void DFS(Trie root, List<Trie> ret)
    {
        if(root == null) return ;
        if(root.sentence != null) {
            ret.add(root);
        }
        for(int i = 0; i < root.entries.length; i ++)
            DFS(root.entries[i], ret);
    }
    public List<String> input(char c) {
        List<String> ret = new LinkedList();
        if(c == '#') {
            cur = root;
            AddTrie(sb.toString(), 1);
            sb.setLength(0);
            return ret;
        }
        else {
            sb.append(c);
            if(cur!= null)
                cur = cur.entries[c];
        }
        
        List<Trie> lst = new ArrayList();
        DFS(cur, lst);
        Collections.sort(lst, new Comparator<Trie>(){
            @Override
            public int compare(Trie A, Trie B)
            {
                if(A.times != B.times)
                    return B.times - A.times;
                else
                    return A.sentence.compareTo(B.sentence);
            }
        });
        for(Trie tmp : lst)
        {
            ret.add(tmp.sentence);
            if(ret.size() == 3) break;
        }
        return ret;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
```
