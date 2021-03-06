class Solution {
    public String getHint(String secret, String guess) {
        int[] hm1 = new int[256];
        int[] hm2 = new int[256];
        int A = 0;
        for(int i = 0; i < secret.length(); i ++)
        {
            if(secret.charAt(i) == guess.charAt(i)) 
                A++;
            else
            {
                hm1[secret.charAt(i)] ++;
                hm2[guess.charAt(i)] ++;
            }
        }
        int B = 0;
        for(int i = 0; i < 256; i ++)
            B+= Math.min(hm1[i], hm2[i]);
        return  String.valueOf(A) + "A" + String.valueOf(B) + "B";
    }
    
}
