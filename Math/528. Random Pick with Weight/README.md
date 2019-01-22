[528. Random Pick with Weight](https://leetcode.com/problems/random-pick-with-weight/)

I didn't add the `+1` at the end of `nextInt()` leading to the failure in passing the OA.

```
class Solution {
    int[] weight ;
    Random rand ;
    public Solution(int[] w) {
        weight = new int[w.length];
        for(int i = 0; i < w.length; i ++)
        {
            if(i == 0)
                weight[i] = w[i];
            else
                weight[i] = w[i] + weight[i-1];
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int sum = weight[weight.length -1];
        int r = rand.nextInt(sum) + 1;
        int ret = Arrays.binarySearch(weight, r);
        if(ret>=0) return ret; else return -ret -1;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
```
