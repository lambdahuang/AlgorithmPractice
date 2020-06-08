[843. Guess the Word](https://leetcode.com/problems/guess-the-word/)

First of all, the question did not mentioned how to return the result.
The result should be returned by setting the wordlist to a new list of words selected from the original words list.

The solution is not seeking for the absoulte answer but just try to find a relatively better solution for it.

You may also apply entropy or other optimization solution to it.

```java
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

---

June 7 2020

Redo the question after a year and find the old solution does not work anymore.

At the first look, I quickly come to the solution same as I did a year ago.
Lately, I found it does not work anymore.
Looking at the official solution, I realize that there is a deeper consideration hidden behind.

In the old solution, we filter the remained candidate based on the number of matches to the tested word. Doing so leaves only the words having exactly the same number of matching characters as between tested word and the target word. After that, in the next round, we simply randomly choose one of candidate from the remained candidates. The question is: Can the randomly select word in the next round of test provide the maximum gain regarding the words guessing?

In other words, we select a word, it may or may not be the target word. If it is, game is over and we win, otherwise, the game will continue. But is there difference between remained candidate in which **choosing some words makes following game more easier than choosing others?** 
In the old solution, we don't consider this question, but now it raises the concern of me.

Out of the scope of this question, I remember another similar case I have seen in my past experience: that is **decision tree**.

Decision tree prioritizes the tree node based on the information gain, which is closely related to the entropy. 
In other words, decision tree will first choose the condition, which can split result equally over the condition, which has unbalanced splitting results.

Insipred by Decision tree, I start to understand that, in word guessing, the higher gain of a word is the one splitting the remained word more equally. But how does a word splitting the remained word? The answer is based on the number of mached characters. Whenever testing a word, you will have a result telling you how many char matched. Except you get 6, you need to continue the game by find out the remained candidates that also has the exact matches to the tested word.
Therefore, we should choose a word that can splits the rest of remained candiates in a most equal way when we have the result from testing.

I don't want to be too verbose, you'll find the answer from the code.

```java
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    int[][] distances;
    public void findSecretWord(String[] wordlist, Master master) {
        distances = new int[wordlist.length][wordlist.length];
        for (int i = 0; i < wordlist.length; i ++) {
            for(int j = i + 1; j < wordlist.length; j ++){
                int tmp = matches(wordlist[i], wordlist[j]);
                distances[i][j] = tmp;
                distances[j][i] = tmp;
            }
        }

        List<Integer> remained = new LinkedList();
        for(int i = 0; i < wordlist.length; i ++) remained.add(i);

        for (int k = 0; k < 10; k ++) {
            int guess = findGuess(wordlist, remained);
            int result = master.guess(wordlist[guess]);
            if (result == 6) return;
            int size = remained.size();
            for (int i = 0; i < size; i ++){
                int tmp = remained.remove(remained.size() - 1);
                if (distances[tmp][guess] == result && tmp != guess) {
                    remained.add(0, tmp);
                }
            }
        }
        return;
    }
    public int findGuess(String[] wordlist, List<Integer> remained) {
        int minmax = Integer.MAX_VALUE;
        int ret = -1;
        for (int i = 0; i < remained.size(); i ++) {
            int max = Integer.MIN_VALUE;
            int[] distr = new int[6];
            int test = remained.get(i);
            for (Integer r : remained) {
                if(r != test) {
                    int tmp = distances[test][r];
                    distr[tmp] ++;
                    if(distr[tmp] > max) {
                        max = distr[tmp];
                    }
                }
            }
            if (minmax > max) {
                ret = test;
                minmax = max;
            }
        }
        return ret;
    }

    public int matches(String a, String b) {
        int result = 0;
        for (int i = 0; i < 6; i ++) {
            if (a.charAt(i) == b.charAt(i)) result ++;
        }
        return result;
    }

}
```