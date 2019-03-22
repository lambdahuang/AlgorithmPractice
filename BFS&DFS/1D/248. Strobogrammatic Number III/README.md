[248. Strobogrammatic Number III](https://leetcode.com/problems/strobogrammatic-number-iii/)

```
class Solution {
    String[] candidatesLeftWings = new String[]{"0", "1", "6", "8", "9"};
    String[] candidatesRighWings = new String[]{"0", "1", "9", "8", "6"};
    String[] candidatesCentral = new String[]{"0", "1", "8"};
    public int strobogrammaticInRange(String low, String high) {
        ArrayDeque<String> lowRet = new ArrayDeque();
        ArrayDeque<String> highRet = new ArrayDeque();

        generate(low.length(), lowRet);
        generate(high.length(), highRet);
        int lowSize = lowRet.size();
        for(String x : lowRet) {
            if(greater(low, x) || greater(x, high)) lowSize --;
        }
        int highSize = highRet.size();
        for(String x : highRet) {
            if(greater(low, x) || greater(x, high)) highSize --;
        }
        //System.out.println(lowSize);

        int ret = lowSize + highSize;
        if(low.length() == high.length()) ret /=2;
        ArrayDeque<String> genRet = new ArrayDeque();
        for(int i = low.length()+1; i < high.length(); i ++) {
            ret += generate(i, genRet);
            genRet.clear();
        }
            
        return ret;
    }
    public int generate(int len, ArrayDeque<String> ret) {
        if(len == 0) return ret.size();
        if(len % 2 == 1) {
            for(int i = 0; i < candidatesCentral.length; i ++) {
                ret.addFirst(new String(candidatesCentral[i]));
            }
            generate(len-1, ret);
        }
        else {
            if(ret.size() == 0) ret.addFirst("");
            int qSize = ret.size();
            for(int i = 0; i < qSize; i ++) {
                String x = ret.removeLast();
                for(int j = 0; j < candidatesLeftWings.length; j ++) {
                    if(len==2 && j == 0) continue;
                    ret.addFirst(candidatesLeftWings[j] + x + candidatesRighWings[j]);
                }
            }
            generate(len-2, ret);
        }
        return ret.size();
    }
    public boolean greater(String A, String B) {
        if(A.length() > B.length()) 
            return true; 
        else if(A.length() < B.length())
            return false;
        for(int i = 0; i < A.length(); i ++)
            if(A.charAt(i) > B.charAt(i))
                return true;
            else if (A.charAt(i) < B.charAt(i))
                return false;
        return false;
    }
}
```
