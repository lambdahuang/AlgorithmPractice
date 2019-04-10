[900. RLE Iterator](https://leetcode.com/problems/rle-iterator/)

Runtime Length Encode (RLE)

```
class RLEIterator {
    int[] a;
    int i = 0;
    public RLEIterator(int[] A) {
        a = A;
    }
    
    public int next(int n) {
        if(i>=a.length) return -1;
        while(n > 0) {
            if(a[i] == 0) {
                i += 2;
                if(i>=a.length)
                    return -1;
            }
            int d = Math.min(n, a[i]);
            a[i] -= d;
            n -= d;
        }
        if(i>=a.length)
            return -1;
        else
            return a[i+1];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
```
