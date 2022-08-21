package com.company;

public class RemoveAllOccurrences {

    public static String remAllOcc(String str, char ch){
        String output="";
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==ch){
                continue;
            }else{
                output= output+ str.charAt(i);
            }

        }
        return output;
    }

    public static void main(String[] args) {
        String str = "aabccbaa";
        char ch = 'a';
        String ans = remAllOcc(str,ch);
        System.out.println(ans);
    }
}
