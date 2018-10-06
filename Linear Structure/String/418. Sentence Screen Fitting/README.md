[418. Sentence Screen Fitting]()

This method TLE.

```
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[][] status = new int[cols][2];
        HashMap<Integer, Integer> hm1 = new HashMap();
        HashMap<Integer, Integer> hm2 = new HashMap();
        int[] lens = new int[sentence.length];
        for(int i = 0; i < sentence.length; i++) lens[i] = sentence[i].length();
        int current_cols = 0;
        while(true)
        {
            int current_rows = 0;
            int start = current_cols;
            for(int j = 0; j < lens.length; j ++)
            {
                int len = lens[j];
                if(current_cols + len > cols)
                {
                    if(current_cols == 0) return 0;
                    current_cols = len; 
                    current_rows ++;
                }
                else
                    current_cols += len;
                
                if(j != lens.length-1)
                {
                    if(current_cols + 1 >= cols)
                    {
                        current_cols = 0;
                        current_rows ++;
                    }
                    else
                        current_cols += 1;
                }
            }
            if(hm1.containsKey(start)) break;
            hm1.put(start, current_cols);
            hm2.put(start, current_rows);
            current_cols+=1;
            if(current_cols > cols) current_cols = 0;
            

        }
        int start_cols = 0;
        int start_rows = 0;
        int ans = 0;
        while(start_rows < rows)
        {
            
            int[] next = new int[2];
            next[0] = hm1.get(start_cols);
            next[1] = hm2.get(start_cols);
            
            if(start_rows + next[1] < rows)
            {
                if(next[0]+1>= cols)
                {
                    start_cols = 0;
                    start_rows += next[1] + 1;
                }
                else
                {
                    start_rows += next[1];
                    start_cols = next[0] + 1;
                }
            }
            else
                break;
            ans++;
        }
        return ans;
    }
}
```

There is another solution, instead of finding the repeat times that target sentence can be put into the output board, the second method is trying to find the space being utilized space in the output board. Then divide the utilized space by length of sentence to get repeat times.

```
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        
        return start / s.length();
    }
}
```
