[975. Odd Even Jump](https://leetcode.com/problems/odd-even-jump/)

It took me a while to understand the idea of the question.

```
class Solution {
    public int oddEvenJumps(int[] A) {
        boolean[] oddJump = new boolean[A.length];
        boolean[] evenJump = new boolean[A.length];
        for(int i = 0; i < oddJump.length; i ++)
            { oddJump[i] = false; evenJump[i] = false;}
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        oddJump[A.length - 1] = true;
        evenJump[A.length - 1] = true;
        tm.put(A[A.length -1], A.length - 1);
        for(int i = A.length - 2; i >= 0; i --)
        {
            Integer oddNextIndexSet = tm.higherKey(A[i]-1);
            Integer evenNextIndexSet = tm.lowerKey(A[i]+1);
            if(oddNextIndexSet != null )
            {
                int tmp = tm.get(oddNextIndexSet);
                if(oddJump[tmp] == true)
                {
                    evenJump[i] = true;
                }
                    
            }
            if (evenNextIndexSet != null )
            {
                int tmp = tm.get(evenNextIndexSet);
                if(evenJump[tmp] == true)
                {
                    oddJump[i] = true;
                }
            }
            tm.put(A[i], i);
        }
        int ret = 0;
        for(int i = 0; i < oddJump.length; i ++){
            if(evenJump[i]) ret++;
        }

        return ret;
    }
}
```
