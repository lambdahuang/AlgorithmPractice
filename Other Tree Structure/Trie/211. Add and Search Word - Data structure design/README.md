[211. Add and Search Word - Data structure design](https://leetcode.com/problems/add-and-search-word-data-structure-design/)

Trie would be the optimal solution.

```
class WordDictionary {
    class Trie {
        public Trie[] entrence = new Trie[26];
        public String s;
        public Trie(String _s)
        {
            this.s = _s;
        }
    }
    Trie main = new Trie("");
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie tmp = main;
        for(int i = 0; i < word.length(); i ++)
        {
            char c = word.charAt(i);
            if(tmp.entrence[c-'a'] != null) 
                tmp = tmp.entrence[c-'a'];
            else
            {
                tmp.entrence[c-'a'] = new Trie("");
                tmp = tmp.entrence[c-'a'];
            }
        }
        tmp.s = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return DFS(word, 0, main);
    }
    
    private boolean DFS(String word, int index, Trie node)
    {
        if(index == word.length()){
            if(node.s.length() != 0) return true; else return false;
        }
        if(word.charAt(index) == '.')
        {
            for(Trie en : node.entrence)
                if(en != null && DFS(word, index + 1, en)) return true;
            return false;
        }
        else
            if(node.entrence[word.charAt(index) - 'a'] != null && DFS(word, index + 1, node.entrence[word.charAt(index) - 'a']))
                return true;
            else 
                return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
```
