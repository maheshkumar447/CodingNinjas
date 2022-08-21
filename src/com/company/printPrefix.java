package com.company;

public class printPrefix {

    public static String reverseWordWise(String input) {

        String [] reverse = input.split(" ");
        String ans="";
        for(int i = reverse.length-1;i>=0;i--){
            ans = ans+reverse[i]+" ";
        }
//        String ans = String.valueOf(reverse);
        return ans;
    }

    public static void allSubStrings(String str){
        for (int i =0;i<str.length();i++){
            for(int j =0;j<=str.length();j++){
                System.out.println(str.substring(i,j));
            }
        }
    }

    public static void prefix(String str){
        for(int i =0; i<str.length();i++){
            System.out.println(str.substring(0,i+1));
        }
    }

    public static void main(String[] args) {

        String str = "Welcome to coding ninjas";
//        prefix(str);
//        allSubStrings(str);
        String s = reverseWordWise(str);
//        for(int i =0; i<s.length();i++) {
            System.out.print(s+" ");
//        }
    }
}
