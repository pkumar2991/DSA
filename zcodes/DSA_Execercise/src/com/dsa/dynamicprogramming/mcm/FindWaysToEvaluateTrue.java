package com.dsa.dynamicprogramming.mcm;

import java.util.HashMap;
import java.util.Map;

public class FindWaysToEvaluateTrue {
    /**
     * Given a boolean expression with following symbols.
     * Symbols
     *     'T' --- true
     *     'F' --- false
     * And following operators filled between symbols
     * Operators
     *     &   ---boolean AND
     *     |   --- boolean OR
     *     ^   --- boolean XOR
     * Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
     * Example:
     * Input: symbol[]    = {T, F, T}
     *        operator[]  = {^, &}
     * Output: 2
     * The given expression is "T ^ F & T", it evaluates true
     * in two ways "((T ^ F) & T)" and "(T ^ (F & T))"
     */

    static Map<String,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String str = "T^F|F&T|T";
        int ans = findSolution(str,0,str.length()-1,true);
        System.out.println("Ways to evaluate the expression to True: "+ans);
    }

    private static int findSolution(String str, int i, int j, boolean isTrue) {
        // base condition
        if(i > j) return 0;
        if(i==j){
            return (isTrue == ((str.charAt(i) == 'T'))) ? 1 : 0;
        }
        StringBuilder key = new StringBuilder();
        key.append(i);
        key.append(" ");
        key.append(j);
        key.append(" ");
        key.append(isTrue);

        if(map.containsKey(key.toString())){
            return map.get(key.toString());
        }

        int ans = 0;
        for (int k = i+1; k <= j-1 ; k=k+2) {
            int lT = findSolution(str,i,k-1,true);
            int lF = findSolution(str,i,k-1,false);
            int rT = findSolution(str,k+1,j,true);
            int rF = findSolution(str,k+1,j,false);

            if(str.charAt(k) == '&'){
                ans = ans + evaluateAndOperator(lT,lF,rT,rF,isTrue);
            }else if(str.charAt(k) == '|'){
                ans = ans + evaluateOrOperators(lT,lF,rT,rF,isTrue);
            }else if(str.charAt(k) == '^'){
                ans = ans + evaluateXorOperators(lT,lF,rT,rF,isTrue);
            }
        }
        map.put(key.toString(),ans);
        return ans;
    }
    static int evaluateAndOperator(int lT, int lF, int rT, int rF, boolean isTrue){
        if(isTrue){
            return lT*rT;
        }
        return lF*rT + lT*rF + lF*rF;
    }
    static int evaluateOrOperators(int lT,int lF,int rT,int rF, boolean isTrue){
        if(isTrue){
           return lT*rF + lF*rT + lT*rT;
        }
        return lF*rF;
    }
    static int evaluateXorOperators(int lT,int lF,int rT,int rF, boolean isTrue){
        if (isTrue) {
            return lT*rF + lF*rT;
        }
        return lT * rT + lF*rF;
    }
}
