class Solution {
    public int totalFruit(int[] tree) {
        if(tree.length <= 2) return tree.length;
        int left = 0;
        int right = 2;
        int max = 2;
        int previous_element = 0; // position of the previous different element
        if(tree[1] == tree[0]) previous_element = -1;
        while(right < tree.length)
        {
            if(tree[right] != tree[right-1])
            {
                if(previous_element != -1 && tree[right] != tree[previous_element])
                    left = previous_element + 1;
                previous_element = right - 1;
            }
            max = Math.max(max, right-left+1);
            right ++;
        }
        return max;
    }
}
