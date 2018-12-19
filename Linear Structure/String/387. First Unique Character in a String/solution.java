
class Solution {
    public int firstUniqChar(String s) {
        int[] map = new int[256];
        char[] arr = s.toCharArray();
        for(char c : arr)
        {
            map[c] ++;
        }
        for(int i = 0; i < arr.length; i++)
        {
            if(map[arr[i]] == 1) return i; 
        }
        return -1;
            
    }
}
