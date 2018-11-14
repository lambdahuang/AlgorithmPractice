class StockSpanner {
    int[] arr = new int[10000];
    int[] map = new int[10000];
    int counter = 0;
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int ans = 1;
        for(int i = counter - 1; i >=0;)
        {
            if(arr[i] <= price)
            {
                ans += map[i];
                i-= map[i];
            }
            else break;
        }
        arr[counter] = price;
        map[counter] = ans;
        counter ++;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
