[380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/description/)

This is an very interesting questrion.

Using the hashset is the directly method however it's not perfect.

Deletion always gives youy the worst performance.

# The vanilla solution with HashSet

```
class RandomizedSet {
    HashSet<Integer> hs = new HashSet();
    ArrayList<Integer> as;
    Random rn = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hs.contains(val)) return false;
        hs.add(val);
        as = new ArrayList(hs);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hs.contains(val)) return false;
        hs.remove(val);
        as = new ArrayList(hs);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        return as.get(rn.nextInt(as.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```

Using hashmap gives us the capability to keep track on the postion of each element.
Instead of deleting element in the middle of the array, we always exchange the target element with element at tail and take it from the tail.

```
class RandomizedSet {
    List<Integer> lst = new ArrayList();
    HashMap<Integer, Integer> hm = new HashMap();
    Random rn = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val) && hm.get(val) < lst.size())
            return false;
        hm.put(val, lst.size());
        lst.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int i = hm.getOrDefault(val, lst.size());
        if(i >= lst.size())
            return false;
        int original_last = lst.get(lst.size() - 1);
        lst.set(i, original_last);
        hm.put(original_last, i);
        hm.put(val, lst.size());
        lst.remove(lst.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return lst.get( (int) (Math.random() * lst.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

```
