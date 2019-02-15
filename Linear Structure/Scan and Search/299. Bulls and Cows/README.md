[299. Bulls and Cows](https://leetcode.com/problems/bulls-and-cows/)

Simpal and straight-forward solution.

First check the a character is a bull or not, if it is not, add up one for the counter of this character.

After the first round of iteration, we compare the counts of characters appeared in the secret string with counts of characters appeared in the guess string.


```
class Solution {
    public String getHint(String secret, String guess) {
        int[] hm1 = new int[256];
        int[] hm2 = new int[256];
        int A = 0;
        for(int i = 0; i < secret.length(); i ++)
        {
            if(secret.charAt(i) == guess.charAt(i)) 
                A++;
            else
            {
                hm1[secret.charAt(i)] ++;
                hm2[guess.charAt(i)] ++;
            }
        }
        int B = 0;
        for(int i = 0; i < 256; i ++)
            B+= Math.min(hm1[i], hm2[i]);
        return  String.valueOf(A) + "A" + String.valueOf(B) + "B";
    }
    
}
```

2019.2.16 
The trap is that the bull and the cow should be processed in different priority. Once a character is identified as bull, it should be removed from the scope of the scan of the cow.

```
class Solution {
    public String getHint(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] map = new int[256];
        boolean[] sign = new boolean[secret.length()];
        for(char c : secret.toCharArray()) map[c] ++;
        for(int i = 0; i < secret.length() ; i ++)
        {
            if(secret.charAt(i) == guess.charAt(i)) {
                A++;
                map[secret.charAt(i)] --;
                sign[i] = true;
            }
        }
        for(int i = 0; i < secret.length() ; i ++)
        {
            if(sign[i] != true && map[guess.charAt(i)] > 0)
            {
                map[guess.charAt(i)] --;
                B++;
            }
        }
        return A + "A" + B + "B";
    }
}
```
