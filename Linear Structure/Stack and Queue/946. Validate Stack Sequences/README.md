# [946. Validate Stack Sequences](https://leetcode.com/problems/validate-stack-sequences/)

The simplitest solution is to simulate a series of stack push and pop.

In each round, we either push or pop an element from stack, however, with preference following this order:

1. If it is possible, we prefer to pop an element and close the round.

2. If 1 cannot be fulfilled, we prefer to push an element and close the round.

3. If both fails, return false.

```java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack();
        int i = 0;
        int j = 0;
        while(i < pushed.length || j < popped.length) {
            if (!st.empty() && st.peek().equals(popped[j])) {
                st.pop();
                j ++;
            } else if(i < pushed.length){
                st.push(pushed[i++]);
            } else
                break;
        }
        if( j == popped.length )
            return true;
        else
            return false;
    }
}
```
