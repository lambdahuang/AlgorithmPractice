[158. Read N Characters Given Read4 II - Call multiple times]()

I don't understand why this question has been marked as hard.

```
/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    Deque<Character> dq = new LinkedList<>();
    public int read(char[] buf, int n) {
        if(dq.size() < n)
        {
            int preread = (n - dq.size()) / 4 + 1;
            for(int i = 0; i < preread; i ++)
            {
                char[] tmp = new char[4];
                int count = this.read4(tmp);
                for(int j = 0; j < count; j ++)
                    dq.addLast(tmp[j]);
            }
        }
        int ret = 0;
        for(ret = 0; ret < n && dq.size() >0; ret ++)
        {
            Character tmp = dq.removeFirst();
            if(tmp != null)
                buf[ret] = tmp;
            else
                break;
        }
        return ret;
            
    }
}
```
