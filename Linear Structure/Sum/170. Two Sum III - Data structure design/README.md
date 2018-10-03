[170. Two Sum III - Data structure design](https://leetcode.com/problems/two-sum-iii-data-structure-design/)

# HashMap

```
class TwoSum {

    HashMap<Integer, Boolean> hm;
    /** Initialize your data structure here. */
    public TwoSum() {
        hm = new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(hm.containsKey(number))
            hm.put(number, true);
        else
            hm.put(number, false);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Boolean> em: hm.entrySet())
        {
            int val = value - em.getKey();
            //System.out.println(val + " " + hm.get(val));
            if(em.getKey().equals(val) && hm.containsKey(val) && hm.get(val) == true)
                return true;
            else if(!em.getKey().equals(val) && hm.containsKey(val))
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
```
