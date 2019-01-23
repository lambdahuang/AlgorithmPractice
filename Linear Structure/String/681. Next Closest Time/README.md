[681. Next Closest Time](https://leetcode.com/problems/next-closest-time/description/)

Logic is simple, be careful the boundry.

```
class Solution {
    public String nextClosestTime(String time) {
        int[] ta = new int[4];
        ta[0] = time.charAt(0) - '0';
        ta[1] = time.charAt(1) - '0';
        ta[2] = time.charAt(3) - '0';
        ta[3] = time.charAt(4) - '0';
        int hour_0 = ta[0];
        int hour_1 = ta[1];
        int minute_0 = ta[2];
        int minute_1 = ta[3];
        Arrays.sort(ta);
        // int minutes = ta[2] * 10 + ta[3];
        // int hours = ta[0] * 10 + ta[1];
        // find the closest minutes
        int tmp = cloestIndex(ta, minute_1);
        if(tmp != -1)
            return genTime(hour_0, hour_1, minute_0, ta[tmp]);
        tmp = cloestIndex(ta, minute_0);
        if(tmp != -1 && (ta[tmp] <= 5))
            return genTime(hour_0, hour_1, ta[tmp], ta[0]);
        // find the cloeset hours
        tmp = cloestIndex(ta, hour_1);
        if(tmp != -1 && (hour_0 != 2 || ta[tmp] < 4))
            return genTime(hour_0, ta[tmp], ta[0], ta[0]);
        tmp = cloestIndex(ta, hour_0);
        if(tmp != -1 && (ta[tmp] < 3))
            return genTime(ta[tmp], ta[0], ta[0], ta[0]);
        return genTime(ta[0], ta[0], ta[0], ta[0]);
    }
    public String genTime(int hour1, int hour2, int minute1, int minute2)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(hour1);
        sb.append(hour2);
        sb.append(':');
        sb.append(minute1);
        sb.append(minute2);
        return sb.toString();
    }
    public int cloestIndex(int[] ta, int target)
    {
        for(int i = 0; i < ta.length; i ++)
            if(ta[i] > target) return i;
        return -1;
    }
}
```

#2019.1.23

```
class Solution {
    public String nextClosestTime(String time) {
        int[] arr = new int[4];
        arr[0] = time.charAt(0)-'0';
        arr[1] = time.charAt(1)-'0';
        arr[2] = time.charAt(3)-'0';
        arr[3] = time.charAt(4)-'0';
        int[] sorted = new int[4];
        for(int i = 0; i < 4; i ++) sorted[i] = arr[i];
        Arrays.sort(sorted);
        TreeSet<Integer> tm = new TreeSet<>();
        for(int i : arr) tm.add(i);
        for(int i = 3; i >=0; i --)
        {
            Integer upper = tm.higher(arr[i]);
            if(upper != null)
            {
                int tmp = arr[i];
                arr[i] = upper;
                if(isValid(arr)) {
                    // set the previous number to the lowest number of the array
                    for(int j = 3; j > i; j--) arr[j] = sorted[0];
                    return generate(arr);
                }
                arr[i] = tmp;
            }
        }
        
        for(int i = 0; i < 4; i++) arr[i] = sorted[0];
        return generate(arr);
    }
    public String generate(int[] arr)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        sb.append(arr[1]);
        sb.append(':');
        sb.append(arr[2]);
        sb.append(arr[3]);
        return sb.toString();
    }
    public boolean isValid(int[] arr)
    {
        int hours = arr[0] * 10 + arr[1];
        int mins = arr[2] * 10 + arr[3];
        if( hours >= 0 && hours < 24 && mins >= 0 && mins < 60) 
            return true; 
        else 
            return false;
    }
}
```
