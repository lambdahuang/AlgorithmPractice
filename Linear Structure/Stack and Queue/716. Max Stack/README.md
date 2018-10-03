[716. Max Stack](https://leetcode.com/problems/max-stack/)

It is important to use *equal*s in comparing two Integer instead of using == which would compare the address of object

```
class MaxStack {
    List<Integer> lst;
    PriorityQueue<Integer> pq;
    /** initialize your data structure here. */
    public MaxStack() {
        lst = new ArrayList(10001);
        pq = new PriorityQueue<Integer>(10001, (Integer a, Integer b) -> a<b?1:-1);
    }
    
    public void push(int x) {
        lst.add(x);
        pq.add(x);
    }
    
    public int pop() {
        int val = lst.get(lst.size()-1);
        lst.remove(lst.size()-1);
        pq.remove(new Integer(val));
        return val;
    }
    
    public int top() {
        return lst.get(lst.size()-1);
    }
    
    public int peekMax() {
        return pq.peek();
    }
    
    public int popMax() {
        Integer val = pq.poll();
        for(int i = lst.size()-1;i>=0;i--)
            if(lst.get(i).equals(val)) {lst.remove(i); break;}
        return val;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
 ```
