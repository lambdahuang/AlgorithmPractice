/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n == 1) return 0;
        int candidate = 0;
        for(int i = 1; i < n; i ++)
        {
            if(knows(candidate, i)==true || knows(i, candidate)==false) candidate = i;
        }
        for(int i = 0; i < n; i ++)
            if(i != candidate && (knows(i, candidate) == false || knows(candidate, i) == true))
                return -1;
        return candidate;
                
    }
}
