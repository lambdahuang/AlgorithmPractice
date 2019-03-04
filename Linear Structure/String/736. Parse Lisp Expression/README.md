[736. Parse Lisp Expression]()

Super complex in logic

```
class Solution {
    public int evaluate(String expression) {
        return Integer.valueOf(DFS(expression, new HashMap<String, Integer>()));
    }
    public String DFS(String s, HashMap<String, Integer> hm) {
        if(s.length() < 2) return "";
        StringBuilder sb = new StringBuilder();
        int depth = 0;
        int lastDepthOne = 0;
        for(int i = 1; i < s.length() - 1; i ++) {
            if(s.charAt(i) == '(') {
                depth ++;
                if(depth == 1) lastDepthOne = i;
            }
            else if(s.charAt(i) == ')') {
                if(depth == 1) {
                    String tmp = s.substring(lastDepthOne, i + 1);
                    InstantCalculate(sb.toString(), true, hm);
                    HashMap<String, Integer> newhm = new HashMap<>(hm);
                    sb.append(DFS(tmp, newhm));
                }
                depth --; 
            }
            else if(depth == 0)
                sb.append(s.charAt(i));
        }
        int ret = InstantCalculate(sb.toString(), false, hm);
        //System.out.println(sb.toString());
        //System.out.println(ret);
        return Integer.toString(ret);
    }
    public int InstantCalculate(String s, boolean preCal, HashMap<String, Integer> hm) {
        String[] elems = s.split(" ");

        if(elems[0].equals("let")) {
            for(int i = 1; i < elems.length; i += 2) {
                if(i + 1 >= elems.length || elems[i] == "" || elems[i+1] == "") continue;
                int x = 0;
                if(elems[i+1].matches("-?\\d+"))
                    x = Integer.valueOf(elems[i+1]);
                else
                    x = hm.get(elems[i+1]);
                hm.put(elems[i], x);
                //System.out.println("->" + elems[i] + "=" + x);
            }
            if(preCal == false) {
                if(elems[elems.length-1].matches("-?\\d+"))
                    return Integer.valueOf(elems[elems.length-1]);
                else
                    return hm.get(elems[elems.length-1]);
            }
        }
        else if(elems[0].equals("mult")) {
            int ret = 1;
            for(int i = 1; i < elems.length; i ++) {
                int x = 0;
                if(elems[i].matches("-?\\d+"))
                    x = Integer.valueOf(elems[i]);
                else
                    x = hm.get(elems[i]);
                ret *= x;
            }
            return ret;
        }
        else if(elems[0].equals("add")) {
            int ret = 0;
            for(int i = 1; i < elems.length; i ++) {
                int x = 0;
                if(elems[i].matches("-?\\d+"))
                    x = Integer.valueOf(elems[i]);
                else
                    x = hm.get(elems[i]);
                ret += x;
            }
            return ret;
        }
        return 0;
    }
}
```

Test Data

```
"(let x 2 (mult x (let x 3 y 4 (add x y))))"
"(add 1 (let x 3 y (mult x 3)))"
"(add 1 2)"
"(mult 3 (add 2 3))"
"(let x 3 x 2 x)"
"(let a1 3 b2 (add a1 1) b2)"
"(let x 2 (add (let x 3 (let x 4 x)) x))"
"(let x -2 y x y)"
```
