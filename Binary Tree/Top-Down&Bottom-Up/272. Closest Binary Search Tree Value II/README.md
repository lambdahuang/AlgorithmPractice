[272. Closest Binary Search Tree Value II](https://leetcode.com/problems/closest-binary-search-tree-value-ii/description/)

I hand-write the higherValue and lowerValue methods which are pretty similar to the higherKey and lowerKey in the TreeMap()

We find the numbers that are just greater and lesser than the target value and gradully widen the windows until we find the K elements.

By doing this, we could solve the question in the O(klog(n)).

```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> ans = new LinkedList();
        if(k == 0) return ans;
        Integer lowerValue = LowerValue(root, target);
        Integer higherValue = HigherValue(root, target); 
        if(containsValue(root, target)) {ans.add((int)target); }
        
        //System.out.println(lowerValue + " " + higherValue);
        while(ans.size() < k)
        {
            
            if((lowerValue != null && higherValue != null) && (target-(double)lowerValue) > ((double)higherValue-target))
            {
                ans.add(higherValue);
                higherValue = HigherValue(root, higherValue);
            }
            else if(lowerValue != null && higherValue != null)
            {
                ans.add(lowerValue);
                lowerValue = LowerValue(root, lowerValue);
            }
            else if(lowerValue == null)
            {
                ans.add(higherValue);
                higherValue = HigherValue(root, higherValue);
            }
            else
            {
                ans.add(lowerValue);
                lowerValue = LowerValue(root, lowerValue);
            }
        }
        return ans;
    }
    public boolean containsValue(TreeNode root, double target)
    {
        TreeNode tmp = root;
        while(tmp != null) 
            if(Double.compare((double)tmp.val, target) == 0) return true;
            else if(Double.compare((double)tmp.val, target) > 0) tmp = tmp.left;
            else tmp = tmp.right;
        return false;
    }
    public Integer HigherValue(TreeNode root, double target)
    {
        TreeNode tmp = root;
        TreeNode lastLargerNode = null;
        while(tmp!=null)
            if(Double.compare((double)(tmp.val), target) < 0)
                tmp=tmp.right;
            else if(Double.compare((double)(tmp.val), target) > 0)
            {
                lastLargerNode = tmp;
                tmp=tmp.left;
            }
            else
                break;
        if(tmp!=null &&tmp.right !=null )
        {
            tmp = tmp.right;
            while(tmp.left != null)tmp=tmp.left; 
        }
        else
            tmp = lastLargerNode;

        if(tmp == null || Double.compare((double)(tmp.val), target) == 0)
            return null;
        else
            return tmp.val;
    }
    public Integer LowerValue(TreeNode root, double target)
    {
        TreeNode tmp = root;
        TreeNode lastSmallerNode = null;
        while(tmp!=null)
            if(Double.compare((double)(tmp.val), target) < 0)
            {
                lastSmallerNode = tmp;
                tmp=tmp.right;
            }
            else if(Double.compare((double)(tmp.val), target) > 0)
                tmp=tmp.left;
            else
                break;
        if(tmp!=null &&tmp.left !=null )
        {
            tmp = tmp.left;
            while(tmp.right != null)tmp=tmp.right; 
        }
        else
            tmp = lastSmallerNode;

        if(tmp == null || Double.compare((double)(tmp.val), target) == 0)
            return null;
        else
            return tmp.val;
    }
} 
```
