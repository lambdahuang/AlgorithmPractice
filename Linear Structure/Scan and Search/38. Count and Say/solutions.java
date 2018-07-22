class Solution {
    public String countAndSay(int n) {
        if(n <= 1)
            return "1";
        else
        {
            StringBuilder sb = new StringBuilder();
            char[] previousLayerArr = countAndSay(n - 1).toCharArray();
            int tmp = 1;
            for(int i = 1; i <= previousLayerArr.length; i++)
            {
                if(i == previousLayerArr.length || 
                   previousLayerArr[i] != previousLayerArr[i-1])
                {
                    sb.append(String.valueOf(tmp));
                    sb.append(previousLayerArr[i-1]);
                    tmp = 1;
                }
                else
                    tmp ++;
            }
            return sb.toString();
        }
    }
}
