[843. Guess the Word](https://leetcode.com/problems/guess-the-word/)

First of all, the question did not mentioned how to return the result.
The result should be returned by setting the wordlist to a new list of words selected from the original words list.

The solution is not seeking for the absoulte answer but just try to find a relatively better solution for it.

You may also apply entropy or other optimization solution to it.
```
class Solution {

    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<>();
            for (String w : wordlist)
                if (calculateCommonPart(guess, w) == x)
                    wordlist2.add(w);
            //wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }
    public int calculateCommonPart(String a, String b)
    {
        int ret = 0;
        for(int i = 0; i < a.length(); i++)
            if(a.charAt(i) == b.charAt(i)) ret ++;
        return ret;
    }
}
```
