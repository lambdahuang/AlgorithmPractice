# [552. Student Attendance Record II](https://leetcode.com/problems/student-attendance-record-ii/)

June 28 2020

It is obvious to me that this is a DP question. However, it takes me a while to realize how to model the state transition formular.

First of all, we need to find a way to define what the basic state structure for DP.

if the total number of combinations at a given length n is combination[n], what is the relationship between `combination[n]` and `combination[n-1]`.

There is no direct connection between *state n* and *state n-1*. Therefore, we need to further decompose the state `combination`.

One way to do so is to track the last character you will append at the end of combination at each step from length 1 to length n.
There are potentially three options: 'A', 'P' and 'L', standing for absent, present, and late respectively.

If we define `absent[n], present[n], and late[n]` to be the numbers of combinations with last records *A, P, and L* respectively,
we will get this equaltion:

 ```java
 combination[n] = absent[n] + present[n] + late[n]
 ```

Now the question becomes to finding the relationships for absent, prsent, and late between length *n-1 and n*.

First obvious rule is:

```java
present[n] = absent[n-1] + present[n-1] + late[n-1]
```

This is true since we can choose any length n-1 combinations and append with a `Present` record at end.

For late record late[n], we should be careful since the rule does not allow more than 2 continuous late records appeared at combinations. Therefore, we should avoid to use any late-record-related way to express the late record because this will cause an recursive logic. Look at this example.

```java
// wrong one
late[n] = absent[n-1] + present[n-1] + late[n-1] - late_appeared_twice_at_end[i-1]
```

In this example, we have made up an `late_appeared_twice_at_end[i-1]` state to track combinations with two continuous late record at the end. How to maintain late_appeared_twice_at_end during the state transition? You have to distinguish which combinations with Late record at the end are with actually one late record and which are with two late records. Then, this depends on the n-1 states, but n-1 states also have two possible cases.

Another solution is to have this:

```java
late[n] = absent[n-1] + present[n-1] + absent[n-2] + present[n-2]
```

Since any valid record end up with A or P at length n-2 can append *LL* at the end to make it still valid at length n.

Now we figureed out the way to handle late, the left one is `absent[n]`.

Absent record has restriction to be appeared at most once in the combination. Therefore, we should track the combinations that are purely without any Absent record. To do this, we need to introduce extra variables `noabsent_present` and `noabsent_present`.

Remember we don't use a single `noabsent` but two because we cannot find the relationship between `noabsent[n]` and `noabsent[n-1]`.

```java
noabsent_present[n] = present[n-1] + late[n-1]

noabsent_late[n] = noabsent_present[n-1] + noabsent_present[n-2]
```

Therefore we have the equation for `absent[n]`.

```java
absent[n] = noabsent_present[n-1] + noabsent_late[n-1]
```

Eventually, we can compress the 1D DP states into O(1).

```java
class Solution {
    public int checkRecord(int n) {
        long l = 1;
        long p = 1, pPrevious = 1, aPrevious = 0;
        long a = 1, pnoA = 1, lnoA = 1, pnoAprevious = 1;
        long x = (long)1e9 + 7;
        long lPrevious = 0
        for (int i = 1; i < n ; i ++) {
            long tmpa = (lnoA + pnoA) % x;
            long tmpl = (p + a + l - lPrevious) % x;
            long tmpp = (l + p + a) % x;

            long tmplnoA = (pnoA + pnoAprevious) % x;
            long tmppnoA = (pnoA + lnoA) % x;

            pnoAprevious = pnoA;
            pnoA = tmppnoA;
            lnoA = tmplnoA;
            lPrevious = l;

            pPrevious = p;
            aPrevious = a;
            a = tmpa;
            l = tmpl;
            p = tmpp;
        }
        return (int)((a % x + p % x + l % x)  % x); 
    }
}
```
