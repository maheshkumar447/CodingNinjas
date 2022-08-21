package Recursion;

public class PrintSubsequence {

    public static void helper(String input, String outputSoFar){
        if(input.length() == 0){
            System.out.println(outputSoFar);
            return;
        }

        // har charcater k pass 2 options honge ...ya to wo output string me include hoga ya phir nhi hoga

        // first case wo  nhi hoga include
        // to recursion call kro next charcater se or output wahi rhegi koi chnge nhi aayeg output string me
        helper(input.substring(1) , outputSoFar);

        // 2nd case hum usko consider krenge output me
        helper(input.substring(1), outputSoFar + input.charAt(0));

    }

    public static void printSubsequence(String input){
        helper(input , "");
    }

    public static void main(String[] args) {
        printSubsequence("XYZ");
    }
}
